<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>index q</title>
	
	
	<link href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" rel="stylesheet">
	<script src="/assets/js/jquery-1.8.3.min.js"></script>
	<script src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	
</head>
<body>
	
	<div>
								
		<table id="examplet" class="display" cellspacing="0" width="100%">
			<thead>
	            <tr>
	                <th>Name</th>
	                <th>Position</th>
	                <th>Office</th>
	                <th>Extn</th>
	                <th>Salary</th>
	            </tr>
	        </thead>
	        <tbody>
	        	
	        </tbody>
		</table>
		
	</div>
		https://blog.csdn.net/tomcat_2014/article/details/50177645					
	<script type="text/javascript">
		$(document).ready(function(){
			console.log('aaa');
			//webDataTable();
			var queryData = {'start':1,'length':10};
			serverDataTable(queryData);
		});
		
		function serverDataTable(queryData){
			table1= $('#examplet').DataTable({  
		          "paging": true,  
		          "lengthChange": true,  
		          "searching": true,  
		          "ordering": true,  
		          "aaSorting" : [[0, "asc"]], //默认的排序方式，第1列，升序排列  
		          "info": true,  
		          "autoWidth": false,  
		          "destroy":true,  
		          "processing":true,  
		          "scrollX": true,   //水平新增滚动轴  
//		          "serverSide":true,    //true代表后台处理分页，false代表前台处理分页  
		          "aLengthMenu":[10,15,20],  
		          "PaginationType" : "full_numbers", //详细分页组，可以支持直接跳转到某页  
		          //当处理大数据时，延迟渲染数据，有效提高Datatables处理能力  
		          "deferRender": true,  
		          "ajax":{  
		        	  url:'/admin/data_table',
					  dataSrc:'res_data' ,
		           	  type:"get",  
		              data:queryData  
		          },  
		          columns:[  
		        	  { "data": "name" },
			            { "data": "position" },
			            { "data": "office" },
			            { "data": "extn" },
			            { "data": "salary" }  
		          ],  
		  
		          /*是否开启主题*/  
		          "bJQueryUI": true,  
		          "oLanguage": {    // 语言设置  
		            "sLengthMenu": "每页显示 _MENU_ 条记录",  
		            "sZeroRecords": "抱歉， 没有找到",  
		            "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",  
		            "sInfoEmpty": "没有数据",  
		            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",  
		            "sZeroRecords": "没有检索到数据",  
		            "sSearch": "检索:",  
		            "oPaginate": {  
		              "sFirst": "首页",  
		              "sPrevious": "前一页",  
		              "sNext": "后一页",  
		              "sLast": "尾页"  
		            }  
		          },  
		        }); 
		}
		
		// 前端分页 查询所有的数据页面端分页
		function webDataTable(){
			$('#examplet').DataTable({
				"bPaginate": true,
				"bLengthChange": false,
				"bSort": true,
				"bInfo": true,
				"bAutoWidth": false,
				"bFilter": true,
				"ajax": {
					url:'/admin/data_table',
					dataSrc:'res_data'
				},
				"bAutoWidth": true, //自己主动宽度  ,
		        "columns": [
		            { "data": "name" },
		            { "data": "position" },
		            { "data": "office" },
		            { "data": "extn" },
		            { "data": "salary" }
		        ],
		        "oLanguage": {
                    "sLengthMenu": "每页显示 _MENU_ 条记录",
                    "sZeroRecords": "对不起，查询不到任何相关数据",
                    "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                    "sInfoEmtpy": "找不到相关数据",
                    "sInfoFiltered": "数据表中共为 _MAX_ 条记录)",
                    "sProcessing": "正在加载中...",
                    "sSearch": "搜索",
                    "sUrl": "", //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascrip{过滤}t/datatable/dtCH.txt
                    "oPaginate": {
                        "sFirst": "第一页",
                        "sPrevious": " 上一页 ",
                        "sNext": " 下一页 ",
                        "sLast": " 最后一页 "
                    }
                }
		    });
		}
	</script>
</body>
</html>