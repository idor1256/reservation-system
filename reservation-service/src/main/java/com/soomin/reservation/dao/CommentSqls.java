package com.soomin.reservation.dao;

public class CommentSqls {
	final static String COUNT_BY_PRODUCT_ID="SELECT COUNT(*) FROM reservation_user_comment WHERE product_id=:product_id";
	final static String SELECT_BY_PRODUCT_ID="SELECT reservation_user_comment.id, reservation_user_comment.user_id, reservation_user_comment.score, reservation_user_comment.comment, reservation_user_comment.create_date, product.name, user.username"
			+ "FROM reservation_user_comment, product, user "
			+ "WHERE product_id=:product_id LIMIT 3";
}
