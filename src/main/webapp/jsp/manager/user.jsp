<%--
  Created by IntelliJ IDEA.
  User: poyu
  Date: 2019/3/6/0006
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/H1/css/user_login.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function cleaning() {
            confirm("确定刷新？ ");
            parent.document.location.reload()
        }
    </script>
</head>
<body>
<div class="div1">
    <div class="div_success">
        <h1>欢迎用户:${userName}</h1>
        <div class="link">

        </div>
        <input style="margin-left:1800px; margin-top: -20px;" type="button" class="register_bn"
               onclick="window.location.href='${pageContext.request.contextPath}/index.jsp'" value="注销">
        <input style="margin-left:1700px;margin-top:-24px; " type="button" class="register_bn"
               onclick="return cleaning()" value="清空">
    </div>
    <div class="register">
        <div class="a">
            <a target="transfer" href="jsp/user/info/CarRegister.jsp">车辆户籍登记</a><br/>
        </div>
        <div class="a">
            <a target="transfer" href="jsp/user/info/CarRevise.jsp">车辆信息变更</a><br/>
        </div>
        <div class="a">
            <a target="transfer" href="jsp/user/carOperation/CarUnruleQuery.jsp">违章查询</a><br/>
        </div>
        <div class="a">
            <a target="transfer" href="jsp/user/carOperation/Ticket_deal.jsp">违章缴费</a><br/>
        </div>
        <div class="a">
            <a target="transfer" href="jsp/user/carOperation/ChangeLicense.jsp">车辆换牌</a><br/>
        </div>
        <div class="a">
            <a target="transfer" href="jsp/user/info/CarClear.jsp"></a><br/>
        </div>
        <div class="a">
            <a target="transfer" href="jsp/user/info/CarClear.jsp">销户</a><br/>
        </div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <iframe class="iframe" name="transfer"
                src="${pageContext.request.contextPath}/IndexInfo.jsp"></iframe>
    </div>
</div>

</body>
</html>
