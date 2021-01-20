package jp.co.openworker.mailsystem1.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

	@Controller
	@RequestMapping("/mailsystem/top_page")
	public class CustomerController {

	    @RequestMapping("/")
	    public String test() {
	        return "top_page";
	    }

	}


