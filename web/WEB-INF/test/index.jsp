<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 06/01/2015
  Time: 05:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title></title>
</head>
<body>
  <s:form action="test_index">
    <s:iterator  var="index" begin="1" end="10" step="1">
      <s:textfield type="checkbox" value="%{index}" name="list" />
    </s:iterator>
  </s:form>
</body>
</html>
