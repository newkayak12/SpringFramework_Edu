<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
      
			$(function(){
				
				 chart() 
			})      
      
      
	     function chart(){
    	  let dat = '${price_star}';
    	  let content = JSON.parse(dat)
    	  console.log("table")
    	  console.log(content)
    	  let string = [];
    	  string.push(['price','star'])
    	  
	         content.forEach((v,i)=>{
	        	 console.log(v)
	 	 				string.push(v)
	         })
	         
	         
         let ldat = '${like_star}'
         let lcontent = JSON.parse(ldat)
         let string2 = [];
         string2.push(['like','star']);
         
         lcontent.forEach((v,i)=>{
        	 string2.push(v)
         })
	     
	       console.log(string2)
	      google.charts.load('current', {'packages':['corechart']});
	      google.charts.setOnLoadCallback(drawChart1);
	      google.charts.setOnLoadCallback(drawChart2);
		
		      function drawChart1() {
		        var data = google.visualization.arrayToDataTable(string
		         );
		        
		        
				
		         console.log(data)
		        var options = {
		          title: 'price-star graph',
		          hAxis: {title: 'price', minValue: 0, maxValue: 60000},
		          vAxis: {title: 'star', minValue: 0, maxValue: 5.0},
		          legend: 'none',
		          pointShape: 'star',
		          pointSize: 10,
		          animation: {
		            duration: 300,
		            easing: 'inAndOut',
		          }
		        };
	
	        var chart = new google.visualization.ScatterChart(document.getElementById('price_star'));
	
	        chart.draw(data, options);
	      }
		      function drawChart2() {
			        var data = google.visualization.arrayToDataTable(string2
			         );
			        
			        
					
			         console.log(data)
			        var options = {
			          title: 'like-star graph',
			          hAxis: {title: 'like', minValue: 0, maxValue: ${likeMaximum}},
			          vAxis: {title: 'star', minValue: 0, maxValue: 5.0},
			          legend: 'none',
			          pointShape: 'star',
			          pointSize: 10,
			          animation: {
			            duration: 300,
			            easing: 'inAndOut',
			          }
			        };
		
		        var chart = new google.visualization.ScatterChart(document.getElementById('like_star'));
		
		        chart.draw(data, options);
		      }
		     
      } 
</script>

<div class="d-flex flex-column justify-content-between align-itmes-center" id="manageFoodDiv">
	<div style="height: 650px" class="d-flex flex-column  align-items-center">
	
		<div class="d-flex justify-content-around">
			<span id="price_star"></span>
			<span id="like_star"></span>
		</div>
	
		<table class="table table-striped table-hover">
		
			<tr>
				<th class="bgColorMainColorSub whiteText">
					대분류
				</th>
				<th class="bgColorMainColorSub whiteText">
					소분류
				</th>
				<th class="bgColorMainColorSub whiteText">
					이름
				</th>
				<th class="bgColorMainColorSub whiteText">
					주소
				</th>
				<th class="bgColorMainColorSub whiteText">
					별점
				</th>
				<th class="bgColorMainColorSub whiteText">
					좋아요 수
				</th>
				<th class="bgColorMainColorSub whiteText">
					상태
				</th>
				<th class="bgColorMainColorSub whiteText">
					폐쇄
				</th>
				<th class="bgColorMainColorSub whiteText">
					정보수정
				</th>
			</tr>
			
			<c:if test="${list.size()>0}">
				<c:forEach items="${list }" var="i">
					<tr>
						<td>${i.foodCategoryMain }</td>
						<td>${i.foodCategorySub }</td>
						<td>${i.foodName }</td>
						<td>${i.foodAddr }</td>
						<td>${i.foodStar }</td>
						<td>${i.foodLikeCount }</td>
						
						<td id="block${i.foodSeq }">
							<input type="hidden" id="B${i.foodSeq}" value="${i.foodStatus }">
								<c:choose>
									<c:when test="${i.foodStatus=='unblock' }">
										게시
									</c:when>
									<c:otherwise>
										내림
									</c:otherwise>
								</c:choose>
						</td>
						
						<td class="text-center">
							<c:choose>
								<c:when test="${i.foodStatus=='unblock' }">
									<input type="button" class="btn cancelBtn" onclick="blockThisId('${i.foodSeq}')" id="btn${i.foodSeq}" value="폐쇄">
								</c:when>
								<c:otherwise>
									<input type="button" class="btn checkBtn" onclick="blockThisId('${i.foodSeq}')" id="btn${i.foodSeq}" value="활성화">
								</c:otherwise>
							</c:choose>
						</td>
						
						<td class="text-center">
							<input type="button" class="btn checkBtn" onclick="updateFood('${i.foodSeq}');" value="수정">
						</td>
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${list.size()==0}">
				<tr>
					<td colspan="8" class="text-center">내용이 없습니다.</td>
				</tr>
			</c:if>
			
		</table>
		
	</div>
	
	<c:if test="${list.size()>0}">
		<div id="mf_pageBar" class="mt-5">${pageBar }</div>
	</c:if>
	
</div>

<script>

	const updateFood = (foodSeq)=> {
		$.ajax({
			url : "${ pageContext.request.contextPath }/admin/updatefood/start",
			data : {
				"foodSeq" : foodSeq	
			},
			success: data => {
				$("#mf_pageBar").css("display", "none");
				
				$("#manageFoodDiv").html("");
				$("#manageFoodDiv").attr("class", "");
				
				$("#title").html("음식점 정보 수정")
				$("#manageFoodDiv").html(data)
			}
		})
	}


	function blockThisId(seq){
		
		if($("#B"+seq).val()=='unblock'){
			
			$.ajax({
				url:"${pageContext.request.contextPath}/admin/blockfood",
				data:{"foodSeq":seq},
				success:data=>{
					if(data>0){
						$("#block"+seq).html("정지")
						$("#btn"+seq).val("게시")
					}	
				}
			})
			
			
		} else {
			$.ajax({
				url:"${pageContext.request.contextPath}/admin/unblockfood",
				data:{"foodSeq":seq},
				success:data=>{
					if(data>0){
						$("#block"+seq).html("게시")
						$("#btn"+seq).val("정지")
					}
				}
				
			})
			
			
		}
		
		
	}
</script>