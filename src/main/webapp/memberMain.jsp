<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
 	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Librain</title>
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  
 <style type="text/css">
	@charset "utf-8";
	
	* {
		padding:0; 
		margin:0; 
		border:0;
	  }
	
	body {
		background-image: url('resources/img/background-library.jpg');
		background-size: 100%;
		/* background: #d5d5d5; */
		font-family:trebuchet MS;
		color:#6B6B6B;
	    border: 0 none;
	    margin: 0;
		font-size:13px;
	    padding: 0;
		 }
	#wrapper{
 		padding: 60px 0px;
			}

.container{}
.row{}
.circle{
  background: #ffffff;
  padding: 40px;
  text-align: center;
  height: 250px;
  width: 250px;
  border: 8px solid #F2F2F2;
    
  transition: all 0.5s;
  -moz-transition: all 0.5s; /* Firefox 4 */
  -webkit-transition: all 0.5s; /* Safari and Chrome */
  -o-transition: all 0.5s; /* Opera */
 
}
.circle h4{
  margin: 0;
  padding: 0;
}
.circle p{}
.circle span{}
.circle span.icon{
}
.circle span.icon i{
  font-size: 48px;
}
.circle span.price-large{
  font-size: 68px
}
.price-small{
  font-size: 24px 
}

.c1:hover{
  background: #39b3d7;
  color: #ffffff;
}
.c1 .blue{
  color: #39b3d7;
}
.c1:hover .blue{
  color: #ffffff;
}

.c2:hover{
  background: #ed9c28;
  color: #ffffff;
}
.c2 .yellow{
  color: #ed9c28;
}
.c2:hover .yellow{
  color: #ffffff;
}

.c3:hover{
  background: #47a447;
  color: #ffffff;
}
.c3 .green{
  color: #47a447;
}
.c3:hover .green{
  color: #ffffff;
}

.c4:hover{
  background: #d2322d;
  color: #ffffff;
}
.c4 .red{
  color: #d2322d;
}
.c4:hover .red{
  color: #ffffff;
} 

</style>
  </head>

  <body>

    <div class="container">
      <div class="masthead">
        <br><h2 style="font-weight:bold; color:white" class="text-muted" >환영합니다</h2>
      </div>

            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
           <!--  /.navbar-header -->
            <hr>

       <!-- Jumbotron -->
     <!--  <div class="jumbotron"> -->
       <img id="bgImg" src="${pageContext.request.contextPath}/resources/img/logo_transparent.png" width="100%" align="middle">
        <p class="lead"></p>
      <!-- </div>  -->
<!--       <link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
 -->  
 <hr>
<div id="wrapper">
    <div class="container">
        <div class="row">
              <div class="col-md-3">
                  <div class="circle c1 img-circle">
                      <span class="icon blue"></span>
                      <span class="price-small blue" style="font-weight:bold">회원가입</span><br><br>
                      <p>회원가입 후 도서를 대출하실 수 있습니다.</p>
                  <a class="btn btn-lg btn-info" href="${pageContext.request.contextPath}/member/join.do" role="button">가입하기</a>
                  </div>
              </div><!-- .Col-md-3 ends here -->
          
              <div class="col-md-3">
                     <div class="circle c2 img-circle">
                      <span class="icon yellow"></span>
                      <span class="price-small yellow" style="font-weight:bold">정보수정</span><br><br>
                      <p>주소와 연락처는 최신상태로 유지하시기 바랍니다.</p>
                      <a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath}/member/login.do" role="button">정보수정</a>
                  </div>
              </div><!-- .Col-md-3 ends here -->
          
          <div class="col-md-3">
                   <div class="circle c3 img-circle">
                      <span class="icon green"></span>
                      <span class="price-small green" style="font-weight:bold">도서검색</span><br><br>
                      <p>Librain 보유 도서 목록을 열람하실 수 있습니다.</p>
                      <a class="btn btn-lg btn-success" href="${pageContext.request.contextPath}/member/book/search.do" role="button">도서검색</a></p>
                  </div>
              </div><!-- .Col-md-3 ends here -->
          
            <div class="col-md-3">
                  <div class="circle c4 img-circle">
                      <span class="icon red"></span>
                      <span class="price-small red" style="font-weight:bold">희망도서</span><br><br>
                      <p>희망도서는 심사 후 구매여부가 결정됩니다.</p>
                      <a class="btn btn-lg btn-danger" href="${pageContext.request.contextPath}/member/book/hope.do" role="button">신청하기</a></p>
                  </div>
                  </div>
              </div><!-- .Col-md-3 ends here -->
        </div><!-- .Container ends here -->
    </div><!-- .Row ends here -->
      
    </div> <!-- /container -->
    <!-- Bootstrap core JavaScript-->
<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
  </body>
</html>
