$(function() {
	var name = $( "#name" ),
	email = $( "#email" ),
	password = $( "#password" ),
	allFields = $( [] ).add( name ).add( email ).add( password ),
	tips = $( ".validateTips" );
	
	$( "#dialog-form1" ).dialog({
		autoOpen: false,
		height: 300,
		width: 350,
		modal: true,
		buttons: {
			"Login": function() {


				//var user = {};
				var email = email_login.value;
				var password = password_login.value;
				
				if((email_login.value == null || email_login.value=="")||(password_login.value == null || password_login.value=="")){
					document.getElementById("errorMessage").innerHTML = "Invalid Input. Please fill all details.";
					return;
				}

				//var requestJson = JSON.stringify(user);
				//console.log("Json String: "+requestJson);
				

				$.ajax({
					type: 'GET', 
	        		url: '/DeviceSensorAnalytics/rest/dsignin/'+email+'/'+password,
	        		success: function(data){
	        			//alert(data);
	        			var obj = $.parseJSON(data);
	        			
	        			//alert(obj.status);
						if(obj.status == 200 ){
							console.log("success");
							console.log("Login Successful..!!");
							document.getElementById("login-user").style.display = "none";  
							document.getElementById("create-user").style.display = "none";
							//document.getElementById("fblogin").style.display = "none";
							document.getElementById("logout-user").style.display = "inline-block";
							document.getElementById("viewPatientList").style.display = "inline-block";
							$( "#dialog-form1").dialog( "close" );
							
						}
						else{
							document.getElementById("errorMessage").innerHTML = "Invalid Input. Try again.";
							console.log("Something went wrong, try again!");
						}
					}
				});

			},
			Cancel: function() {
				$( this ).dialog( "close" );
				parent.reloadContent();
			}
		},
		close: function() {
			allFields.val( "" ).removeClass( "ui-state-error" );
			parent.reloadContent(); 
		}
	});

	$( "#login-user" )
	.button()
	.click(function() {
		$( "#dialog-form1" ).dialog( "open" );
	});

});


function reloadContent() {
    location.reload();
}
