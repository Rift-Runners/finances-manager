var app = angular.module('financeApp.controllers', []);

app.controller('FinancesController', ['$scope', 'FinancesFactory', 'SubjectsFactory', function (
            $scope, FinancesFactory, SubjectsFactory) {

        $scope.finances = FinancesFactory.query();
        $scope.subjects = SubjectsFactory.query();
        
        $scope.saveFinance = function (finance) {
            finance.type = 'Debit';
            FinancesFactory.create(finance);
            $scope.finances.push(angular.copy(finance));
            
            $scope.transaction.type = false;
            $scope.transaction.type = true;
            delete $scope.finance;
        };

        $scope.saveSubject = function (subject) {
            SubjectsFactory.create(subject);
            $scope.subjects.push(angular.copy(subject));

            delete $scope.subject;
        };

        $scope.orderByField = function (field) {
            $scope.sortingRule = field;
            $scope.sortingDirection = !$scope.sortingDirection;
        };

        $scope.isSelectedFinance = function (finances) {
            return finances.some(function (finance) {
                return finance.selected;
            });
        };

    }]);