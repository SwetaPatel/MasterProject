<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>
<%@page import="utils.LocalizationHelper"%>
<%@page import="utils.Session"%>

<html lang="en" class="no-js demo-1">
<head>
	<meta charset="UTF-8" />
<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Health Service</title>
	<meta name="description" content="Health Service" />
	<meta name="keywords" content="health" />
	<meta name="author" content="Codrops" />
	
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script> 
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> 
	
	<link rel="shortcut icon" href="../favicon.ico">
	<link rel="stylesheet" type="text/css" href="css/default.css" />
	<link rel="stylesheet" type="text/css" href="css/bookblock.css" />

	<link rel="stylesheet" type="text/css" href="css/demo1.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script src="js/modernizr.custom.js"></script> 

	<script src="js/jquerypp.custom.js"></script>
	<script src="js/jquery.bookblock.js"></script>
	<script src="js/slidercode.js"></script>

	<script src="js/registration.js"></script>
	<script src="js/login.js"></script>

	
	
<script>	
 	
	   function changeToSpanish()
       {
           document.form1.hiddenLanguage.value = "spanish";
            form1.submit();

       }    
       function changeToEnglish()
       {
           document.form1.hiddenLanguage.value = "english";

           form1.submit();

       }        
 
</script>
</head>
<body>

	<div id="wsb-canvas-template-page" class="wsb-canvas-page page"style="height: 800px; margin: auto; width: 1050px; background-color: #ffffff; position: relative; margin-top: 0px">

		<div id="d_header">
			<div id="heading">
			
			
		<div class="left">
			<% 		
			 String lang = request.getParameter("hiddenLanguage");			
			if (lang == null)
			{
				lang = "english";
				
			} 			
			session.removeAttribute("lang");
			session.setAttribute("lang", lang);
			System.out.println("session is " + session.getAttribute("lang"));
			LocalizationHelper helper = LocalizationHelper.getInstance(lang, getServletContext());
			Session s = Session.getInstance();
			String userId = s.getEmail();
		
			%>
				<span class="s_heading"><%=helper.getText("heading")%></span><br>
				<span class="s_heading" style="font-size: 14px; float:left">
				<%=helper.getText("heading2part1")%>&#9679;<%=helper.getText("heading2part2")%>&#9679;<%=helper.getText("heading2part3")%>
				</span>
		</div>
			
		<div class="right">
				<div style="display:inline-block; vertical-align:top; margin-left:200pxx;">
				
				<a href="HomePage.jsp" id="home" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" style="font-size: 14px; color: #561243;" data-inline="true">
				<span class="ui-button-text"><%=helper.getText("home")%></span>
				</a>
				
				
				<a id="viewPatientList" href="PatientList.jsp" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" 
				style="font-size:14px;color: #561243;<%if(userId == null){ %>display:none; <% } %>" data-inline="true"; >
				<span class="ui-button-text"><%=helper.getText("mypatients")%></span>
				</a>
				
				<a id="login-user" style="font-size: 14px; color: #561243; <%if( userId != null){ %>display:none; <% } %>" data-inline="true";><%=helper.getText("login")%></a>
				
				<a id="logout-user" href="LogOut.jsp" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" 
				style="font-size:14px;color: #561243;<%if(userId == null){ %>display:none; <% } %>" data-inline="true"; ><span class="ui-button-text"><%=helper.getText("logout")%></span></a>
				
				<a id="create-user" style="font-size: 14px; color: #561243; <%if(userId != null){ %>display:none; <% } %>" data-inline="true"><%=helper.getText("register")%></a>
				
				
   				
   				<span id="language"
							style="data-inline:true; <%if (userId != null) {%>display:block; <%}%>">						
						
				 <FORM NAME="form1" METHOD="POST">
							
							<input type="button" id="snlangSpace" name="submit1" 
									onClick="changeToSpanish()"
									style="background: url(img/snLang.png); visibility: visible; border: none; width: 30px; height: 25px;" />

								<input type="button" id="enlangSpace" name="submit2" 
									onClick="changeToEnglish()"
									style="background: url(img/enLang.png); visibility: visible; border: none; width: 30px; height: 25px;" />							
						
						 	<input type="hidden" id="hiddenLanguage"  name="hiddenLanguage">
						
						</FORM> 
						
						       
						</span> 
 				</div>
				

  			   
  			</div>
  			      
				
			</div>
		</div>
		
		
		<br>
		<div class="container">
			<div class="main clearfix">
				<div class="bb-custom-wrapper">
	
					<div id="bb-bookblock" class="bb-bookblock">
						<div class="bb-item">
							<img src="images/HomePage/1.jpg" class="bookflip-image" alt="image01"/>
						</div>
						<div class="bb-item">
							<img src="images/HomePage/2.jpg" class="bookflip-image" alt="image02"/>
						</div>
						<div class="bb-item">
							<img src="images/HomePage/3.jpg" class="bookflip-image" alt="image03"/>
						</div>
						<div class="bb-item">
							<img src="images/HomePage/4.jpg" class="bookflip-image" alt="image04"/>
						</div>
						<div class="bb-item">
							<img src="images/HomePage/5.jpg" class="bookflip-image" alt="image05"/>
						</div>

					</div>
					
				</div>
			</div>


			<script src="js/jquerypp.custom.js"></script>
			<script src="js/jquery.bookblock.js"></script>
			<script>
			var Page = (function() {
				
				var config = {
					$bookBlock : $( '#bb-bookblock' ),
					$navNext : $( '#bb-nav-next' ),
					$navPrev : $( '#bb-nav-prev' ),
					$navFirst : $( '#bb-nav-first' ),
					$navLast : $( '#bb-nav-last' )
				},
				init = function() {
					config.$bookBlock.bookblock( {
						speed : 1000,
						shadowSides : 0.8,
						shadowFlip : 0.7,
						autoplay: true,
						shadows:true
					} );
					initEvents();
				},
				initEvents = function() {

					var $slides = config.$bookBlock.children();

						// add navigation events
						config.$navNext.on( 'click touchstart', function() {
							config.$bookBlock.bookblock( 'next' );
							return false;
						} );

						config.$navPrev.on( 'click touchstart', function() {
							config.$bookBlock.bookblock( 'prev' );
							return false;
						} );

						config.$navFirst.on( 'click touchstart', function() {
							config.$bookBlock.bookblock( 'first' );
							return false;
						} );

						config.$navLast.on( 'click touchstart', function() {
							config.$bookBlock.bookblock( 'last' );
							return false;
						} );
						
						// add swipe events
						$slides.on( {
							'swipeleft' : function( event ) {
								config.$bookBlock.bookblock( 'next' );
								return false;
							},
							'swiperight' : function( event ) {
								config.$bookBlock.bookblock( 'prev' );
								return false;
							}
						} );

						// add keyboard events
						$( document ).keydown( function(e) {
							var keyCode = e.keyCode || e.which,
							arrow = {
								left : 37,
								up : 38,
								right : 39,
								down : 40
							};

							switch (keyCode) {
								case arrow.left:
								config.$bookBlock.bookblock( 'prev' );
								break;
								case arrow.right:
								config.$bookBlock.bookblock( 'next' );
								break;
							}
						} );
					};

					return { init : init };

				})();
				</script>
				<script>
				Page.init();
				</script>

			<div data-type="element" style="text-align: center;">
				<div class="txt" style="font-color: #41b6ba;">
					<h3>&hearts; <%=helper.getText("punchline")%> &hearts;</h3>
					<br>
					<p>
					<%=helper.getText("para1")%>
					</p>


				</div>
			</div>
			<br>		
		
		</div>
 
		<br>
		
		<div class="d_footer">
			<span class="copyright">© 2014 Health Service. All Rights Reserved. | </span>
			<a href="AboutUS.jsp" >About Us </a> 
		</div>
		<br><br>
		
	
		  
			<div id="dialog-form" title="Register">
		<p class="validateTips">All form fields are required.</p>

		<form>
			<fieldset  style="display:inline;">
				<p id="error1" style="font-size:12px;color:red;"></p>
				<label for="fname">First Name</label>
				<input type="text"  name="fname"  id="fname" placeholder='John' class="text ui-widget-content ui-corner-all" style="font-size: 12px;"/><br>
				<label for="lname">Last Name</label>
				<input type="text"  name="lname"  id="lname" placeholder='Phung' class="text ui-widget-content ui-corner-all" style="font-size: 12px;" /><br>
				<label for="email_reg">Email</label>
				<input type="email"  name="email_reg"  id="email_reg"  placeholder='john@yahoo.com' class="text ui-widget-content ui-corner-all" style="font-size: 12px;" /><br>
				<label for="password">Password</label>
				<input type="password" name="password" id="password_reg" class="text ui-widget-content ui-corner-all" style="font-size: 12px;"/>
				<label for="gender">Gender</label>
				<input type="text" name="gender" id="gender" placeholder= 'Female / Male' class="text ui-widget-content ui-corner-all" style="font-size: 12px;"/>
				
			</fieldset>
		</form>
	</div> 
	
	  <div id="dialog-form1" title="Login">
		<p class="validateTips">All form fields are required.</p>

		<form id="login_form">
			<fieldset style="display:inline;">
				<p id="errorMessage" style="font-size:12px;color:red;"></p>
				<label for="email_login">Email</label> <input type="email" name="email_login" id="email_login" style="font-size:12px;" class="text ui-widget-content ui-corner-all" placeholder='john@yahoo.com'/><br>
				<label for="password_login">Password</label> <input type="password" name="password_login" id="password_login" style="font-size:12px;" class="text ui-widget-content ui-corner-all"/> <br>

			</fieldset>
		</form>
	</div>
	</div>
</body>
</html>