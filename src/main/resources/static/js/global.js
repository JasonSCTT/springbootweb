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