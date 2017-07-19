package com.soomin.reservation.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.soomin.reservation.domain.ReservationUserComment;
import com.soomin.reservation.dto.Comment;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Comment> rowMapper = BeanPropertyRowMapper.newInstance(Comment.class);
	
	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("category")
				.usingGeneratedKeyColumns("id");
	}
	
	public int CountByProductId(long id) {
		Map<String, ?> params = Collections.singletonMap("product_id", id);
		return jdbc.queryForObject(CommentSqls.COUNT_BY_PRODUCT_ID, params, Integer.class);
	}
	
	public List<Comment> SelectByProductId(long id){
		Map<String, ?> params = Collections.singletonMap("product_id", id);
		return jdbc.query(CommentSqls.SELECT_BY_PRODUCT_ID, params, rowMapper);
	}
}
