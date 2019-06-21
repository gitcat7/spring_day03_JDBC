package tx4.accountService;

import tx4.accountDao.AccountDao;

public class AccountServiceImpl implements AccountService {

	private AccountDao ad;
	
	@Override
	public void transfer(Integer from, Integer to, Double money) {
		//减钱
		ad.decreasaMoney(from, money);
		//加钱
		ad.increasaMoney(to, money);
	}

	public void setAd(AccountDao ad) {
		this.ad = ad;
	}

}
