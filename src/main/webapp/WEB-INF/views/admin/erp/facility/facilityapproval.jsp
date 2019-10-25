<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="UTF-8">
            <title>Document</title>
        </head>
        <%@include file="../../../employee/includes/header.jsp"%>
        
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
        <script type="text/javascript" src="https://uicdn.toast.com/tui.code-snippet/latest/tui-code-snippet.js"></script>
        <script src="https://uicdn.toast.com/tui.pagination/latest/tui-pagination.js"></script>
        <link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css" />
        <script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
        <link rel="stylesheet" type="text/css" href="https://uicdn.toast.com/tui.pagination/v3.3.0/tui-pagination.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <body>
        

	<div class="wrapper">
        <div class="row">
            <div class="col-md-12">
                <h1 class="page-header">시설승인</h1>
            </div>
		</div>
   </div>        
        
<style>
.glyphicon.glyphicon-plus.btn.btn-primary{
    width:5%;
    margin: 20px;
}

</style>

    <div id="grid"></div>
   

 <script>
$(window).on('load', function () {
    console.log(1)
        grid.findRows((row) => {
    return (row.fac_status == '접수완료')
      }  ).forEach((row2)=>{
          console.log(row2.rowKey)
          grid.addCellClassName(row2.rowKey, 'fac_status', 'glyphicon glyphicon-exclamation-sign')

      })
    
      grid.reloadData()


  })
function gridmodify(row){
	grid.blur()
	setTimeout(()=>{

	$.ajax({
		url:"httP://10.10.10.178:8080/librain/facility/modifyDataRepair",
		data: JSON.stringify(grid.getRow(row)),
		type:"PUT",
		contentType: 'application/json',
		success:function(date){
			alert("수정완료");
			grid.reloadData()
		}
	})},100)
}
const dataSource = {
		  initialRequest: true,
		  api: {
		    readData: { url: 'http://10.10.10.178:8080/librain/facility/readDataRepair', method: 'get' },
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
	    perPage: 100
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
		gridmodify(ev)
		preconfirm=false
		}
		
		}
	
	
})



	grid.on('response',()=>{
        grid.findRows((row) => {
    return (row.fac_status == '접수완료')
      }  ).forEach((row2)=>{
          console.log(row2.rowKey)
          grid.addCellClassName(row2.rowKey, 'fac_status', 'glyphicon glyphicon-exclamation-sign')

      })
    })
	

 tui.Grid.applyTheme('clean',{})
</script>

    <%@include file="../../../employee/includes/footer.jsp"%>


</body>
</html>