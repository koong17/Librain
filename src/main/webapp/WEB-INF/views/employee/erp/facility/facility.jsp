<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<%@include file="../../includes/header.jsp"%>
<body>


     
   <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
   <link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
 
   <link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.time-picker/v1.5.0/tui-time-picker.css" />
   <link rel="stylesheet" href="https://uicdn.toast.com/tui.pagination/latest/tui-pagination.css" />
   <link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.date-picker/v3.2.1/tui-date-picker.css" />
 
 
     <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
     <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
     <script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/v1.5.0/tui-code-snippet.js"></script>
     <script type="text/javascript" src="https://uicdn.toast.com/tui.time-picker/v1.5.0/tui-time-picker.js"></script>
     <script type="text/javascript" src="https://uicdn.toast.com/tui.date-picker/v3.2.1/tui-date-picker.js"></script>
     <script src="https://uicdn.toast.com/tui.pagination/latest/tui-pagination.js"></script>
   <script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>  
   
   <div class="wrapper">
        <div class="row">
            <div class="col-md-12">
                <h1 class="page-header">시설</h1>
            </div>
		</div>
   </div>
   
<br>
<style>
.btn.btn-primary{
    margin: 10px;
}
.gorup.btn{
    margin-left: 10px;
}

</style>
<div class="gorup btn">
    
    <span class="btn btn-primary" aria-hidden="true" onclick='gridaddgrid()'>시설물추가</span>
    <span class="btn btn-primary" aria-hidden="true" onclick='gridmodify()'>수정</span>
    <span class="btn btn-primary" aria-hidden="true" onclick='griddelete()'>삭제</span>
</div>
    <div id="grid"></div>
    
    <div id="addgrid">
        <span class="btn btn-primary" aria-hidden="true" onclick='grdi2checked()'>추가완료</span>
        <div id="grid2"></div>
    </div>
    
    
   
    <script>
    $(window).on('load',function () {
        $('#addgrid').hide()
      })
function gridmodify(){

grid.blur()

console.log(grid.getModifiedRows().updatedRows +"마지막전")

setTimeout(()=>{
var checkfilter=grid.getCheckedRows().filter((rows)=>{
            console.log(rows)
        return  rows.fac_status !='접수완료'   
    } )
    if(checkfilter.length==0){
        alert('수정할 항목이 없습니다.')
        return
    }
$.ajax({
	url:"http://10.10.10.178:8080/librain/facility/modifyData",
	data: JSON.stringify(grid.getModifiedRows().updatedRows),
	type:"PUT",
	contentType: 'application/json',
	success:function(date){
		alert("수정완료");
		grid.reloadData();
	}
})} 
		,100)

	
}
const dataSource = {
	  initialRequest: true,
	  api: {
	    readData: { url: 'http://10.10.10.178:8080/librain/facility/readData', method: 'GET' },
	    createData: { url: 'http://10.10.10.178:8080/librain/facility/createData', method: 'POST' },
	    updateData: { url: '/api/updateData', method: 'PUT' },
	    modifyData: { url: '/api/modifyData', method: 'PUT' },
	    deleteData: { url: '/api/deleteData', method: 'DELETE' }
	  }
	};

const grid = new tui.Grid({
el: document.getElementById('grid'),
data:dataSource,
scrollX: false,
scrollY: false,
minBodyHeight: 30,
rowHeaders: ['checkbox'],
editingEvent:"click",
pageOptions: {
    perPage:100
  },
columns: [
	{
		header: '일련번호',
		name: 'fac_serialnum',
		sortingType: 'desc',
        sortable: true,
        width:100,
        filter: {
            type: 'number',
            showApplyBtn: true,
            showClearBtn: true
          }
     
	},
	{
		header: '시설물이름',
		name: 'fac_name',
	      filter: {
	          type: 'text',
	          showApplyBtn: true,
	          showClearBtn: true
	        }
	},
	{
		header: '장소',
		name: 'fac_address',
		editor:{
			type:"text"
		},
	      filter: {
	          type: 'text',
	          showApplyBtn: true,
	          showClearBtn: true
	        },
		 onAfterChange: function(ev) {
	            grid.check(ev.rowKey);
	          }
	},
	{
		header: '시설물 상태',
		name: 'fac_status',
	      filter: {
	          type: 'text',
	          showApplyBtn: true,
	          showClearBtn: true
	        },
		editor:{
			type:"select",
			options:{
				listItems: [
			          { text: '고장', value: '고장' },
			          { text: '정상', value: '정상' },
			          { text: '수리신청', value: '수리신청' },
			          { text: '비가동', value: '비가동' },
                      { text: '접수완료', value: '접수완료' }
			        ]
			}
		},
		 onAfterChange: function(ev) {
	            grid.check(ev.rowKey);
	          }
	
	},
	{
		header: '카테고리',
		name: 'fac_category',
	      filter: {
	          type: 'text',
	          showApplyBtn: true,
	          showClearBtn: true
	        }
	}
],
 columnOptions: {
      resizable: true
    }
});






