package com.capgemini.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.bank.exceptions.PayeeAccountNotFoundException;
import com.capgemini.bank.repository.BankAccountRepository;
import com.capgemini.bank.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public double getBalance(long accountId) {
		return bankAccountRepository.getBalance(accountId);

	}

	@Override
	public double withdraw(long accountId, double amount) {
		if (bankAccountRepository.updateBalance(accountId, -1 * amount))
			return bankAccountRepository.getBalance(accountId);
		return bankAccountRepository.getBalance(accountId);

	}

	@Override
	public double deposit(long accountId, double amount) {
		if (bankAccountRepository.updateBalance(accountId, amount))
			return bankAccountRepository.getBalance(accountId);
		return bankAccountRepository.getBalance(accountId);
	}

	@Override
	public boolean fundTransfer(long fromAcc, long toAcc, double amount) throws PayeeAccountNotFoundException {

		if (bankAccountRepository.getBalance(toAcc) < 0) {
			throw new PayeeAccountNotFoundException("payee account not found");
		}

		else if (bankAccountRepository.updateBalance(fromAcc, -1 * amount)) {
			if (bankAccountRepository.updateBalance(toAcc, amount)) {
				return true;
			}
		}
		throw new PayeeAccountNotFoundException("Fund transfer unsuccessfull");
	}

}
