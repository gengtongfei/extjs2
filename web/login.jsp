<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/10/22
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="extjs/resources/css/ext-all.css" rel="stylesheet" type="text/css"/>
    <link href="extjs/resources/css/xtheme-peppermint.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="extjs/ext-all.js"></script>
    <script src="js/Login.js" type="text/javascript"></script>
    <script type="text/javascript">

        Ext.onReady(function () {
            Ext.create('ShinowLogin', {
                renderTo: Ext.getBody()
            }).center();
        });

    </script>
</head>
<body>

</body>
</html>
