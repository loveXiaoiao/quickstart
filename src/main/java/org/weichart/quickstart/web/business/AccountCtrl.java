package org.weichart.quickstart.web.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.weichart.quickstart.service.business.AccountService;

/**
 * 
 * @author liyi
 *
 */

@Controller
@RequestMapping(value = "/account")
public class AccountCtrl {
	
	@Autowired
	private AccountService accountService;

}
