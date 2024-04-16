package com.spec.BService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spec.Entity.Account;
import com.spec.Repo.AccountRepo;

@Service
public class AccountService {
	private AccountRepo accountRepo;

	public AccountService(AccountRepo accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	public String createAcc(Account account) {
		accountRepo.save(account);
		return "Success";
	}

	public Account findAcc(String name) {
		return accountRepo.findByName(name);
	}

	public List<Account> findAll() {
		return accountRepo.findAll();
	}

	public List<Account> createAcc(List<Account> accounts) {
		accounts.stream().forEach(account -> accountRepo.save(account));
		return accountRepo.findAll();
	}

	public String withdrawMoney(String name, int no) {
		Account acc = accountRepo.findByName(name);
		if (acc.getBalance() > no) {
			int temp = acc.getBalance() - no;
			acc.setBalance(temp);
			accountRepo.save(acc);
			return "current balance " + (acc.getBalance());
		} else {
			return null;
		}

	}

	public String deposit(String name, int no) {
		Account acc = accountRepo.findByName(name);
		int oldBal = acc.getBalance();
		acc.setBalance(oldBal + no);
		int newBal = acc.getBalance();
		accountRepo.save(acc);
		return "Available Balance=" + newBal;
	}

}
