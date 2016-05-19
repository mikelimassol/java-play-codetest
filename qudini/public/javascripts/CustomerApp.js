(function () {

    angular.module('qudini.CustomerApp', []);

    angular.module('qudini.CustomerApp')
            .controller('CustomerController', ['$http', CustomerController]);
    
    angular.module('qudini.CustomerApp')
            .controller('CustomerAkkaController', ['$http', CustomerAkkaController]);


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
    

    function CustomerAkkaController($http) {

        var self = this;

        self.customers = [];

        function _loadServedCustomers() {

            return $http.get("/assets/data/customers.json").then(function (res) {
                return $http.post("/customers/akka/sort", res.data).then(
                        function (res) {
                            self.customers = res.data;
                        });
            });


        }

        _loadServedCustomers();

    }
    
    


})();
