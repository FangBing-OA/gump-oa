<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>您已退出 Gump OA系统</title>
<link href="../html/style/blue/logout.css" rel="stylesheet"
	type="text/css" />
</head>

<body>
	<table border=0 cellspacing=0 cellpadding=0 width=100% height=100% style="margin-top:200px;">
		<tr>
			<td align=center>
				<div id=Logout>
					<div id=AwokeMsg>
						<img id=LogoutImg
							src="../html/style/blue/images/logout/logout.gif" border=0 /><img
							id=LogoutTitle src="../html/style/blue/images/logout/logout1.gif"
							border=0 />
					</div>
					<div id=LogoutOperate>
						<img src="../html/style/blue/images/logout/logout2.gif" border=0 />
						<a href="/gump-oa/LoginAndExit/Login.jsp">重新登入系统</a>
						<img src="../html/style/blue/images/logout/logout3.gif" border=0 />
						<a href="javascript:window.opener=null;window.close();">关闭此页面</a>
					</div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
