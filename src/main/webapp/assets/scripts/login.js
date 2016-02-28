(function() {
    
    var LoginController = function (appSecurity) {
        this.userName = '';
        this.inputPassword = '';
        this.displayMessage = 'Hello'
        this.isMessage = false;
        
        
        this.doLogin = function(){
          if(this.userName === '1' && this.inputPassword === '1'){
              this.displayMessage = 'Logged in !!';
              appSecurity.setAuthanticated(true);
              appSecurity.setLoginButtonLabel("LogOut");
          } else {
              this.isMessage = false;
              this.displayMessage = 'Invalid User Id or Pasword ';
              appSecurity.setAuthanticated(true);
              appSecurity.setLoginButtonLabel("LogIn");
          }
          
        };
    };

    
   LoginController.$inject = ['appSecurity'];
   app.controller('LoginController', LoginController);
    

    var PageController = function (appSecurity) {
        this.isValidUser = function () {
            return appSecurity.isAuthanticated();
        };
        
        this.getButtonLabel = function () {
            return appSecurity.getLoginButtonLabel();
        }
        
    };
    
    
    PageController.$inject = ['appSecurity'];
    app.controller('PageController', PageController);
    
}());

