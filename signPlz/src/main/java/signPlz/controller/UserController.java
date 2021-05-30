package signPlz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import signPlz.model.User.Register;
import signPlz.model.User.UserLogin;
import signPlz.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user/logincheck")
	public boolean loginCheck(@RequestBody UserLogin param) {
		return userService.loginCheck(param);
	}
	
	//회원가입하기 
	@PostMapping("/user")
	public void insertUsesr(@RequestBody Register register){
		userService.insertUser(register);
	}
	
}
