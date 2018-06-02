package com.coin.Controller;

import java.util.Collection;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coin.dao.UserDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	/* 필요없는듯?
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}*/
	//일꾼이 자신이 일한 내역을 보는 곳
	@RequestMapping(value = "/mains/my_page", method = RequestMethod.GET)
	public String goMypage(Locale locale, Model model) {

		return "my_page";
	}

	//가입하는 부분
	@RequestMapping(value = "/mains/signup", method = RequestMethod.GET)
	public String signup(Locale locale, Model model) {

		return "signup";
	}
	//계약하는 부분
	@RequestMapping(value = "/mains/contract", method = RequestMethod.GET)
	public String contracts(Locale locale, Model model) {

		return "contract";
	}
	
	//로그인 후 메인 홈
	@RequestMapping(value = "/mains/Families_main", method = RequestMethod.GET)
	public String goHomeMain(Locale locale, Model model) {

		return "Families_main";
	}
	/*
	@RequestMapping(value = "/mains/board_write", method = RequestMethod.GET)
	public String board_write(Locale locale, Model model) {

		return "board_write";
	}*/
	
	//전체조회(농부가 올린거를 관리자가 조회)
	@RequestMapping(value = "/mains/select", method = RequestMethod.GET)
	public String selectAll(Locale locale, Model model) {

		return "select";
	}
	
	//일할 곳 검색 및 조회(농부가 올린거를 일꾼이 조회)
	@RequestMapping(value = "/mains/search", method = RequestMethod.GET)
	public String searchAll(Locale locale, Model model) {

		return "search";
	}
	
	
	//등록 및 수정하는 곳(농부가 자신이 게시물을 올리고, 수정하는 부분)
		@RequestMapping(value = "/mains/index", method = RequestMethod.GET)
		public String insert_farmer(HttpServletRequest request, Model model) {

			UserDAO user = new UserDAO();
			
			Collection<?> attributeValues = user.getListByIDLike("");
			model.addAllAttributes(attributeValues);
			return "search";
		}
	
	/*
	@RequestMapping(value = "/board_write", method = RequestMethod.GET)
	public String board_write(Locale locale, Model model) {

		return "board_write";
	}*/
	
	
}
