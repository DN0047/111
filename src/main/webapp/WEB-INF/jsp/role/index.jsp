<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<style>
.tree li {
	list-style-type: none;
	cursor: pointer;
}

table tbody tr:nth-child(odd) {
	background: #F4F4F4;
}

table tbody td:nth-child(even) {
	color: #C00;
}
</style>
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" style="font-size: 32px;" href="#">众筹平台
						- 角色维护</a>
				</div>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li style="padding-top: 8px;">
						<%@include file="/WEB-INF/jsp/common/userinfo.jsp"%>
					</li>
					<li style="margin-left: 10px; padding-top: 8px;">
						<button type="button" class="btn btn-default btn-danger">
							<span class="glyphicon glyphicon-question-sign"></span> 帮助
						</button>
					</li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<div class="tree">
					<%@include file="/WEB-INF/jsp/common/menu.jsp" %>
				</div>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="glyphicon glyphicon-th"></i> 数据列表
						</h3>
					</div>
					<div class="panel-body">
						<form class="form-inline" name="form" style="float: left;">
							<div class="form-group has-feedback">
								<div class="input-group">
									<div class="input-group-addon">查询条件</div>
									<input id="queryText" class="form-control has-success" type="text"
										placeholder="请输入查询条件">
								</div>
							</div>
							<button type="button" class="btn btn-warning" onclick="queryRole()">
								<i class="glyphicon glyphicon-search"></i> 查询
							</button>
						</form>
						<button id="deleteBatchBtn" type="button" class="btn btn-danger"
							style="float: right; margin-left: 10px;">
							<i class="glyphicon glyphicon-remove" ></i> 删除
						</button>
						<button type="button" class="btn btn-primary"
							style="float: right;" onclick="window.location.href='${pageContext.request.contextPath}/role/add.do'">
							<i class="glyphicon glyphicon-plus"></i> 新增
						</button>
						<br>
						<hr style="clear: both;">
						<div class="table-responsive">
							<table class="table  table-bordered">
								<thead>
									<tr>
										<th width="30">#</th>
										<th width="30"><input type="checkbox"></th>
										<th>name</th>
										<th width="100">操作</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="6" align="center">
											<ul class="pagination">
												

											</ul>
										</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/jquery/jquery-2.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/script/docs.min.js"></script>
	<script src="${pageContext.request.contextPath}/jquery/layer/layer.js"></script>
	<script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
			    
			    <c:if test="${empty param.pageno}">
			    queryPage(1);
			    </c:if>
			    <c:if test="${not empty param.pageno}">
			    queryPage(${param.pageno});
			    </c:if>
			    
			    showMenu();
            });

            function changePageno( pageno ) {
            	//window.location.href = "<%=request.getContextPath() %>/role/index.htm?pageno="+pageno;
            	queryPage(pageno);
            }
            
            //使用Ajax异步查询数据
            function queryPage( pageno ){
            	var dataObj = {
        			"pageno" : pageno ,   //pageno 是属性名称,是否增加双引号无所谓
        			"pagesize" : 3
        		};
            	if(condition){
            		dataObj.queryText = $("#queryText").val(); //增加模糊查询条件
            	}
            	
            	var loadingIndex = -1 ;
            	$.ajax({
            		
            		url : "${pageContext.request.contextPath}/role/pageQuery.do",
            		type : "post",
            		data : dataObj,
            		beforeSend : function(){
            			loadingIndex = layer.msg('数据查询中', {icon: 6});
            			return true ;
            		},
            		success : function(userUntil){
            			//显示结果
            			layer.close(loadingIndex);
            			if(userUntil.sunccess){
            				//循环遍历,显示数据
            				var pageObj = userUntil.page;
            				var roleList = pageObj.list ;
            				var content = "";
            				
            				$.each(roleList,function(i,n){
            					
            					content+="<tr>";
								content+="	<td>"+(i+1)+"</td>";
								content+='  <td><input type="checkbox" id="'+n.id+'"></td>';
								content+="	<td>"+n.name+"</td>";
								content+="	<td>";
								content+="		<button type='button' onclick='window.location.href=\"${pageContext.request.contextPath}/role/assignPermission.htm?roleid="+n.id+"\"' class='btn btn-success btn-xs'>";
								content+="			<i class=' glyphicon glyphicon-check'></i>";
								content+="		</button>";
								content+="		<button type='button' onclick='window.location.href=\"${pageContext.request.contextPath}/role/edit.htm?pageno="+pageObj.pageno+"&id="+n.id+"\"' class='btn btn-primary btn-xs'>";
								content+="			<i class=' glyphicon glyphicon-pencil'></i>";
								content+="		</button>";
								content+="		<button type='button' class='btn btn-danger btn-xs' onclick='deleteRole("+n.id+",\""+n.name+"\")'>";
								content+="			<i class=' glyphicon glyphicon-remove'></i>";
								content+="		</button>";
								content+="	</td>";
								content+="</tr>";
            					//$("tbody").append(content);
            					$("tbody").html(content);
            				});
            				
            				//拼接导航条
            				var pageContent = "";
            				
            				if(pageObj.pageno!=1){
            					pageContent += '<li><a href="#" onclick="changePageno('+(pageObj.pageno-1)+')">上一页</a></li>';
            				}
            				
            				for(var i=1 ; i<=pageObj.totalsize ; i++){
            					if(i==pageObj.pageno){
	            					pageContent += '<li class="active"><a href="#" onclick="changePageno('+i+')">'+i+'</a></li>';
            						
            					}else{
	            					pageContent += '<li><a href="#" onclick="changePageno('+i+')">'+i+'</a></li>';
            						
            					}
            				}
            				
            				if(pageObj.pageno!=pageObj.totalno){
            					pageContent += '<li><a href="#" onclick="changePageno('+(pageObj.pageno+1)+')">下一页</a></li>';
            				}
            				
            				$(".pagination").html(pageContent);
            				
            			}else{
            				
            				layer.msg("角色分页查询数据失败", {time:1000, icon:5, shift:6});
            				
            			}
            		},
            		error : function(){
            			layer.msg("角色分页查询数据错误", {time:1000, icon:5, shift:6});
            		}
            		
            	});
            }
            
            var condition = false ;
            //条件查询
            function queryRole(){
            	var queryText = $("#queryText");
            	
            	if(queryText.val()==""){
            		layer.msg("查询条件不能为空", {time:1000, icon:5, shift:6}, function(){
            			queryText.focus();
            		});
            		return ;
            	}
            	condition = true ;
            	queryPage(1);
            }
            
            function deleteRole(uid,name){
            	
    			layer.confirm("是否要删除角色?",  {icon: 3, title:'提示'}, function(cindex){
    				
    				$.ajax({
    					url : "${pageContext.request.contextPath}/role/delete.do",
    					type : "POST",
    					data : {uid:uid},
    					success : function(userUntil){
    						if(userUntil.sunccess){
    							layer.msg("删除"+name+"角色成功!", {time:1000, icon:6}, function(){
    								queryPage(1);
    							});
    						}else{
    							layer.msg("删除"+name+"角色失败!", {time:1000, icon:5, shift:6});
    						}
    					}
    				});

    			    layer.close(cindex);
    			}, function(cindex){
    			    layer.close(cindex);
    			});
            	
            }
            
            
            $("#allCheckbox").click(function(){
				var checkedStatus = this.checked ;
				//alert(checkedStatus);
				//$("tbody tr td input[type='checkbox']").attr("checked",checkedStatus);
				//$("tbody tr td input[type='checkbox']").prop("checked",checkedStatus);
				var tbodyCheckbox = $("tbody tr td input[type='checkbox']");
				$.each(tbodyCheckbox,function(i,n){
					n.checked = checkedStatus;
				});
            });
			//传递多个对象的方式
			//给后来元素增加事件.
			$("tbody").delegate(":checkbox","click",function(){
				if($("tbody tr td input:checked").length==0){
					$("#allCheckbox").attr("checked",false);
				}else{
					$("#allCheckbox").attr("checked",true);
				}
			});



			$("#deleteBatchBtn").click(function(){
				if(window.confirm("确定要删除嘛")){
					alert("正在删除")
				}


				var selectCheckbox = $("tbody tr td input:checked");

				if(selectCheckbox.length==0){

					return false ;
				}

				/* var idStr = "";

                $.each(selectCheckbox,function(i,n){
                    //  url?id=5&id=6&id=7
                    if(i!=0){
                        idStr += "&";
                    }
                    idStr += "id="+n.id;
                });  */


				var datas = new Array();

				$.each(selectCheckbox,function(i,n){
					datas[i] = n.id;

				});



				$.ajax({
					type : "POST",
					//data : idStr,

					traditional:true,
					data : {
						"datas" :datas,
					},
					url : "${pageContext.request.contextPath}/role/batchDelete.do",
					beforeSend : function() {
						return true ;
					},
					success : function(userUntil){
						if(userUntil.sunccess){
							window.location.href="${pageContext.request.contextPath}/role.htm";
						}else{
                            alert("删除失败")
						}
					},
					error : function(){

					}
				});

			});
			

</script>
<script type="text/javascript" src="${pageContext.request.contextPath }/script/menu.js"></script>
        
</body>

</html>