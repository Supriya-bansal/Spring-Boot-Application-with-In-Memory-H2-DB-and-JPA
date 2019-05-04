/**
 * 
 */
package com.assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.models.Member;
import com.assignment.service.MemberServiceImpl;

/**
 * @author supu
 *
 */
@RestController
@RequestMapping("member-api/v1/members")
public class MemberController {
	
	  @Autowired
	  private MemberServiceImpl service;

	  @GetMapping
	  public List<Member> getAllMembers(){
	  return service.getAllMembers();
	  }
	  
	  @GetMapping("{id}")
	  public Member getMemberById(@PathVariable Long id){
	  return service.getMemberById(id);
	  }
	  
	  @PostMapping
	  public Member addNewMember(@Valid @RequestBody Member member){
	  return service.addNewMember(member);
	  }
	  
	  @PutMapping("/update/{id}")
	  public Member updateExistingMember(@RequestBody Member member, @PathVariable Long id) {
	    return service.updateMemberById(member, id);
	  }
	  
	  @DeleteMapping("/delete/{id}")
	  public void deleteMember(@PathVariable Long id) {
	    service.deleteMemberById(id);
	  }

}
