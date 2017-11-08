package com.zcw;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.zcw.dao.UserRepository;
import com.zcw.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OracleConnApplicationTests {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserRepository userRepository;

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

	@Test
	public void inserBatch() {

	}

	@Test
	public void oracleQueryWithJDBC() {
		String sql = "select LENGTH(t.UT_NAME) as length from USER_T t where UT_ID = 5";
		Integer length = jdbcTemplate.queryForObject(sql, Integer.class);
		logger.info("length = {}", String.valueOf(length));

		sql = "select UT_ID, UT_NAME, UT_EMAIL, UT_ADDR, UT_GENDER, UT_ORGID from USER_T t";
		List<User> userList = jdbcTemplate.query(sql, new Object[] {},
				(rs, rowNum) -> new User(rs.getLong("UT_ID"), rs.getString("UT_NAME"), rs.getString("UT_EMAIL"),
						rs.getString("UT_ADDR"), rs.getShort("UT_GENDER"), rs.getString("UT_ORGID")));
		for (User user : userList) {
			logger.info(user.toString());
		}
	}

	@Test
	public void oracleQueryWithJPA() {
		User user = userRepository.findByUtId(new Long(4));
		logger.info(user.toString());
		userRepository.findAll().forEach(u -> logger.info(u.toString()));
	}
}
