package model.service.impl;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;
import model.repository.ServiceRepository;
import model.service.ServiceService;

import java.util.List;

public class ServiceImpl implements ServiceService {
    private ServiceRepository serviceRepository = new ServiceRepository();

    @Override
    public List<Service> findAll() {
        return serviceRepository.findByAll();
    }

    @Override
    public List<RentType> findRentType() {
        return serviceRepository.findRentType();
    }

    @Override
    public List<ServiceType> findServiceType() {
        return serviceRepository.findServiceType();
    }

    @Override
    public boolean insertService(Service service) {
        return serviceRepository.insert(service);
    }

    @Override
    public boolean deleteService(int id) {
        return false;
    }

    @Override
    public Service findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public boolean updateById(int id, Service service) {
        return false;
    }

    @Override
    public List<Service> searchByName(String name) {
        return null;
    }
}
