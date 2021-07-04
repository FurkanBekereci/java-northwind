package furkanbek.northwind.business.abstracts;

import furkanbek.northwind.core.entities.User;
import furkanbek.northwind.core.utilities.results.DataResult;
import furkanbek.northwind.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	
	DataResult<User> findByEmail(String email);
}
