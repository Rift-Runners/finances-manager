var app = angular.module('financeApp.controllers', []);

app.controller('FinancesController', ['$scope', 'FinancesFactory', 'SubjectsFactory', function (
            $scope, FinancesFactory, SubjectsFactory) {

        $scope.finances = FinancesFactory.query();
        $scope.subjects = SubjectsFactory.query();
        $scope.finance;
        
        $scope.saveDebit = function (finance) {
            finance.type = 'Debit';
            FinancesFactory.create(finance);
            $scope.finances.push(angular.copy(finance));

            delete $scope.finance;
            window.location.reload();
        };
        
        $scope.saveCredit = function (finance) {
            finance.type = 'Credit';
            FinancesFactory.create(finance);
            $scope.finances.push(angular.copy(finance));

            delete $scope.finance;
            window.location.reload();
        };
        
        $scope.setEditableFinance = function (finance){
            $scope.finance = finance;
        };
        
        $scope.editFinance = function (finance) {
            FinancesFactory.edit(finance);

            delete $scope.finance;
            window.location.reload();
        };
        
        $scope.deleteFinance = function (finance) {
            console.log(finance);
            FinancesFactory.delete(finance);
            //$scope.finance = null;
            
            delete $scope.finance;
            window.location.reload();
        };

        $scope.saveSubject = function (subject) {
            SubjectsFactory.create(subject);
            $scope.subjects.push(angular.copy(subject));

            delete $scope.subject;
            window.location.reload();
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