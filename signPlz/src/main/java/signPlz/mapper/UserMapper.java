package signPlz.mapper;

import signPlz.model.User.Register;
import signPlz.model.User.UserLogin;

public interface UserMapper {

	String selectPwById(String userId);

	void insertUser(Register register);



}
