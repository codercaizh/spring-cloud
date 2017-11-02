package com.czh.contacts.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.czh.contacts.entity.Contact;

/**
 * 通讯录类
 * @author caizh
 * 此接口只要继承JpaRepository,并在泛型中传入数据库表实体类对应的类型即可直接使用最基本的增删查改，而无需再实现接口。
 */
@Repository
@Transactional
public interface ContactRepository extends JpaRepository<Contact, Long>{
	/**
	 * 根据姓名查找记录
	 * @param name
	 * @return
	 */
	public Contact findByName(String name);
	
	/**
	 * 根据姓名删除记录
	 * @param name
	 * @return
	 */
	public int deleteByName(String name);
}
