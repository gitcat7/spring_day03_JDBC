package jdbctemplate;

import java.util.List;

public interface UserDao {

	//增
	public void save(User u);
	//删
	public void delete(int id);
	//改
	public void update(User u);
	//查
	public List<User> getAll();
}
