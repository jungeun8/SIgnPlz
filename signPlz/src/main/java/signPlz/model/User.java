package signPlz.model;

import lombok.Data;

public class User {

	@Data
	public static class UserLogin {
		private String userId;
		private String password;
	}

	
	
}
