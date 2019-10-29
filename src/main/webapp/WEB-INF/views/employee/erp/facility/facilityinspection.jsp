<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
  
  <%@include file="../../includes/header.jsp"%>
  
  <link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />

  <link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.time-picker/v1.5.0/tui-time-picker.css" />
  <link rel="stylesheet" href="https://uicdn.toast.com/tui.pagination/latest/tui-pagination.css" />
  <link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.date-picker/v3.2.1/tui-date-picker.css" />


    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    

    <script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
    <script type="text/javascript" src="https://uicdn.toast.com/tui.time-picker/v1.5.0/tui-time-picker.js"></script>
    <script type="text/javascript" src="https://uicdn.toast.com/tui.date-picker/v3.2.1/tui-date-picker.js"></script>
    <script src="https://uicdn.toast.com/tui.pagination/latest/tui-pagination.js"></script>
 
    <script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
        <style>
          #form-wrapper{
            display: flex;
            margin-left:9px ;
          }
          .tui-grid-cell-has-input.glyphicon{
            display: flex;

          }
          .btn.btn-info{
              margin-left: 10px;
              display: inline;
          }
        </style>
      	<div class="wrapper">
        <div class="row">
            <div class="col-md-12">
                <h1 class="page-header">시설검사</h1>
            </div>
		</div>
   </div>
      
      
      
            <div id="grid"></div>
          <br>
          <button type="button" class="btn btn-info" onclick="addfacin()">추가하기</button>
            <button type="button" class="btn btn-info " onclick="BATCH_ENTRY()">일괄입력</button>
            
          <div id="grid2"></div>
<script type="text/javascript">


    $(window).on('load', function () {
      $('#grid2').hide()

      $.ajax({
		url:"http://10.10.10.178:8080/librain/facilityinspection/readData",
		type:"get",
		contentType: 'application/json',
		success:function(date){
   

const grid = new tui.Grid({
	el: document.getElementById('grid'),
	data:date.data.contents,
	scrollX: false,
	scrollY: false,
	minBodyHeight: 30,
	rowHeaders: ['checkbox'],
	editingEvent:"click",
	pageOptions: {
    useClient: true,
  perPage: 30
	  },
	columns: [
		{
			header: '일련번호',
			name: 'FacIn_serialnum',
			sortingType: 'desc',
	        sortable: true,
	        width:100,
      filter: {
        type: 'select',
        showApplyBtn: true,
        showClearBtn: true
      }
	     
		},
		{
			header: '시설물이름',
			name: 'FacIn_name',
      width:100,
      filter: {
        type: 'select',
        showApplyBtn: true,
        showClearBtn: true
      }
		},
		{
			header: '장소',
			name: 'facin_address',
			editor:{
				type:"text"
			} ,
      validation: {
        dataType: 'string'},
      filter: {
        type: 'text',
        showApplyBtn: true,
        showClearBtn: true
      }
		},
    {
			header: '이전검사날',
				name: 'FacIn_Inspection_Date',
      filter: {
        type: 'date',
        showApplyBtn: true,
        showClearBtn: true,
        operator: 'OR'
      }
			},
		{
			header: '검사예정일',
				name: 'FacIn_Inspection_Due_Date',
      filter: {
        type: 'date',
        showApplyBtn: true,
        showClearBtn: true,
        operator: 'OR'
      }
			}
			
		
		,
		{
			header: '점검까지남은날',
			name: 'RemainingTime',
      width:20,
      filter: {
        type: 'text',
        showApplyBtn: true,
        showClearBtn: true
      }
		},
      {
          header: '입력',
          name: 'checkbutton',
          defaultValue:'<i class="btn btn-primary" style="display:inline;">점검완료 <i>',
          width:110  ,
          heigt:50
        }
	],
	 columnOptions: {
	      resizable: true
	    }
});
var alerttextvalues='점검예정일까지 7일미만의 일련번호\n';

grid.findRows((row) => {
    return (row.RemainingTime < 7)
      }  ).forEach((row2)=>{
          console.log(row2.rowKey)
          grid.addCellClassName(row2.rowKey, 'RemainingTime', 'glyphicon glyphicon-exclamation-sign bg-danger')

          alerttextvalues+=row2.FacIn_serialnum +'번\n'
      })
      alerttextvalues+='' 
      if(alerttextvalues.length>18) alert(alerttextvalues)
      alerttextvalues="";

     
      grid.on('click',(ev)=>{
	console.log(grid.getModifiedRows())
  if(ev.columnName=="checkbutton"){
      var checktrueorfalse=confirm("점검을 완료하시겠습니까?");
        if(checktrueorfalse==true){
          console.log(grid.getRow(ev.rowKey))
          var object=new Object()
          object=[
          {
          FacIn_serialnum:grid.getRow(ev.rowKey).FacIn_serialnum
          ,FacIn_name:grid.getRow(ev.rowKey).FacIn_name,
          facin_address:grid.getRow(ev.rowKey).facin_address
          }
          ]

          $.ajax({
         type: "PUT",
         url: "http://10.10.10.178:8080/librain/facilityinspection/modifyData",
         data: JSON.stringify(object),
       	contentType: 'application/json',
		success:function(date){
          console.log(date.data.contents)
          grid.resetData(date.data.contents)


          grid.findRows((row) => {
    return (row.RemainingTime < 7)
      }  ).forEach((row2)=>{
          console.log(row2.rowKey)
          grid.addCellClassName(row2.rowKey, 'RemainingTime', 'bg-danger glyphicon glyphicon-exclamation-sign')

          alerttextvalues+=row2.FacIn_serialnum +'번\n'
      })
      alerttextvalues+='점검예정일까지 7일미만의 일련번호' 
      if(alerttextvalues.length>18) alert(alerttextvalues)
      alerttextvalues="";

         }
       });


        }
  

  }
	
})

}})//ajax end
    
    

    }
    )

   












