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
	
	/* �ʿ���µ�?
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}*/
	//�ϲ��� �ڽ��� ���� ������ ���� ��
	@RequestMapping(value = "/mains/my_page", method = RequestMethod.GET)
	public String goMypage(Locale locale, Model model) {

		return "my_page";
	}

	//�����ϴ� �κ�
	@RequestMapping(value = "/mains/signup", method = RequestMethod.GET)
	public String signup(Locale locale, Model model) {

		return "signup";
	}
	//����ϴ� �κ�
	@RequestMapping(value = "/mains/contract", method = RequestMethod.GET)
	public String contracts(Locale locale, Model model) {

		return "contract";
	}
	
	//�α��� �� ���� Ȩ
	@RequestMapping(value = "/mains/Families_main", method = RequestMethod.GET)
	public String goHomeMain(Locale locale, Model model) {

		return "Families_main";
	}
	/*
	@RequestMapping(value = "/mains/board_write", method = RequestMethod.GET)
	public String board_write(Locale locale, Model model) {

		return "board_write";
	}*/
	
	//��ü��ȸ(��ΰ� �ø��Ÿ� �����ڰ� ��ȸ)
	@RequestMapping(value = "/mains/select", method = RequestMethod.GET)
	public String selectAll(Locale locale, Model model) {

		return "select";
	}
	
	//���� �� �˻� �� ��ȸ(��ΰ� �ø��Ÿ� �ϲ��� ��ȸ)
	@RequestMapping(value = "/mains/search", method = RequestMethod.GET)
	public String searchAll(Locale locale, Model model) {

		return "search";
	}
	
	
	//��� �� �����ϴ� ��(��ΰ� �ڽ��� �Խù��� �ø���, �����ϴ� �κ�)
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
