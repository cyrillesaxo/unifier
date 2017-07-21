package io.swagger.api;

import io.swagger.model.Customer;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T15:59:15.554-04:00")

@Controller
public class FaidApiController implements FaidApi {



    public ResponseEntity<Customer> unifierFaidCustomer(@ApiParam(value = "faid id",required=true ) @PathVariable("faid_id") String faidId,
        @ApiParam(value = "customer id",required=true ) @PathVariable("customer_id") String customerId,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
        // do some magic!
        return new ResponseEntity<Customer>(HttpStatus.OK);
    }

}
