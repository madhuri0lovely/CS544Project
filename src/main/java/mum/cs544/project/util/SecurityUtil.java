package mum.cs544.project.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtil {
	public static String getLoggedInUserName() {
		String userName = "";
		
		if(SecurityContextHolder.getContext().getAuthentication() != null) {
			if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null) {
				User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if(user != null) userName = user.getUsername();
			}
		}
		
		return userName;
	}
}
