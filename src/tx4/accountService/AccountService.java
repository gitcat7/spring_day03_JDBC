package tx4.accountService;

public interface AccountService {

	//转账
	public void transfer(Integer from,Integer to,Double money);
}
