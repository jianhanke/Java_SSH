package cn.itcast.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public User findById(Integer id) {
		return this.hibernateTemplate.get(User.class, id);
	}

	public List<User> findAll() {
		return this.hibernateTemplate.find("from User");
	}

	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

	public void update(User user) {
		this.hibernateTemplate.update(user);
	}

	public void delete(User user) {
		this.hibernateTemplate.delete(user);
	}
}
