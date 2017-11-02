package com.czh.contacts.service;


import com.czh.contacts.entity.Contact;

/**
 * 通讯录服务接口
 * @author caizh
 *
 */
public interface ContactService {
	/**
	 * 根据姓名查询联系人
	 * @param name
	 * @return
	 */
	public Contact loadContact(String name);
	/**
	 * 增加或修改联系人
	 * @param contact
	 * @return
	 */
	public Contact saveOrUpdatedContact(Contact contact);
	/**
	 * 删除联系人
	 * @param name
	 * @return
	 */
	public int deleteContact(String name);
	
}
