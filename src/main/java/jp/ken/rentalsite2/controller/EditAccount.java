package jp.ken.rentalsite2.controller;


import java.util.List;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import org.springframework.beans.BeanUtils;
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
import jp.ken.rentalsite2.model.Group1;
import jp.ken.rentalsite2.model.Group2;
import jp.ken.rentalsite2.model.User;

@Controller
@SessionAttributes("user")
public class EditAccount {
	@GroupSequence({Default.class,Group1.class,Group2.class})
	interface GroupOrder{}
	private static ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	@SuppressWarnings("unchecked")
	
	private static UsersInfoDAO<UsersInfo> usersInfoDAO=
			(UsersInfoDAO<UsersInfo>)context.getBean("usersInfoDAO");
	
	@RequestMapping(value="editAccount",method=RequestMethod.GET)
	public String toEditAccount(@ModelAttribute User user,Model model) {
		return "editAccount";
	}
	
	@RequestMapping(value="editAccount",method=RequestMethod.POST,params="confirm")
	public String confirm(@Validated(GroupOrder.class) @ModelAttribute User user,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "editAccount";
		}
		return "editConfirm";
	}
	@RequestMapping(value="editAccount",method=RequestMethod.POST,params="regist")
	public String regist(@ModelAttribute User user,Model model) {
		List<UsersInfo>list=usersInfoDAO.allList();
		for(UsersInfo ui:list) {
			if(!ui.getId().equals(user.getId())) {
				if(user.getName().equals(ui.getName())&&user.getBirthday().equals(ui.getBirthday())){
					model.addAttribute("message","既にアカウントが作られている可能性があります。");
					return "editAccount";
				}else if(user.getName().equals(ui.getName())&&user.getPassword().equals(ui.getPassword())){
					model.addAttribute("message","既に使用されている名前とパスワードです。パスワードを変更してください。");
					return "editAccount";
				}else if(user.getPhone().equals(ui.getPhone())){
					model.addAttribute("message","既に使用されている電話番号です。");
					return "editAccount";
				}else if(user.getMail().equals(ui.getMail())){
					model.addAttribute("message","既に使用されているメールアドレスです。");
					return "editAccount";
				}
			}
		}
		UsersInfo uInfo=new UsersInfo();
		BeanUtils.copyProperties(user, uInfo);
		if(usersInfoDAO.updateUserData(uInfo)==1) {
			return "editComplete";
		}else {
			model.addAttribute("message","登録に失敗しました。");
			return "mainMenu";
		}
	}
	@RequestMapping(value="mainMenu",method=RequestMethod.GET)
	public String toMainMenu() {
		return "mainMenu";
	}
}
