package signPlz.mapper;

import org.apache.ibatis.annotations.Mapper;

import signPlz.model.User.Register;
import signPlz.model.User.UserLogin;

@Mapper
public interface UserMapper {

	String selectPwById(String userId);

	void insertUser(Register register);



}
