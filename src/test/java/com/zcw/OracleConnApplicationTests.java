package com.zcw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OracleConnApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void contextLoads() {
		String sql = "insert into USER_T values(1,'zhangsan','zhangsan@qq.com','wuhan',0,'sanxin')";
		jdbcTemplate.execute(sql);
	}

	@Test
	public void createSequence() {
		String sql = "create sequence seq_user_t increment by 1 start with 1;";
		jdbcTemplate.execute(sql);
	}

	@Test
	public void insertPRKIncrTest() {
		String sql = "insert into USER_T values(seq_user.nextval,'wangwu','wangwu@qq.com','wuhan',0,'sanxin')";
		jdbcTemplate.execute(sql);
	}

}
