var services = angular.module('financeApp.services', ['ngResource']);

var baseUrl = 'http://localhost:8080/finances-manager/';

services.factory('FinancesFactory', function ($resource) {
    return $resource(baseUrl + 'webresources/finances/allFinances', {}, {
        query: { method: 'GET', isArray: true }
    });
});