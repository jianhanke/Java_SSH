package cn.itcast.dao;

import org.springframework.stereotype.Repository;

@Repository()
public class UserDaoImpl implements UserDao{

	@Override
	public void save() {
		System.out.println("save ����û�");
		
	}

	@Override
	public void update() {
		System.out.println("update �����û�");
		
	}

	@Override
	public void delete() {
		System.out.println("delete ɾ���û�");
		
	}

	@Override
	public void find() {
		System.out.println("find �����û�");
		
	}

}
