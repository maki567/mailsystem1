package jp.co.openworker.mailsystem1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Register_AddressContoroller {
	  @RequestMapping("/register_address")
	  public String index() {
	    return "register_address/register_address";
	  }
}