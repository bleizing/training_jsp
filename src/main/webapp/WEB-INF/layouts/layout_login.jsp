<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html style="opacity: 1;background-size: cover;height: auto;min-height: 100%;background-image: url('${ctxAssets}/admin/img/background2.png')";>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title><dec:title/></title>
   <link href='${ctx }/assets/admin/img/logo.png' type='image/x-icon' rel='shortcut icon'>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <style type="text/css">
    @font-face {
	font-family: 'Glyphicons Halflings';
	src: url(${ctx }/assets/bower_components/bootstrap/dist/fonts/glyphicons-halflings-regular.eot);
	src: url(${ctx }/assets/bower_components/bootstrap/dist/fonts/glyphicons-halflings-regular.eot?#iefix)
		format('embedded-opentype'),
		url(${ctx }/assets/bower_components/bootstrap/dist/fonts/glyphicons-halflings-regular.woff2) format('woff2'),
		url(${ctx }/assets/bower_components/bootstrap/dist/fonts/glyphicons-halflings-regular.woff) format('woff'),
		url(${ctx }/assets/bower_components/bootstrap/dist/fonts/glyphicons-halflings-regular.ttf) format('truetype'),
		url(${ctx }assets/bower_components/bootstrap/dist/fonts/glyphicons-halflings-regular.svg#glyphicons_halflingsregular)
		format('svg')
}

  @font-face {
	font-family: 'FontAwesome';
	src: url('${ctx }/assets/bower_components/font-awesome/fonts/fontawesome-webfont.eot?v=4.7.0');
	src: url('${ctx }/assets/bower_components/font-awesome/fonts/fontawesome-webfont.eot?#iefix&v=4.7.0')
		format('embedded-opentype'),
		url('${ctx }/assets/bower_components/font-awesome/fonts/fontawesome-webfont.woff2?v=4.7.0') format('woff2'),
		url('${ctx }/assets/bower_components/font-awesome/fonts/fontawesome-webfont.woff?v=4.7.0') format('woff'),
		url('${ctx }/assets/bower_components/font-awesome/fonts/fontawesome-webfont.ttf?v=4.7.0') format('truetype'),
		url('${ctx }/assets/bower_components/font-awesome/fonts/fontawesome-webfont.svg?v=4.7.0#fontawesomeregular')
		format('svg');
	font-weight: normal;
	font-style: normal
}
 
  </style>

  
  
  <!-- Bootstrap 3.3.7 -->
 <link rel="stylesheet" href="${ctx }/assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
   <link rel="stylesheet" href="${ctx }/assets/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${ctx }/assets/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${ctx }/assets/admin/css/AdminLTE.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${ctx }/assets/admin/css/skins/skin-blue.min.css">


  
  <%--<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">--%>
</head>

<body class="hold-transition login-page" style="background: none">

<dec:body/>

<script>
    var ctx = '${ctx }/';
</script>
<script type="text/javascript" src="${ctx }/scripts/json/json.js"></script>
<script src="${ctx }/assets/bower_components/jquery/jquery.min.js"></script>
<script src="${ctx }/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${ctx }/assets/bower_components/iCheck/icheck.js"></script>
<script src="${ctx }/assets/admin/js/adminlte.min.js"></script>

<script type="text/javascript"
        src="${ctxAssets}/bower_components/jquery/validators/jquery.validate.js?${reqTid }"></script><%--
<script type="text/javascript" src="${ctxJsModules}/login/main.js?${reqTid }"></script>--%>
<!-- iCheck -->
<script src="${ctxAssets}/bower_components/iCheck/icheck.min.js"></script>
<script src="${ctx }/assets/bower_components/bootstrap/dist/js/bootbox.min.js"></script>

</body>


	
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>
