package com.model.service;

import com.model.bean.Customer;
import com.model.bean.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
