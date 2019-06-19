package tx.accountService;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import tx.accountDao.AccountDao;

public class AccountServiceImpl implements AccountService {

	private AccountDao ad;
	private TransactionTemplate tt;
	
	@Override
	public void transfer(Integer from, Integer to, Double money) {
		
		tt.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				//减钱
				ad.delMoney(from, money);
				//加钱
				ad.addMoney(to, money);
			}
		});
		
	}

	public void setAd(AccountDao ad) {
		this.ad = ad;
	}

	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}
	


}
