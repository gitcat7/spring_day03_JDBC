package tx.tx;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tx.accountService.AccountService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx/applicationContext.xml")
public class Demo01 {
	@Resource(name="accountService")
	private AccountService as;
	
	@Test
	public void fun() {
		as.transfer(1, 2, 100d);
	}
}
