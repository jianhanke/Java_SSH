package two_study;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Service;

@Service("userDaoImpl")
public class UserDaoImpl implements UserDao {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbctmplate;

	public JdbcTemplate getJdbctmplate() {
		return jdbctmplate;
	}

	public void setJdbctmplate(JdbcTemplate jdbctmplate) {
		this.jdbctmplate = jdbctmplate;
	}
	
	
	public int addUser(User user) {
		String sql = "insert into t_user(username,password) values(?,?)";
	 
		Object obj[]=new Object[] {user.getUsername(),user.getPassword()};
		int flag=this.jdbctmplate.update(sql, obj);
		return flag;
		
	}
	public int updateUser(User user) {
		String sql="update t_user set username=? ,password=? where userid=?";
		Object obj[]=new Object[] {user.getUsername(),user.getPassword(),user.getUserid()};
		return this.jdbctmplate.update(sql,obj);
	}
	
	public int deleteUserById(int id) {
		String sql="delete from t_user where userid=?";
		return jdbctmplate.update(sql,id);
	}
	
	public User findUserById(int id) {
		String sql="select * from t_user where userid=?";
		RowMapper<User>rowMapper=ParameterizedBeanPropertyRowMapper.newInstance(User.class);
		return this.jdbctmplate.queryForObject(sql, rowMapper,id);
	}
	public List<User> findAllUser(){
		String sql="select * from t_user";
		RowMapper<User>rowMapper=ParameterizedBeanPropertyRowMapper.newInstance(User.class);
		return this.jdbctmplate.query(sql,rowMapper);
	}
	
}
