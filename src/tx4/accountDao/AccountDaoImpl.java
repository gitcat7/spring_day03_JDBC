package tx4.accountDao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void increasaMoney(Integer id,Double money) {
		getJdbcTemplate().update("update person set money=money+? where id=?", money,id);
	}

	@Override
	public void decreasaMoney(Integer id,Double money) {
		getJdbcTemplate().update("update person set money=money-? where id=?", money,id);
	}

}
