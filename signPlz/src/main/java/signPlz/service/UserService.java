package signPlz.service;

import signPlz.model.User.Register;
import signPlz.model.User.UserLogin;

public interface UserService {

	boolean loginCheck(UserLogin param);

	void insertUser(Register register);

}
