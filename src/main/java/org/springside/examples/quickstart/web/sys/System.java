package org.springside.examples.quickstart.web.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springside.examples.quickstart.entity.User;
import org.springside.examples.quickstart.service.account.AccountService;

@Controller
@RequestMapping(value = "/system")
public class System {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "success")
	public String success(){
		return "manage/system";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<User> users = accountService.getAllUser();
		model.addAttribute("users", users);
		return "manage/system";
	}

}
