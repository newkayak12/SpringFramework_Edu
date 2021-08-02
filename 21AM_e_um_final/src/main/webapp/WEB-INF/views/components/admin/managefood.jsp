<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="d-flex flex-column justify-content-between align-itmes-center">
	<div style="height: 650px" class="d-flex flex-column justify-content-around align-items-center">
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      /* google.charts.load('current', {'packages':['corechart']}); */
      
			$(function(){
				
				 chart() 
			})      
      
      
	     function chart(){
    	  let data = '${price_star}';
    	  let content = JSON.parse(data)
    	  console.log(content)
	    	  
	     /* 
	      google.charts.setOnLoadCallback(drawChart1);
		
		      function drawChart1() {
		        var data = google.visualization.arrayToDataTable([
		          ['Age', 'Weight'],
		          [ 8,      12],
		          [ 4,      5.5],
		          [ 11,     14],
		          [ 4,      5],
		          [ 3,      3.5],
		          [ 6.5,    7]
		        ]);
		
		        var options = {
		          title: 'Age vs. Weight comparison',
		          hAxis: {title: 'Age', minValue: 0, maxValue: 15},
		          vAxis: {title: 'Weight', minValue: 0, maxValue: 15},
		          legend: 'none'
		        };
	
	        var chart = new google.visualization.ScatterChart(document.getElementById('chart_div'));
	
	        chart.draw(data, options);
	      }
		      */
      } 
    </script>
	
		<div>
			<span>
			</span>
			<span>
			</span>
			<span>
			</span>
			<span>
			</span>
		
		</div>
	
		<table class="table table-striped table-hover tway">
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
			</tr>
			<c:forEach items="${list }" var="i">
				<tr>
					<td>${i.foodCategoryMain }</td>
					<td>${i.foodCategorySub }</td>
					<td>${i.foodName }</td>
					<td>${i.foodAddr }</td>
					<td>${i.foodStar }</td>
					<td>${i.foodStar }</td>
					
					
					
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
					<td class="text-center" >
					<c:choose>
							<c:when test="${i.foodStatus=='unblock' }">
								<input type="button" onclick="blockThisId('${i.foodSeq}')" id="btn${i.foodSeq}" value="폐쇄">
							</c:when>
							<c:otherwise>
								<input type="button" onclick="blockThisId('${i.foodSeq}')" id="btn${i.foodSeq}" value="활성화">
							</c:otherwise>
						</c:choose>
						
					</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>

	<div>${pageBar }</div>
</div>

<script>

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