package com.itany.mapper;


import com.itany.pojo.ManagerUser;

import java.util.List;

public interface UserMapper {
	
	List<ManagerUser> selectByConditions(ManagerUser managerUser);
	
	void addUser(ManagerUser managerUser);
	
	ManagerUser login(ManagerUser managerUser);

	/**
	 * 根据用户名和密码查询user对象
	 * @param managerUser
	 * @return
	 */
	ManagerUser selectByUsernameAndPassword(ManagerUser managerUser);

	void insertManagerUser(ManagerUser managerUser);

	void updateManagerUser(ManagerUser managerUser);


}