const dataSource2 = [];
const grid2 = new tui.Grid({
	el: document.getElementById('grid2'),
	data:dataSource2,
	scrollX: false,
	scrollY: false,
	minBodyHeight: 30,
	rowHeaders: ['checkbox'],
	editingEvent:"click",
	columns: [
	
		{
			header: '시설물이름',
			name: 'fac_name',
		 	editor:{
				type:'text'
			}, 
			validation:{
				required:true
			}
		},
		{
			header: '장소',
			name: 'fac_address',
			editor:{
				type:'text'
			},
			validation:{
				required:true
			}
			
		},
		{
			header: '시설물 상태',
			name: 'fac_status',
			validation:{
				required:true
			},
			
			editor:{
				type:"select",
				options:{
					listItems: [
				          { text: '고장', value: '고장' },
				          { text: '정상', value: '정상' },
				          { text: '비가동', value: '비가동' }
				        ]
				}
			},
			 onAfterChange: function(ev) {
		             console.log(ev.rowKey);
		            grid.check(ev.rowKey);
		          }
		
		},
		{
			header: '카테고리',
			name: 'fac_category',
			editor:{
				type:'text'
			},
			validation:{
				required:true
			}
		}
		
	],
	 columnOptions: {
	      resizable: true
	    }
});

grid.on('click',(ev)=>{
	console.log(grid.getModifiedRows())
	
})

grid2.on('click',(ev)=>{
	
	console.log(grid2.getModifiedRows())
	
})

function gridaddgrid(){
    $('#addgrid').show()
	console.log('dd')
		grid.blur()
	setTimeout(()=>console.log(grid.getCheckedRows()),100)
	
	console.log(grid.getCheckedRows())
	 grid2.appendRow({"fac_name":"","fac_address":"","fac_status":"","fac_category":""},{extendPrevRowSpan:true})
	/* dataSou	rce2.push({"fac_name":"","fac_address":"","fac_status":"","fac_category":""})
	grid2.resetData(dataSource2) */

}
function griddelete(){
	grid2.blur()
    
	setTimeout(()=>{
    if(grid.getCheckedRows().length ==0){
        alert('삭제할 데이터를 체크해주세요')
        return
    }
    console.log(grid.getCheckedRows().length)
	$.ajax({
		url:'http://10.10.10.178:8080/librain/facility/deleteData',
		data:JSON.stringify(grid.getCheckedRows()),
		contentType: 'application/json',
		type:"DELETE",
		success : function(data) {
	        alert("success!");
	    }
		})
    }
	,100);
	
	console.log(grid.getCheckedRows())
	grid.removeCheckedRows();
	

}


function grdi2checked(){//데이터 보내기용
	grid2.blur()
	setTimeout(()=>	
	$.ajax({
		url:'http://10.10.10.178:8080/librain/facility/createData',
		data:JSON.stringify(grid2.getModifiedRows().createdRows),
		contentType: 'application/json',
		type:"POST",
		success : function(data) {
	        alert("추가완료");
            $('#addgrid').hide()
            grid.reloadData()

	    }
		})
	
		,100)
	

	
}

 tui.Grid.applyTheme('clean',{})
</script>

    <%@include file="../../includes/footer.jsp"%>
</body>
</html>