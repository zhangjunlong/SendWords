/**
 *CharMode函数 
 *测试某个字符是属于哪一类. 
 */
function classifyChar(iN) { 
	//数字 
	if (iN>=48 && iN <=57)
		return 1;
	//大写字母
	if (iN>=65 && iN <=90)
		return 2; 
	//小写 
	if (iN>=97 && iN <=122) 
		return 4; 
	else
		//特殊字符 
		return 8; 
} 

/**
 *bitTotal函数
 *计算出当前密码当中一共有多少种模式
 */
function getTotalModes(num) {

	var modes=0;

	for (i=0;i<4;i++) {

		if (num & 1)
			modes++; 

		num>>>=1;

	}

	return modes;

}

/**
 *checkStrong函数 
 *返回密码的强度级别 
 */
function getStrengthLevel(sPW){

	if (sPW.length<=5) 

		return 0; //密码太短 

	Modes=0; 

	for (i=0;i<sPW.length;i++){
		//测试每一个字符的类别并统计一共有多少种模式.
		Modes|=classifyChar(sPW.charCodeAt(i)); 

	}
	
	return getTotalModes(Modes); 

}

/**
 *pwStrength函数 
 *当用户放开键盘或密码输入框失去焦点时,根据不同的级别显示不同的颜色 
 */
function rateStrength(pwd){

	O_color="silver";
	L_color="darkred";	
	M_color="orange";	
	H_color="green";
	strLevel="";

	if (pwd==null||pwd=='') {
	
		Lcolor=Mcolor=Hcolor=O_color;

	} else {

		S_level=getStrengthLevel(pwd);
		
		switch(S_level) { 
		
		case 0: 
			Ocolor=Lcolor=Mcolor=Hcolor=O_color;
			strLevel="<strong>Too short</strong>";
			document.getElementById("level").style.color=Lcolor;
			break;
		case 1:
			Lcolor=L_color;
			Mcolor=Hcolor=O_color;
			strLevel="<strong>Weak</strong>";
			document.getElementById("level").style.color=Lcolor;
			break; 
		case 2: 
			Lcolor=Mcolor=M_color;
			Hcolor=O_color;
			strLevel="<strong>Fair</strong>";
			document.getElementById("level").style.color=Mcolor;
			break;
		default: 
			Lcolor=Mcolor=Hcolor=H_color;
			strLevel="<strong>Good</strong>";
			document.getElementById("level").style.color=Hcolor;
		}

	} 
	
	document.getElementById("low").style.background=Lcolor;
	document.getElementById("medium").style.background=Mcolor;
	document.getElementById("high").style.background=Hcolor;
	document.getElementById("level").innerHTML=strLevel;
	
	return; 
} 

function repeatCheck(str1,str2,display) {

	if(str1==str2){
		document.getElementById(display).innerHTML="<img src=\"../images/ui/ok.gif\" alt=\"\" align=\"top\"/>Right!";
		document.getElementById(display).className="alert";
		return;
	} else {
		//document.getElementById(ipt).value="";
		document.getElementById(display).innerHTML="<img src=\"../images/ui/error.gif\" alt=\"\" align=\"top\"/>Mistake!";
		document.getElementById(display).className="alert";
		return;
	}
}

//come from Google
function ratePasswd(formKey) {
    if (!isBrowserCompatible) {
      return;
    }

    var passwd = document.forms[formKey]["Passwd"].value;

    if (document.forms[formKey]["Email"]) {
      var email = getUserName(document.forms[formKey]["Email"].value);
    }

    if (document.forms[formKey]["LastName"]) {
      // If Last name exists, It has to be Caribou Sign up.  We'll have
      // all the functions defined in CaribouSignUpBox.gxp
      var lastname = escape(document.forms[formKey]["LastName"].value);
    }

    if (document.forms[formKey]["FirstName"]) {
      var firstname = escape(document.forms[formKey]["FirstName"].value);
    }

    var min_passwd_len = 6;
    var passwdKey = "Passwd";
    var emailKey = "Email";
    var FirstNameKey = "FirstName";
    var LastNameKey = "LastName";

  
    if (passwd.length < min_passwd_len)  {
      if (passwd.length > 0) {
        DrawBar(0);
      } else {
        ResetBar();
      }
    } else {
  	  //We need to escape the password now so it won't mess up with length test
      passwd = escape(passwd);
      var params = passwdKey + "=" + passwd + "&" +
                   emailKey + "=" + email + "&" +
                   FirstNameKey + "=" + firstname + "&" +
                   LastNameKey + "=" + lastname;
      myxmlhttp = CreateXmlHttpReq(RatePasswdXmlHttpHandler);
  
      XmlHttpPOST(myxmlhttp, "https://www.google.com/accounts/RatePassword", params);
  
    }
  }