package com.e_um.controller.groupInfo.group;

import static com.e_um.common.renamePolicy.RenamePolicy.renamepolicy;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.e_um.model.sevice.groupInfo.group.GroupServiceInterface;
import com.e_um.model.vo.groupinfo.group.Group;
import com.e_um.model.vo.groupinfo.member.Member;
import com.e_um.model.vo.userInfo.user.User;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GroupController {

	@Autowired
	GroupServiceInterface service;
	
	@Autowired
	SqlSessionTemplate test;
	
	@RequestMapping("/group/groupCreate.do")
	public String groupCreate(){
		return "group/groupCreate";
	}
	
	/* 메인으로 내가가입한, 인기있는, 새로생긴 소모임*/
	@RequestMapping("/group/groupMain.do")
	public String groupList(Model m) {
		/* List<Group> list=service.selectGroupList(); */
		List<Group> list2=service.selectGroupListConditional();	//내가가입한 소모임
		log.warn("blahbalh{}",list2);
		
		log.warn("bal{}",(Member)test.selectOne("group.selectTest"));
		
		/* m.addAttribute("list",list); */
		return "group";
	}
	
	/* 더보기 버튼 전체 페이지 조회 */
	@RequestMapping("/group/groupListAll.do")
	public String groupListAll(Model m) {
		
		List<Group> list=service.selectGroupList();	//전체소모임
		m.addAttribute("list",list);
		return "group/groupList";
	}
	
	@RequestMapping("/group/Gomain.do") 
	public String  groupInsert(@RequestParam Map param, Model model, HttpServletRequest rq, MultipartFile file){ 
		
		User user = (User) rq.getSession().getAttribute("userSession");
		
		param.put("file", renamepolicy(rq, file, "group"));
		int result = service.groupInsert(param,user.getUserId());
		return "redirect:/group/groupMain.do";
	}
	 
	@RequestMapping("group/groupSigned.do")
	public String groupSigned() {
		return "group/groupboard/groupBoardMain";
	}
	
	@RequestMapping("group/groupBoard.do")
	public String groupBoard() {
		return "group/groupboard/groupBoardSub";
	}
	
	@RequestMapping("group/groupScheduler.do")
	public String groupScheduler() {
		return "group/groupboard/groupBoardSchedule";
	}
	
	
	
}
