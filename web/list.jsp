<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>
        //${pageContext.request.contextPath}/delUserServlet?id=${user.id}
        /*给用户删除提示*/
        function delUser(id) {
            if (confirm("您确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/delUserServlet?id=" + id;
            }
        }

        window.onload = function () {
            /*页面加载完毕 给删除选中加单击事件 将复选框放到一个表单里面,支持提交复选框操作*/
            document.getElementById("delSelected").ondblclick = function () {
                //定义一个标记
                var flag = false;
                if (confirm("您确定要删除选中条目吗？")) {
                    var uids = document.getElementsByName("uuid");
                    for (var i = 0; i < uids.length; i++) {
                        if (uids[i].checked) {
                            flag = true;
                            break;
                        } else {
                            alert("请选择您要删除的条目!");

                        }
                    }
                    if (flag) {//选中条目
                        //提交表单
                        document.getElementById("form").submit();
                    }


                }

            }
            //复选框的优化
            document.getElementById("firstCb").onclick = function () {
                //添加单击事件，与下面的复选框的状态保持一致
                var uids = document.getElementsByName("uuid");
                //20年前的写法
                for (var i = 0; i < uids.length; i++) {
                    //遍历uids,设置状态
                    uids[i].checked = this.checked;
                }
            }

        }


    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">

        <form action="" method="" class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" id="exampleInputName3">
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="text" class="form-control" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0)" ; id="delSelected">删除选中</a>

    </div>

    <form id="form" action="${pageContext.request.contextPath}/delSelectServlet" METHOD="get">

        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${pb.list}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uuid" value="${user.id}"></td>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:delUser(${user.id})">删除</a></td>
                </tr>
            </c:forEach>

        </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">


                <c:if test="${pb.currentPage==1}">
                <li class="disabled">
                    </c:if>

                    <c:if test="${pb.currentPage!=1}">
                <li >
                    </c:if>

                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage-1}&rows=5"
                       aria-label="Previous">
                        <span aria-hidden="true">上一页</span>
                    </a>
                </li>


                <%--激活当前页码--%>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">

                    <c:if test="${pb.currentPage==i}">
                        <li class="active">
                    </c:if>
                    <c:if test="${pb.currentPage!=i}">
                        <li >
                    </c:if>


                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5">${i}</a>


                    </li>
                </c:forEach>


                <%--下一页样式--%>
                <c:if test="${pb.currentPage==pb.totalPage}">
                <li class="disabled">
                    </c:if>

                <c:if test="${pb.currentPage!=pb.totalPage}">
                <li >
                    </c:if>
                    <%--根据键去值map.name  取出来是一个数组[0]--%>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage+1}&rows=5"
                       aria-label="Next">
                        <span aria-hidden="true">下一页</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共条记录，共页
                </span>

            </ul>
        </nav>


    </div>


</div>


</body>
</html>
