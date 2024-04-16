package com.spec.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spec.BService.AccountService;
import com.spec.Entity.Account;

@CrossOrigin("*")
@RestController
public class AccountController {
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@PostMapping("/acc/create")
	public String createAccount(@RequestBody Account account) {
		return accountService.createAcc(account);
	}

	@PostMapping("/accs")
	public List<Account> createAccs(@RequestBody List<Account> accounts) {
		return accountService.createAcc(accounts);
	}

	@GetMapping("/acc/{name}")
	public Account getAccount(@PathVariable String name) {
		Account acc = accountService.findAcc(name);
		return acc;
	}

	@GetMapping("/accs")
	public List<Account> getAllAcc() {
		return accountService.findAll();
	}

	@GetMapping("/acc/{name}/{no}")
	public String withdrawBal(@PathVariable String name, int no) {

		return accountService.withdrawMoney(name, no);

	}

	@GetMapping("/accs/{name}/{no}")
	public String depositBal(@PathVariable String name, int no) {
		return accountService.deposit(name, no);
	}
}
