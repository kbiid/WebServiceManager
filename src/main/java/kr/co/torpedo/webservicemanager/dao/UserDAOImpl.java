package kr.co.torpedo.webservicemanager.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.co.torpedo.webservicemanager.domain.Criteria;
import kr.co.torpedo.webservicemanager.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Inject
	SqlSession sqlSession;

	@Override
	public List<User> selectAll() {
		logger.info("selectAll");
		return sqlSession.selectList("kr.co.torpedo.webservicemanager.dao.UserDAO.selectAll");
	}
	
	@Override
	public List<User> listCriteria(Criteria cri) {
		logger.info("listCriteria");
		return sqlSession.selectList("kr.co.torpedo.webservicemanager.dao.UserDAO.listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) {
		logger.info("countPaging");
		return sqlSession.selectOne("kr.co.torpedo.webservicemanager.dao.UserDAO.countPaging", cri);
	}
	
	@Override
	public void insert(User user) {
		logger.info("insert");
		sqlSession.insert("kr.co.torpedo.webservicemanager.dao.UserDAO.insert", user);
	}

	@Override
	public void update(User user) {
		logger.info("update");
		sqlSession.update("kr.co.torpedo.webservicemanager.dao.UserDAO.update", user);
	}

	@Override
	public void delete(String email) {
		logger.info("delete");
		sqlSession.delete("kr.co.torpedo.webservicemanager.dao.UserDAO.delete", email);
	}
}
