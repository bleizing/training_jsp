<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@ taglib prefix="dec"
           uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta
            content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
            name="viewport">

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
    <link rel="stylesheet" href="${ctx }/assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
	  <!-- Font Awesome -->
	  <link rel="stylesheet" href="${ctx }/assets/bower_components/font-awesome/css/font-awesome.min.css">
	  <!-- Ionicons -->
	  <link rel="stylesheet" href="${ctx }/assets/bower_components/Ionicons/css/ionicons.min.css">
	  <!-- Theme style -->
	  <link rel="stylesheet" href="${ctx }/assets/admin/css/AdminLTE.css">
	
	  <link rel="stylesheet" href="${ctx }/assets/admin/css/skins/skin-blue.min.css">

    <title><dec:title/> - BRI System Support</title>
     <link href='${ctx }/assets/admin/img/logo.png' type='image/x-icon' rel='shortcut icon'>
</head>

<body class="hold-transition skin-blue sidebar-mini">

<script>
    var ctx = '${ctx }/';
</script>
<script type="text/javascript" src="${ctx }/scripts/json/json.js"></script>
<script src="${ctx }/assets/bower_components/jquery/jquery.min.js"></script>
<script src="${ctx }/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<style>
  .mark-mandatory{
    color: red;
  }
  .li-first{
    display: none;
  }
</style>

<script>
  var _ctx = "${ctx }";
  function check_int(evt) {
      var charCode = ( evt.which ) ? evt.which : event.keyCode;
      return ( charCode >= 48 && charCode <= 57 || charCode == 8 || charCode == 46 );
  }

  function check_char(evt) {
      evt = (evt) ? evt : window.event;
      var charCode = (evt.which) ? evt.which : evt.keyCode;

      return((charCode > 47 && charCode < 58)||(charCode > 64 && charCode < 91)||(charCode > 96 && charCode < 123)||charCode == 0 || charCode == 8 || charCode == 46 );

  }
    function setActiveMenu(id, menu) {
        var menuDoc = document.getElementById("menu"+id);
        menuDoc.setAttribute("class", "treeview menu-open");
        var treeDoc = document.getElementById("treeMenu"+id);
        treeDoc.setAttribute("style", "display: block");

        var activeMenu = document.getElementById("li-"+menu);
            activeMenu.setAttribute("class", "active")
        console.log(menu);
    }

    function checkValue(evt, obj) {
      var _value = obj.value;
      var _isPercent = document.getElementById("inpPromoType").value;
      var charCode = ( evt.which ) ? evt.which : event.keyCode;
      var _aslicode =  String.fromCharCode(charCode);


      if(charCode >= 48 && charCode <= 57 || charCode == 8 || charCode == 46){

          console.log(_value+_aslicode);
          if(_isPercent == 0){
              if(_value > 100){
                  obj.value = 100;
                  return false;
              }
          }
      }else{
          return false;
      }
    }
  var DEFAULT_BUTTON_CONFIRM = {};
  var params_confirm = {};
      params_confirm["label"] = "Ya";
      params_confirm["className"] = "btn-success";

      DEFAULT_BUTTON_CONFIRM["confirm"] = params_confirm;
  var params_cancel = {};
      params_cancel["label"] = "Tidak";
      params_cancel["className"] = "btn-danger";
      DEFAULT_BUTTON_CONFIRM["cancel"] = params_cancel;   
      
      function dologout() {
          JSON.post("${ctx }/json/logout", {},function(data){
              window.location.href = "${ctx }/pages/login";

          },null, 20000);
      }

