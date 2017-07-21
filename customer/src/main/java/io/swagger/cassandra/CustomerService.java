package io.swagger.cassandra;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.archinnov.achilles.generated.ManagerFactory;
import io.swagger.cassandra.interfaces.ICustomerService;
import io.swagger.model.Customer;
import io.swagger.model.CustomerView;

/**
 * Created by Cyrille V Eloundou on 07/06/2017.
 */
@Service
public class CustomerService implements ICustomerService {
	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    CassandraConfiguration cassandraConfiguration;

    private ManagerFactory manager;

    public CustomerService(ManagerFactory manager) {
        this.manager = manager;
    }

    public CustomerService() {
    }

	@PostConstruct
	public void init() {
		manager = cassandraConfiguration.cassandraNativeClusterDev();
	}


	@Override
	public void createCustomer(Customer customer) {

/*        RetryPolicy rp = new CustomRetryPolicy(10, 10, 10);
        try {

            manager.crud()
                    .insert(customer)
                    .withConsistencyLevel(ConsistencyLevel.ANY)
                    .withRetryPolicy(rp)
                    .withInsertStrategy(InsertStrategy.ALL_FIELDS)
                    .usingTimeToLive(0)
                    .withLwtResultListener(lwtResult -> log.error("Error : " + lwtResult))
                    //        .executeAsyncWithStats();
                    .execute();
        } catch (Exception e) {
            String threadName = Thread.currentThread().getName();
            log.debug("Thread " + threadName + ":customer " + customer + " failed: " + e.getMessage());
            e.printStackTrace();
            throw (e);
        }*/
		
	}

	@Override
	public Customer findByCustomerId(String customer_id) {
		Customer entity = manager.forCustomer().dsl().select().allColumns_FromBaseTable().where().customer_id().Eq(customer_id)
				.getOne();
		if (entity == null) {
			entity = new Customer(); 
		}
		return entity;
	}

	@Override
	public CustomerView findByFaidId(String faid) {
		CustomerView entity = manager.forCustomerView().dsl().select().allColumns_FromBaseTable().where().faid().Eq(faid)
				.getOne();

		if (entity == null) {
			entity = new CustomerView(); 
		}
		return entity;
	}


	public List<Customer> findcustomers() {
		List<Customer> entities = manager.forCustomer().dsl().select().allColumns_FromBaseTable().without_WHERE_Clause().limit(10)
				.getList();
		if (entities == null) {
			entities = new ArrayList<Customer>(); 
		}
		return entities;
	}

	public List<Customer> findCustomersPagination(String start, String limit) {
		List<Customer> entities = manager.forCustomer().dsl().select().allColumns_FromBaseTable().without_WHERE_Clause().limit(new Integer(limit))
				.getList();
		if (entities == null) {
			entities = new ArrayList<Customer>(); 
		}
		return entities;
	}

	public List<Customer> findCustomersByLastName(String lastName) {
		List<Customer> entities = manager.forCustomer().dsl().select().allColumns_FromBaseTable().without_WHERE_Clause().limit(10)
				.getList();
		if (entities == null) {
			entities = new ArrayList<Customer>(); 
		}
		return entities;
	}

	public List<Customer> findCustomersByLastNameFirstName(String lastName, String firstName) {
		List<Customer> entities = manager.forCustomer().dsl().select().allColumns_FromBaseTable().without_WHERE_Clause().limit(10)
				.getList();
		if (entities == null) {
			entities = new ArrayList<Customer>(); 
		}
		return entities;
	}

	public List<Customer> findCustomersByLastNameFirstNameStartLimit(String start, String limit, String lastName){
			List<Customer> entities = manager.forCustomer().dsl().select().allColumns_FromBaseTable().without_WHERE_Clause().limit(10)
			.getList();
	if (entities == null) {
		entities = new ArrayList<Customer>(); 
	}
	return entities;
	}


    //Need to change
	public List<Customer> findCustomersByLastNameStartLimit(String start, String limit, String lastName) {
		List<Customer> entities = manager.forCustomer().dsl().select().allColumns_FromBaseTable().without_WHERE_Clause().limit(10)
				.getList();
		if (entities == null) {
			entities = new ArrayList<Customer>(); 
		}
		return entities;
	}

	public CustomerView findCustomersByFaidCustomerId(String faid, String customerId) {
		CustomerView entity = manager.forCustomerView().dsl().select().allColumns_FromBaseTable().where().faid().Eq(faid).customer_id().Eq(customerId)
				.getOne();
		if (entity == null) {
			entity = new CustomerView(); 
		}
		return entity;
	}

	public CustomerView findCustomersByFaid(String faid) {
		CustomerView entity = manager.forCustomerView().dsl().select().allColumns_FromBaseTable().where().faid().Eq(faid)
				.getOne();

		if (entity == null) {
			entity = new CustomerView(); 
		}
		return entity;
	}

	public List<Customer> findCustomersByFaidStartLimit(String start, String limit) {
		List<Customer> entities = manager.forCustomer().dsl().select().allColumns_FromBaseTable().without_WHERE_Clause().limit(new Integer(limit))
				.getList();
		if (entities == null) {
			entities = new ArrayList<Customer>(); 
		}
		return entities;
	}

	public List<Customer> findCustomersByLastNameFirstNameStartLimit(String start, String limit, String lastName,
			String firstName) {
		// TODO Auto-generated method stub
		return null;
	}
}