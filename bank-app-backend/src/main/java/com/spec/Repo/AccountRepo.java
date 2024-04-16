package com.spec.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spec.Entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {

	Account findByName(String name);

}
