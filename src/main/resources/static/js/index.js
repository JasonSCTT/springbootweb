var index= new Vue({
    el:"#index",
    data:{
        isFrame:false,
        url:"",
        tableData: [{
            date: '2016-05-18',
            name: '王小虎',
            address: '上海市你在哪里'
        },{  date: '2016-05-02',
            name: '王小虎',
            address: 'shanghiai'}],
        name:""
    },

    mounted:function(){
        this.queryUserbyId();
    }
    ,
    methods:{
        btncreate:function () {
            this.isFrame=true;
            this.url="/html/Login.html";
            console.log(isFrame);
        },

        loginOut: function () {
            Global.axiosPost('/login/loginOut', {}, function (json) {
                if (json.code==1) {
                    location.href = '/html/Login.html';
                }
            });
        },
        queryUserbyId:function () {
            var self =this;
            Global.axiosPost('/login/queryUserbyId', {}, function (json) {

                    if (json.code == 1) {
                        self.name=json.data.username;
                    }else{
                        self.vAlter('警告', 'session中数据异常', 'warning');
                    }

            });
        }



    }
})