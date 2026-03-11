package com.pedrodev.financialmanager.repository;

import com.pedrodev.financialmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
