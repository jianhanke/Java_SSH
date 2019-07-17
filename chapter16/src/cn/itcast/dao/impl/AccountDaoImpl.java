package cn.itcast.dao.impl;
import org.springframework.jdbc.core.JdbcTemplate;
import cn.itcast.dao.AccountDao;
public class AccountDaoImpl implements AccountDao {
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	// 汇款的实现方法
	public void out(String outUser, int money) {
		this.jdbcTemplate.update("update account set money=money-? " +
				" where name = ?", money, outUser);
	}
	// 收款的实现方法
	public void in(String inUser, int money) {
		this.jdbcTemplate.update("update account set money=money+? " +
				"where name = ?", money, inUser);
	}
}
