package io.swagger.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import io.swagger.annotations.ApiParam;
import io.swagger.cassandra.BillingService;
import io.swagger.model.Billing;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T13:50:42.619-04:00")

@Controller
public class V1ApiController implements V1Api {

	@Autowired
	private BillingService billingService;

    public ResponseEntity<Billing> unifier(@ApiParam(value = "customer id",required=true ) @PathVariable("customer_id") String customerId,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
        // do some magic!
    	
    	Billing billings = billingService.findByBillingsCustomerId(customerId);
    	ResponseEntity<Billing> response = new ResponseEntity<Billing>(billings,HttpStatus.OK);
        return response;
    }

	public BillingService getBillingService() {
		return billingService;
	}

	public void setBillingService(BillingService billingService) {
		this.billingService = billingService;
	}
    
}
