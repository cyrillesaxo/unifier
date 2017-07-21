package io.swagger.cassandra.interfaces;

import java.util.List;

import io.swagger.model.Billing;

/**
 * Created by Cyrille V Eloundou on 07/06/2017.
 */
public interface IBillingService {
    public void createBilling(Billing billing);
    public Billing findByBillingId(final String billing_id);
	Billing findByBillingsCustomerId(String customer_id);
}
