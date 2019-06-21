package tx4.accountDao;

public interface AccountDao {

	//加钱
	public void increasaMoney(Integer id,Double money);
	//减钱
	public void decreasaMoney(Integer id,Double money);
}
