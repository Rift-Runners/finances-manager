var services = angular.module('financeApp.services', ['ngResource']);
var baseUrl = 'http://localhost:8080/finances-manager/';

services.factory('FinancesFactory', function ($resource) {
    return $resource(baseUrl + 'webresources/finances', {}, {
        query: { method: 'GET', isArray: true },
        create: {method: 'POST'}
    });
});

services.factory('SubjectsFactory', function ($resource) {
    return $resource(baseUrl + 'webresources/subjects', {}, {
        query: { method: 'GET', isArray: true },
        create: {method: 'POST'}
    });
});