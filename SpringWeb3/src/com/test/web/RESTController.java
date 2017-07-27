package com.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.bean.BoardBean;
import com.test.web.bean.MemberBean;
import com.test.web.dao.BoardDao;
import com.test.web.dao.MemberDao;

@Controller
public class RESTController {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao;
	
	
	// DB->Bean->JSon
	@RequestMapping("/rest/selectMember")
	@ResponseBody
	public Map<String, Object> selectMember(MemberBean mbean){
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
			MemberBean mBean = memberDao.selectMember(mbean);
			
			resMap.put("result", "ok");
			resMap.put("memberBean", mBean);
			
		} catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}
		return resMap;
		
	}
	
	// DB->Bean->JSon->JSon parser 이용
	@RequestMapping("/rest/selectMemberList")
	@ResponseBody
	public Map<String, Object> selectMemberList(){
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try {
			List<MemberBean> list = memberDao.selectMemberList();
			
			resMap.put("result", "ok");
			resMap.put("memberList", list);
			
		} catch(Exception e) {
			e.printStackTrace();
			resMap.put("result", "fail");
		}
		return resMap;
		
	}
	
	// DB->Bean->JSon
		@RequestMapping("/rest/selectBoard")
		@ResponseBody
		public Map<String, Object> selectBoard(BoardBean mbean){
			
			Map<String, Object> resMap = new HashMap<String, Object>();
			
			try {
				BoardBean mBean = boardDao.selectBoard(mbean);
				
				resMap.put("result", "ok");
				resMap.put("boardBean", mBean);
				
			} catch(Exception e) {
				e.printStackTrace();
				resMap.put("result", "fail");
			}
			return resMap;
			
		}
	
	// DB->Bean->JSon->JSon parser 이용
		@RequestMapping("/rest/selectBoardList")
		@ResponseBody
		public Map<String, Object> selectBoardList(){
			
			Map<String, Object> resMap = new HashMap<String, Object>();
			
			try {
				List<BoardBean> list2 = boardDao.selectBoardList();
				
				resMap.put("result", "ok");
				resMap.put("boardList", list2);
				
			} catch(Exception e) {
				e.printStackTrace();
				resMap.put("result", "fail");
			}
			return resMap;
		}
		
		// DB->Bean->JSon
		@RequestMapping("/rest/insertMember")
		@ResponseBody
		public Map<String, Object> insertMember(MemberBean mBean){
			
			Map<String, Object> resMap = new HashMap<String, Object>();
			resMap.put("result", "fail");
			
			try {
				int resVal = memberDao.insertMember(mBean);
				if(resVal>0) {
					resMap.put("result", "ok");
				}
			}
				catch(DuplicateKeyException dke) {
					resMap.put("resultMsg", "이미 존재하는 USER_ID 입니다.");
				} catch(Exception e) {
				e.printStackTrace();
				resMap.put("resultMsg", e.getMessage());
				
			}
			return resMap;
		}
		
		// DB->Bean->JSon
				@RequestMapping("/rest/updateMember")
				@ResponseBody
				public Map<String, Object> updateMember(MemberBean mBean){
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					
					try {
						int resVal = memberDao.updateMember(mBean);
						if(resVal>0) {
							resMap.put("result", "ok");
							resMap.put("resultMsg", "업데이트에 성공 하였습니다.");
						}
						else {
							resMap.put("resultMsg", "존재하지 않는 USER_ID 입니다.");
						}
					
						} catch(Exception e) {
						e.printStackTrace();
						resMap.put("resultMsg", e.getMessage());
					}
					return resMap;
				}
				
				// DB->Bean->JSon
				@RequestMapping("/rest/deleteMember")
				@ResponseBody
				public Map<String, Object> deleteMember(MemberBean mBean){
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					
					try {
						int resVal = memberDao.deleteMember(mBean);
						if(resVal>0) {
							resMap.put("result", "ok");
							resMap.put("resultMsg", "삭제에 성공 하였습니다.");
						}
						else {
							resMap.put("resultMsg", "존재하지 않는 USER_ID 입니다.");
						}
					
						} catch(Exception e) {
						e.printStackTrace();
						resMap.put("resultMsg", e.getMessage());
					}
					return resMap;
				}
		
				// DB->Bean->JSon
				@RequestMapping("/rest/insertBoard")
				@ResponseBody
				public Map<String, Object> insertBoard(BoardBean mBean){
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					
					try {
						int resVal = boardDao.insertBoard(mBean);
						if(resVal>0) {
							resMap.put("result", "ok");
						}
					}
						catch(DuplicateKeyException dke) {
							resMap.put("resultMsg", "이미 존재하는 USER_ID 입니다.");
						} catch(Exception e) {
						e.printStackTrace();
						resMap.put("resultMsg", e.getMessage());
						
					}
					return resMap;
				}	
				
				// DB->Bean->JSon
				@RequestMapping("/rest/updateBoard")
				@ResponseBody
				public Map<String, Object> updateBoard(BoardBean mBean){
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					
					try {
						int resVal = boardDao.updateBoard(mBean);
						if(resVal>0) {
							resMap.put("result", "ok");
							resMap.put("resultMsg", "업데이트에 성공 하였습니다.");
						}
						else {
							resMap.put("resultMsg", "존재하지 않는 USER_ID 입니다.");
						}
					
						} catch(Exception e) {
						e.printStackTrace();
						resMap.put("resultMsg", e.getMessage());
					}
					return resMap;
				}
				
				// DB->Bean->JSon
				@RequestMapping("/rest/deleteBoard")
				@ResponseBody
				public Map<String, Object> deleteBoard(BoardBean mBean){
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					
					try {
						int resVal = boardDao.deleteBoard(mBean);
						if(resVal>0) {
							resMap.put("result", "ok");
							resMap.put("resultMsg", "삭제에 성공 하였습니다.");
						}
						else {
							resMap.put("resultMsg", "존재하지 않는 USER_ID 입니다.");
						}
					
						} catch(Exception e) {
						e.printStackTrace();
						resMap.put("resultMsg", e.getMessage());
					}
					return resMap;
				}
				
				
				
		
	
}
