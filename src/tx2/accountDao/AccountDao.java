package tx2.accountDao;

public interface AccountDao {

	//加钱
	public void addMoney(Integer id,Double money);
	//减钱
	public void delMoney(Integer id,Double money);
}
