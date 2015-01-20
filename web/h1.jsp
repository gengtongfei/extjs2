<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/10/23
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="extjs/resources/ext-theme-access/ext-theme-access-all.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="extjs/ext-all.js"></script>
    <script src="extjs/locale/ext-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/tabPanel.js"></script>
    <script type="text/javascript">
        Ext.onReady(function(){
            Ext.create('TabPanel', {
                renderTo: Ext.getBody()
            });

        });

    </script>

</head>
<body>

</body>
</html>
