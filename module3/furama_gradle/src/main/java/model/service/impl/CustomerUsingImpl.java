package model.service.impl;

import model.bean.customer.CustomerUsing;
import model.repository.CustomerUsingRepository;
import model.service.CustomerUsingService;

import java.util.List;

public class CustomerUsingImpl implements CustomerUsingService {
    CustomerUsingRepository customerUsingRepository = new CustomerUsingRepository();
    @Override
    public List<CustomerUsing> findAll() {
        return customerUsingRepository.findAll();
    }

    @Override
    public List<CustomerUsing> search(String name) {
        return customerUsingRepository.search(name);
    }


}
