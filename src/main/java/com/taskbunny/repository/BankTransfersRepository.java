package com.taskbunny.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskbunny.models.BankTransfers;

public interface BankTransfersRepository extends JpaRepository<BankTransfers, Integer>{

}
