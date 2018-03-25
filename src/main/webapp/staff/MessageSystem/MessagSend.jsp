<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>发送消息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" src="../script/jquery.js"></script>
    <script language="javascript" src="../script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="../script/PageUtils.js" charset="utf-8"></script>
    <script language="javascript" src="../script/DemoData.js" charset="utf-8"></script>
	<script language="javascript" src="../script/DataShowManager.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="../style/blue/pageCommon.css" />

	<script language="javascript" src="../script/fckeditor/fckeditor.js" charset="utf-8"></script>
    <script type="text/javascript">
		$(function(){
			var fck = new FCKeditor("content");
			fck.Width = "99%";
			fck.Height = "300px";
			fck.ToolbarSet = "bbs";
			fck.BasePath = "../script/fckeditor/";
			fck.ReplaceTextarea();
		});

		function openSelectReceiverUI(){
			myShowModalDialog("selectReceiverUI.html", 500, 500);
		}
    </script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="../style/images/title_arrow.gif"/> 发送消息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <form action="outBox.html">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="../style/blue/images/item_point.gif" /> 信息内容 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="65px">级别</td>
						<td colspan="2">
							<select name="priority">
								<option value="普通">普通　</option>
								<option value="重要">重要　</option>
							</select>
						</td>
                    </tr>
					<tr>
                        <td width="65px">接收人</td>
                        <td><input type="text" name="receiverName" readonly class="InputStyle" style="width:400px; float:left;"/>
							<div onClick="openSelectReceiverUI()" class="FuncBtn" style="margin-left: 10px;">
								<div class="FuncBtnHead"></div>
								<div class="FuncBtnMemo">选择...</div>
								<div class="FuncBtnTail"></div>
							</div>
 						</td>
                    </tr>
					 <tr>
                        <td>标题</td>
                        <td><input type="text" name="title" class="InputStyle" style="width:472px;"/></td>
                    </tr>
                    <tr>
                        <td>内容</td>
                        <td><textarea name="content" class="TextareaStyle" style="width: 550px; height: 300px;"></textarea></td>
                    </tr>
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
			<input type="IMAGE" src="../style/blue/images/button/send.png"/>
			<input type="IMAGE" src="../style/blue/images/button/saveToDraftBox.png"/>
			<a href="javascript:history.go(-1);"><img src="../style/images/goBack.png"/></a>
        </div>
    </form>
</div>

</body>
</html>
