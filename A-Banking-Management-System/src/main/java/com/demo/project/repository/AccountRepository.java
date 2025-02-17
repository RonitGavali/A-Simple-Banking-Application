package com.demo.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.project.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
