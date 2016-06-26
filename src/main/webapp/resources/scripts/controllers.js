var app = angular.module('financeApp.controllers', []);


app.controller('FinancesListController', ['$scope', 'FinancesFactory', function ($scope, FinancesFactory) {
        $scope.finances = FinancesFactory.query();
    }]);

//app.controller('FinancesListController', ['$scope', '', function ($scope) {
//        $scope.finances = [
//            {'name': 'Banana stuff', 'subject': 'food', 'type': 'debit',
//                'value': '10,00', 'paid': 'NO'},
//            {'name': 'Apple stuff', 'subject': 'food', 'type': 'debit',
//                'value': '20,00', 'paid': 'NO'},
//            {'name': 'Watermelon stuff', 'subject': 'food', 'type': 'debit',
//                'value': '30,00', 'paid': 'YES'}
//        ];
//    }]);