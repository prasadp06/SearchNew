(function() {
    
    var JobController = function (jobService, $log) {
        this.jobs = jobService.getJobs();
        this.job  = null;
        this.sortyBy = 'name';
        this.reverse   = false;
        this.addNew = false;
        
        this.sort = function (colName){
            this.sortBy = colName;
            this.reverse = !this.reverse;
            $log.info("Sorting Job !! " + this.sortBy + "|" + this.reverse);
        };
        
        
        this.printDetails = function (id) {
            this.job = jobService.getJob(id);
            $log.info(" Reading Details of Id " + id + " | " + this.job.id + this.job.name);
        };
        
        this.addNewJob = function (){
            this.addNew = false;
            this.job.status = 'Pending';
            jobService.addJob(this.job);
        }
    };
    
    JobController.$inject = ['jobService','$log'];
    app.controller('JobController', JobController);
    
}());