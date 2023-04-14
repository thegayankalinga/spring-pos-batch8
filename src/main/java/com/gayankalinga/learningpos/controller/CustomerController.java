package com.gayankalinga.learningpos.controller;

import com.gayankalinga.learningpos.dto.CustomerDTO;
import com.gayankalinga.learningpos.dto.request.CustomerUpdateRequestDTO;
import com.gayankalinga.learningpos.service.CustomerService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    /*
    - if there are multiple implementations of the interface
    - we can use @Qualifier annotations to specify the object
     */

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String indexPage(){
        return "Hello this is the POS Application for Batch 8";
    }

    @PostMapping(path = "save-customer")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        /*front end request property names should be same as DTO properties
        to have correctly transformed from json to java & vise-versa
         */
        return customerService.saveCustomer(customerDTO);
    }

    @PutMapping(path ={"/update"})
    public CustomerDTO updateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO){
        return customerService.updateCustomer(customerUpdateRequestDTO);
    }

    @GetMapping(path = {"/get-by-id"}, params = {"id"})
    public CustomerDTO getCustomerById(@RequestParam(value = "id")int customerId){
        return customerService.getCustomerById(customerId);
    }

    @GetMapping(path = {"/get-all"})
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @DeleteMapping(path = {"/delete/{id}"})
    public String deleteCustomerById(@PathVariable(value = "id") int customerId){
        return customerService.deleteCustomerById(customerId);
    }

}
