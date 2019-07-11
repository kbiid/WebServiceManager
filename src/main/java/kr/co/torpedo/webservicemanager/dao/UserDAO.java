package kr.co.torpedo.webservicemanager.dao;

import java.util.List;

import kr.co.torpedo.webservicemanager.domain.Criteria;
import kr.co.torpedo.webservicemanager.domain.User;

public interface UserDAO {
	// 날짜 순으로 정렬한 유저 전체 목록
	public List<User> selectAll();
	
	//정해준 페이징 만큼 select
	public List<User> listCriteria(Criteria cri);
	
	//총 유저수를 반환
	public int countPaging(Criteria cri);

	// 추가된 유저 삽입
	public void insert(User user);

	// 유저 정보 업데이트
	public void update(User user);

	// 유저 삭제
	public void delete(int id);
}
