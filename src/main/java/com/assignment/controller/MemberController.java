/**
 * 
 */
package com.assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.models.Member;
import com.assignment.service.MemberServiceImpl;

/**
 * @author supu
 *
 */
@RestController
@RequestMapping("member-api/v1/")
public class MemberController {
	
	  @Autowired
	  private MemberServiceImpl service;

	  @GetMapping(value = "about")
	  public String getInfo(){
	  return "about";
	  }
	  
	  @GetMapping(value = "members", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	  public List<Member> getAllMembers(){
	  return service.getAllMembers();
	  }
	  
	  @GetMapping(value = "members/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	  @ResponseBody public Member getMemberById(@PathVariable Long id){
	  return service.getMemberById(id);
	  }
	  
	  @PostMapping(value = "members", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	  public Member addNewMember(@Valid @RequestBody Member member){
	  return service.addNewMember(member);
	  }
	  
	  @PutMapping("/members/update/{id}")
	  Member updateExistingMember(@RequestBody Member member, @PathVariable Long id) {
	    return service.updateMemberById(member, id);
	  }
	  
	  @DeleteMapping("/members/delete/{id}")
	  void deleteMember(@PathVariable Long id) {
	    service.deleteMemberById(id);
	  }

}
