package com.pedrodev.financialmanager.repository;

import com.pedrodev.financialmanager.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasactionRepository extends JpaRepository<Transaction, Long> {
}
