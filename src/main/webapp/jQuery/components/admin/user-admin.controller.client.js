$(document).ready(function(){
	$("#div1").hide();
    $("#div2").hide();
    $("#div3").hide();
    $("#div4").hide();
    $("#div5").hide();

  
  $("#button1").click(function(){
	    
	    var $patt = $("#div5").attr("style");
	   	var $match= $patt.match(/display: none;/g);
	   	
         if($("#div2").attr("style")==!("display: none;"))
         {
         	$("#div2").hide();
         }
         if($("#div3").attr("style")==!("display: none;"))
         {
         	$("#div3").hide();
         }
         if($("#div4").attr("style")==!("display: none;"))
         {
         	$("#div4").hide();
         }
         if($match==null)
         {
         	$("#div5").hide();
         }
         if($("#div1").attr("style")==!("display: none;"))
         {
         	$("#div1").hide();
         }
         else
         {
         	$("#div1").show();
         }

   })
   

   $("#button2").click(function(){
	    
	    var $patt = $("#div5").attr("style");
	   	var $match= $patt.match(/display: none;/g);
	   	
         if($("#div1").attr("style")==!("display: none;"))
         {
         	$("#div1").hide();
         }
         if($("#div3").attr("style")==!("display: none;"))
         {
         	$("#div3").hide();
         }
         if($("#div4").attr("style")==!("display: none;"))
         {
         	$("#div4").hide();
         }
         if($match==null)
         {
         	$("#div5").hide();
         }
         if($("#div2").attr("style")==!("display: none;"))
         {
         	$("#div2").hide();
         }
         else
         {
         	$("#div2").show();
         }

   })

   
   
    $("#button3").click(function(){
        var $patt = $("#div5").attr("style");
       	var $match= $patt.match(/display: none;/g);
       	
    	if($("#div1").attr("style")==!("display: none;"))
        {
        	$("#div1").hide();
        }
    	
    	if($("#div2").attr("style")==!("display: none;"))
        {
        	$("#div2").hide();
        }
        
    	if($("#div3").attr("style")==!("display: none;"))
        {
        	$("#div3").hide();
        }
    	
    	 if($("#div4").attr("style")==!("display: none;"))
         {
         	$("#div4").hide();
         }
       	
       	if($match==null)
        {
        	$("#div5").hide();
        }
      
        else
        {
        	$("#div5").show();
        }

  })
  
   $("#button4").click(function(){
        var $patt = $("#div5").attr("style");
       	var $match= $patt.match(/display: none;/g);
       	
    	if($("#div1").attr("style")==!("display: none;"))
        {
        	$("#div1").hide();
        }
    	
    	if($("#div2").attr("style")==!("display: none;"))
        {
        	$("#div2").hide();
        }
        
    	 if($("#div4").attr("style")==!("display: none;"))
         {
         	$("#div4").hide();
         }
       	
       	if($match==null)
        {
        	$("#div5").hide();
        }
       	
       	if($("#div3").attr("style")==!("display: none;"))
        {
        	$("#div3").hide();
        }
      
        else
        {
        	$("#div3").show();
        }

  })
 
  $("#button5").click(function(){
        var $patt = $("#div5").attr("style");
       	var $match= $patt.match(/display: none;/g);
       	
    	if($("#div1").attr("style")==!("display: none;"))
        {
        	$("#div1").hide();
        }
    	
    	if($("#div2").attr("style")==!("display: none;"))
        {
        	$("#div2").hide();
        }
        
    	 if($("#div3").attr("style")==!("display: none;"))
         {
         	$("#div3").hide();
         }
       	
       $("#div4").show();

  })

  
  
});