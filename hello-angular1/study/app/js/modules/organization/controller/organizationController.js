"use strict";
define(["main-app", "jquery", "richey-orgchart"], function (app, $) {

    app
        .controller("OrganizationController", ["$scope", function ($scope) {

            $scope.orgData = {
                'id': '1',
                'name': '上帝生物科技有限公司',
                'content': '太阳系-地球',
                'className': 'richey-orgchart-company',
                'type': 'company',
                'imgUrl': '',
                'children': [
                    {
                        'id': 2,
                        'name': '地球总管',
                        'content': '上帝',
                        'className': 'richey-orgchart-position',
                        'type': 'position',
                        'children': [
                            {
                                id: 100,
                                'name': '植物部门',
                                'content': '各种植物',
                                'className': 'richey-orgchart-department',
                                'type': 'department',
                                'children': [
                                    {
                                        'id': 3,
                                        'name': '水果部门',
                                        'content': '各种个水果',
                                        'className': 'richey-orgchart-department',
                                        'type': 'department',
                                        'children': [
                                            {
                                                'id': 10,
                                                'name': '香蕉部',
                                                'content': '各种香蕉',
                                                'className': 'richey-orgchart-department',
                                                'type': 'department'
                                            },
                                            {
                                                'id': 11,
                                                'name': '苹果部',
                                                'content': '苹果苹果',
                                                'className': 'richey-orgchart-department',
                                                'type': 'department',
                                                'children': [
                                                    {
                                                        'id': 12,
                                                        'name': '种植小组',
                                                        'content': '各种种植技术',
                                                        'className': 'richey-orgchart-group',
                                                        'type': 'group'
                                                    },
                                                    {
                                                        'id': 13,
                                                        'name': '采摘小组',
                                                        'content': '采摘入库',
                                                        'className': 'richey-orgchart-group',
                                                        'type': 'group'
                                                    }
                                                ]
                                            }
                                        ]
                                    },
                                    {
                                        'id': 4,
                                        'name': '蔬菜部门',
                                        'content': '各种蔬菜',
                                        'className': 'richey-orgchart-department',
                                        'type': 'department'
                                    },
                                    {
                                        'id': 5,
                                        'name': '树部门',
                                        'content': '各种树',
                                        'className': 'richey-orgchart-department',
                                        'type': 'department'
                                    },
                                    {
                                        'id': 6,
                                        'name': '草部门',
                                        'content': '各种草',
                                        'className': 'richey-orgchart-department',
                                        'type': 'department'
                                    }

                                ]
                            }
                        ]
                    }

                ]
            }

            $scope.addChildrenNode = function (name) {
                //请求后台新增子部门
                alert(name+"新增了一个子部门!")
            }

        }])

})