package com.productapp.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.productapp.entities.UserEntity;
import com.productapp.service.UserService;
//Who will call this logic : spring sec
@Service
public class DetailService implements UserDetailsService{

	private UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=userService.findByUsername(username);//load the user that is understand by me
		System.out.println("------------------------------------");
		System.out.println(userEntity);
		System.out.println("---------------------------------------");
		
		//spring sec dont understand it, i need to covert this to the usre that is understood by spring sec
		  if(userEntity==null)
	            throw new UsernameNotFoundException("Username/password is invalid");
	        //now problem: userEntity--->UserDetails(which spring sec understand)
	        return new SecUser(userEntity);
	}

}
