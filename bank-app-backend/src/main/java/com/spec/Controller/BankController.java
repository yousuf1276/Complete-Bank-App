package com.spec.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.spec.BService.BankService;
import com.spec.Entity.BankEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RestController
public class BankController {
	@Autowired
	BankService bkService;
	
	@PostMapping("/bank/user")
	public List<BankEntity> addAllUserDB(@RequestBody List<BankEntity> bkEntity) {
		
		return bkService.addAllUserToDB(bkEntity);
	}
	@GetMapping("/bank/getuser")
	public String checkLogin(@RequestParam String name,String password) {
		return bkService.checkIsValidUser(name,password);
	}
	

}
