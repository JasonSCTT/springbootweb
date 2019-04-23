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
            address: 'shanghiai'}]
    }
    ,
    methods:{
        btncreate:function () {
            this.isFrame=true;
            this.url="/html/Login.html";
            console.log(isFrame);
        }
    }
})