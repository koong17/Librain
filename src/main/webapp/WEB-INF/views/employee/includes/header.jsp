<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="utf-8">
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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<c:if test='${empty sessionScope.emp_no }'>
<c:redirect url="/login.do" />
</c:if>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/main.do"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;Librain</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
             		     사용자 : ${sessionScope.emp_name } [${sessionScope.emp_position }]
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                   	    <c:choose>	 
						<c:when test='${!empty sessionScope.emp_no }'>
                        <li><a href="${pageContext.request.contextPath}/mypage/commute.do"><i class="fa fa-check" aria-hidden="true"></i> 근태관리</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/mypage/info.do"><i class="fa fa-krw" aria-hidden="true"></i>&nbsp;&nbsp;정보수정</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/mypage/pay.do"><i class="fa fa-gear fa-fw"></i> 개인급여</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/logout.do"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                        </c:when>
                        <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/login.do"><i class="fa fa-sign-in fa-fw"></i> Login</a>
                        </li>
                        </c:otherwise>
                        </c:choose>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <c:choose>
                       <c:when test="${sessionScope.emp_position == '관장' || sessionScope.emp_position == '팀장'}">
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> 관리자</a>
                            <ul class="nav nav-second-level collapse in">
                                 <li>
                                    <a href="#">직원관리 <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/mgmt/emplist2.do">직원목록</a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/mgmt/cmtlist.do">근태목록</a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/mgmt/totalpay.do">급여관리</a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/mgmt/totalpaylist.do">급여목록</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                                
                               <li>
                                    <a href="#">도서관리 <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                    	<li>
		                                    <a href="${pageContext.request.contextPath}/book/search.do">도서검색</a>
		                                </li>
		                                <li>
		                                    <a href="${pageContext.request.contextPath}/book/rent.do">대여</a>
		                                </li>
		                                <li>
		                                    <a href="${pageContext.request.contextPath}/book/hope.do">희망 도서 승인</a>
		                                </li>
		                                <li>
		                                    <a href="${pageContext.request.contextPath}/book/newApply.do">도서 구입 신청</a>
		                                </li>
		                                <li>
		                                    <a href="${pageContext.request.contextPath}/book/discardApply.do">도서 폐기 신청</a>
		                                </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/admin/book/approve/newBook.do">도서 구입 승인</a>
                                        </li>
                                        <li>
                                            <a href="${pageContext.request.contextPath}/admin/book/approve/disBook.do">도서 폐기 승인</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                                
                                <li>
                                    <a href="#">회원관리 <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/memberList.do">회원목록</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                                
                            	<li>
                                    <a href="#">시설관리 <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/facility">시설</a>
                                        </li>
                                        <li>
                                        	<a href="${pageContext.request.contextPath}/facilityapproval">시설승인</a>
                                        </li>
                                         <li>
                                        	<a href="${pageContext.request.contextPath}/facilityinspection">시설검사</a>
                                        </li>
                                        
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li> 
                                
                                <li>
                                <a href="${pageContext.request.contextPath}/board/list.do">사내게시판</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                       </c:when>
                       <c:otherwise>
                         <li>
                            <a href="#"><i class="fa fa-book" aria-hidden="true"></i> 도서관리<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${pageContext.request.contextPath}/book/search.do">도서검색</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/book/rent.do">대여</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/book/hope.do">희망 도서 승인</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/book/newApply.do">도서 구입 신청</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/book/discardApply.do">도서 폐기 신청</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        			
                        			
                        			<li>
                                    <a href="#"><i class="fa fa-gear fa-fw"></i>시설관리 <span class="fa arrow"></span></a>
                                    <ul class="nav nav-second-level">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/facility">시설</a>
                                        </li>
                                        <li>
                                        	<a href="${pageContext.request.contextPath}/facilityapproval">시설승인</a>
                                        </li>
                                         <li>
                                        	<a href="${pageContext.request.contextPath}/facilityinspection">시설검사</a>
                                        </li>
                                        
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li> 
                                
                        <li>
                            <a href="${pageContext.request.contextPath}/memberList.do"><i class="fa fa-sitemap fa-fw"></i>회원조회</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/mgmt/emplist.do"><i class="fa fa-users fa-fw"></i>직원보기</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/board/list.do"><i class="fa fa-edit fa-fw"></i> 사내게시판</a>
                        </li>
                       </c:otherwise>
                       </c:choose>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
        
<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
  
  
        
        
        
        