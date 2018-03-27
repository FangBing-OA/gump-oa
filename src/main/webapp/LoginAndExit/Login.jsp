<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<TITLE>GUMP OA</TITLE>
<LINK HREF="../html/style/blue/login.css" type=text/css rel=stylesheet />
<script src="../../js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="../../js/jquery.validate.min.js" type="text/javascript"></script>
<script type="text/javascript">
	//验证用户名是否存在
	jQuery.validator.addMethod("isExist", function(value, element, params) {
		//定义一个标志
		var flag = false;

		//value:输入的内容
		//element:被校验的元素对象
		//params:规则对应的参数值
		$.ajax({
			"async" : false,//是否异步
			"url" : "ChackAccAction!doChack",//跳转的地址
			"data" : {
				"account" : value
			},// 传递的参数
			"type" : "POST",// 提交方式
			"dataType" : "json",// json格式
			"success" : function(data) {// 
				//flag = data.isExist;
				flag = true;
			}
		});
		//返回false代表该校验器不通过
		return flag;
	});

	/* validate插件验证表单 */
	$(function() {
		$("#register").validate({
			rules : {
				"account" : {
					"required" : true
				},
				"password" : {
					"required" : true,
					"rangelength" : [ 6, 12 ]
				}

			},
			messages : {
				"account" : {
					"required" : "账号不能为空"
				},
				"password" : {
					"required" : "密码不能为空",
					"rangelength" : "密码长度6-12位"
				}
			}
		});
	});
</script>
<style type="text/css">
.error {
	color: red;
	font-size: 12px;
}
</style>
</HEAD>

<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0
	CLASS=PageBody>
	<s:form action="LoginOrExit!Login" theme="simple" id="register">
		<DIV ID="CenterAreaBg">
			<DIV ID="CenterArea">
				<DIV ID="LogoImg">
					<IMG BORDER="0" SRC="../html/style/blue/images/logo.png" />
				</DIV>
				<DIV ID="LoginInfo">
					<TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=80%>
						<TR>
							<TD width=45 CLASS="Subject"><IMG BORDER="0"
								SRC="../html/style/blue/images/login/userId.gif" /></TD>

							 <TD><INPUT SIZE="20" CLASS="TextField" TYPE="text"
								NAME="account" /></TD> 

							<TD ROWSPAN="2" STYLE="padding-left: 10px;"><INPUT
								TYPE="image"
								SRC="../html/style/blue/images/login/userLogin_button.gif" /></TD>
						</TR>
						<TR>
							<TD CLASS="Subject"><IMG BORDER="0"
								SRC="../html/style/blue/images/login/password.gif" /></TD>

							 <TD><INPUT SIZE="20" CLASS="TextField" TYPE="password"
								NAME="password" /></TD>
						</TR>
					</TABLE>
				</DIV>
				<DIV ID="CopyRight">
					<A HREF="javascript:void(0)">&copy; 2018 版权所有 Gump</A>
				</DIV>
			</DIV>
		</DIV>
	</s:form>
</BODY>

</HTML>

