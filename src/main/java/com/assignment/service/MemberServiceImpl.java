package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.constants.MessageConstants;
import com.assignment.exception.MemberNotFoundException;
import com.assignment.models.Member;
import com.assignment.repository.MemberRepository;

@Component
public class MemberServiceImpl implements MemberServiceInterface{
	
	@Autowired
	private MemberRepository repository;

	@Override
	public List<Member> getAllMembers() {
		return repository.findAll();
	}

	@Override
	public Member getMemberById(Long id) {
		return repository.findById(id)
	      .orElseThrow(() -> new MemberNotFoundException(MessageConstants.NO_MEMBER_FOUND_WITH_INPUT_ID_EXCEPTION + id));
	}

	@Override
	public Member addNewMember(Member member) {
		return repository.save(member);
	}

	@Override
	public Member updateMemberById(Member member,Long id) {
		return repository.findById(id)
	      .map(existing -> {
	    	  existing.setFirstName(member.getFirstName());
	    	  existing.setLastName(member.getLastName());
	    	  existing.setDateOfBirth(member.getDateOfBirth());
	    	  existing.setPostalCode(member.getPostalCode());
	        return repository.save(existing);
	      })
	      .orElseGet(() -> {
	        return repository.save(member);
	      });
	}

	@Override
	public void deleteMemberById(Long id) {
		repository.deleteById(id);
	}

}
