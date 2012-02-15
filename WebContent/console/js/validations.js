<!--
	/**
	  *trim the space left of the string
	  *@param String
	  */
	function lTrim(sString)
	{ 
		var sStr,i,iStart,sResult = "";
		
		sStr = sString.split("");
		iStart = -1 ;
		for (i = 0 ; i < sStr.length ; i++)
		{
		if (sStr[i] != " ") 
		{
		iStart = i;
		break;
		}
		}
		if (iStart == -1) { return "" ;}
		else { return sString.substring(iStart) ;}
	}
	
	/**
	  *trim the space right of the stirng
	  *@param String
	  */
	function rTrim(sString)
	{ 
		var sStr,i,sResult = "",sTemp = "" ;
		
		 if (sString.length == 0) { return "" ;} //
		
		sStr = sString.split("");
		for (i = sStr.length - 1 ; i >= 0 ; i --)  //
		{ 
		sResult = sResult + sStr[i]; 
		}
		sTemp = JStrLTrim(sResult) ; //
		
		if (sTemp == "") { return "" ; }
		
		sStr = sTemp.split("");
		sResult = "" ;
		for (i = sStr.length - 1 ; i >= 0 ; i--) //
		{
		sResult = sResult + sStr[i];
		}
		return sResult ;
	} 
	
	/**
	  *trim the space both sides
	  *@param String
	  */
	function trim(sString)
	{
		var strTmp ;
		
		strTmp = rTrim(lTrim(sString)) ;
		
		return strTmp ;
	}
	
	/**
	  *check the if E-Mail String is correct 
	  *@param String
	  */
	function isEmail(emailAddr){
		if((emailAddr == null) || (emailAddr.length < 2)) 
			return false ;
    	var aPos = emailAddr.indexOf("@" ,1) ;
	 	if(aPos < 0){
    	    return false ;
    	}

    	if(emailAddr.indexOf("." ,aPos+2) < 0)
    	{
    	    return false ;
    	}
    	
    	var s=emailAddr.charAt(emailAddr.length-1);
    	if(!(('a'<=s&&s<='z')||('A'<=s&&s<='Z'))){
    		return false;
    	}
    	return true ;
	}
	
	/**
	  *Check if a String is numeric
	  *@param String
	  */
	function isNumeric(NUM)
	{
		var i,j,strTemp;
		strTemp="0123456789."; //String for comparing
		
		if ( NUM.length== 0)
			return false;
			
		for (i=0;i<NUM.length;i++)
		{
			j=strTemp.indexOf(NUM.charAt(i)); 
			if (j==-1)
			{
				//if there is character which isn't included by strtemp,return false
				return false;
			}
		}
		
		return true;
	}

	/** 
	 *Check if a string is a date type
	 *invoked isNumeric
	 *retrun: boolean 
	 *@param: String 
	 *divider: '-' 
	 */ 
	function isDate(dateStr){
	  var parts;
	
	  if(dateStr.indexOf("-") > -1){
	    parts = dateStr.split('-');
	  }else if(dateStr.indexOf("/") > -1){
	    parts = dateStr.split('/');
	  }else{
	    return false;
	  }
	
	  if(parts.length < 3){
	  //Integrality checking 
	    return false;
	  }
	
	  for(i = 0 ;i < 3; i ++){
	  //Check the charaters of date is numeric
	    if(!isNumeric(parts[i])){
	      return false;
	    }
	  }
	
	  y = parts[0];//Year
	  m = parts[1];//Month
	  d = parts[2];//Date
	
	  if(y > 3000){
	    return false;
	  }
	
	  if(m < 1 || m > 12){
	    return false;
	  }
	
	  switch(d){
	    case 29:
	      if(m == 2){
	      //Special for leap year
	        if( (y / 100) * 100 == y && (y / 400) * 400 != y){
	          //
	        }else{
	          return false;
	        }
	      }
	      break;
	    case 30:
	      if(m == 2){
	      //Special check for February
	        return false;
	      }
	      break;
	    case 31:
	      if(m == 2 || m == 4 || m == 6 || m == 9 || m == 11){
	      //Special for month with 30 days
	        return false;
	      }
	      break;
	    default:
	
	  }
	
	  return true;
	}
//-->