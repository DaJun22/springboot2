package com.dj.springbootTest.modules.test.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@ResponseBody
	@RequestMapping("/test")
	public String testcontroller() {
		return "hello11122332";
	}
	
	@RequestMapping("/index")
	public String indexPage(ModelMap modelMap) {
		//modelMap.addAttribute("template", "test/index");
		return "index";
	}
	
	@RequestMapping("/demoInfo")
	@ResponseBody
	public String demoDesc(HttpServletRequest request, @RequestParam String key) {
		String parameter = request.getParameter("key");
		return "This is a Spring Boot demo." + parameter + "--" + key;
	}
	
	@PostMapping(value="/upload", consumes="multipart/form-data")
	public String uploadFile(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select file.");
			return "redirect:/test/index";
		}
		
		String fileName = file.getOriginalFilename();
		
		File destFile = new File(String.format("D:\\upload\\%s", fileName));
		try {
			file.transferTo(destFile);
			redirectAttributes.addFlashAttribute("message", "upload success.");
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			LOGGER.debug(e.getMessage());
			redirectAttributes.addFlashAttribute("message", "upload failed.");
		}
		
		return "redirect:/test/index";
	}
	
}
