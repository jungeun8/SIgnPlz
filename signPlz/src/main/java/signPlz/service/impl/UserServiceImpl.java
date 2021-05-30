package signPlz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import signPlz.mapper.UserMapper;
import signPlz.model.User.Register;
import signPlz.model.User.UserLogin;
import signPlz.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public boolean loginCheck(UserLogin param) {
		String password = userMapper.selectPwById(param.getUserId());
		if(password == null) { // DB 조회결과가 없다면
			return false; //등록된 계정이 없습니다.
		}else if(!password.equals(param.getPassword())){ // 조회한 패스워드가 일치하지 않은 경우
			return false; //비밀번호가 일치하지 않습니다.
		}else { // 계정정보 일치
			return true;
		}
	}

	@Override
	public void insertUser(Register register) {
		userMapper.insertUser(register);
		
	}
}
