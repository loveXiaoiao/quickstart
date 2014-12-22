package org.springside.examples.quickstart.web.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/system")
public class System {
	
	@RequestMapping(value = "success")
	public String success(){
		return "manage/system";
	}

}
