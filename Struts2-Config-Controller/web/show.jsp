<%--
  Created by IntelliJ IDEA.
  User: YanoHao
  Date: 2018/2/28
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>OGNL测试页面</title>
</head>
<body>
    <h1>利用OGNL获取一个List中所有商品</h1>
    <s:iterator value="{'a','b','c','d','e'}" var="v">
        <td>
            <s:property value="v"></s:property>
        </td>
    </s:iterator>
    <table>
        <thead>
            <td>商品ID</td>
            <td>商品名称</td>
            <td>商品数量</td>
            <td>商品类别ID</td>
        </thead>

        <s:iterator value="productsList" var="product">
            <tr>
                <td><s:property value="#product.pid"/></td>
                <td><s:property value="#product.pname"/></td>
                <td><s:property value="#product.pnum"/></td>
                <td><s:property value="#product.ptype"/></td>
                <td>1</td>
            </tr>
        </s:iterator>
    </table>
    <h1>利用OGNL获取一个Map中所有商品</h1>
    <table>
        <thead>
        <td>商品ID</td>
        <td>商品名称</td>
        <td>商品数量</td>
        <td>商品类别ID</td>
        </thead>

        <%--遍历Map时，每一次遍历出来var的是一个Entry对象，遵循javabean格式，对象中有getKey()和getValue()方法，因此可以使用.key和.value--%>
        <s:iterator value="productsMap" var="entry">
            <tr>
                <td><s:property value="#entry.value.pid"/></td>
                <td><s:property value="#entry.value.pname"/></td>
                <td><s:property value="#entry.value.pnum"/></td>
                <td><s:property value="#entry.value.ptype"/></td>
                <td>1</td>
            </tr>
        </s:iterator>
    </table>
    <s:debug></s:debug>
</body>
</html>
