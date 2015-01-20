Ext.define('ShinowMain', {
    extend: 'Ext.container.Viewport',
    initComponent: function () {
        var me = this;
        this.createMenuList();

        Ext.apply(this, {
            layout: 'border',
            style: {
                backgroundColor: '#d3e1f1'
            },
            items: [{
                region: 'north',
                html: '<h1 class="x-panel-header"style="color: blue">医院挂号管理系统</h1>',
                border: false,
                margins: '0 0 5 0'
            }, {
                region: 'west',
                width: 200,
                title: '菜单栏',
                layout: 'accordion',
                collapsible: true,
                split: true,
                margin: '5 0 5 0',
                items: me.menuList
            }, {
                region: 'south',
                title: 'South Panel',
                collapsible: true,
                html: '备注信息',
                split: true,
                height: 100,
                minHeight: 100
            }, {
                region: 'east',
                title: 'East Panel',
                collapsible: true,
                split: true,
                width: 150
            }, {
                region: 'center',
                xtype: 'tabpanel', // TabPanel itself has no title
                id:'centerid'

            }]

        });
        this.callParent();
    },
    menuList: new Array(),
    createMenuList: function () {
        var menuData = {}, tpl, me = this;
        tpl = new Ext.XTemplate(
            '<tpl for=".">',
            '<div class="part01">',
            '<img src="{childPic}">',
            '<div class="con">',
            '<span>{childId}</span>',
            '<div class="con1">{childName}</div>',
            '</div>',
            '</div>',
            '</tpl>'
        );

        Ext.Ajax.request({
            url: '/show',
            async: false,
            success: function (response) {
                menuData = Ext.JSON.decode(response.responseText);
            }
        });
        for (var i = 0, len = menuData.menulist.length; i < len; i++) {
            var storeID = 'store_' + i, item, title = menuData.menulist[i].menuName;
            Ext.create('Ext.data.Store', {
                id: storeID,
                data: menuData.menulist[i].childmenuinfosByMenuId,
                fields: [
                    { name: 'childPic', type: 'string' },
                    { name: 'childName', type: 'string' },
                    { name: 'childId', type: 'int' }
                ]
            });

            item = {
                xtype: 'panel',
                title: title,
                layout: 'fit',
                items: [{
                    xtype: 'dataview',
                    store: Ext.data.StoreManager.lookup(storeID),
                    tpl: tpl,
                    itemSelector: 'div.part01',
                    listeners:{
                        itemclick:function(view,record){
                            Ext.require('js.tabPanel',function(){
                                var obj=Ext.create('js.tabPanel');
                               var center=Ext.getCmp('centerid');
                                var tab=center.items.get('myGrid');
//                                center.add(obj);
//                                center.setActiveTab(obj);
                                if(!tab){
                                    center.add(obj);
                                    center.setActiveTab(obj)
                                }else{
                                    if(center.setActiveTab()!==tab){
                                        center.setActiveTab(obj);
                                    }

                                        }

                            },this);

                        }
                    }
                }]
            };
            me.menuList.push(item);
        }
    }
});