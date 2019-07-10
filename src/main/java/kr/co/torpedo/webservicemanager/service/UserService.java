package kr.co.torpedo.webservicemanager.service;

import java.util.List;

import kr.co.torpedo.webservicemanager.domain.User;

public interface UserService {
	// 날짜 순으로 정렬한 유저 전체 목록
	public List<User> selectAll();

	// 추가된 유저 삽입
	public void insert(User user);

	// 유저 정보 업데이트
	public void update(User user);

	// 유저 삭제
	public void delete(int id);
}
