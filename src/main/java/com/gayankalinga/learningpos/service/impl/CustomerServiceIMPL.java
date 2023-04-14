package com.gayankalinga.learningpos.service.impl;

import com.gayankalinga.learningpos.dto.CustomerDTO;
import com.gayankalinga.learningpos.dto.request.CustomerUpdateRequestDTO;
import com.gayankalinga.learningpos.entity.Customer;
import com.gayankalinga.learningpos.repository.CustomerRepository;
import com.gayankalinga.learningpos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
- service is implementing the service interface
- if any changes service class will throw errors not the controller class
- in this class you have to transfer DTO to Entity
 */

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {



        Customer customer = new Customer(

                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumbers(),
                customerDTO.getNic(),
                customerDTO.isActiveStatus()
        );

        customerRepository.save(customer);
        return customerDTO.getCustomerName() + " Saved";
    }

    @Override
    public CustomerDTO updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {

        if(customerRepository.existsById(customerUpdateRequestDTO.getCustomerId())){
            Customer customer = customerRepository.getReferenceById(customerUpdateRequestDTO.getCustomerId());

            //Update Entity values with update DTO values
            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
            customer.setNic(customerUpdateRequestDTO.getNic());
            customer.setActiveStatus(customerUpdateRequestDTO.isActiveStatus());

            customerRepository.save(customer);

            //Convert the Entity to DTO
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.isActiveStatus()
            );

            return customerDTO;

        }else{
            throw new RuntimeException("Cannot find the customer to update");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepository.existsById(customerId)){
            Customer customer = customerRepository.getReferenceById(customerId);

            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.isActiveStatus()
            );

            return customerDTO;

        }else{
            throw new RuntimeException("Customer Not Found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        if(customerList.size() > 0){
            List<CustomerDTO> customerDTOList = new ArrayList<>();

            for (Customer customer: customerList) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getContactNumbers(),
                        customer.getNic(),
                        customer.isActiveStatus()
                );
                customerDTOList.add(customerDTO);
            }

            return customerDTOList;
        }else{
            throw new RuntimeException("Something went wrong");
        }

    }

    @Override
    public String deleteCustomerById(int customerId) {
        if(customerRepository.existsById(customerId)){
            customerRepository.deleteById(customerId);
            return customerId + " Deleted";
        }else{
            throw new RuntimeException("Not Found");
        }
    }


}
