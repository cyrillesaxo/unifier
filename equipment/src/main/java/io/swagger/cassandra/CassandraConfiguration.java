package io.swagger.cassandra;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.Session;
import com.datastax.driver.extras.codecs.jdk8.InstantCodec;

import info.archinnov.achilles.generated.ManagerFactory;
import info.archinnov.achilles.generated.ManagerFactoryBuilder;
import info.archinnov.achilles.script.ScriptExecutor;
import info.archinnov.achilles.type.SchemaNameProvider;

@Component
public class CassandraConfiguration  {
	private static final Logger log = LoggerFactory.getLogger(CassandraConfiguration.class);

    @Value("${cassandra.host:localhost}")
    String cassandraHosts;

    @Value("${cassandra.cql.port:9042}")
    String cassandraCqlPort;

    @Value("${cassandra.useSSL:false}")
    Boolean useSSL;

    @Value("${cassandra.sslPort:9042}")
    Integer sslPort;

    @Value("${cassandra.keySpaceName:equipment_domain}")
    String keySpaceName;

    @Value("${cassandra.interactionKeySpaceName:interaction_ks}")
    String interactionKeySpaceName;

    @Value("${cassandra.readtimeoutMs:1000000}")
    Integer readTimeoutMs;

    @Value("${cassandra.clusterName:Cassandra}")
    private String clusterName;

    @Value("${cassandra.username:}")
    private String casUserName;

    @Value("${cassandra.password:}")
    private String casPassword;

    private static final Logger logger = LoggerFactory.getLogger(CassandraConfiguration.class);
    
    
    private CassandraConnector cassandraConnector;
    
    private static Session session;
    
   private ManagerFactory managerFactory;
    
    
    @Autowired
    public void setCassandraConnector(CassandraConnector c){
    	 System.out.println(" ########################  SETTING THE CASSANDRACONNECTOR ############");
    	c.init();
    	 this.cassandraConnector = c;
    }
    
    //cyrille
    @PostConstruct
    public void initStaticSession(){
    	try{
    		if (this.session == null) {
		        this.session = this.cassandraConnector.getSession();   
		        
				this.managerFactory = ManagerFactoryBuilder.builder(session.getCluster()).doForceSchemaCreation(false)
						.withBeanValidation(true).withDefaultKeyspaceName(keySpaceName).withPostLoadBeanValidation(true)
						.withSchemaNameProvider(snp).build();		
				
		        System.out.println(" ########################  STATIC CASSANDRA SESSION CREATED  ####################################");
    		}else
    			System.out.println(" ############ ALREADY INITIALIZED");
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    final SchemaNameProvider snp = new SchemaNameProvider() {

        @Override
        public <T> String keyspaceFor(Class<T> entityClass) {
            String ksName = keySpaceName;
            return getKeySpaceFromEntityName(entityClass.getName());
        }

        @Override
        public <T> String tableNameFor(Class<T> entityClass) {
            return entityClass.getName();
        }
    };

    public String getKeySpaceFromEntityName(String name) {
        String ksName = keySpaceName;
        String lcName = name.toLowerCase();
        if (lcName.indexOf("interaction") >= 0 || lcName.indexOf("product") >= 0 ) {
            ksName = interactionKeySpaceName;
        }

        if (ksName.indexOf('"') > 0) {
            ksName = ksName.replace("\"", "");
        }

        return ksName;

    }

    public CassandraConfiguration() {
        log.debug("cassandra config loaded");
    }

    
    //cyrille
	@Bean(destroyMethod = "shutDown")
	public ManagerFactory cassandraNativeClusterDev() {
		try {
			if (this.managerFactory == null) {
				this.managerFactory = ManagerFactoryBuilder.builder(session.getCluster()).doForceSchemaCreation(false)
						.withBeanValidation(true).withDefaultKeyspaceName(keySpaceName).withPostLoadBeanValidation(true)
						.withSchemaNameProvider(snp).build();

			}

            session.getCluster().getConfiguration().getCodecRegistry().register(InstantCodec.instance);

			return this.managerFactory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.managerFactory;
	}
    
  //cyrille
	@Profile("default")
	@Bean(destroyMethod = "shutDown")
	public ManagerFactory cassandraNativeClusterProduction() {
		try {

			if (this.managerFactory == null) {
				this.managerFactory = ManagerFactoryBuilder.builder(session.getCluster()).doForceSchemaCreation(false)
						.withBeanValidation(true).withDefaultKeyspaceName(keySpaceName).withSchemaNameProvider(snp)
						.build();

                session.getCluster().getConfiguration().getCodecRegistry().register(InstantCodec.instance);

				return this.managerFactory;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// final Session session = cluster.connect();

		// maybeCreateSchema(session);

		return this.managerFactory;
	}

    private void maybeCreateSchema(Session session) {
        logger.info("Execute schema creation script 'cassandra/schema_creation.cql' if necessary");
        final ScriptExecutor scriptExecutor = new ScriptExecutor(session);
        scriptExecutor.executeScript("cassandra/schema_creation.cql");
    }


    public SchemaNameProvider getSchemaNameProvider() {
        return snp;
    }

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}