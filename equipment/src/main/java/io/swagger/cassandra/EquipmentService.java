package io.swagger.cassandra;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.archinnov.achilles.generated.ManagerFactory;
import info.archinnov.achilles.generated.manager.Equipment_Manager;
import info.archinnov.achilles.internals.dsl.crud.FindWithOptions;
import io.swagger.cassandra.interfaces.IEquipmentService;
import io.swagger.model.Equipment;

/**
 * Created by Cyrille V Eloundou on 07/06/2017.
 */
@Service
public class EquipmentService implements IEquipmentService {
	private static final Logger log = LoggerFactory.getLogger(EquipmentService.class);

	@Override
	public void createCustomer(io.swagger.model.Equipment equipment) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Equipment> findByEquipmentsCustomerId(String customer_id) {
		List<Equipment> entities = manager.dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id)
				.getList();

		if (entities == null) {
			entities = new ArrayList<Equipment>(); 
		}
		return entities;
	}

	@Autowired
	CassandraConfiguration cassandraConfiguration;

	private Equipment_Manager manager;

	public EquipmentService(Equipment_Manager manager) {
		this.manager = manager;
	}

	public EquipmentService() {
	}

	@PostConstruct
	public void init() {
		ManagerFactory mf = cassandraConfiguration.cassandraNativeClusterDev();
		manager = mf.forEquipment();
	}

	// @Override
	/*
	 * public void createEquipment(Equipment Equipment) {
	 * 
	 * RetryPolicy rp = new CustomRetryPolicy(10, 10, 10); try {
	 * 
	 * manager.crud() .insert(Equipment)
	 * .withConsistencyLevel(ConsistencyLevel.ANY) .withRetryPolicy(rp)
	 * .withInsertStrategy(InsertStrategy.ALL_FIELDS) .usingTimeToLive(0)
	 * .withLwtResultListener(lwtResult -> log.error("Error : " + lwtResult)) //
	 * .executeAsyncWithStats(); .execute(); } catch (Exception e) { String
	 * threadName = Thread.currentThread().getName(); log.debug("Thread " +
	 * threadName + ":Equipment " + Equipment + " failed: " + e.getMessage());
	 * e.printStackTrace(); throw (e); }
	 * 
	 * }
	 */

	public CassandraConfiguration getCassandraConfiguration() {
		return cassandraConfiguration;
	}

	public void setCassandraConfiguration(CassandraConfiguration cassandraConfiguration) {
		System.out.println(" ### setting CassandraConfiguration ");
		this.cassandraConfiguration = cassandraConfiguration;
	}

	public Equipment_Manager getManager() {
		return manager;
	}

	public void setManager(Equipment_Manager manager) {
		this.manager = manager;
	}

	public Equipment findByEquipmentId2(String Equipment_id) {
		FindWithOptions<Equipment> entityFind = manager.crud().findById(Equipment_id, null, null);
		Equipment entity = entityFind.get();

		if (entity == null) {
			throw new InteractionNotFoundException(format("Cannot find Equipment with 'id': '%s'", Equipment_id));
		}
		return entity;
	}

	@Override
	public Equipment findByEquipmentId(String customer_id) {
		Equipment entity = manager.dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id)
				.getOne();

		if (entity == null) {
			entity = new Equipment(); 
		}
		return entity;
	}

}