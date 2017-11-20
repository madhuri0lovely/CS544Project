package mum.cs544.project.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.cs544.project.entity.Person;
import mum.cs544.project.entity.Role;
import mum.cs544.project.service.IPersonService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
    private IPersonService personService;
	
	@Override
    @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//if(userName.trim().equals("")) return null;
		System.out.println("loadUserByUsername ["+username+"]....");
        Person person = personService.findByUsername(username);
        if(person == null) {
        	throw new UsernameNotFoundException("User is invalid!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(person.getRoles() != null) {
        	for(Role role : person.getRoles()) {
        		System.out.println(role.getName());
        		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().toUpperCase()));
        	}
        }

        return new org.springframework.security.core.userdetails.User(person.getUsername(), person.getPassword(), grantedAuthorities);
	}
}
