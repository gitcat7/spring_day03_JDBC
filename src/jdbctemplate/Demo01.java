package jdbctemplate;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo01 {

	@Resource(name = "userService")
	private UserDao u;
	
	@Test
	public void fun() {
		//创建连接池
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:DATABASE");
			dataSource.setUser("game");
			dataSource.setPassword("game");
			
			//创建JDBC模块
			JdbcTemplate jdbcTempLate = new JdbcTemplate(dataSource);
			Object list = jdbcTempLate.query("select * from t_user", new RowMapper<Object>() {

				@Override
				public Object mapRow(ResultSet rs, int arg1) throws SQLException {
					return rs;
				}});
			System.out.println(list);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void fun2() {
		/*User user = new User(null,"aa","111");
		u.save(user);*/
		
		//u.delete(21);
		
		/*User user = new User();
		user.setUserid(1);
		user.setUsername("ll");
		u.update(user);*/
		
		System.out.println(u.getAll());
	}
}
