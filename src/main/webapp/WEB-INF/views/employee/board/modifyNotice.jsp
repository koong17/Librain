<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<!-- 첨부파일 시작 -->
<div class='bigPictureWrapper'>
   <div class='bigPicture'>
   </div>
</div>

<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
      
      <div class="panel-heading">Files</div>
      <!-- panel-heading -->
      <div class="panel-body">
      <!-- 파일 재첨부  -->
      	<div class="form-group uploadDiv">
      		<input type="file" name="uploadFile" multiple="multiple">
      	</div>
   
         <div class='uploadResult'>
            <ul>
            
            </ul>
         </div>
      </div>
      <!-- end panel-body -->
      </div>
      <!-- end panel-body -->
      </div>
      <!-- end panel -->
</div> 
<!--  /.row -->

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify</h1>
	</div>
	<!--  /.col-lg-12 -->
</div>
<!--  /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">

			<div class="panel-heading">Board Modify Page</div>
			<!--  /.panel-heading -->
			<div class="panel-body">

				<form role="form" action="${pageContext.request.contextPath}/employee/board/modifyNotice" method="post">

					<!-- 페이지 관련 추가 -->
					<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
					<input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
					<!-- criteria type/keyword처리 -->						
					<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>
					<input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
					
					<div class="form-group">
						<label>Board_no</label> <input class="form-control" name="board_no"
							value='<c:out value="${board.board_no }"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label>Title</label> <input class="form-control" name="board_title"
							value='<c:out value="${board.board_title }"/>' required>
					</div>

					<div class="form-group">
						<label>Text area</label>
						<textarea class="form-control" rows="3" name='board_content' required><c:out
								value="${board.board_content }"/></textarea>
					</div>

					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="board_writer"
							value='<c:out value="${board.board_writer }"/>' readonly="readonly">
					</div>

					<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info">List</button>
				</form>
			</div>
			<!-- end panel body -->
		</div>
		<!-- end panel body -->
	</div>
	<!-- end panel-->
</div>
<!-- /.row -->



<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form");

		$('button').on("click", function(e) {
       	 var isvalidate = $("form[role='form']")[0].checkValidity();
    	 if (isvalidate) {
			e.preventDefault();

			var operation = $(this).data("oper");
			console.log(operation);

			if (operation === 'remove') {
				formObj.attr("action", "${pageContext.request.contextPath}/employee/board/removeNotice");
			} else if (operation === 'list') {
				formObj.attr("action", "${pageContext.request.contextPath}/employee/board/list").attr("method", "get");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				//검색조건
				var keywordTag = $("input[name='keyword']").clone();
				var typeTag = $("input[name='type']").clone();
				
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(keywordTag);
				formObj.append(typeTag);
			} else if (operation == 'modify') {
				
				console.log("submit clicked");
				
				var str = "";
				
				$(".uploadResult ul li").each(function(i, obj){
					var jobj = $(obj);
					
					console.dir(jobj);
					
					 str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
		             str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
		             str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
		             str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+ jobj.data("type")+"'>";
				});
				
				formObj.append(str).submit();
				
			}
			formObj.submit();
    	 }
		});
	});
</script>

