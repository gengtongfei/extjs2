Ext.define('js.tabPanel', {
    extend: 'Ext.grid.Panel',
    id:'js.tabPanel',
    initComponent: function () {
        var me = this;
   //     this.createMenuList();
        var Qstore=Ext.create("Ext.data.Store",{
            proxy:{
                type:'ajax',
                url:'/sex1',
                reader:{
                    type:'json',
                    root:'sexlist'
                }
            },
            fields:[
                {name:'sexTypeCode',type:'int'},
                {name:'sexTypeName',type:'string'}
            ],
            autoLoad:true
        });

        var mStore = Ext.create("Ext.data.Store", {
            pageSize: 2,
            proxy: {
                type: 'ajax',
                url: '/tomcat',
                reader:{
                    type:'json',
                    root:'adminlist',
                    totalProperty: 'count'
                }
            },
            fields:[
                {name:'adminName',type:'string'},
                {name:'adminPass',type:'string'},
                {name:'adminId',type:'int'},
                {name:'sexTypesBySexTypeCode.sexTypeName',type:'string'}
            ],
            autoLoad:false,
            listeners:{
                beforeload: function(store, operation){
                    var name = Ext.getCmp('ad');
                    var iddd=Ext.getCmp('abc');
                    var namesex=Ext.getCmp('sexid')
                    if (name ||iddd){
                        if (name.getValue()||iddd.getValue()||namesex.getValue())
                        {
                            if (operation.params)
                            {
                                operation.params.admin = name.getValue();
                                operation.params.stuno = iddd.getValue();
                                operation.params.sexname = namesex.getValue();
                            }
                            else
                            {
                                operation.params = {admin: name.getValue()};
                                operation.params={stuno:iddd.getValue()};
                                operation.params={sexname:namesex.getValue()};
                            }
                        }
                    }
                }
            }
        });
        mStore.load({
                params: {
                    start: 1,
                    limit: 2
                }
            }
        );

        Ext.apply(this,{
            title:'数据表格',
            width: 500,
            id: 'myGrid',
            store: mStore,
    //        renderTo: Ext.getBody(),
            columns:[
                {text:'ID',dataIndex:'adminId'},
                {text:'姓名',dataIndex:'adminName'},
                {text:'密码', dataIndex:'adminPass'},
                {text:'性别',dataIndex:'sexTypesBySexTypeCode.sexTypeName'}


            ],
            dockedItems: [{
                xtype: 'pagingtoolbar',
                store: mStore,
                dock: 'bottom',
                displayInfo: true
            }]
            ,
            tbar: [
                { xtype: 'button',
                    text:'添加',
                    handler:me.addMsg

                },
                {
                    xtype:'button',
                    text:'删除',
                    handler:me.deleteMsg
                },
                {
                    xtype:'button',
                    text:'修改',
                    handler:me.updateMsg
                },{
                    xtype:'panel',
                    layout:'column',
                    bodyPadding: 5,
                    border:false,
                    bodyStyle: {
                        background: '#E7E7E7'
                    }
                    },

                    {
                        xtype:'textfield',
                        fieldLabel:'姓名',
                        labelWidth:30,
                        LabelAlign:'right',
                        name : 'admin',
                        id : "ad"
                    },
                    {
                        xtype:'textfield',
                        fieldLabel:'ID',
                        labelWidth:20,
                        name:'stuno',
                        LabelAlign:'right',
                        id:'abc'
                    },
                    {
                        xtype:'combo',
                        fieldLabel: '性别',
                        labelWidth:30,
                        LabelAlign:'right',
                        emptyText : '请选择性别',
                        displayField: 'sexTypeName',
                        valueField: 'sexTypeCode',
                        store:Qstore,
                        id:'sexid',
                 //       name:'adminInfo.sexTypesBySexTypeCode.sexTypeCode'
                        name:'sexname'



                    },
                    {
                        xtype:'button',
                        text:'查询',
                        handler:function(){
                           Ext.getCmp("myGrid").store.load({params:{admin:Ext.getCmp("ad").getValue(),stuno:Ext.getCmp("abc").getValue()},sexname:Ext.getCmp("sexid")})
//                           Ext.getCmp("myGrid").store.load({params:{Id:Ext.getCmp("abc").getValue()}})
//                           Ext.getCmp("myGrid").store.load({params:{Id:Ext.getCmp("abc").getValue()}})

                        }
                    }
                ]
            });
        this.callParent();
    },
    addMsg:function(){

        var sexStore=Ext.create("Ext.data.Store",{
            proxy:{
                type:'ajax',
                url:'/sex1',
                reader:{
                    type:'json',
                    root:'sexlist'
                }
            },
            fields:[
                {name:'sexTypeCode',type:'int'},
                {name:'sexTypeName',type:'string'}
            ],
            autoLoad:true
        });
            Ext.create('Ext.window.Window', {
                title: '添加数据',
                modal: true,
                layout: 'fit',
                id: 'tabPanelWin',
                width: 300,
                items: [
                    {
                        xtype: 'form',
                        layout: 'form',
                        defaults: {
                            xtype: 'textfield',
                            allowBlank: false
                        },
                        items: [
                            { fieldLabel: '姓名', id: 'text1',name:'admin1.adminName' },
                            { fieldLabel: '密码', id: 'text2',name:'admin1.adminPass' },
                            { xtype:'hidden',id: 'text3',name:'admin1.roleTypesByRoleId.roleId' ,value:1 },
                            {xtype:'combo',fieldLabel: '性别',id:'text4',store:sexStore,emptyText : '请选择',name:'admin1.sexTypesBySexTypeCode.sexTypeCode',
                                displayField: 'sexTypeName',
                                valueField: 'sexTypeCode'
                            }

                        ]
                    }
                ],
                buttons: [
                    { text: '提交',
                        handler:function(){
                            var form= this.up('window').down('form').getForm();
                            if(form.isValid()){
                                form.submit({
                                    url:'/insert1',
                                    success: function (form, action) {
                                        var msg = Ext.JSON.decode(action.response.responseText);
                                        if (msg.ss) {
                                            Ext.getCmp('myGrid').store.reload();
                                            Ext.getCmp('tabPanelWin').close();
                                            return;
                                        }
                                        Ext.MessageBox.show({
                                            title: '系统提示',
                                            msg: msg.message,
                                            icon: Ext.MessageBox.WARNING,
                                            buttons: Ext.MessageBox.YES
                                        });

                                    }
                                })
                            }
                        }
                    },
                    { text: '重置' ,
                        handler:function(){
                            this.up('window').down('form').getForm().reset();
                        }
                    }
                ]
            }).show();
        },
    deleteMsg:function(){
        var record = Ext.getCmp('myGrid').getSelectionModel().getSelection()[0];
        if(null==record){
            Ext.Msg.show({
                title:'系统提示！',
                msg: '请你选择一条数据',
                buttons: Ext.Msg.CANCEL,
                icon: Ext.Msg.QUESTION
            });
            return;
        }
        Ext.MessageBox.confirm('删除提示','确实要删除姓名为【' + record.get('adminName') + '】的数据么？',function(btn){
            if (btn == 'yes')
            {
                Ext.Ajax.request({
                    url: '/delete2.action?admin2.adminId='+record.get('adminId'),
                    success: function(action){
                        Ext.getCmp('myGrid').store.reload();
                    },
                    failure:function(){

                    }
                });
            }
        });
    },
    updateMsg:function() {
        var record = Ext.getCmp('myGrid').getSelectionModel().getSelection()[0];
        if(null==record){
            Ext.Msg.show({
                title:'系统提示！',
                msg: '请你选择一条数据',
                buttons: Ext.Msg.CANCEL,
                icon: Ext.Msg.QUESTION
            });
            return;
        }
        var SexStore=Ext.create("Ext.data.Store",{
            proxy:{
                type:'ajax',
                url:'/sex1',
                reader:{
                    type:'json',
                    root:'sexlist'
                }
            },
            fields:[
                {name:'sexTypeCode',type:'int'},
                {name:'sexTypeName',type:'string'}
            ],
            autoLoad:true
        });
        Ext.create('Ext.window.Window', {
            title: '编辑',
            modal: true,
            layout: 'fit',
            id: 'tabPanelUpa',
            width: 300,
            items: [
                {
                    xtype: 'form',
                    layout: 'form',
                    margin:5,
                    defaults: {
                        xtype: 'textfield',
                        allowBlank: false
                    },
                    items: [
                        { fieldLabel: '姓名',name:'adminInfo.adminName',value:record.get('adminName') },
                        { fieldLabel: '密码',name:'adminInfo.adminPass',value:record.get('adminPass') },
                        { xtype:'hidden',name:'adminInfo.adminId',value:record.get('adminId') },

                        {xtype:'combo',fieldLabel: '性别', tooltip: '选择性别',store:SexStore, emptyText : '请选择',name:'adminInfo.sexTypesBySexTypeCode.sexTypeCode',
                            displayField: 'sexTypeName',
                            valueField: 'sexTypeCode'
                        }

                    ]
                }
            ],
            buttons: [
                { text: '提交',
                    handler:function(){
                        var form= this.up('window').down('form').getForm();
                        if(form.isValid()){
                            form.submit({
                                url:'/update3',
                                success: function (form, action) {
                                    var msg = Ext.JSON.decode(action.response.responseText);
                                    if (msg.stat) {
                                        Ext.getCmp('myGrid').store.reload();
                                        Ext.getCmp('tabPanelUpa').close();
                                        return;
                                    }
                                    Ext.MessageBox.show({
                                        title: '系统提示',
                                        msg: msg.message,
                                        icon: Ext.MessageBox.WARNING,
                                        buttons: Ext.MessageBox.YES
                                    });

                                }
                            })
                        }
                    }
                },
                { text: '重置' ,
                    handler:function(){
                        this.up('window').down('form').getForm().reset();
                    }
                }
            ]
        }).show();
    }

})