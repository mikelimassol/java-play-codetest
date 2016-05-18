(function () {

    angular.module('qudini.CustomerApp', []);

    angular.module('qudini.CustomerApp')
            .controller('CustomerController', ['$http', CustomerController]);

    /**
     * Bonus points - manipulating the without waiting for the
     * server request
     */
    function CustomerController($http) {

        var self = this;

        self.customers = [];

        function _loadServedCustomers() {

            return $http.get("/assets/data/customers.json").then(function (res) {
                return $http.post("/customers/sort", res.data).then(
                        function (res) {
                            self.customers = res.data;
                        });
            });


        }

        _loadServedCustomers();

    }

})();