const grid2 = new tui.Grid({
	el: document.getElementById('grid2'),
	data:[],
	scrollX: false,
	scrollY: false,
	minBodyHeight: 30,
	rowHeaders: ['checkbox'],
	editingEvent:"click"
  ,
	columns: [
	
		{
			header: '시설물이름',
			name: 'facfacin_name'
      , editor:{
				type:"text"
			},
			validation:{
				required:true,
        dataType: 'string'
			}
		},
		{
			header: '장소',
			name: 'facin_address',
			editor:{
				type:"text"
			} ,
			validation:{
				required:true,
        dataType: 'string'
			}
		},
    {
			header: '안전점검주기',
				name: 'f_cycle'
        , editor:{
				type:"text"
			},
			validation:{
				required:true,
        dataType: 'number'
			},
			 onAfterChange: function(ev) {
		             console.log(ev.rowKey);
		            grid2.check(ev.rowKey);
		          }
			},
      {
          header: '입력',
          name: 'checkbutton',
          defaultValue:'<i class="btn btn-primary " >점검완료 <i>',
          width:90  ,
          heigt:20
        }
	],
  
	 columnOptions: {
	      resizable: true
	    }
});
 function addfacin() {

   $('#grid2').show()
grid2.appendRow({"facfacin_name":"","facin_address":"","f_cycle":"", "checkbutton":'<i class="btn btn-primary ">입력 <i>'  })

   }
   grid2.on('click',function (ev) {
      console.log(ev)
      if(ev.columnName=="checkbutton"){

     var trueorfalsevailidate=   grid2.validate().some((check)=>{
          return check.rowKey==ev.rowKey
        })
        console.log(trueorfalsevailidate)
        if(!trueorfalsevailidate) {
	console.log(grid2.getRow(ev.rowKey).facfacin_name)
          var object=new Object()
          object=[
          {
          FacIn_serialnum:grid2.getRow(ev.rowKey).FacIn_serialnum
          ,facfacin_name:grid2.getRow(ev.rowKey).facfacin_name,
          facin_address:grid2.getRow(ev.rowKey).facin_address
          ,f_cycle:grid2.getRow(ev.rowKey).f_cycle
          }
          ]
          console.log(object)

          $.ajax({
         type: "post",
         url: "http://10.10.10.178:8080/librain/facilityinspection/createData",
         data: JSON.stringify(object),
       	contentType: 'application/json',
		success:function(date){
          grid2.clear()


         }
       });


        }
        
        // confirm('입력하시겠습니까?');
      }
     })


     function BATCH_ENTRY() {
      grid2.blur()
      setTimeout(() => {
        

        if(grid2.validate().length){
          alert('빈칸없이 모두 입력해주세요')
          return
        }
        console.log(JSON.stringify(grid2.getCheckedRows()))

          $.ajax({
         type: "POST",
         url: "http://10.10.10.178:8080/librain/facilityinspection/createData",
         data: JSON.stringify(grid2.getCheckedRows()),
       	contentType: 'application/json',
		success:function(date){
            grid2.removeCheckedRows()
            $('#grid2').hide()
         }
       });
        
      }, 0);


       

      
     

       
     }
            </script>
            </body>
           
</html>