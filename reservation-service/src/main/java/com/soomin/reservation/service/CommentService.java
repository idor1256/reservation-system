package com.soomin.reservation.service;

import java.util.List;

import com.soomin.reservation.dto.Comment;

public interface CommentService {
	public int CountProductComment(long productId);
	public List<Comment> GetProductComment(long productId);
}
