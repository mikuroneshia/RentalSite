package jp.ken.rentalsite2.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jp.ken.rentalsite2.dao.UsersInfoDAO;
import jp.ken.rentalsite2.entity.UsersInfo;
import jp.ken.rentalsite2.model.User;
@Controller
@SessionAttributes("user")
public class DeleteController {
	
	private static ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	private static UsersInfoDAO<UsersInfo> usersInfoDAO=
			(UsersInfoDAO<UsersInfo>)context.getBean("usersInfoDAO");
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteConfrim(@ModelAttribute User user) {
		return "deleteConfirm";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteComplete(@ModelAttribute User user,Model model,SessionStatus status) {
		UsersInfo uInfo=new UsersInfo();
		BeanUtils.copyProperties(user, uInfo);
		if(usersInfoDAO.deleteUserData(uInfo)==1) {
			status.setComplete();
			return "deleteComplete";
		}else {
			model.addAttribute("message","アカウントの削除に失敗しました");
			return "mainMenu";
		}
		
	}
}
