window.Global={

    axiosPost: function (url, data, sCallback, eCallback) {
        axios.post(url, data, { headers: { 'X-Requested-with': 'XMLHttpRequest' } }).then(function (response) {
            if (typeof (sCallback) === "function") {
                sCallback(response.data);
            }
        }).catch(function (error) {
            if (typeof (eCallback) === "function") {
                eCallback(error);
            }
        });
    },



}

Vue.prototype.vAlter = function (title, obj, type) {
    var message = null;
    if(obj instanceof Object){
        if(obj.message){
            message = obj.message;
        }
        if (obj.response && obj.response.status){
            message = obj.response.status + ":" + message;
        }
    }
    if(message === null){
        message = obj;
    }

    this.$notify({
        title: title, message: message, type: type
    });
}
