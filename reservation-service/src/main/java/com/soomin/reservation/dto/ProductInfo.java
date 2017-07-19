package com.soomin.reservation.dto;

import java.util.List;

import com.soomin.reservation.domain.DisplayInfo;
import com.soomin.reservation.domain.Product;
import com.soomin.reservation.domain.ProductDetail;
import com.soomin.reservation.domain.ProductImage;

public class ProductInfo {
	private Product product;
	private List<ProductImage> images;
	private ProductDetail detail;
	private DisplayInfo display_info;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<ProductImage> getImages() {
		return images;
	}
	public void setImages(List<ProductImage> images) {
		this.images = images;
	}
	public ProductDetail getDetail() {
		return detail;
	}
	public void setDetail(ProductDetail detail) {
		this.detail = detail;
	}
	public DisplayInfo getDisplay_info() {
		return display_info;
	}
	public void setDisplay_info(DisplayInfo display_info) {
		this.display_info = display_info;
	}
	
}
