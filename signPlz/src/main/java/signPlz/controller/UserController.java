package signPlz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import signPlz.model.User.Register;
import signPlz.model.User.UserLogin;
import signPlz.service.UserService;

@Api(tags = { "001. User" })
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user/logincheck")
	public boolean loginCheck(@RequestBody UserLogin param) {
		return userService.loginCheck(param);
	}
	
	@ApiOperation(value = "회원가입", notes = "회원가입")
	@PostMapping("/user")
	public void insertUsesr(@RequestBody Register register){
		userService.insertUser(register);
	}
	
}
