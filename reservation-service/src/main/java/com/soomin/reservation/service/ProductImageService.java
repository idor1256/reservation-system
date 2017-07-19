package com.soomin.reservation.service;

import java.util.List;

import com.soomin.reservation.domain.ProductImage;

public interface ProductImageService {
	public List<ProductImage> getImage(long productId);
	public ProductImage getRepresentitiveImage(long productId);
	public int getCount(long productId);
}
