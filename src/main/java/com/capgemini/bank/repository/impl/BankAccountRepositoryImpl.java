package com.capgemini.bank.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.bank.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public double getBalance(long accountId) {
		return jdbcTemplate.queryForObject("select balance from bankdata where accountid=?", new Object[] {accountId},double.class);
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		double balance=jdbcTemplate.queryForObject("select balance from bankdata where accountid=?", new Object[] {accountId},Double.class);
		if(balance+newBalance>=0)
		if(jdbcTemplate.update("update bankdata set balance = ? where accountid = ?", new Object[] {newBalance+balance,accountId})!=0)
		{
			return true;
		}
		return false;
		
	}

}
