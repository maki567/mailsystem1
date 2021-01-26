package jp.co.openworker.mailsystem1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class My_PageController {
	  @RequestMapping("/my_page")
	  public String index() {
	    return "my_page/my_page";
	  }
}