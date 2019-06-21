package tx3.accountDao;

public interface AccountDao {

	//加钱
	public void increaseMoney(Integer id,Double money);
	//减钱
	public void decreaseMoney(Integer id,Double money);
}