</script>
<div class="wrapper">


  <header class="main-header">


    <a href="/admins/pages/home" class="logo">

      <span class="logo-mini"><b>B</b>SS</span>

      <span class="logo-lg"><b>BRImo </b>SUPPORT SYSTEM</span>
    </a>


    <nav class="navbar navbar-static-top" role="navigation">

      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
         
         

          <li class="dropdown user user-menu">

            <a href="#" class="dropdown-toggle" data-toggle="dropdown">

              <img src="${ctx }/pages/get/img/profile?ratio=45x80" id="idImageLogo" class="user-image img-profile" alt="User Image">

              <span class="hidden-xs">${sessionUserName }</span>
            </a>
            <ul class="dropdown-menu">

              <li class="user-header">
                <img src="${ctx }/pages/get/img/profile?ratio=45x80" class="img-circle img-profile" alt="User Image">

                <p>
                  ${sessionUserName } - ${sessionGroupName }
                  <small>Member since ${sessionCreateOn }</small>
                </p>
              </li>

              <li class="user-footer">
                <div class="pull-left">
                  <a href="${ctx }/pages/user/profile?ratio=180x180" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a onclick="dologout()" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <%--<li>--%>
            <%--<a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>--%>
          <%--</li>--%>
        </ul>
      </div>
    </nav>
  </header>

  <aside class="main-sidebar">


    <section class="sidebar">


      <div class="user-panel">
        <div class="pull-left image">
          <img src="${ctx }/pages/get/img/profile?ratio=45x80" class="img-profile" alt="User Image img-profile">
        </div>
        <div class="pull-left info">
          <p>${sessionUserName }</p>


        </div>
      </div>



      <ul class="sidebar-menu" data-widget="tree">
        <li class="header"></li>

        <li ><a href="/admins/pages/home"><i class="fa fa-home"></i> <span>Beranda</span></a></li>
        
        
        <li id="menuManageParam" class="treeview menu-display">
          <a ><i class="fa fa-sliders"></i> <span>Management Parameter</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul id="treeMenuManageParam" class="treeview-menu menu-display">
            <li id="li-10000" class="li-10000 menu-display"><a href="${ctx }/pages/denom/pulsa"><i class="fa fa-phone-square"></i> Denom Pulsa</a></li>
            <li id="li-37000" class="li-37000 menu-display"><a href="${ctx }/pages/denom/paketdata"><i class="fa fa-phone-square"></i> Paket Data</a></li>
            <li id="li-38000" class="li-38000 menu-display"><a href="${ctx }/pages/denom/brizzi"><i class="fa fa-credit-card"></i> Denom Brizzi</a></li>
            <li id="li-39000" class="li-39000 menu-display"><a href="${ctx }/pages/ccmanagement"><i class="fa fa-credit-card"></i> Manajemen Kartu Kredit</a></li>
            <li id="li-13000" class="li-13000 menu-display"><a href="${ctx }/pages/cardmanagement/list"><i class="fa fa-credit-card"></i> Manajemen Kartu</a></li>
            <li id="li-20000" class="li-20000 menu-display"><a href="${ctx }/pages/bank/list"><i class="fa fa-bank"></i> Master Bank</a></li>
            <li id="li-30000" class="li-30000 menu-display"><a href="${ctx }/pages/sysconfig"><i class="fa fa-gears"></i> System Config</a></li>
            <li id="li-17000" class="li-17000 menu-display"><a href="${ctx }/pages/scheduler/list"><i class="fa fa-calendar"></i> Scheduler Manager</a></li>
            <li id="li-22000" class="li-22000 menu-display"><a href="${ctx }/pages/singleton/list"><i class="fa fa-recycle"></i> Singleton Manager</a></li>
            <li id="li-40000" class="li-40000 menu-display"><a href="${ctx }/pages/tnc/list"><i class="fa fa-file-text-o"></i> Syarat Ketentuan</a></li>
            <li id="li-14000" class="li-14000 menu-display"><a href="${ctx }/pages/instructions/list"><i class="fa fa-file-text-o"></i> Petunjuk Penggunaan</a></li>

          </ul>
        </li>
        
        <li id="menuManageKYC" class="treeview menu-display">
          <a ><i class="fa fa-sliders"></i> <span>Management KYC</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul id="treeMenuManageKYC" class="treeview-menu menu-display">
            <li id="li-50000" class="li-50000 menu-display"><a href="${ctx }/pages/kyc/list"><i class="fa fa-file-text-o"></i> Verifikasi KYC</a></li>
            <li id="li-60000" class="li-60000 menu-display"><a href="${ctx }/pages/kyc/list/approve"><i class="fa fa-file-text-o"></i> Approval KYC</a></li>
            <li id="li-23000" class="li-23000 menu-display"><a href="${ctx }/pages/kyc/status/list"><i class="fa fa-folder-open-o"></i> Dashboard Open Account </a></li>
          </ul>
        </li>
        
        <li id="menuManageOpenAccount" class="treeview menu-display">
        	<a ><i class="fa fa-sliders"></i> <span>Management Open Account</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          
          <ul id="treeMenuManageOpenAccount" class="treeview-menu menu-display">
          	<li id="li-55000" class="li-55000 menu-display"><a href="${ctx }/pages/openaccount/list/new"><i class="fa fa-file-text-o"></i> New </a></li>
          	<li id="li-55100" class="li-55100 menu-display"><a href="${ctx }/pages/openaccount/list/existing"><i class="fa fa-file-text-o"></i> Existing </a></li>
          </ul>
        </li>

        <li id="menuManageVoucher" class="treeview menu-display">
          <a href="${ctx }/pages/ewallet/dashboard"><i class="fa fa-sliders"></i> <span>Management Voucher eWallet</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul id="treeMenuManageVoucher" class="treeview-menu menu-display">
            <li id="li-79999" class="li-79999 menu-display"><a href="${ctx }/pages/ewallet/dashboard"><i class="fa fa-bar-chart-o"></i> Dashboard</a></li>
            <li id="li-70000" class="li-70000 menu-display"><a href="${ctx }/pages/ewallet/maker"><i class="fa fa-money"></i> Maker PO</a></li>
            <li id="li-80000" class="li-80000 menu-display"><a href="${ctx }/pages/ewallet/spv"><i class="fa fa-money"></i> Approval PO</a></li>
          </ul>
        </li>

          <li id="menuManagePromo" class="treeview menu-display">
              <a href="#"><i class="fa fa-sliders"></i> <span> Management Promo </span>
                  <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
              </a>
              <ul id="treeMenuManagePromo" class="treeview-menu">
                  <li id="li-15000" class="li-15000 menu-display"><a href="${ctx}/pages/promo/list"><i class="fa fa-dollar"></i> Kode Promo </a></li>
                  <li id="li-16000" class="li-16000 menu-display"><a href="${ctx}/pages/rules/list"><i class="fa fa-book"></i> Rules Authority </a></li>
              </ul>
          </li>

        <li id="menuManageResponseCode" class="treeview menu-display">
          <a href="#"><i class="fa fa-sliders"></i> <span> Management Response Code </span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul id="treeMenuManageResponseCode" class="treeview-menu">
            <li id="li-18000" class="li-18000 menu-display"><a href="${ctx}/pages/resp-code/list"><i class="fa fa-list-alt"></i> List Code </a></li>
            <li id="li-19000" class="li-19000 menu-display"><a href="${ctx}/pages/resp-code-map/list"><i class="fa fa-clipboard"></i> Code Mapping </a></li>
            <li id="li-21000" class="li-21000 menu-display"><a href="${ctx}/pages/resp-handler-map/list"><i class="fa fa-clipboard"></i> Handler Map </a></li>
            <li id="li-24000" class="li-24000 menu-display"><a href="${ctx}/pages/handler-code/list"><i class="fa fa-clipboard"></i> Handler Code </a></li>
          </ul>
          
        </li>
        
        
                

        <li id="menuManageImage" class="treeview menu-display">
          <a ><i class="fa fa-sliders"></i> <span>Management Image</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul id="treeMenuManageImage" class="treeview-menu menu-display">
            <li id="li-88100" class="li-88100 menu-display"><a href="${ctx }/pages/imagemanagement/list"><i class="fa fa-file-text-o"></i> Maker Image</a></li>
            <li id="li-88200" class="li-88200 menu-display"><a href="${ctx }/pages/imagemanagement/list/approval"><i class="fa fa-file-text-o"></i> Signer Image</a></li>
          </ul>
        </li>

        <li id="menuManageUser" class="treeview menu-display">
          <a href="#"><i class="fa fa-users"></i> <span> Management User </span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul id="treeMenuManageUser" class="treeview-menu menu-display">
            <li id="li-90000" class="li-90000 menu-display"><a href="${ctx}/pages/usermanagement/usermobile"><i class="fa fa-user"></i> User New BRI Mobile</a></li>
            <li id="li-11000" class="li-11000 menu-display"><a href="${ctx}/pages/usermanagement/userportal"><i class="fa fa-tv"></i> User Portal</a></li>
            <li id="li-12000" class="li-12000 menu-display"><a href="${ctx}/pages/usermanagement/grouprole"><i class="fa fa-tags"></i> Group role</a></li>
          </ul>
        </li>

        
      </ul>

    </section>
  </aside>


  <div class="content-wrapper">

    <section class="content-header">
      <h1>
        <dec:title/>

        
      </h1>


    </section>


    <section class="content container-fluid">

     	<dec:body/>

    </section>

  </div>

  <footer class="main-footer">

    <div class="pull-right hidden-xs">
     BRI
    </div>

    <strong>Copyright &copy; 2018 <a href="#">BRI </a>.</strong> All rights reserved.
  </footer>




  <div class="control-sidebar-bg"></div>
