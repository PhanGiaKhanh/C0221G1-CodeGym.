package case_study.controllers;

import case_study.commons.Common;
import case_study.commons.FileUtils;
import case_study.models.Customer;

import java.util.Comparator;
import java.util.List;

public class ShowInformationCustomer {
    public static void show(){
        List<Customer> list = FileUtils.readCustomer(Common.DATA_CUSTOMER);
        list.sort(Comparator.comparing(Customer :: getCustomerName).thenComparing(Customer::getDayOfBirth));
        list.forEach(e->e.showInfo());
    }
}
