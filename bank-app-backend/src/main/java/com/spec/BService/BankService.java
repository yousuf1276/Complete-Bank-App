package com.spec.BService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spec.Entity.BankEntity;
import com.spec.Repo.BankRepo;

@Service
public class BankService {

	@Autowired
	BankRepo bkRepo;

	public List<BankEntity> addAllUserToDB(List<BankEntity> bkEntity) {
		// TODO Auto-generated method stub
		return bkRepo.saveAll(bkEntity);
	}

	public String checkIsValidUser(String name, String password) {
		
		BankEntity bkEntity = bkRepo.findByName(name);
		
		if( (bkEntity != null) && (bkEntity.getPassword().contentEquals(password) == true)){
			
			return "success";
		}
		
		return "failure";
	}

	

}