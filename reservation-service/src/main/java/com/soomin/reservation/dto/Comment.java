package com.soomin.reservation.dto;

import com.soomin.reservation.domain.ReservationUserComment;

public class Comment {
	private ReservationUserComment reservation_user_comment;
	private String user_name;
	private String product_name;
	
	public ReservationUserComment getReservation_user_comment() {
		return reservation_user_comment;
	}
	public void setReservation_user_comment(ReservationUserComment reservation_user_comment) {
		this.reservation_user_comment = reservation_user_comment;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
}
