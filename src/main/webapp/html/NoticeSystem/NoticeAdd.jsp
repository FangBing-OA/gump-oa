<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-3.0.0.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="/gump-oa/html/style/images/title_arrow.gif"/> 发送消息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <form action="na!add" method="post">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="../style/blue/images/item_point.gif" /> 信息内容 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
        
					 <tr>
                        <td>标题</td>
                        <td><input type="text" name="title" class="InputStyle" style="width:472px;"  name="title"/></td>
                    </tr>
                    <tr>
                        <td>内容</td>
                        <td><textarea name="content" class="TextareaStyle" style="width: 550px; height: 300px;" name="content"></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
			<input type="IMAGE" src="/gump-oa/html/style/blue/images/button/send.png" id="submit" name="submit"/>
			<a href="javascript:history.go(-1);"><img src="/gump-oa/html/style/images/goBack.png"/></a>
        </div>
    </form>
</div>

</body>
<script type="text/javascript">
	$("submit").click(function(){
		submit();
	});
</script>
</html>