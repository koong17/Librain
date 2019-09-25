<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp" %>
<style>
	.uploadResult{
		width:100%;
		background-color : gray;
		}
		
	.uploadResult ul{
		display:flex;
		flex-flow: row;
		justify-content: center;
		align-items: center;
	}
	
	.uploadResult ul li{
		list-style: none;
		padding : 10px;
		align-content: center;
		text-align : center;
	}
	
	.uploadResult ul li img{
		width: 100px;
	}
	
	.uploadResult ul li span {
		color: white;
	}
	
	.bigPictureWrapper {
		position: absolute;
		display: none;
		justify-content: center;
		align-items: center;
		top: 0%;
		width: 100%;
		height: 100%;
		background-color: gray;
		z-index: 100;
		background: rbga(255, 255, 255, 0.5);
	}
	
	.bigPicture{
		position: relative;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	.bicPicture img{
		width: 600px;
	}
	</style>
	
	
	
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!--  /.col-lg-12 -->
	</div>
	<!--  /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
			
				<div class="panel-heading">Board Read Page</div>
				<!--  /.panel-heading -->
				<div class="panel-body">
				
					<div class="form-group">
						<label>Bno</label>	<input class="form-control" name="bno" 
							value='<c:out value="${board.bno }"/>' readonly="readonly">
						</div>
				
				
						<div class="form-group">
						<label>Title</label>	<input class="form-control" name="title" 
							value='<c:out value="${board.title }"/>' readonly="readonly">
						</div>
						
							<div class="form-group">
								<label>Text area</label>
								<textarea class="form-control" rows="3" 
									name='content' readonly="readonly"><c:out value="${board.content }"/></textarea>
								</div>
								
						<div class="form-group">
						<label>Writer</label>	<input class="form-control" name="writer" 
							value='<c:out value="${board.writer }"/>' readonly="readonly">
						</div>
								<button data-oper='modify' class="btn btn-default">Modify</button>
								<button data-oper='list' class="btn btn-info">List</button>
								
								<form id='operForm' action="${pageContext.request.contextPath}/employee/board/modify" method="get">
									<input type='hidden' id='bno' name='bno' 
										value='<c:out value="${board.bno }"/>'>
									<input type='hidden' name='pageNum' 
										value='<c:out value="${cri.pageNum}"/>'>			
									<input type='hidden' name='amount' 
										value='<c:out value="${cri.amount}"/>'>		
									<!-- criteria type/keyword처리 -->						
									<input type='hidden' name='keyword'
										value='<c:out value="${cri.keyword }"/>'>
									<input type='hidden' name='type'
										value='<c:out value="${cri.type }"/>'>
								</form>
						
				</div>
				<!-- end panel body -->
			</div>
			<!-- end panel body -->
		</div>
		<!-- end panel-->
	</div>
	<!-- /.row -->
		<!-- 첨부파일 -->
	<div class='bigPictureWrapper'>
		<div class='bigPicture'>
		</div>
	</div>
	
	
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
			
			<div class="panel-heading">Files</div>
			<!--  /.panel-heading -->
			<div class="panel-body">
			
				<div class='uploadResult'>
					<ul>
					</ul>
				</div>
			</div>
			<!-- end panel body -->
			</div>
			<!-- end panel body -->
		</div>
			<!--  end panel -->
	</div>
	<!--  /.row -->
	
	

	
	<script type="text/javascript">
	$(document).ready(function() {
		var operForm = $("#operForm");
		$("button[data-oper='modify']").on("click", function(e){
			
			operForm.attr("action", "${pageContext.request.contextPath}/employee/board/modify").submit();
		});
		
		$("button[data-oper='list']").on("click", function(e){
			
			operForm.find("#bno").remove();
			operForm.attr("action", "${pageContext.request.contextPath}/employee/board/list")
			operForm.submit();
		});
	});
	</script>
	
	<!-- 파일첨부관련 -->
	<script>
	$(document).ready(function(){
		(function(){
			var bno = '<c:out value="${board.bno}"/>';
			//화면에 보여주기
			$.getJSON("${pageContext.request.contextPath}/employee/board/getAttachList", {bno:bno}, function(arr){
				console.log(arr);
				
				var str = "";
				$(arr).each(function(i, attach){
					
					//image type
					if(attach.fileType) {
						
						var fileCallPath = encodeURIComponent( attach.uploadPath + "/s_" + attach.uuid + "_" + attach.fileName);
						
						str += "<li data-path='"+attach.uploadPath + "' data-uuid = '" + attach.uuid + "' data-filename= '" + attach.fileName + 
							  "' data-type='"+attach.fileType + "'><div>";
						str += "<img src = '${pageContext.request.contextPath}/employee/board/display?fileName="+fileCallPath+"'>";
						str += "</div>";
						str += "</li>";
					} else {
						str += "<li data-path='" + attach.uploadPath + "' data-uuid = '"+attach.uuid + "' data-filename = '"+attach.fileName +"' data-type='"+attach.fileType +"'><div>";
						str += "<span> " + attach.fileName + "</span><br/>";
						str += "<img src = '../../resources/img/attach.png' width=30px>";
						str += "</div>";
						str += "</li>";
					}
					
				});	//attach end
				
				$(".uploadResult ul").html(str);
				
			}); //end getjson
		})(); //end function
		
////////파일다운로드
		  $(".uploadResult").on("click","li", function(e){
		      
			    console.log("view image");
			    
			    var liObj = $(this);
			    
			    var path = encodeURIComponent(liObj.data("path")+"/" + liObj.data("uuid")+"_" + liObj.data("filename"));
			    
			    if(liObj.data("type")){
			      showImage(path.replace(new RegExp(/\\/g),"/"));
			    }else {
			      //download 
			      self.location ="${pageContext.request.contextPath}/employee/board/download?fileName="+path
			    }
			    
			  });
			  
			  function showImage(fileCallPath){
				    
			    //alert(fileCallPath);
			    
			    $(".bigPictureWrapper").css("display","flex").show();
			    
			    $(".bigPicture")
			    .html("<img src='${pageContext.request.contextPath}/employee/board/display?fileName="+fileCallPath+"' >")
			    .animate({width:'100%', height: '100%'}, 1000);
			    
			  }
			  
			  //숨기기
			  $(".bigPictureWrapper").on("click", function(e){
				    $(".bigPicture").animate({width:'0%', height: '0%'}, 1000);
				    setTimeout(function(){
				      $('.bigPictureWrapper').hide();
				    }, 1000);
				  });
		
		
		
		
	});	//end document
	</script>
	
	<%@include file="../includes/footer.jsp"%>