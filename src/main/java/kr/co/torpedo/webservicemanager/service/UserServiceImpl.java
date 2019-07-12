package kr.co.torpedo.webservicemanager.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.torpedo.webservicemanager.dao.UserDAO;
import kr.co.torpedo.webservicemanager.domain.User;
import kr.co.torpedo.webservicemanager.paging.Criteria;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Inject
	UserDAO userDao;

	@Override
	public List<User> selectAll() {
		logger.info("selectAll");
		return userDao.selectAll();
	}

	@Override
	public List<User> listCriteria(Criteria cri) {
		logger.info("listCriteria");
		return userDao.listCriteria(cri);
	}

	@Override
	public int countPaging(Criteria cri) {
		logger.info("countPaging");
		return userDao.countPaging(cri);
	}

	@Override
	public void insert(User user) {
		logger.info("insert");
		userDao.insert(user);
	}

	@Override
	public void update(User user) {
		logger.info("update");
		userDao.update(user);
	}

	@Override
	public void delete(String email) {
		logger.info("delete");
		userDao.delete(email);
	}

	@Override
	public User selectUser(int id) {
		logger.info("selectUser");
		return userDao.selectUser(id);
	}
}
