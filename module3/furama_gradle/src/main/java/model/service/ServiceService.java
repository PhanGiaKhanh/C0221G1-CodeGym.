package model.service;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();

    List<RentType> findRentType();

    List<ServiceType> findServiceType();

    boolean insertService(Service service);

    boolean deleteService(int id);

    Service findById(int id);

    boolean updateById(int id, Service service);

    List<Service> searchByName(String name);

}
