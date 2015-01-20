Ext.onReady(function(){
    Ext.create('Ext.panel.Panel',{
        title:'登陆',
        layout:'fit',
        width:260,
        items:[{
            xtype:'form',
            border:false,
            margin:'5 5 5 5',

            defaults:{
                xtype:'textfield',
                allowBlank:false,
                labelWidth:60,
                labelAlign:'right'
            },
            items:[
                {
                    fieldLabel:'用户名',
                    blankText:'用户名不能为空!',
                    name:'user.userName'

            },{
                    fieldLabel:'密码',
                    blankText:'密码不能为空！',
                    inputType:'password',
                    name:'user.userPass'

                },{
                    fieldLabel:'验证码',
                    blankText:'验证码不能为空',
                    maxLength:4,
                    name:'uncode'
                }

            ]

        }],
        buttonAlign:'center',
        buttons:[
            {
                text:'登陆',
                handler:function(){
                    var form=this.up('panel').down('form').getForm();
                    if(form.isValid()){//对象是否被实例化，及实例化后是否有效
                    form.submit({
                        url:'/mylogin',
                            success:function(form,action){
                                var msg=Ext.JSON.decode(action.response.responseText);
                                if(msg.isno){
                                    Ext.Msg.alert("系统提示",msg.message);
                                    window.location='main.jsp';
                                }else{
                                    Ext.Msg.alert("系统提示",msg.message);
                                }

                            },
                            failure:function(form,action){
                              var msg= Ext.JSON.decode(action.response.responseText);
                              if(msg.isno){
                                  Ext.Msg.alert("系统提示",msg.message);
                              }
                            }

                        });
                    }
                }
            },
            {
                text:'重置',
                handler:function(){
                    this.up('panel').down('form').getForm().reset();

                }
            }
        ],
            renderTo:Ext.getBody()
    }).center();

});