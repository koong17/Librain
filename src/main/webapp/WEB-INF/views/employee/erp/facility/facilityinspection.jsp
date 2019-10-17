<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>

<br>
<input type="button" value="추가" onclick='gridaddgrid()'/>
<input type="button" value="삭제" onclick='griddelete()'/>
<input type="button" value="카테고리형식으로  몇개씩보기지원" onclick='aa()'/>
<input type="button" value="수정" onclick='gridmodify()'/>

    <div id="grid"></div>
    
    <br>
    <br>
    입력폼 모달로 만들지 생각해볼것sss
    <div id="grid2"></div>
    <input type="button" value="그리드2체크확인" onclick='grdi2checked()'/>
    
    
<script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/latest/tui-code-snippet.js"></script>
<script src="https://uicdn.toast.com/tui.pagination/latest/tui-pagination.js"></script>
<script src="https://uicdn.toast.com/tui-grid/v4.5.2/tui-grid.js"></script>
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
<link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
var a=10;
function gridmodify(){

	grid.blur()
	console.log(grid.getModifiedRows().updatedRows +"마지막전")
	
	setTimeout(()=>

	$.ajax({
		url:"/mvc/facility/modifyData",
		data: JSON.stringify(grid.getModifiedRows().updatedRows),
		type:"PUT",
		contentType: 'application/json',
		success:function(date){
			alert("수정완료");
			grid.reloadData();
		}
	}) 
			,100)
	
 	
}
const dataSource = {
		  initialRequest: true,
		  api: {
		    readData: { url: 'http://localhost:8080/mvc/facility/readData', method: 'GET' },
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
			header: '일련번호',
			name: 'fac_serialnum',
			sortingType: 'desc',
	        sortable: true,
	        width:90
	     
		},
		{
			header: '시설물이름',
			name: 'fac_name'
		},
		{
			header: '장소',
			name: 'fac_address',
			editor:{
				type:"text"
			}
		},
		{
			header: '시설물 상태',
			name: 'fac_status',
			editor:{
				type:"select",
				options:{
					listItems: [
				          { text: '고장', value: '고장' },
				          { text: '정상', value: '정상' },
				          { text: '수리신청', value: '수리신청' },
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
	pageOptions: {
	    perPage: 7
	  },
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
				          { text: '수리신청', value: '수리신청' },
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
	setTimeout(()=>
	$.ajax({
		url:'http://localhost:8080/mvc/facility/deleteData',
		data:JSON.stringify(grid.getCheckedRows()),
		contentType: 'application/json',
		type:"DELETE",
		success : function(data) {
	        alert("success!");
	    }
		});

	,100)
	
	console.log(grid.getCheckedRows())
	grid.removeCheckedRows();
	

}


function grdi2checked(){//데이터 보내기용
	grid2.blur()
	console.log(grid2.getCheckedRowKeys().length)
	console.log(grid2.getModifiedRows().createdRows)
	console.log(JSON.stringify(grid2.getModifiedRows().createdRows))
	console.log(grid2.validate().length);
	confirm()
	setTimeout(()=>	
	$.ajax({
		url:'http://localhost:8080/mvc/facility/createData',
		data:JSON.stringify(grid2.getModifiedRows().createdRows),
		contentType: 'application/json',
		type:"POST",
		success : function(data) {
	        alert("success!");
	    }
		});
	
		,100)
	

	
}

 tui.Grid.applyTheme('clean',{})
</script>


<br><br><Br>



</body>
</html>