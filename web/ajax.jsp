<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/10/23
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="extjs/resources/ext-theme-neptune/ext-theme-neptune-all.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="extjs/ext-all.js"></script>
    <script type="text/javascript">
        Ext.onReady(function(){
            Ext.create('Ext.data.Store',{
                id: 'mystore',
                proxy: {
                    type: 'ajax',
                    url: '/select',
                    reader:{
                        type:'json',
                        root:'userList'
                    }
                },
                fields:[
                { name:'userList.adminInfosBySexTypeCode.adminId'},
                {name:'userList.adminInfosBySexTypeCode.adminName'}
            ],
                autoLoad:true
            });

            Ext.create('Ext.grid.Panel',{
                title:'数据表格',
                store: Ext.data.StoreManager.lookup('mystore'),
                columns:[
                    {text:'ID',dataIndex:'userList.adminInfosBySexTypeCode.adminId'},
                    {text:'姓名',dataIndex:'userList.adminInfosBySexTypeCode.adminName'}
                ],
                renderTo:Ext.getBody()
            });

        });

    </script>


</head>
<body>

</body>
</html>