</div>
<dec:getProperty property="page.local_script"></dec:getProperty>
<script src="${ctx }/assets/admin/js/adminlte.min.js"></script>

<script>
    var ROLE_GROUP = ${ctxArrayRole };

    function displayMenu(){
        var _groupName = '${sessionGroupName}';

/*         if(_groupName == "SYSADMIN"){
            $('.li-first').removeClass("li-first");
            return;
        } */
        $('.menu-display').css("display", "none");
        var data = ROLE_GROUP;

        for(var i=0; i<data.length; i++){
            var _tree = data[i]["tree"];
            $("#menu"+_tree).css("display","block");
            $("#treeMenu"+_tree).removeAttr("style");
            $('.li-'+data[i].role).css("display","block");
            $('.btnli-'+data[i].role).removeClass("li-first");
        }
    }
    
    function convertToAngka(nominal)
    {
        var angka = parseInt(nominal.replace(/,.*|[^0-9]/g, ''), 10);
        return angka;
    }
    function toIdr(number) {
        var reverse = parseInt(number, 10).toString().split('').reverse().join('');
        var rev2 = '';
        for (var i = 0; i < reverse.length; i++) {
            rev2 += reverse[i];
            if ((i + 1) % 3 === 0 && i !== (reverse.length - 1)) {
                rev2 += '.';
            }
        }
        return rev2.split('').reverse().join('');
    }
    $(".rpformat").keyup(function (){

        separator = ".";
        a = $(this).val();
        areal = a;
        b = a.replace(/[^\d]/g,"");
        c = "";
        panjang = b.length;
        j = 0;
        for (i = panjang; i > 0; i--) {
            j = j + 1;
            if (((j % 3) == 1) && (j != 1)) {
                c = b.substr(i-1,1) + separator + c;
            } else {
                c = b.substr(i-1,1) + c;
            }
        }
        $(this).val(c);
        $(this).attr("data-real", convertToAngka(c));
    });
    
    displayMenu();
</script>
</body>
</html>