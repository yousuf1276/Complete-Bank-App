package com.spec.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spec.Entity.BankEntity;

public interface BankRepo extends JpaRepository<BankEntity, String> {
	BankEntity findByName(String name);

}
