package com.test.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.bean.MemberBean;
import com.test.web.dao.MemberDao;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	// DB->Bean->JSon
		@RequestMapping("/rest/loginProc")
		@ResponseBody
		public Map<String, Object> selectMember(MemberBean mbean){
			
			Map<String, Object> resMap = new HashMap<String, Object>();
			
			try {
				MemberBean resBean = memberDao.loginProc(mbean);
				
				if(resBean == null) {
					resMap.put("result", "fail");
					resMap.put("resultMsg", 
							"해당하는 유저가 없습니다. \n아이디와 비밀번호를 확인 해주세요.");
				}
				else {
					resMap.put("result", "ok");
					resMap.put("resultMsg", "로그인 성공");
					resMap.put("memberBean", resBean);	
				}
				
			} catch(Exception e) {
				e.printStackTrace();
				resMap.put("result", "fail");
			}
			return resMap;
			
		}
		
		// DB->Bean->JSon
				@RequestMapping("/rest/signUpProc")
				@ResponseBody
				public Map<String, Object> signUpProc(MemberBean mbean){
					
					Map<String, Object> resMap2 = new HashMap<String, Object>();
					
					resMap2.put("result", "fail");
					resMap2.put("resultMsg", "회원가입 실패");
					
					try {
						int resBean2 = memberDao.signUpProc(mbean);
						if(resBean2 > 0) {
							resMap2.put("result", "ok");
							resMap2.put("resultMsg", "회원가입 성공");
						}
					} catch(Exception e) {
						e.printStackTrace();
						resMap2.put("result", "fail");
					}
					return resMap2;
				}
		
				// DB->Bean->JSon
				@RequestMapping("/rest/updateProc")
				@ResponseBody
				public Map<String, Object> updateProc(MemberBean mbean){
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					resMap.put("resultMsg", "회원 정보 수정 실패");
					
					try {
						int resBean2 = memberDao.updateProc(mbean);
						if(resBean2 > 0) {
							resMap.put("result", "ok");
							resMap.put("resultMsg", "회원정보 수정 성공");
						}
					} catch(Exception e) {
						e.printStackTrace();
						resMap.put("result", "fail");
					}
					return resMap;
				}

}
