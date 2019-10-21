<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp" %>
<c:choose>
	<c:when test="${empty sessionScope.emp_no }">
	<script>window.location.href='${pageContext.request.contextPath}/login.do'</script>
	</c:when>
</c:choose>
<div class="row">
   <div class="col-lg-12">
      <h1 class="page-header">일반글 등록</h1>
   </div>
   <!--  /.col-lg-12 -->
   </div>
   <!--  /.row -->
   
    <!-- 첨부파일 관련 코드 -->
   <div class="row">
      <div class="col-lg-12">
         <div class="panel panel-default">

            <div class="panel-heading">File Attach</div>
            <!-- /.panel-heading -->
            <div class="panel-body">
               <div class="form-group uploadDiv">
                  <input type="file" name='uploadFile' multiple>
               </div>
               
               <div class='uploadResult'>
                  <ul>
                  
                  </ul>
               </div>
               
               </div>
               <!-- end panel body -->

            </div>
            <!-- end panel body -->
         </div>
         <!-- end panel -->
      </div>
      <!-- /.row -->
      
   
   <div class="row">
      <div class="col-lg-12">
         <div class="panel panel-default">
            <div class="panel-heading">게시글</div>
            <!--  /.panel-heading -->
            
            <div class="panel-body">
               <form role="form" action="${pageContext.request.contextPath}/board/register.do" method="post">
                  <div class="form-group">
                  <label>Title</label>   <input id="board_title" class="form-control" name="board_title" required>
                  </div>
                     <div class="form-group">
                        <label>Text area</label>
                        <textarea class="form-control" id="board_content" rows="3" name='board_content' required></textarea>
                        </div>
                        
                        <div class="form-group">
                           <label>Writer</label><input class="form-control" id = "board_writer" name="board_writer" value="${sessionScope.emp_name}" readonly="readonly">
                        <br>
                        <button type="submit" class="btn btn-info">등록</button>
                        <button type="reset" class="btn btn-danger">취소</button>
               </form>
            </div>
            <!-- end panel body -->
         </div>
         <!-- end panel body -->
      </div>
      <!-- end panel-->
   </div>
   <!-- /.row -->
   
  
      <!-- 첨부파일 처리 -->
      <script>
      $(document).ready(function (e){
         var formObj = $("form[role='form']");
         
         $("button[type='submit']").on("click", function(e){
        	 
        	//유효성검사
        	 var isvalidate = $("form[role='form']")[0].checkValidity();
        	 if (isvalidate) {
            e.preventDefault();	//버튼 기본 기능 막기
            console.log("submit clicked");

            var str = "";
            
            $(".uploadResult ul li").each(function(i, obj){
              
              var jobj = $(obj);
              
              console.dir(jobj);
              console.log("-------------------------");
              console.log(jobj.data("filename"));
              
              str += "<input type='hidden' name='attachList["+i+"].fileName' value='"+jobj.data("filename")+"'>";
              str += "<input type='hidden' name='attachList["+i+"].uuid' value='"+jobj.data("uuid")+"'>";
              str += "<input type='hidden' name='attachList["+i+"].uploadPath' value='"+jobj.data("path")+"'>";
              str += "<input type='hidden' name='attachList["+i+"].fileType' value='"+ jobj.data("type")+"'>";
              
            });
            console.log(str);
            formObj.append(str).submit();
        	 }
         });	//button submit end
         
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
                  url : '${pageContext.request.contextPath}/board/uploadAjaxAction.do',
                  processData: false,
                  contentType: false,
                  data: formData,
                  type: 'POST',
                  dataType: 'json',
                     success: function(result){
                        console.log(result);
                        showUploadResult(result);	//업로드 결과 처리 함수
                     }
               })
               
            }); //파일 변화 감지(change)
            
            
          //업로드 결과 처리
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
                       str += "<img src = '${pageContext.request.contextPath}/board/display?fileName="+fileCallPath+"'>";
                       str += "</div>";
                       str += "</li>";
                       
                    }else {
                     	var fileCallPath = encodeURIComponent( obj.uploadPath+ "/" + obj.uuid + "_" + obj.fileName);
                     	var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
                     	
                     	str += "<li ";
                     	str += "data-path='"+obj.uploadPath+"'data-uuid='"+obj.uuid+"'data-filename='"+obj.fileName+"' data-type='"+obj.image+"'><div>";
                     	str += "<span>" + obj.fileName+"</span>";
                        str += "<button type='button' data-file= \'"+ fileCallPath +"\'data-type='file' class='btn btn-warning btn-circle'><i class='fa fa-times'></i></button><br>";
                        str += "<img src= '../resources/img/attach.png'></a>";
                        str += "</div>";
                        str += "</li>";
                    }
               });   //파일타입 분류
               uploadUL.append(str);
               
            }//showUploadResult end
            
            //x버튼 누르면 서버에서 삭제
            $(".uploadResult").on("click", "button", function(e){
               console.log("delete file");
               
               var targetFile = $(this).data("file");
               var type=$(this).data("type");
               
               var targetLi = $(this).closest("li");
               
               $.ajax({
                  url : '${pageContext.request.contextPath}/board/deleteFile.do',
                  data : {fileName: targetFile, type:type},
                  dataType : 'text',
                  type : 'POST',
                     success: function(result){
                        alert(result);
                        targetLi.remove();
                     }
               }); //$.ajax
            });//x버튼 end
            
      });//document.ready 끝
      </script>
      
      <style>
   .uploadResult {
      width:100%;
      background-color : gray;
   }
   
   .uploadResult ul{
      display : flex;
      flex-flow : row;
      justify-content : center;
      align-items: center;
   }
   
   .uploadResult ul li {
      list-style: none;
      padding: 10px;
      align-content: center;
      text-align: center;
   }
   
   .uploadResult ul li img{
      width: 30px;
   }
   
   .uploadResult ul li span {
      color.white;
   }
   
   .bigPictureWrapper {
      position: absolute;
      display: none;
      justify-content: center;
      align-items: center;
      top:0%;
      width:100%;
      height:100%;
      background-color: gray;
      z-index: 100;
      background:rbga(255, 255, 255, 0.5);
   }
   
   .bigPicture{
      position: relative;
      display : flex;
      justify-content: center;
      align-items: center;
   }
   
   .bigPicture img{
      width:600px
   }
</style>
   <%@include file="../includes/footer.jsp"%>