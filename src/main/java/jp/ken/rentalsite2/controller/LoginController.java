package jp.ken.rentalsite2.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.ken.rentalsite2.dao.UsersInfoDAO;
import jp.ken.rentalsite2.entity.UsersInfo;
import jp.ken.rentalsite2.model.User;

@Controller
@SessionAttributes("user")
public class LoginController {
	private static ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static UsersInfoDAO<UsersInfo> usersInfoDAO=
(UsersInfoDAO<UsersInfo>)context.getBean("usersInfoDAO");
	
	@ModelAttribute("user")
	public User setUser() {
		return new User();
	}
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String toLogin(Model model) {
		List<UsersInfo> list=usersInfoDAO.allList();
		model.addAttribute("usersList",list);
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@Validated @ModelAttribute User user,BindingResult result,Model model) {
		List<UsersInfo> list=usersInfoDAO.allList();
		for(UsersInfo uInfo:list) {
			if(uInfo.getName().equals(user.getName())&&uInfo.getPassword().equals(user.getPassword())) {
				user.setId(uInfo.getId());
				user.setKana(uInfo.getKana());
				user.setAge(uInfo.getAge());
				user.setGender(uInfo.getGender());
				user.setBirthday(uInfo.getBirthday());
				user.setAddress(uInfo.getAddress());
				user.setPhone(uInfo.getPhone());
				user.setMail(uInfo.getMail());
				user.setPassword(uInfo.getPassword());
				return "mainMenu";
			}
		}
		model.addAttribute("message","該当するアカウント情報がありませんでした。未登録の方は新規登録をして下さい。");
		return "login";
	}

}
