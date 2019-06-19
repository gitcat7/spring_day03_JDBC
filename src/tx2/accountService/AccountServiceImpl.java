package tx2.accountService;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import tx.accountDao.AccountDao;

public class AccountServiceImpl implements AccountService {

	private AccountDao ad;
	private TransactionTemplate tt;
	
	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(Integer from, Integer to, Double money) {
			//减钱
			ad.delMoney(from, money);
			//加钱
			ad.addMoney(to, money);
		
	}

	public void setAd(AccountDao ad) {
		this.ad = ad;
	}

	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}
	


}
