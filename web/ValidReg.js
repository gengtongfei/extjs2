Ext.onReady(function(){
    Ext.create('Ext.panel.Panel',{
        title:'注册',
        layout:'fit',
        width:260,
        items:[{
            xtype:'form',
            border:false,
            margin:'5 5 5 5',
            defaults:{
              labelWidth:60,
              labelAlign:'right'
            },
            defaultType: 'textfield',
            items:[{
                fieldLabel:'用户名',
                allowBlank:false,
                blankText:'注册名不能为空！',
                name:'userName'
            },
                {
                    fieldLabel:'密码',
                    allowBlank:false,
                    blankText:'密码不能为空！',
                    name:'userPass'
                    },{
                    fieldLabel:'确认密码',
                    allowBlank:false,
                    blankText:'请再次输入密码！',
                    name:'userPass1'
                    },{
                    fieldLabel:'密码保护问题',
                    name:'passQuestion'
                    },{
                    fieldLabel:'密保答案',
                    name:'passQuesAnsw'
                    },{
                    fieldLabel:'出生日期',
                    vtype:'datefield',
                    name:'birthday'
                    },
                {
                        fieldLabel:'昵称',
                    name:'nickName'

                    },{
                    fieldLabel: '密保邮箱',
                    name: 'email',
                    allowBlank: false,
                    vtype:'email',
                    tooltip: 'Enter your email address',
                    name:'questEmailAddr'
                }
            ]
        }],
        renderTo:Ext.getBody()

    });


    });