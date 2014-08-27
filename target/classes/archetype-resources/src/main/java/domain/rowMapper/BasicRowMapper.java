package ${package}.domain.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ${package}.domain.Basic;

public class BasicRowMapper implements RowMapper<Basic> {

	public Basic mapRow(ResultSet resultSet, int index) throws SQLException {
		Basic bs = new Basic();
		bs.setId(resultSet.getString(Basic.ID));
		return bs;
	}

}
