package io.swagger.cassandra;


import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.QueryLogger;
import com.datastax.driver.core.QueryOptions;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SocketOptions;
import com.datastax.driver.core.policies.ConstantReconnectionPolicy;
import com.datastax.driver.core.policies.DefaultRetryPolicy;

import info.archinnov.achilles.generated.ManagerFactory;
import info.archinnov.achilles.generated.ManagerFactoryBuilder;
import info.archinnov.achilles.script.ScriptExecutor;
import info.archinnov.achilles.type.SchemaNameProvider;

@Configuration
public class CassandraConnector {
	private static final Logger log = LoggerFactory.getLogger(CassandraConnector.class);


    @Value("${cassandra.host:localhost}")
    private String cassandraHosts;
    
    @Value("${cassandra.cql.port:9042}")
    private String cassandraCqlPort;
    
    @Value("${cassandra.keySpaceName:billing_domain}")
    private String keySpaceName;
    
    @Value("${cassandra.readtimeoutMs:1000000}")
    private Integer readTimeoutMs;
    
    @Value("${cassandra.clusterName:Cassandra}")
    private String clusterName;
    
    @Value("${cassandra.username:}")
    private String casUserName;
    
    @Value("${cassandra.password:}")
    private String casPassword;
    
    @Value("${cassandra.useSSL:false}")
    private Boolean useSSL;
    
    @Value("${cassandra.sslPort:9042}")
    private Integer sslPort;

    private Session session;
    
    private static final Logger logger = LoggerFactory.getLogger(CassandraConnector.class);
    
    final SchemaNameProvider snp = new SchemaNameProvider() {

        @Override
        public <T> String keyspaceFor(Class<T> entityClass) {
            String ksName = keySpaceName;

            if (ksName.indexOf('"') > 0) {
                ksName = ksName.replace("\"", "");
            }

            return ksName;
        }

        @Override
        public <T> String tableNameFor(Class<T> entityClass) {
            return entityClass.getName();
        }
    };

    public CassandraConnector() {
		super();
	}

	public CassandraConnector(String cassandraHosts,String cassandraCqlPort,String keySpaceName,String interactionKeySpaceName,Integer readTimeoutMs,
    		 String clusterName, String casUserName, String casPassword, Boolean useSSL, Integer sslPort) {
    	this.cassandraHosts = cassandraHosts;
    	this.cassandraCqlPort = cassandraCqlPort;
    	this.keySpaceName = keySpaceName;
    	this.readTimeoutMs = readTimeoutMs;
    	this.clusterName = clusterName;
    	this.casUserName = casUserName;
        this.casPassword = casPassword;
        this.useSSL = useSSL;
        this.sslPort = sslPort;

        init();
        log.debug("cassandra config loaded");
    }

   // @Bean(destroyMethod = "shutDown")
    @PostConstruct
    public void init() {

       // reloadProperties();
    	System.out.println("##################:"+cassandraHosts);
        String[] hosts = cassandraHosts.split(",") ;

        SocketOptions socketOptions = new SocketOptions().setReadTimeoutMillis(readTimeoutMs);
        Cluster cluster = null;
        if (useSSL) {
            cluster = Cluster.builder()
                    .withReconnectionPolicy(new ConstantReconnectionPolicy(1000))
                    .withRetryPolicy(DefaultRetryPolicy.INSTANCE)
                    .withQueryOptions(new QueryOptions().setFetchSize(2000))
                    .withSocketOptions(socketOptions)
                    .addContactPoints(hosts)
                    .withSSL()
                    .withPort(sslPort)
                    .withClusterName(clusterName)
                    .withCredentials(casUserName, casPassword)
                    .build();
        } else {
            cluster = Cluster.builder()
                    .withReconnectionPolicy(new ConstantReconnectionPolicy(1000))
                    .withRetryPolicy(DefaultRetryPolicy.INSTANCE)
                    .withQueryOptions(new QueryOptions().setFetchSize(2000))
                    .withSocketOptions(socketOptions)
                    .addContactPoints(hosts)
                    .withPort(Integer.parseInt(cassandraCqlPort))
                    .withClusterName(clusterName)
                    .withCredentials(casUserName, casPassword)
                    .build();
        }

        QueryLogger queryLogger = QueryLogger.builder().withMaxQueryStringLength(20000)
                .build();
        cluster.register(queryLogger);

        session = cluster.connect();
        if(session == null) System.out.println(" #####33 SESION IS NULL ###################");
        System.out.println("################## END OF INIT METHOD ######################");

    }

    
    //cyrille
    @Profile("default")
    public ManagerFactory cassandraNativeClusterProduction() {

        final ManagerFactory factory = ManagerFactoryBuilder
                .builder(this.session.getCluster())
                .doForceSchemaCreation(false)
                .withBeanValidation(true)
                .withDefaultKeyspaceName(keySpaceName)
                .withSchemaNameProvider(snp)
                .build();
       // final Session session = cluster.connect();

        // maybeCreateSchema(session);

        return factory;
    }

    private void maybeCreateSchema(Session session) {
        logger.info("Execute schema creation script 'cassandra/schema_creation.cql' if necessary");
        final ScriptExecutor scriptExecutor = new ScriptExecutor(session);
        scriptExecutor.executeScript("cassandra/schema_creation.cql");
    }


    public Session getSession(){
    	if(this.session == null)
			try {
				throw new Exception("------------------ The cassandra session is null");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	return this.session;
    }
    
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public String getCassandraHosts() {
		return cassandraHosts;
	}

	public void setCassandraHosts(String cassandraHosts) {
		this.cassandraHosts = cassandraHosts;
	}

	public String getCassandraCqlPort() {
		return cassandraCqlPort;
	}

	public void setCassandraCqlPort(String cassandraCqlPort) {
		this.cassandraCqlPort = cassandraCqlPort;
	}

	public String getKeySpaceName() {
		return keySpaceName;
	}

	public void setKeySpaceName(String keySpaceName) {
		this.keySpaceName = keySpaceName;
	}

	public Integer getReadTimeoutMs() {
		return readTimeoutMs;
	}

	public void setReadTimeoutMs(Integer readTimeoutMs) {
		this.readTimeoutMs = readTimeoutMs;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getCasUserName() {
		return casUserName;
	}

	public void setCasUserName(String casUserName) {
		this.casUserName = casUserName;
	}

	public String getCasPassword() {
		return casPassword;
	}

	public void setCasPassword(String casPassword) {
		this.casPassword = casPassword;
	}

	public Boolean getUseSSL() {
		return useSSL;
	}

	public void setUseSSL(Boolean useSSL) {
		this.useSSL = useSSL;
	}

	public Integer getSslPort() {
		return sslPort;
	}

	public void setSslPort(Integer sslPort) {
		this.sslPort = sslPort;
	}

	public SchemaNameProvider getSnp() {
		return snp;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	
}
