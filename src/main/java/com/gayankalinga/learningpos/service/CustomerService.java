package com.gayankalinga.learningpos.service;

import com.gayankalinga.learningpos.dto.CustomerDTO;
import com.gayankalinga.learningpos.dto.request.CustomerUpdateRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/* making an agreement between controller & service
- this is a way of loosing the coupling between these two classes
- controller will use service interface instead of service impl
 */

@Service
public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomerById(int customerId);
}
