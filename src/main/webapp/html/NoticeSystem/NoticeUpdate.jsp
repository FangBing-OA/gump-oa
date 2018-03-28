<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>公告修改</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<!--显示表单内容-->
    <form action="na!doUpdate" method="post">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
            <img border="0" width="4" height="7" src="../style/blue/images/item_point.gif" />  </div> 
        </div>
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm" style="border-collapse:separate;
border-spacing:15px 30px;">
					<tr>
						<td><s:hidden name="updateId"/></td>
					</tr>
                    <tr><td>公告标题</td>
                    	
                       <td><s:textfield name="updateTitle" theme="simple"/></td>
                    </tr>
                   
                    <tr><td>公告内容</td>
                        <td><s:textarea name="updateContent" theme="simple"/></td>
                    </tr> 
                
                    <tr>
                        <td><input type="submit" value="修改"/></td>
                        <td align="center"><input type="reset" value="重置"/></td>
                    </tr>
                </table>
            </div>
        </div>
     </form>  
</body>
</html>
