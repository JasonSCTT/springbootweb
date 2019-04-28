// Vue实例
var app = new Vue({
    el: '#app',
    data: {
        checkCode: "data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAAAjCAIAAACMxRqVAAACf0lEQVR42sWZPU4EMQyFIyQqrkJDQUPHCai5wJ4SCdFTUXMYVlo0ZPzs52eHASnFbCab+It/4njG58f7v7TXl7dzw87Gv0ptrMh3BDBf5TJgRZKhiDW3Q5mVJRaFGaJYvw4czbn1RGul8nA5HeCH2xu34RoKP1l+m/D0fKU0UcMq8DYuAjbkopZSVbSBe34+cFwKfGnEutDzjwBOmXOTRmCyF4oris5vBsyQPbslAwaOE4HRaDmz7uoGOJqhZ9gD/4xULnNqt1XgSMMNYPKvgfvB4xMPXbhBjfMsAl5h3p6ToIVyE+Cn0yNpOnYJeHu+u782zQ2liQ9HtOZYVoAvzIvA7gyIOjdjCEniER1UrsFEhFXmEjDimU5j/IVMK1L7NiOx4bl/EdgwI5vb3wd2EymXKnqVOrNJNgiw8VgJGNfGcxh73OOOAM9v09BNgM203HtN9PoOWgowYf5jYPPHfwCesUXgNB/G1DJSMjmEovxn4DiXzU05CTDyoA+LwKhbV8NpciIBz69WgN2gFYmoB63zMwFG5f8AR2BmdvJKP5bSo5VfCSNgY9Vu/w6Y59J8L5Bqc1fsSS/MCMwzdsNGItbOpBVg/jZNLXlVpAHsMhNaB5jfgYx8PPHg2VU0Z7WcOP+Msq7d5SEiTC+6KHfjnrAOjNGen08jusQq1Qziw2lJoFGXj9Sg11L9+7C4qfhMQrHrt6UytV4bJO7jA5NN5eUo5bCtVpVFJesuM+Y94PbWq/SLcaEE3PjI5AArReZeyCkp+SDgXREvunxVC9+iBGJ1Xolnq8Auc6OwvPj5rwRcJfeBG981Gx7Vs+p0HuljWjUs9T5ni+N1E3OtkovxBe3tgbb9RepBAAAAAElFTkSuQmCC",
        pictureCode: "请输入验证码",
        checked: false,
        login: {
            username: '',
            password: '',
            remember: ''
        },
        flag: true,
        loading: {} //loading动画
    },
    mounted: function () {
        this.createCheckCode();
    },
    methods: {
        /**
         * loading加载动画
         */
        loadings() {
            this.loading = this.$loading({
                lock: true,
                text: '拼命加载中',
                spinner: 'el-icon-loading',
            });
            setTimeout(() => {
                this.loading.close();
            }, 500);
        },

        createCheckCode: function () {
            var self = this;
            Global.axiosPost("/login/getPicutreCode", {}
                , function (json) {
                    self.checkCodedata = 'data:image/gif;base64,' + json;
                    document.getElementById("createCheckCode").src = self.checkCodedata;
                });
        },

        submitForm(login) {
            var self =this;
            this.$refs[login].validate((valid) => {
                if (valid) {
                    this.loadings(); //加载动画
                    Global.axiosPost("/login/loginin", {
                            username: self.login.username,
                            password: self.login.password,
                            pictureCode:self.login.pictureCode
                        }
                        , function (json) {
                            if (json.code == 1) {
                                    location.href="/Home/index";
                                }else{
                                    self.vAlter('警告', json.data.msg, 'warning');
                                    self.createCheckCode();
                                }
                        });

                }
            });
        }

    }
});