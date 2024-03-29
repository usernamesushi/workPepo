<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>

        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">

        <%-- 隐藏域--%>
        <input type="hidden" name="id" value="${Object.id}"/>

          <div class="form-group">
              <%--readonly="readonly" 设置参数不能修改--%>
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  value="${Object.name}"  placeholder="请输入姓名" />
          </div>

          <div class="form-group">

            <label>性别：</label>
             <c:if test="${Object.gender=='男'}" >
                 <input type="radio" name="gender" value="男"  checked />男
                 <input type="radio" name="gender" value="女"  />女
             </c:if>
              <c:if test="${Object.gender=='女'}" >
                  <input type="radio" name="gender" value="男"   />男
                  <input type="radio" name="gender" value="女"  checked />女
              </c:if>
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age"  value="${Object.age}" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
            <label for="address">籍贯：</label>

              <c:if test="${Object.address=='陕西'}">
                  <select name="address" id="address" class="form-control"  >
                      <option value="陕西" selected>陕西</option>
                      <option value="北京" >北京</option>
                      <option value="上海">上海</option>
                  </select>
              </c:if>

              <c:if test="${Object.address=='北京'}">
                  <select name="address" id="address" class="form-control" >
                      <option value="陕西" >陕西</option>
                      <option value="北京" selected>北京</option>
                      <option value="上海">上海</option>
                  </select>
              </c:if>

              <c:if test="${Object.address=='上海'}">
                  <select name="address" id="address" class="form-control" >
                      <option value="陕西" >陕西</option>
                      <option value="北京" >北京</option>
                      <option value="上海" selected>上海</option>
                  </select>
              </c:if>

              <c:if test="${Object.address!='上海'&& Object.address!='北京'&& Object.address!='陕西'}">
                  <select name="address" id="address" class="form-control" >
                      <option value="${Object.address}" >${Object.address}</option>

                  </select>

              </c:if>

          </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" name="qq"  value="${Object.qq}" placeholder="请输入QQ号码"/>
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" name="email"  value="${Object.email}" placeholder="请输入邮箱地址"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" value="返回"/>
             </div>
        </form>


        </div>
    </body>
</html>