<!-- 첨부파일 보여주기 -->
<script>
$(document).ready(function(){
   (function(){
      
      var board_no = '<c:out value="${board.board_no}"/>';
      $.getJSON("${pageContext.request.contextPath}/employee/board/getAttachList", {board_no: board_no}, function(arr){
         console.log(arr);
         var str = "";
         $(arr).each(function(i, attach){	//파일 불러오기, 수정/삭제 가능하게 만들기
            //image type
            if(attach.fileType){
               var fileCallPath = encodeURIComponent(attach.uploadPath+"/s_"+attach.uuid + "_" + attach.fileName);
               
               str += "<li data-path='"+attach.uploadPath+"' data-uuid='" + attach.uuid +"' data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"' ><div>";
               str += "<span> " + attach.fileName + "</span>";
               str += "<button type='button' data-file=\'"+fileCallPath+"\'data-type='image' ";
               str += "class='btn btn-warning btn-Circle'><i class='fa fa-times'></i></button><br>";
               str += "<img src='${pageContext.request.contextPath}/employee/board/display?fileName="+fileCallPath+"'>";
               str += "</div>";
               str += "</li>";
            } else {
               
               str += "<li data-path= '"+attach.uploadPath+"' data-uuid='" + attach.uuid+"' data-filename= '" +attach.fileName+ "' data-type='" +attach.fileType +"' ><div>";
               str += "<span> " + attach.fileName +"</span><br/>";
               str += "<button type='button' data-file=\'" + fileCallPath + "\'data-type='file'";
               str += " class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
               str += "<img src='../../resources/img/attach.png'></a>";
               str += "</div>";
               str += "</li>";
               
            }   // if-else end
            
         });   //(arr).each end
         
         $(".uploadResult ul").html(str);
      });   //end getjson
      
   })(); //end function
   
   $(".uploadResult").on("click", "button", function(e){// x 버튼 클릭시 삭제 이벤트
	   
	   console.log("delete file");
	   if(confirm("Remove this file? ")){
		   var targetLi = $(this).closest("li");
		   targetLi.remove();
	   }
   });	//uploadResult end
   
   //첨부파일 추가
   
   var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
   var maxSize = 5242880; //5MB

   function checkExtension(fileName, fileSize) {

      if (fileSize >= maxSize) {
         alert("파일 사이즈 초과");
         return false;
      }

      if (regex.test(fileName)) {
         alert("해당 종류의 파일은 업로드할 수 없습니다.");
         return false;
      }
      return true;
   }//파일 필터링(checkExtension end)
   
   $("input[type='file']").change(function (e){
      
      var formData = new FormData();

      var inputFile = $("input[name='uploadFile']");
      
      console.log("---------------------------------------")
      //console.log(inputFile[0].files[0]);
      
      
      var files = inputFile[0].files;
      
      for(var i = 0; i < files.length; i++){
   	  
   	  //console.log(files[i])
          if(!checkExtension(files[i].name, files[i].size)){
            return false;
         } 
         
         formData.append("uploadFile", files[i]);
         //console.log("appended.....................")
         
      }//for end
      
      $.ajax({
         url : '${pageContext.request.contextPath}/employee/board/uploadAjaxAction',
         processData: false,
         contentType: false,
         data: formData,
         type: 'POST',
         dataType: 'json',
            success: function(result){
               console.log(result);
               showUploadResult(result);	//업로드 결과 처리 함수
            }
      }); //$.ajax
      
   }); //파일 변화 감지(change)
   
   
   ///////////////////업로드 결과 처리
   function showUploadResult(uploadResultArr){
      if(!uploadResultArr || uploadResultArr.length ==0){return;}
      
      var uploadUL = $(".uploadResult ul");
      var str = "";
      
      $(uploadResultArr).each(function(i, obj){
           //image type
           if (obj.image){
              var fileCallPath = 
                 encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
              str += "<li data-path='"+obj.uploadPath+"'";
              str += " data-uuid='"+obj.uuid+"' data-filename='" + obj.fileName + "' data-type='"+obj.image+"'";
              str += "><div>";
              str += "<span>" + obj.fileName+"</span>";
              str += "<button type='button' data-file= \'"+ fileCallPath +"\'"
              str += "data-type='image' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
              str += "<img src = '${pageContext.request.contextPath}/employee/board/display?fileName="+fileCallPath+"'>";
              str += "</div>";
              str += "</li>";
              
           }else {
            	var fileCallPath = encodeURIComponent( obj.uploadPath+ "/" + obj.uuid + "_" + obj.fileName);
            	var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
            	
            	str += "<li ";
            	str += "data-path='"+obj.uploadPath+"'data-uuid='"+obj.uuid+"'data-filename='"+obj.fileName+"' data-type='"+obj.image+"'><div>";
            	str += "<span>" + obj.fileName+"</span>";
               str += "<button type='button' data-file= \'"+ fileCallPath +"\'data-type='file' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
               str += "<img src= '../../resources/img/attach.png'></a>";
               str += "</div>";
               str += "</li>";
           }
      });   //파일타입 분류
      uploadUL.append(str);
      
   }//showUploadResult end
   
});	//document end

</script>

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
<%@include file="../includes/footer.jsp"%>