function onLoadDetail() {
	var param = (document.URL.split("?"))[1];
	var pa = (document.URL.split("&"));
	var itemDetails = pa[0].split("=")[1];
	var eventName = pa[1].split("=")[1];
	
	var categoryName = pa[2].split("=")[1];

var audioString;
	
	if(categoryName === "birthday"){
		Stitle = "<h1 align=\"center\"> BirthDay Planning</h1>";
		Simages = "<img src=\"images/Birthday/finalbday1.png\" alt=\"Slide 1\" />"+
	    "<img src=\"images/Birthday/finalbday2.png\" alt=\"Slide 2\" />"+
	    "<img src=\"images/Birthday/finalbday3.png\" alt=\"Slide 3\" />"+
	    "<img src=\"images/Birthday/finalbday4.png\" alt=\"Slide 4\" />"+
	    "<img src=\"images/Birthday/finalbday5.png\" alt=\"Slide 5\" />"+
	    "<img src=\"images/Birthday/finalbday6.png\" alt=\"Slide 6\" />";  
	    audioString = "<audio controls autoplay loop ><source src=\"audio/HBDTune.mp3\" type=\"audio/mpeg\"></audio>";

	   
	}
else if(categoryName === "wedding"){
		Stitle = "<h1 align=\"center\"> Wedding Planning</h1>";
		Simages = "<img src=\"images/Wedding/finalwed1.png\" alt=\"Slide 1\" />"+
	    "<img src=\"images/Wedding/finalwed2.png\" alt=\"Slide 2\" />"+
	    "<img src=\"images/Wedding/finalwed3.png\" alt=\"Slide 3\" />"+
	    "<img src=\"images/Wedding/finalwed4.png\" alt=\"Slide 4\" />"+
	    "<img src=\"images/Wedding/finalwed5.png\" alt=\"Slide 5\" />"+
	    "<img src=\"images/Wedding/finalwed6.png\" alt=\"Slide 6\" />"; 
	    audioString = "<audio controls autoplay loop ><source src=\"audio/wed.mp3\" type=\"audio/mpeg\"></audio>";

	}
else if(categoryName === "common"){
	Stitle = "<h1 align=\"center\"> Wedding</h1>";
	Simages = "<img src=\"images/Wedding/finalwed1.png\" alt=\"Slide 1\" />"+
    "<img src=\"images/Newyear/finalny3.png\" alt=\"Slide 3\" />"+
    "<img src=\"images/Wedding/finalwed2.png\" alt=\"Slide 2\" />"+
    "<img src=\"images/Birthday/finalbday5.png\" alt=\"Slide 5\" />"+
    "<img src=\"images/Newyear/finalny4.png\" alt=\"Slide 4\" />"+

    "<img src=\"images/Birthday/finalbday6.png\" alt=\"Slide 6\" />"; 
	
    audioString = "<audio controls autoplay loop ><source src=\"audio/common.mp3\" type=\"audio/mpeg\"></audio>";

}
else{
		Stitle = "<h1 align=\"center\"> Christmas And NewYear Party Planning</h1>";
		Simages = "<img src=\"images/Newyear/finalny1.png\" alt=\"Slide 1\" />"+
	    "<img src=\"images/Newyear/finalny2.png\" alt=\"Slide 2\" />"+
	    "<img src=\"images/Newyear/finalny3.png\" alt=\"Slide 3\" />"+
	    "<img src=\"images/Newyear/finalny4.png\" alt=\"Slide 4\" />"+
	    "<img src=\"images/Newyear/finalny5.png\" alt=\"Slide 5\" />"+
	    "<img src=\"images/Newyear/finalny6.png\" alt=\"Slide 6\" />"; 
	    audioString = "<audio controls autoplay loop ><source src=\"audio/Christms.mp3\" type=\"audio/mpeg\"></audio>";

	}
	$("#slideShowImages").html(Simages);
	$("#audioPlayer").html(audioString);
	
	var strSysmbol = eventName.replace(/%20/g,' ');
	
	var eventName1 = "&#9829;   " + strSysmbol + "   &#9829;" ;
	document.getElementById('eventNameSpace').innerHTML = eventName1;

	document.getElementById('eventNameSpace').style.fontWeight = 'bold';
	document.getElementById('eventNameSpace').style.fontSize = '40px';
	document.getElementById('eventNameSpace').style.color = '#87968e';



	var strWithoutPipe = itemDetails.split("|");
	//alert(strWithoutPipe);

	var detailTableString1 = "<form><table  align='center' id='customers'><tr><th>No.</th><th> Task Name</th><th width='180px'>Estimated Cost ($)</th></tr>";
	var detailTableString = "";

	for (var i = 0; i < strWithoutPipe.length; i++) {
		var s = strWithoutPipe[i].split("$");

		
		var strItem = s[1].replace(/%20/g,' ');

		var detailTableString2 = "<tr class='alt'><td>" + (i + 1) + "</td><td>" +strItem
				+ "</td><td><input type='text' id='txtCost" + i + "' value='"
				+ s[2] + "' onkeypress='return checkNo(event)' placeholder='Enter Cost'></td></tr>";

		detailTableString = detailTableString.concat(detailTableString2);
	}

	var detailTableStringFinal = detailTableString1.concat(detailTableString);

	document.getElementById('detailSpace').innerHTML = detailTableStringFinal;

}




