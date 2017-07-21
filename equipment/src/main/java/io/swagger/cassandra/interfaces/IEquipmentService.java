package io.swagger.cassandra.interfaces;

import java.util.List;

import io.swagger.model.Equipment;

/**
 * Created by Cyrille V Eloundou on 07/06/2017.
 */
public interface IEquipmentService {
    public void createCustomer(Equipment equipment);
    public Equipment findByEquipmentId(final String customer_id);
    public List<Equipment> findByEquipmentsCustomerId(String customer_id); 
}
