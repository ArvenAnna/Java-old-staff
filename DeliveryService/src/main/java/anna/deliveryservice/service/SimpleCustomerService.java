/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anna.deliveryservice.service;

import anna.deliveryservice.domain.Customer;
import anna.deliveryservice.exception.NoSuchCustomerException;
import anna.deliveryservice.repository.CustomerRepository;

/**
 *
 * @author Alex
 */
public class SimpleCustomerService implements CustomerService{
    
    private CustomerRepository customerRepository;

    public SimpleCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void giveCard(Customer customer) {
        if(customerRepository.findById(customer.getId())!=null){
            customer.setCard(0);
        }else{
            throw new NoSuchCustomerException();
        }
        customerRepository.update(customer);
    }

    @Override
    public Integer addSumToCard(Customer customer, int sum) {
        if(customer.getCard()!=null){
            customer.setCard(customer.getCard() + sum);
            customerRepository.update(customer);
            return customer.getCard();
        }else return null;   
    }
    
}