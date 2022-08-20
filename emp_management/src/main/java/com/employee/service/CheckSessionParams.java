package com.employee.service;

public class CheckSessionParams {
	public static boolean checkUserLoggingStatus(String username, String password, boolean hasLoggedOut) {
		if (username != null && hasLoggedOut) 
			return true;
		else
			return false;	
	}
}
