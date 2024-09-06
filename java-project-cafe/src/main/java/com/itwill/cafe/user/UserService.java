package com.itwill.cafe.user;

public class UserService {
	
	private UserDao userDao;
	
	public UserService() throws Exception {
		userDao = new UserDao();
	}
	
	/*
	 * 회원가입
	 */
	public int create(User user) throws Exception{
		//1.아이디중복체크
		if(userDao.countByUserId(user.getUserId())>=1) {
			//중복
			return -1;
		}else {
			//가입
			int rowCount=userDao.insert(user);
			return rowCount;
		}
	}
	
	/*
	 * 회원로그인
	 */
	public User login(String userId,String password)throws Exception{
		/*
		 * 0 : 실패
		 * 1 : 성공
		 * 
		 */
		if(userDao.countByUserId(userId)==1) {
			//아이디존재하는경우
			User loginUser = userDao.selectById(userId);
			if(loginUser !=null && loginUser.getPassword().equals(password)) {
				//로그인성공(아이디존재&패쓰워드일치)
				return loginUser;
			}
		}
		//로그인 실패(null반환)
		return null;
	}
	
	
	/*
	 * 회원로그아웃
	 */
	public void logout() {
		/*
		 * 로그아웃시 DB작업이필요하다면 기술함
		 */
	}
	
	/*
	 * 로그인한 회원의 정보보기
	 */
	public User findUser(String userId) throws Exception{
		return userDao.selectById(userId);
	}
	
	/*
	 * 아이디중복체크
	 */
	public boolean isDuplicateId(String userId) throws Exception{
		if(userDao.countByUserId(userId)>=1) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * 회원탈퇴
	 */
	public int remove(String userId) throws Exception{
		return userDao.delete(userId);
	}
	
	/*
	 * 회원정보수정
	 */
	public int update(User user) throws Exception {
		return userDao.update(user);
	}
	
}
