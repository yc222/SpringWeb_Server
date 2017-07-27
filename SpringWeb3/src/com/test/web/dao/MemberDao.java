package com.test.web.dao;

import java.util.List;

import com.test.web.bean.MemberBean;

public interface MemberDao {
	
	public MemberBean selectMember(MemberBean bean);
	
	public List<MemberBean> selectMemberList();
	
	/** 회원 가입*/
	public int insertMember(MemberBean bean);
	
	/** 회원 수정*/
	public int updateMember(MemberBean bean);
	
	/** 회원 삭제*/
	public int deleteMember(MemberBean bean);
	
	/** 회원 로그인 정보 조회*/
	public MemberBean loginProc(MemberBean bean);
	
	/** 회원 가입 */
	public int signUpProc(MemberBean bean);
	
	/** 회원 수정 */
	public int updateProc(MemberBean bean);
	
	
	
}
