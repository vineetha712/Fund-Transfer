package com.fundTransfer.fundTransfer.Repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.fundTransfer.fundTransfer.Entity.Beneficiary;

public interface BeneficiaryRepo extends ReactiveCrudRepository<Beneficiary, Long> {

}
