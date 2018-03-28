package com.luo.study.mmmapper;

import com.github.pagehelper.PageInfo;
import com.luo.study.mmmapper.model.AccountEntity;
import com.luo.study.mmmapper.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Import(MmMapperApplication.class)
public class MmMapperApplicationTests {

	@Autowired
	AccountService accountService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test01(){
		AccountEntity accountInfo = accountService.getAccountInfo();

		System.out.println(accountInfo);
	}

	@Test
	public void test02(){

		List<AccountEntity> allAccount = accountService.getAllAccount();
		System.out.println(allAccount.size());
	}

	@Test
	public void test03(){

		PageInfo page = accountService.getAccountByPage(1, 2);
		List list = page.getList();
		System.out.println(list.size());
		System.out.println(page);
	}
}
