package ${package}.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import ${package}.service.BasicService;
import ${package}.domain.Basic;
import ${package}.dao.BasicDao;

@Service
@Repository(value = "basicService")
public class BasicServiceImpl implements BasicService{
	
	
	@Autowired
	private BasicDao basicDao;
	
	public List<Basic> queryForList(){
		return basicDao.queryForList();
	}
}
