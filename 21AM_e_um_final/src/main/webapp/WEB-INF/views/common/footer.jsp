
<style>
	.footer {
	  position: relative;
	  height : 130px;
	  left: 0;
	  bottom: 0;
	  width: 100%;
	  background-color: #70b3d9;
	  color: white;
	  text-align: center;
	  padding : 10px;
	}
	.footer p {
		margin: 1px;
		font-size : 10px;
	}
    .list-inline {
        text-align: center;
    }
    .list-inline-item {
        display: inline-block;
        margin-left: 10px;
        margin-right: 10px;
    }
    .list-inline-item a {
        text-decoration: none;
        color: rgb(47, 50, 57);
        font-family:'Noto Sans KR';
    }
    .footer-basic .copyright {
        margin-top: 15px;
        text-align: center;
        font-size: 13px;
        color: white;
        margin-bottom: 0;
    }
    
   
</style>
<script type="text/javascript">

</script>


		<div id="footerContainer">
			<div class="d-flex justify-content-around mb-4 p-2 border col-12">
				<span id="controlpanelprev"></span>
				<span id="controlpanelfooter"></span>
				<span id="controlpanelnext"></span>
			</div>
			<div id="footerinnerContainer" style="height:600px" class="pb-5 mb-5" >
				<div id="friendList" style="display: none;">
				</div>
				<div id="footerprofileview" style="display: none;">
				
				
				</div>
			</div>
				
		</div>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css">
<footer class="footer mt-5 pt-0 dockbar">
		
	 <div id="icon_menu" class="iconboxfooter  mt-2 mb-2  col-12 " style="height:fit-content;"> 
          <ul class="navbar-nav d-flex flex-row  justify-content-between pr-4 pl-4 col-12">  
                <li class="nav-item" >
                	<i class="fas fa-bell fa-lg  p-2 fa-7x" style="font-size:50px" onclick="fn_showalarmbot(); "></i>
               		<!-- <span  class="p-2" id="alarmCountbot" style="font-size:16px; position:relative; bottom:30px; border-radius: 100%; background-color: rgba(255, 0, 0, 0.8); color: white;  width: 50px !important;  z-index: 200"></span> -->
               		<span class="small text-center"  style=" position:fixed; left:90px; bottom: 50px; z-index: 200; border-radius: 100%; background-color: rgba(255, 0, 0, 0.8); color: white; display:none; width: 30px; height: 30px; font-size:18px" id="alarmCountbot"></span>
                </li>
                
                
                
                <li class="border mt-2 mb-2"></li>
				<li class="nav-item">            
                	<i class="fas fa-user fa-lg  p-2 fa-7x" style="font-size:50px" onclick="fn_showprofilebot()"></i>
                </li >
                <li class="border mt-2 mb-2"></li>
                
                <li class="nav-item">
                	<i class="fas fa-address-book fa-lg fa-7x mt-2" style="font-size:50px;" onclick="friendListbot()"></i>
                </li>
                
                <li class="border mt-2 mb-2"></li>
                
                <li class="nav-item">
                	<i class="fas fa-comments fa-lg p-2 fa-7x " style="font-size:50px"></i>
                	<span class="small" style="width: 30px; height: 30px; font-size:18px; position:fixed;  right:30px; bottom: 50px; z-index: 200; border-radius: 100%; background-color: rgba(255, 0, 0, 0.8); color: white; display: none;" id="chatCountbot">12</span>
                </li>
                <!--span알림  -->
          </ul>
     </div> 
     


	<div class="footerInfo">
	    <ul class="list-inline">
	        <li class="list-inline-item"><a href="#">Home</a></li>
	        <li class="list-inline-item"><a href="#">Services</a></li>
	        <li class="list-inline-item"><a href="#">About</a></li>
	        <li class="list-inline-item"><a href="#">Terms</a></li>
	        <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
	    </ul>
	    <p class="copyright">E_um | address : ... | email : eum@eum.com</p>
	    <p class="copyright">team | kimsanghyun kimyejin kimtaehui leewoosik janghyerin</p>
	    <p class="copyright">Copyright Â©2021 E_um Co.Ltd.All rights reserved</p>
    </div>
    
</footer>



</body>
</html>