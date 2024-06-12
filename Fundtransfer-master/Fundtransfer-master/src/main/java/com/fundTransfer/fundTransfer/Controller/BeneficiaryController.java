package com.fundTransfer.fundTransfer.Controller;
import java.util.Map;

import com.fundTransfer.fundTransfer.Entity.Beneficiary;
import com.fundTransfer.fundTransfer.Repo.BeneficiaryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;


@Controller
public class BeneficiaryController {
	@Autowired
	private BeneficiaryRepo beneficiaryRepo;
	
	@RequestMapping("/beneficiary")
    public String showCreateBeneficiary(){
        return "newBeneficiary";
    }
	
	@RequestMapping(value = "/addBeneficiary", method = RequestMethod.POST)
	public String createBeneficiary(@RequestParam Map<String, String> request) {
		Beneficiary beneficiary = new Beneficiary();
		System.out.println(request);
		System.out.println(request.get("accountNumber"));
		beneficiary.setAccountNumber((String)request.get("accountNumber"));
		beneficiary.setName((String)request.get("name"));
		beneficiary.setNickName((String)request.get("nickName"));
		beneficiary.setAccountNumber2((String)request.get("accountNumber2"));
        Mono<Beneficiary> userMono = Mono.just(beneficiary);//request.bodyToMono(Beneficiary.class);
        userMono.flatMap(beneficiary1 -> beneficiaryRepo.save(beneficiary1)).subscribe(); 
        return "beneficiarySaved";
    }
}
