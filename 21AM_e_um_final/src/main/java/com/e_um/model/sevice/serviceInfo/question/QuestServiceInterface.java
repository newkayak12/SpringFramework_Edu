package com.e_um.model.sevice.serviceInfo.question;

import java.util.List;

import com.e_um.model.vo.serviceinfo.question.NoHasAQuestion;

public interface QuestServiceInterface {
	
	int insertQuestion(NoHasAQuestion nhq);
	
	List<NoHasAQuestion> selectQuestionList(String userId, int cPage, int numPerPage);
	
	int selectQuestionListCount(String userId);

}
