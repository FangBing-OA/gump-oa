<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>GUMP OA登录系统</title>
<link href="css/user.css" type="text/css" rel="stylesheet" />

<link rel="stylesheet" href="static/login/bootstrap.min.css" />
<link rel="stylesheet" href="static/login/css/camera.css" />
<link rel="stylesheet" href="static/login/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="static/login/matrix-login.css" />
<link rel="stylesheet" href="static/login/font-awesome.css" />
<script type="text/javascript" src="static/login/js/jquery-1.5.1.min.js"></script>
<!-- 软键盘控件start -->
<link href="static/login/keypad/css/framework/form.css" rel="stylesheet" type="text/css" />
<!-- 软键盘控件end -->
<style type="text/css">
/* 页面中的文本都不可被选中 */
body {
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

.cavs {
	z-index: 1;
	position: fixed;
	width: 95%;
	margin-left: 20px;
	margin-right: 20px;
}
</style>
<script>
	//window.setTimeout(showfh,3000); 
	var timer;
	function showfh() {
		fhi = 1;
		//关闭提示晃动屏幕，注释掉这句话即可
		timer = setInterval(xzfh2, 10);
	};
	var current = 0;
	function xzfh() {
		current = (current) % 360;
		document.body.style.transform = 'rotate(' + current + 'deg)';
		current++;
		if (current > 360) {
			current = 0;
		}
	};
	var fhi = 1;
	var current2 = 1;
	function xzfh2() {
		if (fhi > 50) {
			document.body.style.transform = 'rotate(0deg)';
			clearInterval(timer);
			return;
		}
		current = (current2) % 360;
		document.body.style.transform = 'rotate(' + current + 'deg)';
		current++;
		if (current2 == 1) {
			current2 = -1;
		} else {
			current2 = 1;
		}
		fhi++;
	};
</script>
</head>
<body>

	<!--小键盘承载器-->
	<canvas class="cavs"></canvas>
	<div
		style="width: 100%; text-align: center; margin: 0 auto; position: absolute;">
		<!-- 登录 -->
		<div id="windows1">
			<div id="loginbox">
				<form action="LoginOrExit!Login" method="post" name="loginForm" id="loginForm">
					<div class="control-group normal_text">
						<h3>
							<img src="static/login/logo.png" alt="Logo" />
						</h3>
					</div>
					<div class="control-group">
						<div class="controls">
							<div class="main_input_box">
								<span class="add-on bg_lg"> <i><img height="37"
										src="static/login/user.png" /></i>
								</span><input type="text" name="loginname" id="loginname" value=""
									placeholder="请输入用户名" />
							</div>
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<div class="main_input_box">
								<span class="add-on bg_ly"> <i><img height="37"
										src="static/login/suo.png" /></i>
								</span><input type="password" name="password" id="password"
									placeholder="请输入密码" class="keypad" keypadMode="full"
									allowKeyboard="true" value="" />
							</div>
						</div>
					</div>
					<div style="float: right; padding-right: 10%;">
					
					</div>
					<div class="form-actions">
						<div style="width: 86%; padding-left: 8%;">

							<!-- 滑块验证 -->
							<label class="form-inline">
								<div class="form-inline-font" style="color: white;">验证 :</div>
								<div class="form-inline-input">
									<div class="code-box" id="code-box">
										<input type="text" name="code" class="code-input" />
										<p></p>
										<span>>>></span>
									</div>
								</div>
							</label>

							<span class="pull-right"><a onclick="severCheck();"
								class="flip-link btn btn-info" id="to-recover">登录</a></span>
						</div>
					</div>
				</form>
				<div class="controls">
					<div class="main_input_box">
						<font color="white"><span id="nameerr">gump © 冈普科技
								2018</span></font>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div id="templatemo_banner_slide" class="container_wapper">
		<div class="camera_wrap camera_emboss" id="camera_slide">
			<!-- 背景图片 -->
			<div data-src="static/login/images/banner_slide_01.jpg"></div>
			<div data-src="static/login/images/banner_slide_02.jpg"></div>
			<div data-src="static/login/images/banner_slide_03.jpg"></div>
			<div data-src="static/login/images/banner_slide_04.jpg"></div>
			<div data-src="static/login/images/banner_slide_05.jpg"></div>
		</div>
		<!-- #camera_wrap_3 -->
	</div>

	<script src="js/login.js"></script>
	<script>
		window.addEventListener('load', function() {

			//code是后台传入的验证字符串
			var code = "jsaidaisd656", codeFn = new moveCode(code);

			//获取当前的code值
			//console.log(codeFn.getCode());

			//改变code值
			//code = '46asd546as5';
			//codeFn.setCode(code);

			//重置为初始状态
			//codeFn.resetCode();
		});
	</script>

	<script type="text/javascript">
		//服务器校验
		function severCheck() {
			if (check()) {
				$("#loginForm").submit();
			}
		}

		$(document).ready(function() {
			changeCode1();
			$("#codeImg").bind("click", changeCode1);
			$("#zcodeImg").bind("click", changeCode2);
		});

		$(document).keyup(function(event) {
			if (event.keyCode == 13) {
				$("#to-recover").trigger("click");
			}
		});

		function genTimestamp() {
			var time = new Date();
			return time.getTime();
		}

		function changeCode1() {
			$("#codeImg").attr("src", "code.do?t=" + genTimestamp());
		}
		function changeCode2() {
			$("#zcodeImg").attr("src", "code.do?t=" + genTimestamp());
		}

		//客户端校验
		function check() {

			if ($("#loginname").val() == "") {
				$("#loginname").tips({
					side : 2,
					msg : '用户名不得为空',
					bg : '#AE81FF',
					time : 3
				});
				showfh();
				$("#loginname").focus();
				return false;
			} else {
				$("#loginname").val(jQuery.trim($('#loginname').val()));
			}
			if ($("#password").val() == "") {
				$("#password").tips({
					side : 2,
					msg : '密码不得为空',
					bg : '#AE81FF',
					time : 3
				});
				showfh();
				$("#password").focus();
				return false;
			}
			if ($("#code").val() == "") {
				$("#code").tips({
					side : 1,
					msg : '验证码不得为空',
					bg : '#AE81FF',
					time : 3
				});
				showfh();
				$("#code").focus();
				return false;
			}
			
			//验证滑块是否拖动
			if($("p").html() != "验证成功"){
				$("p").tips({
					side : 1,
					msg : '拖动滑块进行验证',
					bg : '#AE81FF',
					time : 3
				});
				showfh();
				$("p").focus();
				return false;
			}
			
			$("#loginbox").tips({
				side : 1,
				msg : '正在登录 , 请稍后 ...',
				bg : '#68B500',
				time : 10
			});

			return true;
		}

		function savePaw() {
			if (!$("#saveid").attr("checked")) {
				$.cookie('loginname', '', {
					expires : -1
				});
				$.cookie('password', '', {
					expires : -1
				});
				$("#loginname").val('');
				$("#password").val('');
			}
		}

		function saveCookie() {
			if ($("#saveid").attr("checked")) {
				$.cookie('loginname', $("#loginname").val(), {
					expires : 7
				});
				$.cookie('password', $("#password").val(), {
					expires : 7
				});
			}
		}

		jQuery(function() {
			var loginname = $.cookie('loginname');
			var password = $.cookie('password');
			if (typeof (loginname) != "undefined"
					&& typeof (password) != "undefined") {
				$("#loginname").val(loginname);
				$("#password").val(password);
				$("#saveid").attr("checked", true);
				$("#code").focus();
			}
		});

		//登录注册页面切换
		function changepage(value) {
			if (value == 1) {
				$("#windows1").hide();
				$("#windows2").show();
				changeCode2();
			} else {
				$("#windows2").hide();
				$("#windows1").show();
				changeCode1();
			}
		}

		//注册
		function rcheck() {
			if ($("#USERNAME").val() == "") {
				$("#USERNAME").tips({
					side : 3,
					msg : '输入用户名',
					bg : '#AE81FF',
					time : 2
				});
				$("#USERNAME").focus();
				$("#USERNAME").val('');
				return false;
			} else {
				$("#USERNAME").val(jQuery.trim($('#USERNAME').val()));
			}
			if ($("#PASSWORD").val() == "") {
				$("#PASSWORD").tips({
					side : 3,
					msg : '输入密码',
					bg : '#AE81FF',
					time : 2
				});
				$("#PASSWORD").focus();
				return false;
			}
			if ($("#PASSWORD").val() != $("#chkpwd").val()) {
				$("#chkpwd").tips({
					side : 3,
					msg : '两次密码不相同',
					bg : '#AE81FF',
					time : 3
				});
				$("#chkpwd").focus();
				return false;
			}
			if ($("#name").val() == "") {
				$("#name").tips({
					side : 3,
					msg : '输入姓名',
					bg : '#AE81FF',
					time : 3
				});
				$("#name").focus();
				return false;
			}
			if ($("#EMAIL").val() == "") {
				$("#EMAIL").tips({
					side : 3,
					msg : '输入邮箱',
					bg : '#AE81FF',
					time : 3
				});
				$("#EMAIL").focus();
				return false;
			} else if (!ismail($("#EMAIL").val())) {
				$("#EMAIL").tips({
					side : 3,
					msg : '邮箱格式不正确',
					bg : '#AE81FF',
					time : 3
				});
				$("#EMAIL").focus();
				return false;
			}
			if ($("#rcode").val() == "") {
				$("#rcode").tips({
					side : 1,
					msg : '验证码不得为空',
					bg : '#AE81FF',
					time : 3
				});
				$("#rcode").focus();
				return false;
			}
			return true;
		}

		//提交注册
		function register() {
			if (rcheck()) {
				var nowtime = date2str(new Date(), "yyyyMMdd");
				$.ajax({
					type : "POST",
					url : 'appSysUser/registerSysUser.do',
					data : {
						USERNAME : $("#USERNAME").val(),
						PASSWORD : $("#PASSWORD").val(),
						NAME : $("#name").val(),
						EMAIL : $("#EMAIL").val(),
						rcode : $("#rcode").val(),
						FKEY : $.md5('USERNAME' + nowtime + ',fh,'),
						tm : new Date().getTime()
					},
					dataType : 'json',
					cache : false,
					success : function(data) {
						if ("00" == data.result) {
							$("#windows2").hide();
							$("#windows1").show();
							$("#loginbox").tips({
								side : 1,
								msg : '注册成功,请登录',
								bg : '#68B500',
								time : 3
							});
							changeCode1();
						} else if ("04" == data.result) {
							$("#USERNAME").tips({
								side : 1,
								msg : "用户名已存在",
								bg : '#FF5080',
								time : 15
							});
							showfh();
							$("#USERNAME").focus();
						} else if ("06" == data.result) {
							$("#rcode").tips({
								side : 1,
								msg : "验证码输入有误",
								bg : '#FF5080',
								time : 15
							});
							showfh();
							$("#rcode").focus();
						}
					}
				});
			}
		}

		//邮箱格式校验
		function ismail(mail) {
			return (new RegExp(
					/^(?:[a-zA-Z0-9]+[_\-\+\.]?)*[a-zA-Z0-9]+@(?:([a-zA-Z0-9]+[_\-]?)*[a-zA-Z0-9]+\.)+([a-zA-Z]{2,})+$/)
					.test(mail));
		}
		//js  日期格式
	</script>
	<script src="static/login/js/bootstrap.min.js"></script>
	<script src="static/js/jquery-1.7.2.js"></script>
	<script src="static/login/js/jquery.easing.1.3.js"></script>
	<script src="static/login/js/jquery.mobile.customized.min.js"></script>
	<script src="static/login/js/camera.min.js"></script>
	<script src="static/login/js/templatemo_script.js"></script>
	<script src="static/login/js/ban.js"></script>
	<script type="text/javascript" src="static/js/jQuery.md5.js"></script>
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
	<script type="text/javascript" src="static/js/jquery.cookie.js"></script>

	<!-- 软键盘控件start -->
	<script type="text/javascript"
		src="static/login/keypad/js/form/keypad.js"></script>
	<script type="text/javascript"
		src="static/login/keypad/js/framework.js"></script>
	<!-- 软键盘控件end -->
</body>
</html>