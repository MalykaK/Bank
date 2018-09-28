package com.capgemini.bank.repository;

import com.capgemini.bank.model.Customer;

public interface CustomerRepository {
	public Customer authenticate(Customer customer);
	public Customer updateProfile(Customer customer);
	public boolean updatePassword(Customer customer, String oldPassword, String newPassword);
}
