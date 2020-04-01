package com.dj.springbootTest.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/first")
public class ControllerTest {
	
	@ResponseBody
	@RequestMapping("/test")
	public String testcontroller() {
		return "hello1112233";
	}
}
