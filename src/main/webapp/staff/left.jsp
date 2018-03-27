<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript" src="script/jquery.js"></script>
<script language="JavaScript" src="script/menu.js"></script>
<script type="text/javascript" src="/gump-oa/src/main/webapp/jquery-3.0.0.js"></script>
<link type="text/css" rel="stylesheet" href="style/blue/menu.css" />
</head>
<body style="margin: 0">
<div id="Menu">
    <ul id="MenuUl">
        <li class="level1">
      <div onClick="menuClick(this)" class="level1Style"><img src="style/images/MenuIcon/FUNC20001.gif" class="Icon" /> <a target="right" href="http://localhost:8080/gump-oa/ea!getAllEmp">员工管理</a></div>
        </li>
        
        <li class="level1">
            <div onClick="menuClick(this);" class="level1Style"><img src="style/images/MenuIcon/FUNC20057.gif" class="Icon" />  <a target="right"
			href="Flow_FormFlow_Old/mySubmittedList.html">部门管理</a></div>
        </li>
        <li class="level1">
            <div onClick="menuClick(this);" class="level1Style"><img src="style/images/MenuIcon/FUNC20064.gif" class="Icon" /> 信息管理</div>
            <ul style="display: none;" class="MenuLevel2">
                <li class="level2">
                    <div class="level2Style"><img src="style/images/MenuIcon/menu_arrow_close.gif" /> 短消息</div>
                    <ul style="display: inline;" id="message" >
                        <li class="level3Head"><a target="right" href="ma!toSave.action">发送短消息</a></li>
                        <li class="level33"><a target="right" href="ma!toRedirectInBox.action">已接收</a></li>
                        <li class="level33"><a target="right" href="ma!toRedirectOutbox.action">已发送</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        
        
        
        <li class="level1">
            <div class="level1Style"><img src="style/images/MenuIcon/FUNC20056.gif" class="Icon" />  <a target="right"
			href="Flow_FormFlow_Old/mySubmittedList.html">公告管理</a></div>
        </li>
        
        
        
        <li class="level1">
            <div onClick="menuClick(this);" class="level1Style"><img src="style/images/MenuIcon/FUNC20070.gif" class="Icon" />  <a target="right"
			href="Flow_FormFlow_Old/mySubmittedList.html">公文管理</a></div>
        </li>
        
        
        
        <li class="level1">
            <div onClick="menuClick(this);" class="level1Style"><img src="style/images/MenuIcon/FUNC261000.gif" class="Icon" />  <a target="right"
			href="Flow_FormFlow_Old/mySubmittedList.html">职位管理</a></div>
        </li>
        
        
        <li class="level1">
            <div onClick="menuClick(this);" class="level1Style"><img src="style/images/MenuIcon/FUNC20077.gif" class="Icon" /> 个人设置</div>
            <ul style="display: none;" class="MenuLevel2">
                <li class="level2">
                    <div class="level2Style"><img src="style/images/MenuIcon/menu_arrow_single.gif" /> <a target="right" href="Person_Config/editUserInfoUI.html">个人信息</a></div>
                </li>
                <li class="level2">
                    <div class="level2Style"><img src="style/images/MenuIcon/menu_arrow_single.gif" /> <a target="right" href="Person_Config/editPasswordUI.html">密码修改</a></div>
                </li>
<!--                <li class="level2">
                    <div class="level2Style"><img src="style/images/MenuIcon/menu_arrow_single.gif" /> 桌面定义</div>
                </li>-->
            </ul>
        </li>
        
    </ul>
</div>
</body>
 <script type="text/javascript">

   function check()
   {
	   
	   var message=document.getElementById("message");
	   if(message.style.display=="none")
		   {	 
		   message.style.display="inline";
		   }
	   else
		   {
			 message.style.display="none";   
		   }
	  // alert(message);
   }
  
</script>
</html>

