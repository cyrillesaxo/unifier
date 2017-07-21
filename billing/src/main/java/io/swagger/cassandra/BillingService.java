package io.swagger.cassandra;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.archinnov.achilles.generated.ManagerFactory;
import io.swagger.cassandra.interfaces.IBillingService;
import io.swagger.model.Allowances;
import io.swagger.model.Billing;
import io.swagger.model.BillingInfo;
import io.swagger.model.ChargesCredits;
import io.swagger.model.LastPayment;
import io.swagger.model.Usage;

/**
 * Created by Cyrille V Eloundou on 07/06/2017.
 */
@Service
public class BillingService implements IBillingService {
	private static final Logger log = LoggerFactory.getLogger(BillingService.class);

	private ExecutorService executor = Executors.newFixedThreadPool(6);
	@Override
	public Billing findByBillingId(String billing_id) {
		// TODO Auto-generated method stub
		return null;
	}


    @Autowired
    CassandraConfiguration cassandraConfiguration;

    private ManagerFactory manager;

    public BillingService(ManagerFactory manager) {
        this.manager = manager;
    }

    public BillingService() {
    }

	@PostConstruct
	public void init() {
        manager = cassandraConfiguration.cassandraNativeClusterDev();
	}
	
	@Override
	public Billing findByBillingsCustomerId(String customer_id) {
		/*	Billing entity = manager.forBilling().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id)
				.getOne();

		if (entity == null) {
			entity = new Billing(); 
		}*/ /*else{ 
			
			BillingInfo billingInfo = manager.forBillingInfo().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id).getOne();
			entity.setBillingInfo(billingInfo);
			List<LastPayment> lastPayment = manager.forLastPayment().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id).getList();
			entity.lastPayment(lastPayment);
			List<Allowances> allowances = manager.forAllowances().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id).getList();
			entity.allowances(allowances);
			List<Usage> usage  = manager.forUsage().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id).getList();
			entity.usage(usage);
			List<ChargesCredits> chargesCredits = manager.forChargesCredits().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id).getList();
			entity.chargesCredits(chargesCredits);
		
			//concurrentRun(entity, customer_id, manager);
		}*/
		Billing entity =null;
		concurrentRun(entity, customer_id, manager);
		return entity;
	}
	
	
	public void concurrentRun(Billing entity, String customer_id, ManagerFactory manager){
		try{
			
			
			Callable<Billing> billingTask = () -> manager.forBilling().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id).getOne();
			Future<Billing> billingFuture = executor.submit(billingTask);
			
				Callable<BillingInfo> billingInfoTask = () -> manager.forBillingInfo().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id).getOne();
				Future<BillingInfo> billingInfoFuture = executor.submit(billingInfoTask);
				
				Callable<List<LastPayment>> lastPaymentTask = () -> manager.forLastPayment().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id).getList();
				Future<List<LastPayment>> lastPaymentFuture = executor.submit(lastPaymentTask);
				
				
				Callable<List<Allowances>> allowancesTask = () -> manager.forAllowances().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id).getList();
				Future<List<Allowances>> allowancesFuture = executor.submit(allowancesTask);
				
				
				Callable<List<Usage>> usageTask = () -> manager.forUsage().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id).getList();
				Future<List<Usage>> usageFuture = executor.submit(usageTask);
				
				
				Callable<List<ChargesCredits>> chargesCreditsTask = () -> manager.forChargesCredits().dsl().select().allColumns_FromBaseTable().where().customerId().Eq(customer_id).getList();
				Future<List<ChargesCredits>> chargesCreditsFuture = executor.submit(chargesCreditsTask);
				
				entity = billingFuture.get();
				BillingInfo billingInfo = billingInfoFuture.get();
				List<LastPayment> lastPayment = lastPaymentFuture.get();
				List<Allowances> allowances = allowancesFuture.get();
				List<Usage> usage = usageFuture.get();
				List<ChargesCredits> chargesCredits = chargesCreditsFuture.get();
				
				
				entity.chargesCredits(chargesCredits);
				entity.setBillingInfo(billingInfo);
				entity.lastPayment(lastPayment);
				entity.allowances(allowances);
				entity.usage(usage);
		
		}catch(ExecutionException e){
			e.printStackTrace();
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createBilling(Billing billing) {

/*        RetryPolicy rp = new BillingRetryPolicy(10, 10, 10);
        try {

            manager.crud()
                    .insert(billing)
                    .withConsistencyLevel(ConsistencyLevel.ANY)
                    .withRetryPolicy(rp)
                    .withInsertStrategy(InsertStrategy.ALL_FIELDS)
                    .usingTimeToLive(0)
                    .withLwtResultListener(lwtResult -> log.error("Error : " + lwtResult))
                    //        .executeAsyncWithStats();
                    .execute();
        } catch (Exception e) {
            String threadName = Thread.currentThread().getName();
            log.debug("Thread " + threadName + ":Equipment " + billing + " failed: " + e.getMessage());
            e.printStackTrace();
            throw (e);
        }*/
		
	}

}