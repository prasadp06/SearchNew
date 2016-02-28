(function() {
    
    var JobService = function () {
        var jobs= [
                { id: '1', name: 'Job One', parent: 'JVM 1', status: 'Processing', startDate: '24-02-2016', endDate: ''},
                { id: '2', name: 'Job Two', parent: 'JVM 2', status: 'Completed', startDate: '24-02-2016', endDate: '24-02-2016'}
        ];
        
        
        this.getJobs = function () {
          return jobs;
        };
        
        this.getJob = function (jobId) {
            for(var i = 0; i<jobs.length; i++){
                if(jobs[i].id == parseInt(jobId)){
                    return jobs[i];
                }
            }
        };
        
        this.addJob = function (nJob) {
          return jobs.push(nJob);
        };
        
    };
    
    //JobController.$inject = ['$scope'];
    app.service('jobService', JobService);
    
}());