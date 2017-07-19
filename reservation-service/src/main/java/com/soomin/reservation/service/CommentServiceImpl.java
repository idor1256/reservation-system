package com.soomin.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomin.reservation.dao.CommentDao;
import com.soomin.reservation.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentDao commentDao;
	
	@Override
	public int CountProductComment(long productId) {
		// TODO Auto-generated method stub
		return commentDao.CountByProductId(productId);
	}

	@Override
	public List<Comment> GetProductComment(long productId) {
		// TODO Auto-generated method stub
		
		return commentDao.SelectByProductId(productId);
	}
	
}
