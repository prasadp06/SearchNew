(function() {
    
    var SecurityFactory = function () {
        this.authanticated = false;
        this.buttonName      = "LogIn";
        var factory = {}
        
        factory.isAuthanticated = function () {
          return  this.authanticated;
        };
        
        factory.getLoginButtonLabel = function () {
          return this.buttonName ;
        };
        
        factory.setAuthanticated = function (value){
            this.authanticated = true;
        };
        
        factory.setLoginButtonLabel = function (value) {
          this.buttonName = value;
        };
        
        return factory;
    };
    
    //JobController.$inject = ['$scope'];
    app.factory('appSecurity', SecurityFactory);
    
}());