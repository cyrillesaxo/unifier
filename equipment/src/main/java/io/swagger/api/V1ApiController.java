package io.swagger.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import io.swagger.annotations.ApiParam;
import io.swagger.cassandra.EquipmentService;
import io.swagger.model.Equipment;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-06T13:50:52.490-04:00")

@Controller
public class V1ApiController implements V1Api {

	@Autowired
	private EquipmentService equipmentService;

    public ResponseEntity<List<Equipment>> unifier(@ApiParam(value = "customer id",required=true ) @PathVariable("customer_id") String customerId,
        @ApiParam(value = "authorization header" ) @RequestHeader(value="authorization", required=false) String authorization,
        @ApiParam(value = "application user id" ) @RequestHeader(value="applicationId", required=false) String applicationId) {
    	
    	List<Equipment> equipments = equipmentService.findByEquipmentsCustomerId(customerId);
    	ResponseEntity<List<Equipment>> response = new ResponseEntity<List<Equipment>>(equipments,HttpStatus.OK);
        return response;
    }

	public EquipmentService getEquipmentService() {
		return equipmentService;
	}

	public void setEquipmentService(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}
    

}
