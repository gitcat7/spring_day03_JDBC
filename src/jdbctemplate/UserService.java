package jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserService implements UserDao {

	private JdbcTemplate jt;
	
	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public void save(User u) {
		String sql = "insert into t_user values(?,?,?)";
		jt.update(sql, null,u.getUsername(),u.getPassword());
		
	}

	@Override
	public void delete(int i) {
		String sql = "delete from t_user where userid=?";
		jt.update(sql, i);
	}

	@Override
	public void update(User u) {
		String sql = "update t_user set username = ? where userid = ?";
		jt.update(sql, u.getUsername(),u.getUserid());
	}

	@Override
	public List<User> getAll() {
		String sql = "select * from t_user";
		return jt.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setUserid(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("pwd"));
				return u;
			}});
	}

}
