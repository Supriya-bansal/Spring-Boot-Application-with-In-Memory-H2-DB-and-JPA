package com.assignment.service;

import java.util.List;

import com.assignment.models.Member;

public interface MemberServiceInterface {
	
	List<Member> getAllMembers();
	
	Member getMemberById(Long id);
	
	Member addNewMember(Member member);
	
	Member updateMemberById(Member member, Long id);
	
	void deleteMemberById(Long id);
	
}
