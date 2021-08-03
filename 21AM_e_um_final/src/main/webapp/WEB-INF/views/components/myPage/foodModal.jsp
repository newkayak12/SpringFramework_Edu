<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<table class="table">
    <colgroup>
    	<col class="col-1">
    	<col class="col-3">
    	<col class="col-3">
        <col class="col-1">
        <col class="col-3">
        <col class="col-1">
    </colgroup>
    <thead class="thead-light">
      <tr>
        <th class="colcenter">예약번호</th>
        <th class="colcenter">식당명</th>
        <th class="colcenter">주소</th>
        <th class="colcenter">인원 수</th>
        <th class="colcenter">날짜/시간</th>
        <th class="colcenter">예약 취소</th>
      </tr>
    </thead>
    <tbody>
    	<c:if test="${!empty movieInfo }">
    		<c:forEach var="m" items="${movieInfo }">
			   	<tr>
			   		<td class="colcenter align-middle">${m.movieReservNum }</td>
					<td class="colcenter align-middle">${m.movieTitle }</td>
					<td class="colcenter align-middle">${m.movieLocation } ${m.movieBox }</td>
					<td class="colcenter align-middle">
						<fmt:formatDate value="${m.movieReservDate }" var="movieReservDate" pattern="yyyy/MM/dd"/><c:out value="${movieReservDate }"/> ${m.movieTime } ${m.seats1 }
						<c:set var="su" value="1"/>
						<c:if test="${m.seat2!=null }">
							, ${m.seat2 }
							<c:set var="su" value="2"/>
						</c:if>
						<c:if test="${m.seat3!=null }">
							, ${m.seat3 }
							<c:set var="su" value="3"/>
						</c:if>
						<c:if test="${m.seat4!=null }">
							, ${m.seat4 }
							<c:set var="su" value="4"/>
						</c:if>
						(총 <c:out value="${su }"/>인)
					</td>
					<td class="colcenter pointer align-middle">
						<c:if test="${m.dateMinus!=0 }">
							<button class="cancelBtn btn" onclick="fn_cancelMovie('${m.movieReservNum }');">취소</button>
						</c:if>
						<c:if test="${m.dateMinus==0 }">
							<button class="disabledBtn btn" disabled>취소</button>
						</c:if>
					</td>
		  		</tr>
	 		</c:forEach>
    	</c:if>
    	<c:if test="${empty movieInfo }">
    		<tr>
    			<td colspan="5">예매 정보가 없습니다.</td>
    		</tr>
    	</c:if>
    </tbody>
</table>

<nav aria-label="Page navigation example">
 	 ${pageBar }
</nav>

<script>
	function fn_cancelMovie(movieReservNum){
		$.ajax({
			type:"post",
			url:"${pageContext.request.contextPath}/user/mypage/cancelMovie",
			data:{"movieReservNum":movieReservNum},
			success:data=>{
				if(data>0){
					alert("예매가 취소되었습니다.");
					$("#myPageModal").modal("hide");
					fn_openMPModal("movie");
				}else{
					alert("예매 취소에 실패했습니다.");
				}
			}
		})
	}
</script>