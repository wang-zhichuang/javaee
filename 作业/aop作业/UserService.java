package service;

import org.springframework.stereotype.Service;

@Service(value = "iUserService")
public class UserService implements IUserService {
/* (non-Javadoc)
 * @see service.IUserService#login(java.lang.String, java.lang.String)
 */
@Override
public String login(String userId,String userPwd) {
	if("abc".equals(userId)&&"123".equals(userPwd)) {
		return "Success";
	}
	else {
		return "Failure";
	}
}
}
