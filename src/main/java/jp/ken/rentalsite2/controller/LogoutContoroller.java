package jp.ken.rentalsite2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class LogoutContoroller {
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();
		return "logout";
	}
}
