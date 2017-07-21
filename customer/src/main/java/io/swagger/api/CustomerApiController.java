package io.swagger.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import io.swagger.annotations.ApiParam;
import io.swagger.cassandra.CustomerService;
import io.swagger.model.Customer;
import io.swagger.model.CustomerView;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T15:59:15.554-04:00")

@Controller
public class CustomerApiController implements CustomerApi {

	@Autowired
	private CustomerService customerService;

    public ResponseEntity<Customer> unifierCustomer(@ApiParam(value = "customer id",required=true ) @PathVariable("customer_id") String customerId,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
    	
    	Customer customer = customerService.findByCustomerId(customerId);
    	ResponseEntity<Customer> response = new ResponseEntity<Customer>(customer,HttpStatus.OK);
        return response;
    }

    public ResponseEntity<List<Customer>> unifierCustomerAll(@ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
    	
    	List<Customer> customers = customerService.findcustomers();
    	ResponseEntity<List<Customer>> response = new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
        return response;
    }

    public ResponseEntity<List<Customer>> unifierCustomerAllPagination(@ApiParam(value = "start",required=true ) @PathVariable("start") String start,
        @ApiParam(value = "limit",required=true ) @PathVariable("limit") String limit,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
        // do some magic!
    	List<Customer> customers = customerService.findCustomersPagination(start,limit);
    	ResponseEntity<List<Customer>> response = new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
        return response;
    }

    public ResponseEntity<List<Customer>> unifierCustomerAllSearchLastName(@ApiParam(value = "last_name",required=true ) @PathVariable("last_name") String lastName,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
        // do some magic!
    	List<Customer> customers = customerService.findCustomersByLastName(lastName);
    	ResponseEntity<List<Customer>> response = new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
        return response;
    }

    public ResponseEntity<List<Customer>> unifierCustomerAllSearchLastNameFirstName(@ApiParam(value = "last_name",required=true ) @PathVariable("last_name") String lastName,
        @ApiParam(value = "first name",required=true ) @PathVariable("first_name") String firstName,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
        // do some magic!
    	List<Customer> customers = customerService.findCustomersByLastNameFirstName(lastName, firstName);
    	ResponseEntity<List<Customer>> response = new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
        return response;
    }

    public ResponseEntity<List<Customer>> unifierCustomerAllSearchLastNameFirstNamePagination(@ApiParam(value = "start",required=true ) @PathVariable("start") String start,
        @ApiParam(value = "limit",required=true ) @PathVariable("limit") String limit,
        @ApiParam(value = "last_name",required=true ) @PathVariable("last_name") String lastName,
        @ApiParam(value = "first name",required=true ) @PathVariable("first_name") String firstName,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
        // do some magic!
    	List<Customer> customers = customerService.findCustomersByLastNameFirstNameStartLimit(start, limit, lastName, firstName);
    	ResponseEntity<List<Customer>> response = new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
        return response;
    }

    public ResponseEntity<List<Customer>> unifierCustomerAllSearchLastNamePagination(@ApiParam(value = "start",required=true ) @PathVariable("start") String start,
        @ApiParam(value = "limit",required=true ) @PathVariable("limit") String limit,
        @ApiParam(value = "last_name",required=true ) @PathVariable("last_name") String lastName,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
        // do some magic!
    	List<Customer> customers = customerService.findCustomersByLastNameStartLimit(start, limit, lastName);
    	ResponseEntity<List<Customer>> response = new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
        return response;
    }

    public ResponseEntity<CustomerView> unifierCustomerFaid(@ApiParam(value = "faid id",required=true ) @PathVariable("faid_id") String faidId,
        @ApiParam(value = "customer id",required=true ) @PathVariable("customer_id") String customerId,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
        // do some magic!
    	CustomerView customer = customerService.findCustomersByFaidCustomerId(faidId, customerId);
    	ResponseEntity<CustomerView> response = new ResponseEntity<CustomerView>(customer,HttpStatus.OK);
        return response;
    }

    public ResponseEntity<CustomerView> unifierFaid(@ApiParam(value = "faid id",required=true ) @PathVariable("faid_id") String faidId,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
        // do some magic!
    	CustomerView customer = customerService.findCustomersByFaid(faidId);
    	ResponseEntity<CustomerView> response = new ResponseEntity<CustomerView>(customer,HttpStatus.OK);
        return response;
    }

    public ResponseEntity<List<Customer>> unifierFaidAll(@ApiParam(value = "start",required=true ) @PathVariable("start") String start,
        @ApiParam(value = "limit",required=true ) @PathVariable("limit") String limit,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {

    	List<Customer> customers = customerService.findCustomersByFaidStartLimit(start, limit);
    	ResponseEntity<List<Customer>> response = new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
        return response;
    }

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
    

}
