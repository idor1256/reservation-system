package com.yg.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yg.reservation.service.ProductService;
import com.yg.reservation.vo.ProductSummaryVo;

@Controller
@RequestMapping("/api/products")
public class ProductAPIController {
	private ProductService productService;

	@Autowired
	public ProductAPIController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/promotions")
	public List<ProductSummaryVo> getPromotions() {
		return productService.getPromotions();
	}
}