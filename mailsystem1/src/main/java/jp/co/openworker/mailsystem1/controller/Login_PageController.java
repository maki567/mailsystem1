package jp.co.openworker.mailsystem1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class Login_PageController {
	  @RequestMapping("/login_page")
	  public String index() {
	    return "login_page/login_page";
	  }
}