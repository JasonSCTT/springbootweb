var index= new Vue({
    el:"#index",
    data:{
        tableData: [{
            date: '2016-05-18',
            name: '王小虎',
            address: '上海市你在哪里'
        },{  date: '2016-05-02',
            name: '王小虎',
            address: 'shanghiai'}]
    }
    ,
    methods:{
        btncreate:function () {
            console.log("asdfasdf");
            $("#abc").load("Login.html");
        }
    }
})