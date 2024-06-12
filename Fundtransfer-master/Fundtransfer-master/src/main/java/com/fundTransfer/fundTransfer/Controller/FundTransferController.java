package com.fundTransfer.fundTransfer.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class FundTransferController {

     @RequestMapping("/fundTransfer")
     public String home(){
         return "transferType";
     }
     
     @RequestMapping("/imps")
     public String impsForm(){
         return "imps";
     }
     
     @RequestMapping(value = "/sendImps", method = RequestMethod.POST)
     public String sendImps(@RequestParam Map<String, String> request, Model model) {
		model.addAttribute("formData", request);
    	return "impsSuccess";
	}
     
     @RequestMapping("/neft")
     public String neftForm(){
         return "neft";
     }
     
     @RequestMapping(value = "/sendNeft", method = RequestMethod.POST)
     public String sendNeft(@RequestParam Map<String, String> request, Model model) {
		model.addAttribute("formData", request);
    	 return "neftSuccess";
	}
     
     @RequestMapping("/rtgs")
     public String rtgsForm(){
         return "rtgs";
     }
     
     @RequestMapping(value = "/sendRtgs", method = RequestMethod.POST)
     public String sendRtgs(@RequestParam Map<String, String> request, Model model) {
		model.addAttribute("formData", request);
    	 return "rtgsSuccess";
	}
 }