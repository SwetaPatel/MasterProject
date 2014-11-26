<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="utils.LocalizationHelper"%>
<%@page import="utils.Session"%>
<% 
System.out.println("session is redirect in selectionnnn "  +session.getAttribute("lang"));
String langSelected = session.getAttribute("lang").toString();
if(langSelected == null){
	langSelected = "english";
}
LocalizationHelper helper = LocalizationHelper.getInstance(langSelected, getServletContext());
Session s = Session.getInstance();
String userId = s.getEmail();

%>
<!-- SummaryPage -->

<!DOCTYPE html>
<html lang="en" class="no-js demo-1">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Health Service</title>
	<meta name="description" content="Health Service" />
	<meta name="keywords" content="health" />
<meta name="author" content="Codrops" />

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>


<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/bookblock.css" />

<link rel="stylesheet" type="text/css" href="css/demo1.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquerypp.custom.js"></script>
<script src="js/jquery.bookblock.js"></script>
<script src="js/slidercode.js"></script>
<script defer src="js/slideShow.js"></script>

<script src="js/registration.js"></script>
<script src="js/login.js"></script>
<script type="text/javascript" src="js/DetailView.js"></script>
</head>
<script>
function getPatientList(){
	//alert("Hello");
	var demail = "<%=userId%>";
	$.ajax({
		type: 'GET', 
		url: '/DeviceSensorAnalytics/rest/plist/'+demail,
		success: function(data) {			    

			//alert(data);
			var obj = $.parseJSON(data);
			
			//alert(obj.status);
			if(obj.status == 200){
				//alert(obj.patientList);
				var values = [];
				values = obj.patientList;
				//alert(values);
				var listString = "<table>";
				$.each(values, function( index, value ) {
					   //alert( index + ": " + value );
						//listString+="<li><a id = \""+ value +"\" href=\"\" onclick=\"redirect(this.id);return false;\">"+value+"</a></li>";
						listString+="<tr><td><a id = \""+ value +"\" href=\"\" onclick=\"redirect(this.id);return false;\">"+value+"</a></td></tr>";
				});
								
				listString+="</table>";
				//alert(listString);
				$("#patientList").html(listString);				
			}		
		}
	});	
	
}

function redirect(emailId) {
	<%if (userId == null) {%>
alert("Please login");
<%} else {
%>
	//alert(emailId);
	window.location.href = "PatientDetails.jsp?email="+emailId;
	
<%}%>
}

</script>
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

<body onload="getPatientList()"> 
<div id="wsb-canvas-template-page" class="wsb-canvas-page page"
		style="height: 800px; margin: auto; width: 1050px; background-color: #ffffff; position: relative; margin-top: 0px">

		<div id="d_header">
			<div id="heading">

<div class="left">
			
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
				style="font-size:14px;color: #561243;<%if(userId == null){ %>display:none; <% } %>" data-inline="true"; ><span class="ui-button-text"><%=helper.getText("mypatients")%></span></a>
				
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
						
						        </FORM> 
						</span> 
 				</div>
				
   				

  			   
  			</div>
  			
  			      
				
			</div>
		</div>
		<br>
		<div class="container">
			<div id = "patientList" align="center"></div>
			
		</div>
			
		</div>


				<br>
		<div class="d_footer">
			<span class="copyright">© 2014 Health Service. All Rights Reserved. | </span>
			<a href="AboutUS.jsp" >About Us </a> 
		</div>
		<br><br>

	</div>

</body>
</html>