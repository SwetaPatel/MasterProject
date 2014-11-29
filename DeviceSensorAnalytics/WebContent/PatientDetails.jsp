<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="utils.LocalizationHelper"%>
<%@page import="utils.Session"%>
<% 	
			Session s = Session.getInstance();
			String userId = s.getEmail();
			String lang = s.getLanguage();
			
			if(lang==null){
				lang = "english";
			}
			
			LocalizationHelper helper = LocalizationHelper.getInstance(lang, getServletContext());
%>

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
<link href="images/template2/tabcontent.css" rel="stylesheet" type="text/css" />
<script src="js/tabcontent.js" type="text/javascript"></script>

<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="css/default.css" />
<link rel="stylesheet" type="text/css" href="css/bookblock.css" />

<link rel="stylesheet" type="text/css" href="css/demo1.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/modernizr.custom.js"></script>

<script src="js/jquerypp.custom.js"></script>
<script src="js/jquery.bookblock.js"></script>
<script src="js/slidercode.js"></script>
<script defer src="js/slideShow.js"></script>

<script src="js/registration.js"></script>
<script src="js/login.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load("visualization", "1", {
		packages : [ "corechart" ]
	});
	google.setOnLoadCallback(drawChart);
	function drawChart(high, low, timeStamp) {
		//var h = high;
		//var l = low;
		var highBp = [];
		var lowBp = [];
		//alert(low[0]);
		var timestamp =timeStamp;
		//var j, k;
		//alert(h);
		var c = low.length;
		//alert(c);
		for (var j = 0; j <c ; j++) {
			var a =high[j];
			highBp[j] = Number(a);
		}
		for (var k = 0; k < c; k++) {
			var b = low[k];
			lowBp[k] = Number(b);
			
		}
		/* for (var m = 0; m < 5; m++) {
			var d = timeStamp[m];
			timestamp[m] = Number(d);
		}
		alert(timestamp[0]); */
		
		var data = google.visualization.arrayToDataTable([
				[ 'TimeStamp', 'highBp', 'lowBp' ],
				[ timestamp[0], highBp[0], lowBp[0] ],
				[ timestamp[1], highBp[1], lowBp[1] ],
				[ timestamp[2], highBp[2], lowBp[2] ],
				[ timestamp[3], highBp[3], lowBp[3] ],
				[ timestamp[4], highBp[4], lowBp[4] ] ]);

		var options = {
			title : 'Patient Data Trend'
		};

		var chart = new google.visualization.LineChart(document
				.getElementById('visualization1'));

		chart.draw(data, options);
	}
</script>

<script>
//alert(document.URL);
var param = (document.URL.split("?"))[1];	
var pEmail = param.split("=")[1];
//alert(pEmail);

function fetchData(){


	$.ajax({
		type: 'GET', 
		url: '/DeviceSensorAnalytics/rest/pdetails/'+pEmail,
		success: function(data) {			    

			//alert(data);
			var obj = $.parseJSON(data);
			
			//alert(obj.status);
			if(obj.status == 200){
				var pemail = obj.pemail;
				var gender = obj.gender;
				var fName = obj.fName;
				var lName = obj.lName;
				var age = obj.age;
				var profileString = "<table>";
				profileString+="<tr><td><b>First Name:</b></td><td>"+fName+"</td></tr>";
				profileString+="<tr><td><b>Last Name:</b></td><td>"+lName+"</td></tr>";
				profileString+="<tr><td><b>Age:</b></td><td>"+age+"</td></tr>";
				profileString+="<tr><td><b>Email:</b></td><td>"+pemail+"</td></tr>";
				profileString+="<tr><td><b>Gender:</b></td><td>"+gender+"</td></tr>";
				
				profileString+="</table>";
				//alert(profileString);
				$("#profile").html(profileString);
				
			}		
		}
	});	
}

// Add function for Report


function sendData(){
	var data = document.getElementById("feedbackText").value;
	//alert(data);

	$.ajax({

		type: 'POST', 
		url: '/DeviceSensorAnalytics/rest/feedback/'+pEmail+'/'+data,
		success: function(data){
			//alert(data);
			var obj = $.parseJSON(data);
			
			//alert(obj.status);
			if(obj.status == 200){
				
				alert("Feedback sent successfully");
				document.getElementById("feedbackText").value = "";	
			}

		}
	});
}

function getReportData() {
	var highBp = [];
	var lowBp = [];
	var timestamp = [];
//	var i;
	$.ajax({
		type : 'GET',
		url : '/DeviceSensorAnalytics/rest/report/' + pEmail,
		success : function(data) {

			//alert(data);
			var obj = $.parseJSON(data);

			if (obj.status == 200) {
		
				for (var i = 0; i < obj.values.length; i++) {
					highBp[i] = obj.values[i].highBp;
					lowBp[i] = obj.values[i].lowBp;
					timestamp[i] = obj.values[i].timestampVal;
					
				}
			}
			drawChart(highBp, lowBp, timestamp);
		}
	});

}

</script>
<script>	
 	
	   function changeToSpanish()
       {	//alert("change to spanish called");
           //document.form1.hiddenLanguage.value = "spanish";
			$.ajax({

        		type: 'POST', 
        		url: '/DeviceSensorAnalytics/rest/language/'+"spanish",
        		success: function(data){
        			//alert(data);
        			var obj = $.parseJSON(data);
        			
        			//alert(obj.status);
        			if(obj.status == 200){
        				console.log("Changed to Spanish");
        				
        			}
        			
        		}
        	});
            form1.submit();
       }    
       function changeToEnglish()
       {
			$.ajax({

        		type: 'POST', 
        		url: '/DeviceSensorAnalytics/rest/language/'+"english",
        		success: function(data){
        			//alert(data);
        			var obj = $.parseJSON(data);
        			
        			//alert(obj.status);
        			if(obj.status == 200){
        				console.log("Changed to english");
        				
        			}
        			
        		}
        	});
            form1.submit();
       }        
 
</script>

<body onload="fetchData()">
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

			<ul class="tabs" data-persist="true">
			    <li><a href="#view1">Profile</a></li>
			    <li><a href="#view2">Reports</a></li>
			    <li><a href="#view3">Feedback</a></li>
			</ul>
			<div class="tabcontents">
			    <div id="view1">
			    	<h3 align = "center"><%=helper.getText("profile")%></h3>
				    <div id = "profile" align="center"></div>
			    </div>
			    <div id="view2">
			        <div>
						<h3 align="center"><%=helper.getText("report")%></h3>  
						<div align="center">
							<table>
								<tr>
									<td style='width: 200px; font-size: 0.9em;'>
										<div id="visualization1" style="width: 500px; height: 300px;"></div>
									</td>
									<!-- <td style='width: 200px; font-size: 0.9em;'>
										<div id="visualization2" style="width: 500px; height: 300px;"></div>
									</td> -->
								</tr>
							</table>
						</div>
						<br>
						<div align="center">

							<button class="button" id="getD" value="getD"
								onclick="getReportData();"><%=helper.getText("getReport")%></button>
							
						</div>
					</div>
			    </div>
			    <div id="view3">
			    	<div>
				       <h3 align = "center"><%=helper.getText("feedbackHeading")%></h3>
				       <div align = "center">
				       <textarea id = "feedbackText" rows="4" cols="50">
						 
						</textarea>
						</div>
						<br>
						<div align="center">
							
							<button class= "button" id = "Send" value = "Send" onclick = "sendData();"><%=helper.getText("send")%></button>
						</div>
					</div>
			    </div>
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