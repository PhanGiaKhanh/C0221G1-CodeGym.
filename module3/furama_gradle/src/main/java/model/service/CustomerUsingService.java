package model.service;

import model.bean.customer.CustomerUsing;

import java.util.List;

public interface CustomerUsingService {
    List<CustomerUsing> findAll();
    List<CustomerUsing> search(String name);

}
