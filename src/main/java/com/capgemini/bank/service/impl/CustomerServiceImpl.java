package com.capgemini.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bank.model.Customer;
import com.capgemini.bank.repository.CustomerRepository;
import com.capgemini.bank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer authenticate(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.authenticate(customer);
	}

	@Override
	public Customer updateProfile(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.updateProfile(customer);
	}

	@Override
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return customerRepository.updatePassword(customer, oldPassword, newPassword);
	}

}
