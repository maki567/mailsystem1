package jp.co.openworker.mailsystem1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class HomeController {
	  @RequestMapping("/home")
	  public String index() {
	    return "test1/test";
	  }
}