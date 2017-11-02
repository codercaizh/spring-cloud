package com.czh.contacts.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.czh.contacts.entity.Contact;
import com.czh.contacts.entity.Response;
import com.czh.contacts.service.ContactService;

/**
 * 通讯录控制器(Rest风格)
 * @author caizh
 *
 */
@RestController
@RequestMapping("/contact")
public class ContactController{
	
	@Autowired
	private ContactService contactService;
	
	/**
	 * 根据姓名查询联系人
	 * @param name
	 * @return
	 */
	@GetMapping("/name/{name}")
	public Response searchContact(@PathVariable(name = "name",required = false) String name) {
		Response response = new Response();
		Contact contact = contactService.loadContact(name);
		if(contact == null) {
			response.setRtncode(Response.EMPTY);
		}else {
			response.setRtncode(Response.SUCCESS);
			response.setBody(contact);
		}
		return response;
	}
	
	/**
	 * 增加或修改联系人
	 * @param contact
	 * @param bindingResult
	 * @return
	 */
	@PostMapping()
	public Response saveOrUpdatedContact(@Valid Contact contact,BindingResult bindingResult) {
		Response response = new Response();
		if(bindingResult.hasErrors()) {
			response.setRtncode(Response.FAILED);
			response.setMessage(bindingResult.getFieldError().getDefaultMessage());
		}else {
			contact = contactService.saveOrUpdatedContact(contact);
			if(contact == null) {
				response.setRtncode(Response.EMPTY);
			}else {
				response.setRtncode(Response.SUCCESS);
				response.setBody(contact);
			}
		}
		return response;
	}
	/**
	 * 删除联系人
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE,value = "/name/{name}")
	public Response delContact(@PathVariable(name = "name",required = false) String name) {
		//该方法会返回删除多少记录
		int result = contactService.deleteContact(name);
		Response response = new Response();
		if(result == 0) {
			response.setRtncode(Response.EMPTY);
		}else {
			response.setRtncode(Response.SUCCESS);
		}
		return response;
	}
}
	
