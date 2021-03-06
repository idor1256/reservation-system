package com.yg.reservation.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yg.reservation.domain.User;
import com.yg.reservation.security.AuthUser;
import com.yg.reservation.service.ImageService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private ImageService imageService;
	
	@Autowired
	public AdminController(ImageService imageService) {
		this.imageService = imageService;
	}

	@GetMapping("/images")
	public String imageAdmin() {
		return "imageAdmin";
	}
	
	@PostMapping("/images")
	public String create(@AuthUser User user, @RequestParam MultipartFile file) throws IllegalStateException, IOException {
		MultipartFile[] files = { file };
		imageService.add(user.getId(), files);
		return "redirect:/admin/images";
	}
}
