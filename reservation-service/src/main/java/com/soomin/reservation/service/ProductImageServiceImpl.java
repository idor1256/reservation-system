package com.soomin.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomin.reservation.dao.ProductImageDao;
import com.soomin.reservation.domain.ProductImage;

@Service
public class ProductImageServiceImpl implements ProductImageService{
	@Autowired
	ProductImageDao productImageDao;
	
	@Override
	public List<ProductImage> getImage(long productId) {
		// TODO Auto-generated method stub
		return productImageDao.selectRepresentByProductId(productId);
	}

	@Override
	public ProductImage getRepresentitiveImage(long productId) {
		// TODO Auto-generated method stub
		return productImageDao.selectThumbnailByProductId(productId);
	}

	@Override
	public int getCount(long productId) {
		// TODO Auto-generated method stub
		return productImageDao.countByProductId(productId);
	}
	
}
