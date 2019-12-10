package service;

public class UserService implements IUserService {
/* (non-Javadoc)
 * @see service.IUserService#login(java.lang.String, java.lang.String)
 */
@Override
public boolean login(String userId,String userPwd) {
	if("abc".equals(userId)&&"123".equals(userPwd)) {
		return true;
	}
	else {
		return false;
	}
}
}
