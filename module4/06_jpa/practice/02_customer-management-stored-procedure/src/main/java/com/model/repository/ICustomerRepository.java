package com.model.repository;

import com.model.bean.Customer;

public interface ICustomerRepository  {
    boolean insertWithStoredProcedure(Customer customer);
}
