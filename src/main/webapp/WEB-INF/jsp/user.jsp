<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor:pointer;
        }
        table tbody tr:nth-child(odd){background:#F4F4F4;}
        table tbody td:nth-child(even){color:#C00;}
    </style>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="#">众筹平台 - 用户维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-top:8px;">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
                            <i class="glyphicon glyphicon-user"></i>  <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                            <li class="divider"></li>
                            <li><a href="index.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                        </ul>
                    </div>
                </li>
                <li style="margin-left:10px;padding-top:8px;">
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
                <ul style="padding-left:0px;" class="list-group">
                    <li class="list-group-item tree-closed" >
                        <a href="main.html"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a>
                    </li>
                    <li class="list-group-item">
                        <span><i class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span class="badge" style="float:right">3</span></span>
                        <ul style="margin-top:10px;">
                            <li style="height:30px;">
                                <a href="${pageContext.request.contextPath}/user/toIndex.htm" style="color:red;"><i class="glyphicon glyphicon-user"></i> 用户维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="role.html"><i class="glyphicon glyphicon-king"></i> 角色维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="permission.html"><i class="glyphicon glyphicon-lock"></i> 许可维护</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge" style="float:right">3</span></span>
                        <ul style="margin-top:10px;display:none;">
                            <li style="height:30px;">
                                <a href="auth_cert.html"><i class="glyphicon glyphicon-check"></i> 实名认证审核</a>
                            </li>
                            <li style="height:30px;">
                                <a href="auth_adv.html"><i class="glyphicon glyphicon-check"></i> 广告审核</a>
                            </li>
                            <li style="height:30px;">
                                <a href="auth_project.html"><i class="glyphicon glyphicon-check"></i> 项目审核</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon-th-large"></i> 业务管理 <span class="badge" style="float:right">7</span></span>
                        <ul style="margin-top:10px;display:none;">
                            <li style="height:30px;">
                                <a href="cert.html"><i class="glyphicon glyphicon-picture"></i> 资质维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="type.html"><i class="glyphicon glyphicon-equalizer"></i> 分类管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="process.html"><i class="glyphicon glyphicon-random"></i> 流程管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="advertisement.html"><i class="glyphicon glyphicon-hdd"></i> 广告管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="message.html"><i class="glyphicon glyphicon-comment"></i> 消息模板</a>
                            </li>
                            <li style="height:30px;">
                                <a href="project_type.html"><i class="glyphicon glyphicon-list"></i> 项目分类</a>
                            </li>
                            <li style="height:30px;">
                                <a href="tag.html"><i class="glyphicon glyphicon-tags"></i> 项目标签</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed" >
                        <a href="param.html"><i class="glyphicon glyphicon-list-alt"></i> 参数管理</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input id="queryText" class="form-control has-success" type="text" placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button id="queryBtn" type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
                    </form>
                    <button type="button" class="btn btn-danger" id="deleteBatchBtn"  style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
                    <button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='${pageContext.request.contextPath}/user/toAdd.htm'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th width="30"><input id="allCheckbox" type="checkbox"></th>
                                <th>账号</th>
                                <th>名称</th>
                                <th>邮箱地址</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                            <tfoot>
                            <tr >
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
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/layer/layer.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/script/menu.js"></script>
</body>
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

        queryPageUser(1);
    });
    $("tbody .btn-success").click(function(){
        window.location.href = "assignRole.html";
    });
    $("tbody .btn-primary").click(function(){
        window.location.href = "edit.html";
    });


    function pageChange(pageno){
        //window.location.href="${pageContext.request.contextPath}/user/index.do?pageno="+pageno ;
        queryPageUser(pageno);
    }

    var jsonObj = {
        "pageno" : 1,
        "pagesize" : 10
    };


    var loadingIndex = -1 ;
    function queryPageUser(pageno){

        jsonObj.pageno = pageno ;
        $.ajax({
            type : "POST",
            data : jsonObj,
            url : "${pageContext.request.contextPath}/user/index01.do",
            beforeSend : function(){

                return true ;
            },


        success : function(ajaK){

            if(ajaK.sunccess){
                var limitBean = ajaK.page ;

                var userLis = limitBean.listpage ;

                var content = '';
                $.each(userLis,function(i,n){
                    content+='<tr>';
                    content+='  <td>'+(i+1)+'</td>';
                    content+='  <td><input type="checkbox" id="'+n.id+'"></td>';
                    content+='  <td>'+n.loginacct+'</td>';
                    content+='  <td>'+n.username+'</td>';
                    content+='  <td>'+n.email+'</td>';
                    content+='  <td>';
                    content+='	  <button type="button" oncl ick="window.location.href=\'${pageContext.request.contextPath}/user/doAssignRole.htm?id='+n.id+'\'" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
                    content+='	  <button type="button" onclick="window.location.href=\'${pageContext.request.contextPath}/user/toUpdate.htm?id='+n.id+'\'" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
                    content+='	  <button type="button" onclick="deleteUser('+n.id+',\''+n.loginacct+'\')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
                    content+='  </td>';
                    content+='</tr>';
                });


                $("tbody").html(content);

                var contentBar = '';

                if(limitBean.pageno==1 ){
                    contentBar+='<li class="disabled"><a href="#">上一页</a></li>';
                }else{
                    contentBar+='<li><a href="#" onclick="pageChange('+(limitBean.pageno-1)+')">上一页</a></li>';
                }

                for(var i = 1 ; i<= limitBean.totalsize ; i++ ){
                    contentBar+='<li';
                    if(limitBean.pageno==i){
                        contentBar+=' class="active"';
                    }
                    contentBar+='><a href="#" onclick="pageChange('+i+')">'+i+'</a></li>';
                }

                if(limitBean.pageno==limitBean.totalsize ){
                    contentBar+='<li class="disabled"><a href="#">下一页</a></li>';
                }else{
                    contentBar+='<li><a href="#" onclick="pageChange('+(limitBean.pageno+1)+')">下一页</a></li>';
                }

                $(".pagination").html(contentBar);

            }else{

            }
        },
        error : function(){

        }
    });
    }



    $("#queryBtn").click(function(){
        var queryText = $("#queryText").val();
        jsonObj.queryText = queryText ;
        queryPageUser(1);
    });


    function deleteUser(id,loginacct){

         if (window.confirm("确定要删除嘛")) {
             alert("删除中")
         }
            $.ajax({
                type : "POST",
                data : {
                    "id" : id
                },
                url : "${pageContext.request.contextPath}/user/doDelete.do",
                beforeSend : function() {
                    return true ;
                },
                success : function(userUntil){
                    if (userUntil.sunccess) {
                        window.location.href = "${pageContext.request.contextPath}/user.htm";
                    }else{
                      alert("删除失败")
                    }
                },
                error : function(){

                }
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

    //只能给当前页面存在的元素增加事件,后来的元素无法增加事件.
    /* $("tbody tr td input[type='checkbox']").click(function(){
        alert("888");
    }); */

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
                url : "${pageContext.request.contextPath}/user/doDeleteBatch.do",
                beforeSend : function() {
                    return true ;
                },
                success : function(userUntil){
                    if(userUntil.sunccess){
                        window.location.href="${pageContext.request.contextPath}/user.htm";
                    }else{

                    }
                },
                error : function(){

                }
            });


    });

</script>
</html>
