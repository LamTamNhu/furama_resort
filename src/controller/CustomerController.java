package controller;

import services.ICustomerService;
import services.impl.CustomerService;

public class CustomerController {
    private final ICustomerService customerService = new CustomerService();

    public Object getAll() {
        return customerService.getAll();
    }
}
