$(function() {
    var name = $( "#name" );
    var  email = $( "#email" );
    var password = $( "#password" );
    
   var  allFields = $( [] ).add( name ).add( email ).add( password ),
      tips = $( ".validateTips" );
 
 
    $( "#dialog-form" ).dialog({
      autoOpen: false,
      height: 350,
      width: 350,
      modal: true,
      buttons: {
    	 
        "Register": function() {
        	

        	if((fname.value == null || fname.value=="")||(lname.value == null || lname.value=="")||(email_reg.value == null || email_reg.value=="")||(password_reg.value == null || password_reg.value=="")||(gender.value == null || gender.value=="")){
        		document.getElementById("error1").innerHTML = "Invalid Input.Please fill all the details";
        		return;
        	}
        	
  
        	var firstName = fname.value;
        	var lastName = lname.value;
        	var email = email_reg.value;
        	var password = password_reg.value;
        	var dgender = gender.value;
     
			//Modified by Sweta Patel
        	$.ajax({

        		type: 'POST', 
        		url: '/DeviceSensorAnalytics/rest/dsignup/'+email+'/'+password+'/'+firstName+'/'+lastName+'/'+dgender,
        		success: function(data){
        			if(data.errorCode == 200 && data.responseText == "Success"){
        				console.log("Registration sucess..!!");
        				$("#dialog-form").dialog( "close" );
        			}
        			else if (data.errorCode == 500)
        				{
        				document.getElementById("error1").innerHTML = "Email address already exists.";

        				}
        			else{
        				document.getElementById("error1").innerHTML = "Registration Failed.Try Again";
        			}
        		}
        	});
        	
        },
        Cancel: function() {
          $( this ).dialog( "close" );
          parent.reloadContent(); // added by Rohini
        }
      },
      close: function() {
        allFields.val( "" ).removeClass( "ui-state-error" ); 
        parent.reloadContent(); 
      } 
    });
 
    $( "#create-user" )
      .button()
      .click(function() {
        $( "#dialog-form" ).dialog( "open" );
      });
  });


function reloadContent() {
  location.reload();
}