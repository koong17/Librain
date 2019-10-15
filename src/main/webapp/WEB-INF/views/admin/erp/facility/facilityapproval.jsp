<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
ddㅇㄴㅁㅇ
<br>
<input type="button" value="추가" onclick='gridaddgrid()'/>
<input type="button" value="삭제" onclick='griddelete()'/>
<input type="button" value="카테고리형식으로  몇개씩보기지원" onclick='aa()'/>
<input type="button" value="수정" onclick='gridmodify()'/>


ㅇㅇ
    <div id="grid"></div>
    
    <br>
    <br>
    <input type="button" value="그리드2체크확인" onclick='grdi2checked()'/>
    
    
<script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/latest/tui-code-snippet.js"></script>
<script src="https://uicdn.toast.com/tui.pagination/latest/tui-pagination.js"></script>
<script src="https://uicdn.toast.com/tui-grid/v4.5.2/tui-grid.js"></script>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
var a=10;
function gridmodify(row){
	/* a=3;
	grid.setPerPage(a); */
	grid.blur()
	setTimeout(()=>console.log(grid.getCheckedRows()),100)
	console.log(	grid.getRow(row))
	console.log(grid.getModifiedRows().updatedRows)
	$.ajax({
		url:"/mvc/facility/modifyDataRepair",
		data: JSON.stringify(grid.getRow(row)),
		type:"PUT",
		contentType: 'application/json',
		success:function(date){
			alert("수정완료");
			grid.reloadData()
		}
	})
}
const dataSource = {
		  initialRequest: true,
		  api: {
		    readData: { url: 'http://localhost:8080/mvc/facility/readDataRepair', method: 'GET' },
		    createData: { url: 'http://localhost:8080/mvc/facility/createData', method: 'POST' },
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
	    perPage: a
	  },
	columns: [
		{
			header: '시설물 상태',
			name: 'fac_status',
			 width:90
		
		},
		{
			header: '일련번호',
			name: 'fac_serialnum',
			sortingType: 'desc',
	        sortable: true,
	        width:90
	     
		},
		{
		    align: 'center',
			header: '시설물이름',
			name: 'fac_name'
		},
		{
		    align: 'center',
			header: '장소',
			name: 'fac_address'
		}
	],
	 columnOptions: {
	      resizable: true
	    }
});




grid.on('click',(ev)=>{
	console.log(grid.getModifiedRows())
	console.log(ev)
		console.log(grid.getValue(ev.rowKey,ev.columnName))
	
	if(ev.columnName=='fac_status'){

			if(grid.getValue(ev.rowKey,ev.columnName)=="접수완료") 	{var preconfirm=confirm("수리완료하시겠습니까?")}
			else{ var preconfirm=confirm("접수하시겠습니까?")} 
	if(preconfirm==true){
		gridmodify(ev.rowKey)
		preconfirm=false
		}
		
		}
	
	
})




	
	

 tui.Grid.applyTheme('clean',{})
</script>


<br><br><Br>

ㅁㄴㅇㅁㄴㅇ
</body>
</html>