package com.e_um.controller.admin;

import static com.e_um.common.pagebar.PageBar.getPageBar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.e_um.model.sevice.admin.AdminServiceInterface;
import com.e_um.model.vo.groupinfo.group.Group;
import com.e_um.model.vo.userInfo.user.User;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AdminController {
	@Autowired
	AdminServiceInterface service;

	@RequestMapping("/admin/enter")
	public String adminPageEnter() {
		return "admin";
	}
	
	@RequestMapping("/admin/menu")
	public String adminMenu() {
		return "components/admin/adminmenu";
	}

	@RequestMapping("/admin/manageuser")
	public String manageUser(@RequestParam(defaultValue = "1", value = "cPage")String cPage, Model model) {
		int numPerPage = 10;
		
		List<User> list = service.manageUser(Integer.parseInt(cPage), numPerPage);
		List<User> statistics = service.statisticsUser();
		int men = service.getMenCount();
		int women =service.getWomenCount();
		log.warn("{}",list);
		
		int seoul = 0;
		int busan = 0;
		int daegu = 0;
		int incheon =0;
		int gwangju =0;
		int daejeon = 0;
		int ulsan =0;
		int gyeonggi = 0;
		int gangwon = 0;
		int chungbuk  = 0;
		int chungnam = 0;
		int jeonbuk =0;
		int jeonnam =0;
		int gyeongbuk =0;
		int gyeonnam =0;
		int jeju =0; 
		
		for(User u : statistics) {
			switch (u.getUserAddrBasic().substring(0, 2)) {
			case "서울":
				seoul+=1;
				break;
			case "부산":
				busan+=1;
				break;
			case "대구":
				daegu+=1;
				break;
			case "인천":
				incheon+=1;
				break;
			case "광주":
				gwangju+=1;
				break;
			case "대전":
				daejeon+=1;
				break;
			case "울산":
				ulsan+=1;
				break;
			case "경기":
				gyeonggi+=1;
				break;
			case "강원":
				gangwon+=1;
				break;
			case "충북":
				chungbuk+=1;
				break;
			case "충남":
				chungnam+=1;
				break;
			case "전북":
				jeonbuk+=1;
				break;
			case "전남":
				jeonnam+=1;
				break;
			case "경북":
				gyeongbuk+=1;
				break;
			case "경남":
				gyeonnam+=1;
				break;
			case "제주":
				jeju+=1;
				break;
			}
			
			
		}
		
		model.addAttribute("seoul", seoul);
		model.addAttribute("busan", busan);
		model.addAttribute("daegu", daegu);
		model.addAttribute("incheon", incheon);
		model.addAttribute("gwangju", gwangju);
		model.addAttribute("daejeon", daejeon);
		model.addAttribute("ulsan", ulsan);
		model.addAttribute("gyeonggi", gyeonggi);
		model.addAttribute("gangwon", gangwon);
		model.addAttribute("chungbuk", chungbuk);
		model.addAttribute("chungnam", chungnam);
		model.addAttribute("jeonbuk", jeonbuk);
		model.addAttribute("jeonnam", jeonnam);
		model.addAttribute("gyeongbuk", gyeongbuk);
		model.addAttribute("gyeonnam", gyeonnam);
		model.addAttribute("jeju", jeju);
		
		
		
		model.addAttribute("men",men);
		model.addAttribute("women",women);
		model.addAttribute("list",list);
		
		model.addAttribute("pageBar", getPageBar(service.userTotalData(), Integer.parseInt(cPage) ,numPerPage ,"manageUser"));
		return "components/admin/manageuser";
	}
	
	@RequestMapping("/admin/blockuser")
	@ResponseBody
	public int blockUser(String userId) {
		return service.blockUser(userId);
	}
	
	@RequestMapping("/admin/unblockuser")
	@ResponseBody
	public int unblockUser(String userId) {
		return service.unblockUser(userId);
	}
	
	@RequestMapping("/admin/managegroup")
	public String manageGroup(@RequestParam(defaultValue = "1", value = "cPage")String cPage, Model model) {
		int numPerPage = 10;
		model.addAttribute("list",service.manageGroup(Integer.parseInt(cPage), numPerPage));
		List<Group> statistics = service.statisticsGroup();
		
		int game = 0;
		int athletics =0;
		int cook =0;
		int movie =0;
		int food = 0;
		int book = 0;
		int shopping = 0;
		int coding = 0;
		
		int genderAll = 0;
		int men = 0;
		int women = 0;
		
		
		int ageAll =0;
		int twenty = 0;
		int thirty = 0;
		int fourty = 0;
		
		
		for(Group g : statistics){
			switch (g.getGroupTheme()) {
			case "게임":
				game+=1;
				break;
			case "운동":
				athletics+=1;
				break;
			case "요리":
				cook+=1;
				break;
			case "영화":
				movie+=1;
				break;
			case "맛집":
				food+=1;
				break;
			case "독서":
				book+=1;
				break;
			case "쇼핑":
				shopping+=1;
				break;
			case "코딩":
				coding+=1;
				break;
			}
			
			switch (g.getGroupGender()) {
			case "all":
				genderAll+=1;
				break;
			case "M":
				men+=1;
				break;
			case "F":
				women+=1;
				break;

			}
			
			switch (g.getGroupAge()) {
			case "ageall":
				ageAll+=1;
				break;
			case "agea20":
				twenty+=1;
				break;
			case "age30":
				thirty+=1;
				break;
			case "agea40":
				fourty+=1;
				break;

			
			}
		}
		
		
		
		
		
		int[] ageList = {ageAll, twenty, thirty, fourty};
		int[] genderList = {genderAll, men, women};
		int[] themeList = {game, athletics, cook, movie, food, book, shopping, coding};
		model.addAttribute("ageList", ageList);
		model.addAttribute("genderList", genderList);
		model.addAttribute("themeList", themeList);
		model.addAttribute("pageBar",getPageBar(service.groupTotalData(), Integer.parseInt(cPage), numPerPage, "managerGroup"));
		
		return "components/admin/managegroup";
	}
	@RequestMapping("/admin/blindgroup")
	@ResponseBody
	public int blindGroup(String groupSeq) {
		return service.blindGroup(groupSeq);
	}
	@RequestMapping("/admin/unblindgroup")
	@ResponseBody
	public int unblindGroup(String groupSeq) {
		return service.unblindGroup(groupSeq);
	}
	
	@RequestMapping("/admin/managefood")
	public String manageFood(@RequestParam(defaultValue = "1", value = "cPage")String cPage, Model model) {
		int numPerPage =10;
		model.addAttribute("list",service.manageFood(Integer.parseInt(cPage), numPerPage));
		model.addAttribute("pageBar",getPageBar(service.foodTotalData(), Integer.parseInt(cPage), numPerPage, "manageFood"));
		return "components/admin/managefood";
	}
	@RequestMapping("/admin/manageservice")
	public String manageService(@RequestParam(defaultValue = "1", value = "cPage")String cPage, Model model) {
		return "components/admin/manageservice";
	}
	@RequestMapping("/admin/managemovie")
	public String manageMovie(@RequestParam(defaultValue = "1", value = "cPage")String cPage, Model model) {
		return "components/admin/managemovie";
	}
	
}
