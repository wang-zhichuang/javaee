package main;

import service.IUserService;
import service.UserService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
IUserService userService=new UserService();
userService.login("aaa","bbb");
	}

}
