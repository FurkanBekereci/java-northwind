package furkanbek.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import furkanbek.northwind.business.abstracts.UserService;
import furkanbek.northwind.core.dataAccess.UserDao;
import furkanbek.northwind.core.entities.User;
import furkanbek.northwind.core.utilities.results.DataResult;
import furkanbek.northwind.core.utilities.results.Result;
import furkanbek.northwind.core.utilities.results.SuccessDataResult;
import furkanbek.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao ;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Kullanıcı getirildi.");
	}

}
