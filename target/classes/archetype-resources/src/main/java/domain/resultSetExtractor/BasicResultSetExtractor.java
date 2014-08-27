package ${package}.domain.resultSetExtractor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import ${package}.domain.Basic;

public class BasicResultSetExtractor implements
		ResultSetExtractor<List<Basic>> {

	public List<Basic> extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
        List<Basic> ls = new ArrayList<Basic>();
		while (resultSet.next()) {
			Basic bs = null;
			String id = resultSet.getString(Basic.ID);
			ls.add(bs);
		}
		return ls;
	}
}