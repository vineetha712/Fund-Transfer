package com.fundTransfer.fundTransfer.Handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.fundTransfer.fundTransfer.Entity.Beneficiary;
import com.fundTransfer.fundTransfer.Repo.BeneficiaryRepo;

import reactor.core.publisher.Mono;

public class BeneficiaryHandler {
	@Autowired
	private BeneficiaryRepo beneficiaryRepo;
	/** 
     * Create a new user. 
     */
    public Mono<ServerResponse> createBeneficiary(ServerRequest request) { 
        Mono<Beneficiary> userMono = request.bodyToMono(Beneficiary.class); 
        return userMono.flatMap(beneficiary -> beneficiaryRepo.save(beneficiary)) 
                .flatMap(savedBeneficiary -> ServerResponse.ok().bodyValue(savedBeneficiary)); 
    } 
}
