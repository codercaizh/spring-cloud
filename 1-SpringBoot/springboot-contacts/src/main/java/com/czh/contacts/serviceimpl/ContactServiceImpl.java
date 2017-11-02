package com.czh.contacts.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.czh.contacts.entity.Contact;
import com.czh.contacts.repository.ContactRepository;
import com.czh.contacts.service.ContactService;

/**
 * 通讯录服务接口通用实现
 * @author caizh
 *
 */
@Service
public class ContactServiceImpl implements ContactService{
	//使用此注解可以自动注入服务
	@Autowired 
	private ContactRepository contactRepository;
	
	@Override
	@Cacheable(value = "contact",key = "'LoadContact='+#name")
	public Contact loadContact(String name) {
		Contact contact =  contactRepository.findByName(name);
		return contact;
	}

	@Override
	@CachePut(value = "contact",key = "'LoadContact='+#contact.name")
	public Contact saveOrUpdatedContact(Contact contact) {
		if(contact.getId() == null) {
			//新增操作
			if(contactRepository.findByName(contact.getName())!=null) {
				return null;
			}
		}
		return contactRepository.save(contact);
	}

	@Override
	@CacheEvict(value = "contact",key = "'LoadContact='+#name")
	public int deleteContact(String name) {
		return contactRepository.deleteByName(name);
	}


}
