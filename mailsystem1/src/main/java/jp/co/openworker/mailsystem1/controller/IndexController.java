package jp.co.openworker.mailsystem1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.openworker.mailsystem1.model.mapper.MstCategoryMapper;
import jp.co.openworker.mailsystem1.model.mapper.MstProductMapper;
import jp.co.openworker.mailsystem1.model.session.LoginSession;
import jp.co.openworker.mailsystem1.model.form.SearchForm;
import jp.co.openworker.mailsystem1.model.domain.MstCategory;
import jp.co.openworker.mailsystem1.model.domain.MstProduct;


@Controller
@RequestMapping("/mailsystem1")
public class IndexController {

	@Autowired
	MstCategoryMapper categoryMapper;
	
	@Autowired
	MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	
	@RequestMapping("/")
	public String index(Model m) {
		if (!loginSession.getLogined() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = (int)(Math.random() * 1000000000 * -1);
			while (tmpUserId > -100000000) {
				tmpUserId *= 10;
			}
			loginSession.setTmpUserId(tmpUserId);
		}
		
		List<MstCategory> categorys = categoryMapper.find();	
		
		List<MstProduct> products = productMapper.find();
		
		m.addAttribute("categorys", categorys);
		m.addAttribute("selected", 0);
		m.addAttribute("products", products); 
		m.addAttribute("loginSession", loginSession);
		return "index";
	}
	
	@RequestMapping("/search")
	public String index(SearchForm f, Model m) {
		List<MstProduct> products;

		String keywords = f.getKeywords().replaceAll("　", " ").replaceAll("\\s{2,}", " ").trim();
		if (f.getCategory() == 0) {
			// 
			products = productMapper.findByProductName(keywords.split(" "));
		} else {
			products = productMapper.findByCategoryAndProductName(f.getCategory(), keywords.split(" "));
			
		}

		List<MstCategory> categorys = categoryMapper.find();
		m.addAttribute("keywords", keywords);
		m.addAttribute("selected", f.getCategory()); 
		m.addAttribute("categorys", categorys); 
		m.addAttribute("products", products); 
		m.addAttribute("loginSession", loginSession);
		
		return "index";
		
	}
}