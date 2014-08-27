package ${package}.dao.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ${package}.domain.rowMapper.BasicRowMapper;

import ${package}.dao.BasicDao;
import ${package}.domain.Basic;

@Repository(value = "basicDao")
public class BasicDaoImpl implements BasicDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@SuppressWarnings("unchecked")
	public List<Basic> queryForList(){
		StringBuffer sql = new StringBuffer();
		sql.append("select * from t_Basic");
		List<Basic> list = jdbcTemplate.query(sql.toString(),
				new BasicRowMapper());
		return list;
	}
}
