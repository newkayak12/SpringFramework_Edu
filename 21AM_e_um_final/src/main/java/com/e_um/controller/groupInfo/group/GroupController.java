package com.e_um.controller.groupInfo.group;

import static com.e_um.common.renamePolicy.RenamePolicy.renamepolicy;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.view.RedirectView;

import com.e_um.model.sevice.groupInfo.board.BoardServiceInterface;
import com.e_um.model.sevice.groupInfo.group.GroupServiceInterface;
import com.e_um.model.vo.groupinfo.board.Board;
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
	BoardServiceInterface serviceb;

	@RequestMapping("/group/groupCreate.do")
	public String groupCreate() {
		return "group/groupCreate";
	}

	/* 메인으로 내가가입한, 인기있는, 새로생긴 소모임 */
	@RequestMapping("/group/groupMain.do")
	public String groupList(Model m, HttpServletRequest rq) {
		List<Group> list = service.selectGroupList();
		List<Group> list2 = service.selectGroupListConditional((User) rq.getSession().getAttribute("userSession")); // 내가가입한
																													// 소모임

		m.addAttribute("list2", list2);
		m.addAttribute("list", list);
		return "group";
	}

	/* 더보기 버튼 전체 페이지 조회 */
	@RequestMapping("/group/groupListAll.do")
	public String groupListAll(Model m) {

		List<Group> list = service.selectGroupList(); // 전체소모임
		m.addAttribute("list", list);
		return "group/groupList";
	}

	@RequestMapping("/group/Gomain.do")
	public String groupInsert(@RequestParam Map param, Model model, HttpServletRequest rq, MultipartFile file) {

		User user = (User) rq.getSession().getAttribute("userSession");

		param.put("file", renamepolicy(rq, file, "group"));
		int result = service.groupInsert(param, user.getUserId());
		
		return "redirect:/group/groupMain.do";
	}
	
	

	@RequestMapping("/group/groupJoinForm.do")
	public String groupJoin(@RequestParam Map param, HttpServletRequest rq, Model model) {
		User user = (User) rq.getSession().getAttribute("userSession");
		log.warn("추측{}",param);
		String userId= user.getUserId();
		param.put("userId", userId);
		int result = service.groupJoin(param);
		return "redirect:/group/groupMain.do";
	}

	
	@RequestMapping("/group/groupJoin.do") 
	  public String groupJoinForm(HttpServletRequest rq, @RequestParam(value="groupSeq")String groupSeq ,Model model) { 
		  User user=(User) rq.getSession().getAttribute("userSession"); 
		  String userId= user.getUserId();
		  String page ="group/groupJoin";
		  System.out.println(groupSeq);
		  Group list=service.selectGroupUseridCheck(groupSeq);
		  model.addAttribute("group",list);
		  

		  log.warn("{}",list);
		  for(Member m : list.getMembers()) {
		  
				
			if(m.getGroupUser().getUserId().equals(userId)) {
				log.warn("야호!")
	;			return "redirect:/group/groupSigned.do";
			}
		  }
		  return page;
		}

	
	@RequestMapping("/group/groupBoardWrite.do")
	public String groupBoardWrite(HttpSession session) {
		return"group/groupboard/groupBoardWrite";
	}
	  

	  
	
	@RequestMapping("/group/groupBoardInsert.do")
	public String groupBoardInsert(Board board , Model model, MultipartFile[] file, HttpServletRequest rq) {
		User user=(User) rq.getSession().getAttribute("userSession");
		String userId= user.getUserId();
		
		board.setGroupBoardUser(user);
		
		log.warn("{}",user);
		log.warn("{}",board);
		log.warn("{}",file);
		
		
		int result = serviceb.groupboardinsert(board);
		
		return "";
	}
	
	
	
	
	
	
	@RequestMapping("/group/groupSigned.do")
	public String groupSigned() {
		return "group/groupboard/groupBoardMain";
	}

	@RequestMapping("/group/groupBoard.do")
	public String groupBoard() {
		return "group/groupboard/groupBoardSub";
	}

	@RequestMapping("/group/groupScheduler.do")
	public String groupScheduler() {
		return "group/groupboard/groupBoardSchedule";
	}
	
	@RequestMapping(value = "/group/filesupload", method = RequestMethod.POST)
	@ResponseBody
	public String fileUpload(HttpServletRequest rq, MultipartHttpServletRequest files) {
		log.warn("asdfasdf{}",files);
		return null;
	}

}
