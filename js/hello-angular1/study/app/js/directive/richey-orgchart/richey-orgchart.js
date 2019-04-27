"use strict";
define(["main-app", "orgchart"], function (app) {
    app.directive("richeyOrgchart", function () {


        return {
            scope: {
                "orgData": "=",
                "orgDepth": "@",
                "disableCollapsable":"@",
                "richeyAddChildrennode": "&"
            },
            restrict: "E",
            template: "",
            replace: true,
            link: function ($scope, element) {


                var oc = element.orgchart({
                    'data': $scope.orgData,
                    'nodeTitle': 'name', //节点标题,默认name
                    'nodeContent': 'content', //节点内容,
                    'chartClass': 'richey-orgchart', //组织架构样式,默认'' 当实例化多个orgcharts在一个页面上,应该添加不同名称来区分他们。
                    'depth': 999, //指定最初显示的图表级别,默认999
                    'toggleSiblingsResp': true, //显示隐藏节点,默认false
                    'draggable': true, //拖动,默认false
                    'exportButton': true, //是否显示导出按钮,默认false
                    'exportFilename': 'demoOrg.jpg', //导出图片名称
                    'parentNodeSymbol': 'fa-th-large', //折叠图标,默认'fa-users'  意为着有子节点
                    'direction': 'l2b', //显示方向,默认 Top to Button
                    'pan': true, //移动图形 默认false
                    'zoom': true, //
                    'zoominLimit': 1.5,
                    'zoomoutLimit': 0.5,
                    'nodeTemplate': function (data) {
                        return '<div class="title"> '
                                    + data.name +
                               '</div> \
                               <div class="content"> \
                                        <div class="image"> \
                                            <img src="../../images/elephant.png">\
                                        </div> \
                                        <div class="info">  '
                                            + data.content +
                                        '</div> \
                                </div> \
                                <div class="bottom">+</div>\
                                <div class="add-node-box">\
                                <div>\
                                     <span class="item">公司</span>\
                                     <span class="item">部门</span>\
                                     <span class="item">职位</span>\
                                     <span class="item">小组</span>\
                                </div>\
                                <div class="save-node">\
                                  保存\
                                </div>'
                    },
                    'createNode': function ($node, data) {
                        //todo 根据data.type类型判断
                        $node.find('.bottom').on('click', function () {
                            $node.find('.add-node-box').toggle();
                        })
                        $node.find('.save-node').on('click', function () {
                            //todo 校验数据是否正确
                            $scope.richeyAddChildrennode({name: data.name});

                            var hasChild = $node.parent().attr('colspan') > 0 ? true : false;
                            if (!hasChild) {
                                oc.addChildren($node, {
                                    'children': [{
                                        'name': '新增植物',
                                        'content': '新增的植物',
                                        'className': 'richey-orgchart-department',
                                        'type': 'department',
                                        'relationship': '100'
                                    }]
                                });
                            } else {
                                oc.addSiblings($node.closest('tr').siblings('.nodes').find('.node:first'),
                                    {
                                        'siblings': [{
                                            'name': '新增植物',
                                            'content': '新增的植物',
                                            'className': 'richey-orgchart-department',
                                            'type': 'department',
                                            'relationship': '100'
                                        }]
                                    });
                            }


                            $node.find('.add-node-box').toggle();
                        })
                        
                        $node.on('click','.bottomEdge',function () {

                            var posX = $node.width() > $('.orgchart').width() ? -($node.width() / 2) : '0';
                            $node.css('transform', 'matrix(1, 0, 0, 1, ' + posX + ', 0)');
                        })
                        
                        
                    }

                });
                if($scope.disableCollapsable === 'true') {
                    //个关闭折叠/展开功能
                    $('.orgchart').addClass('noncollapsable');
                }

                //todo 解决收起后节点消失的问题 (添加重置按钮或自动重置?)
                /*$('.btnRecenter').click(function() {
                    var chart = $('.orgchart');
                    var posX = chart.width() > chart.parent('div').width() ? -(chart.width() / 2) : '0';
                    chart.css('transform', 'matrix(1, 0, 0, 1, ' + posX + ', 0)');
                });*/



            }
        }
    })
})