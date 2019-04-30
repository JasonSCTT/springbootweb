var index = new Vue({
    el: "#index",
    data: {
        isIFrame: false,
        url: "",
        tableData: [{
            date: '2016-05-18',
            name: '王小虎',
            address: '上海市你在哪里'
        }, {
            date: '2016-05-02',
            name: '王小虎',
            address: 'shanghiai'
        }],
        name: "",
        tabs: [
            {
                title: '导航1',
                index: 1,
                submenulist: [
                    {title: '导航1-1',
                    index:1-1},
                    {title: '导航1-2',
                    index:1-2},
                    {title: '导航1-3',
                    index:1-3}
                ]
            },
            {
                title: '导航2',
                index: 2,
                submenulist: [
                    {
                        title: '导航2-1',
                        index: 2 - 1
                    },
                    {
                        title: '导航2-2',
                        index: 2 - 2
                    },
                    {
                        title: '导航2-3',
                        index: 2 - 3
                    }
                ]
            },
            {
                title: '导航3',
                index: 3,
                submenulist: [
                    {
                        title: '导航3-1',
                        index: 3 - 1
                    },
                    {
                        title: '导航3-2',
                        index: 3 - 2
                    },
                    {
                        title: '导航3-3',
                        index: 3 - 3
                    }
                ]
            }

        ]
    },

    mounted: function () {
        this.queryUserbyId();
    }
    ,
    methods: {
        btncreate: function () {
            this.url = "/html/Login.html";
        },

        loginOut: function () {
            Global.axiosPost('/login/loginOut', {}, function (json) {
                if (json.code == 1) {
                    location.href = '/html/Login.html';
                }
            });
        },
        queryUserbyId: function () {
            var self = this;
            Global.axiosPost('/login/queryUserbyId', {}, function (json) {

                if (json.code == 1) {
                    self.name = json.data.username;
                } else {
                    self.vAlter('警告', 'session中数据异常', 'warning');
                }

            });
        },

        clickTab: function (item) {
            var self = this;
            this.isIFrame = false;
            Vue.nextTick(function () {
                Global.axiosGet("/html/manage/manage.html", null, function (h) {
                    $("#content #divcontent").html(h);
                });
            });
        }
    }
})