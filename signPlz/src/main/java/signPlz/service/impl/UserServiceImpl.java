package signPlz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import signPlz.mapper.UserMapper;
import signPlz.model.User.UserLogin;
import signPlz.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public void loginCheck(UserLogin param) {
		userMapper.loginCheck(param);
	}

}
