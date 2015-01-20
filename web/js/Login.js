Ext.define('ShinowLogin', {
    extend: 'Ext.form.Panel',
    initComponent: function () {
        var me = this;
        Ext.apply(this, {
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
            buttons: [
                { text: '登陆', handler: me.doLogin },
                { text: '重置', handler: function () { this.up('form').getForm().reset(); } }
            ]
        });

        this.callParent();
    },
    doLogin: function () {
        var form = this.up('form').getForm();
        if (form.isValid()) {
            form.submit({
                url: '/mylogin',
                success: function (form, action) {
                    var msg = Ext.JSON.decode(action.response.responseText);
                    if (msg.isno) {
                        window.location = 'main.jsp';
                        return;
                    }
                    Ext.MessageBox.show({
                        title: '系统提示',
                        msg: msg.message,
                        icon: Ext.MessageBox.WARNING,
                        buttons: Ext.MessageBox.YES
                    });
                    this.up('form').getForm().reset();
                },
                failure: function (form, action) {
                    Ext.MessageBox.show({
                        title: '系统提示',
                        msg: '网络原因无法正常发送请求，请联系网络管理员！',
                        icon: Ext.MessageBox.QUESTION,
                        buttons: Ext.MessageBox.YES
                    });
                }
            });
        }
        //Ext.Msg.alert('提示','成功');
    }
});