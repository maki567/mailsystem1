package jp.co.openworker.mailsystem1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.openworker.mailsystem1.model.domain.MstUser;
import jp.co.openworker.mailsystem1.model.form.UserForm;
import jp.co.openworker.mailsystem1.model.mapper.MstUserMapper;
import jp.co.openworker.mailsystem1.model.session.LoginSession;

@Controller
@RequestMapping("/mailsystem1/user")
public class UserController {
	
	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@RequestMapping("/")
	public String index(Model m) {
		m.addAttribute("loginSession", loginSession);
		return "register_user/register_user";
	}
	
	@RequestMapping("/duplicatedUserName")
	@ResponseBody
	public boolean duplicatedUserName(@RequestParam String userName) {
		int count = userMapper.findCountByUserName(userName);
		return count > 0;
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public boolean register(@RequestBody UserForm f) {
		MstUser user = new MstUser(f);
		
		int count = userMapper.insert(user);
		
		return count > 0;
	}
	
}