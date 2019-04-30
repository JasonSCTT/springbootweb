let valisealCode = (rule, value, callback) => {
    let reg = /[\u4e00-\u9fa5]/ig;
    if (reg.test(value) === false) {
        callback();
    } else {
        callback(new Error('不允许输入中文'));
    }
};

var Manage = new Vue({
        el: '#Manage',
        data: {
            image: {
                modal: false,
            },
            search: {},
            departmentList: [
                {
                    departmentKey: '1',
                    departmentName: 'sc'
                }
            ],
            uploadImageUrl: "/seal/Manage/importImage",
            uploadExcelUrl: "/seal/Manage/importImage",
            fileList: [],
            isFirstCreate: true,
            branchList: [
                {
                    branchCode: 1,
                    branchNameCode: '部门1'
                }, {
                    branchCode: 2,
                    branchNameCode: '部门2'
                }, {
                    branchCode: 3,
                    branchNameCode: '部门3'
                }
            ],
            typenamelist: [
                {typename: '类型1'}, {typename: '类型2'}, {typename: '类型3'}

            ],
            applyimage: {
                modal: false,
                applyImage: ""
            },
            table: {
                pageNo: 1,
                pageSize: 10,
                total: 1,
                Sorts: [],
                Data: [
                    {
                        name: "jason1",
                        department: "woshi1",
                        status: 1
                    },
                    {
                        name: "jason2",
                        department: "woshi2",
                        status: 0
                    }
                ]
            },
            Manage: {
                modal: false,
                title: "新增总部"
            },
            salesDialog: {
                modal: false,
            },
            sales: {
                oaSerialNo: "",
                applyImage: ""
            },
            model: {},
            importDialog: {
                importDialogShow: {
                    modal: true
                }
            },
            //表单校验规则
            rules: {
                type: [
                    {required: true, message: '请输入类型', trigger: 'change'}
                ],

            },
            rulesale: {
                oaSerialNo: [
                    {required: true, message: '请输入oa编号', trigger: 'change'}
                ]
            },
            ruleApplyImage: {
                applyImage: [
                    {required: true, message: '请上传图片', trigger: 'change'}
                ]
            },

        },
        mounted: function () {
            // this.getList();
            // this.doBranchList();
            // this.doSealTypeNameList();
            // this.getList();
            // this.doSealBaseImageList();
        },
        methods: {

            indexMethod: function (index) {
                return index + 1 + Manage.table.pageSize * (Manage.table.pageNo - 1);
            },

            dialogOk: function (formname) {
                var self = this;
                this.$refs[formname].validate((valid) => {
                    if (valid) {
                        if (this.isFirstCreate) {
                            var params = {};
                            params.sealLevel = 0;
                            params.departmentName = this.model.departmentName;
                            params.sealTypeName = this.model.sealTypeName;
                            params.sealName = this.model.sealName;
                            params.sealCode = this.model.sealCode;
                            var item = self.sealList.find(function (item) {
                                return item.sealTypeName == params.sealTypeName;
                            })
                            if (item != undefined) {
                                params.sealTypeId = item.sealTypeId;
                            } else {
                                params.sealTypeId = null;
                            }

                            var item = self.departmentList.find(function (item) {
                                return item.departmentName == params.departmentName;
                            })
                            if (item != undefined) {
                                params.departmentId = item.departmentKey;
                            } else {
                                params.departmentId = null;
                            }
                            // var item = self.sealBaseImageList.find(function (item) {
                            //     return item.sealCode == params.sealCode;
                            // })
                            // if (item != undefined) {
                            //     params.sealImage = item.sealImage;
                            // } else {
                            //     self.vAlter('警告', "请输入正确的代码", 'warning');
                            //     return;
                            // }
                            Global.getTableData("/seal/Manage/createSealInfo", params, function (json) {
                                if (json.IsSuccess) {
                                    self.Manage.modal = false;
                                    self.getList();
                                } else {
                                    self.vAlter('警告', json.Message, 'warning');
                                }
                            });
                        } else {
                            Global.getTableData("/seal/Manage/update", {
                                //TODO form 参数绑定
                                sealName: this.model.sealName,
                                eid: this.model.eid
                            }, function (json) {
                                if (json.IsSuccess) {
                                    self.Manage.modal = false;
                                    self.getList();
                                } else {
                                    self.vAlter('警告', json.Message, 'warning');
                                }
                            });
                        }

                    }
                });
            },
            openApplyImage: function () {
                this.applyimage.modal = true;
            },
            btnQuery: function () {
                this.getList();
            },
            btnEditSealInfo: function () {
                var self = this;
                var params = {};
                params.sealLevel = 0;
                params.departmentName = this.model.departmentName;
                params.sealTypeName = this.model.sealTypeName;
                params.sealName = this.model.sealName;
                par
                var item = self.sealList.find(function (item) {
                    return item.sealTypeName == params.sealTypeName;
                })
                if (item != undefined) {
                    params.sealTypeId = item.sealTypeId;
                } else {
                    params.sealTypeId = null;
                }

                var item = self.departmentList.find(function (item) {
                    return item.departmentName == params.departmentName;
                })
                if (item != undefined) {
                    params.departmentId = item.departmentKey;
                } else {
                    params.departmentId = null;
                }

            },
            btnDeleteSealInfo: function (item) {
                var self = this;
                this.$confirm('此操作将该记录删除, 是否继续?', '提示', {
                    type: 'warning',
                }).then(function () {
                    Global.getTableData("/seal/Manage/deleteSealInfo", {
                        eid: item.eid
                    }, function (json) {
                        if (json.IsSuccess) {
                            self.getList();
                        } else {
                            self.vAlter('警告', json.Message, 'warning');
                        }
                    });
                }).catch(function (error) {//加上catch
                    console.log(error);
                })
            },

            //分页数量
            sizeChange: function (v) {
                this.table.pageSize = v;
                this.getList();
            },
            //第几页
            pageChange: function (v) {
                this.table.pageNo = v;
                this.getList();
            },
            openDialog: function (item) {
                this.Manage.modal = true;
                this.search.sealLevel = 0;
                this.doSealTypeNameList();
                this.isFirstCreate = true;
                this.resetModel();
                this.doZongbuDepartmentList();
            },

            dialogZongbuCancel: function () {
                this.Manage.modal = false;
                this.resetSealTypeNameList();
                this.resetModel();
            },
            //
            resetSealTypeNameList: function () {
                this.search.sealLevel = null;
                this.doSealTypeNameList();
            },
            resetModel: function () {
                this.model = {
                    departmentName: null,
                    sealTypeName: null,
                    sealName: null,
                    eid: null,
                    sealImage: "",
                    title: "新增总部"
                }
            },
            openPictureDialog: function (item) {
                this.image.modal = true;
                this.image.sealImage = item.sealImage;
            },
            dialogCancel: function (item) {
                this.image.modal = false;
                this.applyimage.modal = false;
            },

            handleAvatarSuccess: function (res, file) {
                if (res.IsSuccess) {
                    Manage.model.aaaa = res.Data;
                } else {
                    Manage.vAlter('警告', res.Message, 'warning');
                }
                endLoading();
            },


            beforeAvatarUpload: function (file) {
                if (file == undefined || file == null) {
                    Manage.vAlter('警告', "请选择文件！", 'warning');
                    return false;
                } else if (!file.name.endsWith('png') && !file.name.endsWith('PNG')) {
                    Manage.vAlter('警告', "请选择png、PNG格式的图片！", 'warning');
                    return false;
                } else if (file.size / 1024 / 1024 > 10) {
                    Manage.vAlter('警告', "附件大小不能超过10M！必须大于10M,请联系运维修改系统配置！", 'warning');
                    return false;
                }
            },

            handleApplyImageSuccess: function (res, file) {
                if (res.IsSuccess) {
                    Manage.applyimage.applyImage = res.Data;
                } else {
                    Manage.vAlter('警告', res.Message, 'warning');
                }
                endLoading();
            },
            handlePreview: function (file) {
                if (file == undefined || file == null) {
                    Manage.vAlter('警告', "请选择文件！", 'warning');
                    return false;
                } else if (!file.name.endsWith('xlsx') && !file.name.endsWith('xls')) {
                    Manage.vAlter('警告', "请选择xlsx或者xls文件！", 'warning');
                    return false;
                } else if (file.size / 1024 / 1024 > 10) {
                    Manage.vAlter('警告', "附件大小不能超过10M！必须大于10M,请联系运维修改系统配置！", 'warning');
                    return false;
                }
                // startLoading(document.querySelector("#sales").firstElementChild);
            },

            handleSuccess: function (res, file) {
                //debugger;
                if (res.IsSuccess) {
                    Manage.getList();
                    Manage.sales.oaSerialNo = "";
                    Manage.$refs['upload'].clearFiles();
                    Manage.salesDialog.modal = false;
                } else {
                    Manage.vAlter('警告', res.Message, 'warning');
                }
                endLoading();
            },

            loadTemplate: function () {
                window.location.href = "/seal/Manage/asdfasdf";
            },
            submitUpload: function (item) {
                this.$refs[item].validate((valid) => {
                    if (valid) {
                        if (Manage.sales.applyImage == "") {
                            Manage.vAlter('警告', 'oa截图未上传', 'warning');
                        } else {
                            this.$refs.upload.submit();// 提交上传组件的action
                        }
                    } else {
                        Manage.vAlter('警告', '请确保文件已经上传，oa流水号已经填写', 'warning');
                    }
                });
            },


        }
    })
;