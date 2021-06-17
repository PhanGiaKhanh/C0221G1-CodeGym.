package com.model.service;

import com.model.bean.Customer;
public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
