/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Customer;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T15:59:15.554-04:00")

@Api(value = "faid", description = "the faid API")
public interface FaidApi {

    @ApiOperation(value = "Get unifier information", notes = "This API will return a customer information.", response = Customer.class, tags={ "unifier", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The request was successful", response = Customer.class),
        @ApiResponse(code = 400, message = "Bad request error", response = Void.class),
        @ApiResponse(code = 404, message = "Record not found", response = Void.class),
        @ApiResponse(code = 500, message = "The server encountered an unexpected condition which prevented it from fulfilling the request", response = Void.class) })
    
    @RequestMapping(value = "/faid/{faid_id}/customer/{customer_id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Customer> unifierFaidCustomer(@ApiParam(value = "faid id",required=true ) @PathVariable("faid_id") String faidId,@ApiParam(value = "customer id",required=true ) @PathVariable("customer_id") String customerId,@ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,@ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId);

}
