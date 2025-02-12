package com.e_um.model.dao.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.e_um.controller.admin.AdminController;
import com.e_um.model.vo.groupinfo.group.Group;
import com.e_um.model.vo.placeinfo.food.food.Food;
import com.e_um.model.vo.placeinfo.food.menu.FoodMenu;
import com.e_um.model.vo.serviceinfo.faq.Faq;
import com.e_um.model.vo.placeinfo.movie.movie.Movie;
import com.e_um.model.vo.placeinfo.movie.reserv.MovieTicketing;
import com.e_um.model.vo.serviceinfo.faq.Faq;
import com.e_um.model.vo.serviceinfo.question.NoHasAQuestion;
import com.e_um.model.vo.serviceinfo.question.Question;
import com.e_um.model.vo.userInfo.report.ReportFeed;
import com.e_um.model.vo.userInfo.report.ReportFeedComment;
import com.e_um.model.vo.userInfo.report.ReportFoodComment;
import com.e_um.model.vo.userInfo.report.ReportGroupBoard;
import com.e_um.model.vo.userInfo.report.ReportGroupBoardComment;
import com.e_um.model.vo.userInfo.user.User;

import lombok.extern.slf4j.Slf4j;

@Repository
public class AdminDao implements AdminDaoInterface{

	@Override
	public List<User> manageUser(int cPage, int numPerPage, SqlSessionTemplate session) {
		return session.selectList("admin.managUser", "",new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	@Override
	public int userTotalData(SqlSessionTemplate session) {
		return session.selectOne("admin.userTotalData");
	}

	@Override
	public int blockUser(String userId, SqlSession session) {
		return session.update("admin.blockUser", userId);
	}

	@Override
	public int unblockUser(String userId, SqlSession session) {
		return session.update("admin.unblockUser", userId);
	}

	@Override
	public int blindMovieComment(String userId, SqlSession session) {
//		Movie_review_destroy
//		user_id
		return session.update("admin.blindMovieComment",userId);
	}

	@Override
	public int blindFoodComment(String userId, SqlSession session) {
//		food_comment_block
//		user_id
		return session.update("admin.blindFoodComment",userId);
	}

	@Override
	public int blindFeed(String userId, SqlSession session) {
//		feed_block
//		user_id
		return session.update("admin.blindFeed",userId);
	}

	@Override
	public int blindFeedComment(String userId, SqlSession session) {
//		feed_comment_block
//		user_id
		return session.update("admin.blindFeedComment",userId);
	}

	@Override
	public int blindGroupComment(String userId, SqlSession session) {
//		group_comment_block
//		user_id
		return session.update("admin.blindGroupComment",userId);
	}
	@Override
	public int blindGroupBoard(String userId, SqlSession session) {
//		group_board_block
//		group_board_block
//		group_board_block
//		userId
		return session.update("admin.blindGroupBoardComment",userId);
	}
	
	
	
	
	@Override
	public int unblindMovieComment(String userId, SqlSession session) {
		return session.update("admin.unblindMovieComment",userId);
	}
	
	@Override
	public int unblindFoodComment(String userId, SqlSession session) {
		return session.update("admin.unblindFoodComment",userId);
	}

	@Override
	public int unblindFeed(String userId, SqlSession session) {
		return session.update("admin.unblindFeed",userId);
	}

	@Override
	public int unblindFeedComment(String userId, SqlSession session) {
		return session.update("admin.unblindFeedComment",userId);
	}

	@Override
	public int unblindGroupComment(String userId, SqlSession session) {
		return session.update("admin.unblindGroupComment",userId);
	}
	@Override
	public int unblindGroupBoard(String userId, SqlSession session) {
		return session.update("admin.unblindGroupBoardComment",userId);
	}

	@Override
	public List<Group> manageGroup(int cPage, int numPerPage, SqlSessionTemplate session) {
		return session.selectList("admin.manageGroup","",new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	@Override
	public int groupTotalData(SqlSessionTemplate session) {
		return session.selectOne("admin.groupTotalData");
	}

	@Override
	public int blindGroup(String groupSeq, SqlSessionTemplate session) {
		return session.update("admin.blindGroup", groupSeq);
	}

	@Override
	public int unblindGroup(String groupSeq, SqlSessionTemplate session) {
		return session.update("admin.unblindGroup",groupSeq);
	}

	@Override
	public List<Food> manageFood(int cPage, int numPerPage, SqlSessionTemplate session) {
		return session.selectList("admin.manageFood","",new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	@Override
	public int getMenCount(SqlSession session) {
		return session.selectOne("admin.getMenCount");
	}

	@Override
	public int getWomenCount(SqlSession session) {
		return session.selectOne("admin.getWomenCount");
	}

	@Override
	public List<User> statisticsUser(SqlSession session) {
		return session.selectList("admin.managUser");
	}

	@Override
	public List<Group> statisticsGroup(SqlSession session) {
		return session.selectList("admin.manageGroup");
	}

	@Override
	public int foodTotalData(SqlSessionTemplate session) {
		return session.selectOne("admin.foodTotalData");
	}

	@Override
	public int blockFood(String foodSeq, SqlSessionTemplate session) {
		return session.update("admin.blockFood",foodSeq);
	}

	@Override
	public int unblockFood(String foodSeq, SqlSessionTemplate session) {
		return session.update("admin.unblockFood",foodSeq);
	}

	@Override
	public List<Food> statisticsFood(SqlSessionTemplate session) {
		return session.selectList("admin.manageFood");
	}

	@Override
	public int likeMaxiumCount(SqlSessionTemplate session) {
		return session.selectOne("admin.likeMaximumCount");
	}

	@Override
	public List<ReportFeed> manageFeed(int cPage, int numPerPage, SqlSessionTemplate session) {
		return session.selectList("admin.manageFeed","",new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	@Override
	public int feedTotalData(SqlSessionTemplate session) {
		return session.selectOne("admin.feedTotalData");
	}

	@Override
	public int feedBlock(String seq, SqlSessionTemplate session) {
		return session.update("admin.feedBlock", seq);
	}

	@Override
	public int feedUnBlock(String seq, SqlSessionTemplate session) {
		return session.update("admin.feedUnBlock", seq);
	}

	@Override
	public List<ReportFeedComment> manageFeedComment(int cPage, int numPerPage, SqlSessionTemplate session) {
		return session.selectList("admin.manageFeedComment", "", new RowBounds((cPage-1)*numPerPage,numPerPage));
	}

	@Override
	public int feedCommentTotalData(SqlSessionTemplate session) {
		return session.selectOne("admin.feedCommentTotalData");
	}

	@Override
	public int feedCommentBlock(String seq, SqlSessionTemplate session) {
		return session.update("admin.feedCommentBlock",seq);
	}

	@Override
	public int feedCommentUnBlock(String seq, SqlSessionTemplate session) {
		return session.update("admin.feedCommentUnBlock",seq);
	}

	@Override
	public List<ReportFoodComment> manageFoodComment(int cPage, int numPerPage, SqlSessionTemplate session) {
		return session.selectList("admin.manageFoodComment","", new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	@Override
	public int foodCommentTotalData(SqlSessionTemplate session) {
		return session.selectOne("admin.foodCommentTotalData");
	}

	@Override
	public int foodCommentBlock(String seq, SqlSessionTemplate session) {
		return session.update("admin.foodCommentBlock",seq);
	}

	@Override
	public int foodCommentUnBlock(String seq, SqlSessionTemplate session) {
		return session.update("admin.foodCommentUnBlock",seq);
	}

	@Override
	public List<ReportGroupBoard> manageGroupBoard(int cPage, int numPerPage, SqlSessionTemplate session) {
		return session.selectList("admin.manageGroupBoard","",new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	@Override
	public int groupBoardTotalData(SqlSessionTemplate session) {
		return session.selectOne("admin.groupBoardTotalData");
	}

	@Override
	public int groupBoardBlock(String seq, SqlSessionTemplate session) {
		return session.update("admin.groupBoardBlock",seq);
	}

	@Override
	public int groupBoardUnBlock(String seq, SqlSessionTemplate session) {
		return session.update("admin.groupBoardUnBlock",seq);
	}

	@Override
	public List<ReportGroupBoardComment> manageReportGroupBoardComment(int cPage, int numPerPage,
			SqlSessionTemplate session) {
		return session.selectList("admin.manageReportGroupBoardComment","",new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	@Override
	public int reportGroupBoardCommentTotalData(SqlSessionTemplate session) {
		return session.selectOne("admin.reportGroupBoardCommentTotalData");
	}

	@Override
	public int reportGroupBoardCommentBlock(String seq, SqlSessionTemplate session) {
		return session.update("admin.reportGroupBoardCommentBlock");
	}

	@Override
	public int reportGroupBoardCommentUnBlock(String seq, SqlSessionTemplate session) {
		return session.update("admin.reportGroupBoardCommentUnBlock");
	}

	@Override
	public int updatefood(SqlSessionTemplate session, Food food) {
		return session.update("admin.updatefood", food);
	}

	@Override
	public int updatefoodMenu(SqlSessionTemplate session, FoodMenu m) {
		return session.update("admin.updatefoodMenu", m);
	}

	public List<Faq> selectFAQ(SqlSessionTemplate session, int cPage, int numPerPage) {
		return session.selectList("admin.selectFAQ","",new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	public List<Movie> movieList(SqlSessionTemplate session, int cPage, int numPerPage) {
		return session.selectList("movie.movieListAdmin","",new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	@Override
	public int movieTotalData(SqlSessionTemplate session) {
		return session.selectOne("movie.movieTotalCount");
	}

	@Override
	public List<MovieTicketing> ticketingList(SqlSessionTemplate session, int cPage, int numPerPage) {
		return session.selectList("movie.tickectList","",new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	@Override
	public int tickectTotal(SqlSessionTemplate session) {
		return session.selectOne("movie.tickectCount");
	}

	@Override
	public int writeFAQ(SqlSessionTemplate session, Faq f) {
		return session.insert("admin.writeFAQ",f);
	}

	@Override
	public int faqTotalData(SqlSessionTemplate session) {
		return session.selectOne("admin.faqTotalData");
	}

	@Override
	public int changeFAQStatus(SqlSessionTemplate session, Faq f) {
		return session.update("admin.changeFAQStatus",f);
	}

	@Override
	public Faq selectFAQOne(SqlSessionTemplate session, String faqSeq) {
		return session.selectOne("admin.selectFAQOne",faqSeq);
	}

	@Override
	public int modifyFAQ(SqlSessionTemplate session, Faq f) {
		return session.update("admin.modifyFAQ",f);
	}

	@Override
	public List<NoHasAQuestion> selectQNAAll(SqlSessionTemplate session, int cPage, int numPerPage) {
		return session.selectList("admin.selectQNAAll","",new RowBounds((cPage-1)*numPerPage, numPerPage));
	}

	@Override
	public int qnaTotalData(SqlSessionTemplate session) {
		return session.selectOne("admin.qnaTotalData");
	}

	@Override
	public NoHasAQuestion selectQNA(SqlSessionTemplate session, String questionSeq) {
		return session.selectOne("admin.selectQNA",questionSeq);
	}

	@Override
	public int updateAnswer(SqlSessionTemplate session, Question qa) {
		String questionSeq=qa.getQuestionSeq();
		System.out.println("dao 들어옴");
		if(session.insert("admin.insertAnswer",qa)>0) {
			System.out.println("insertAnswer 실행!");
			if(session.update("admin.updateAnswerFlag",questionSeq)>0) {
				System.out.println("updateAnswerFlag 실행!");
				return session.insert("admin.insertSupportAlarm",qa);
			}else {
				return 0;
			}
		}else {
			return 0;
		}
	}
	
}
