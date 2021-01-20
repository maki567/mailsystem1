package jp.co.openworker.mailsystem1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/mailsystem/top_page")
public class HomeController {

  @RequestMapping("/")
  public String index() {
	  return "top_page";
  //@ResponseBody
  //public String index() {
    //return "<a href=\"/logout\">ログアウト</a>";
  }
}
