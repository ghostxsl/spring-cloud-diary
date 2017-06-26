var app =angular.module('fortunes', []);

app.controller('ro',function ($scope,$http) {
   $scope.enroo=function (userAccount,userPassword,userSex) {
       $http({method:'GET',url:'add?userAccount='+userAccount+'&userPassword='+userPassword+'&userSex='+userSex})
           .success(function (data) {
               $scope.tem=data;
               if($scope.tem !== "f" && $scope.tem !== "t" ){
                   alert("服务出现问题!");
               }
               else if($scope.tem !== "t"){
                   $scope.varRepeat=true;
               }
               else{
                   $scope.myVar4= true;
               }
           });
   };

});

app.controller('pageCon',function ($scope,$http) {
    $scope.login = function (account,pass) {
        $http({method:'GET',url:'check?account='+account+'&pass='+pass}).success(function (data) {
            $scope.tem=data;
            if($scope.tem !== "f" && $scope.tem !== "t" ){
                alert("服务出现问题!");
            }
            else if($scope.tem !== "t"){
                $scope.err=true;
            }
            else{
                $scope.myVar1= false;
                $scope.myVar3= true;
            }
        });
    };
    $scope.myVar1= true;
    $scope.myVar2= false;
    $scope.myVar3= false;
    $scope.myVar4= false;
    $scope.err=false;
    $scope.varRepeat=false;

    $scope.roll = function () {
        $scope.myVar1 = false;
        $scope.myVar2 = true;
    };
    $scope.re = function () {
        $scope.myVar1 = true;
        $scope.myVar2 = false;
    };
});

app.controller("myNoteCtrl", function($scope, $http) {
    $scope.his=function (account) {
        $http({method:'GET',url:'history?account='+account}).success(function (data) {
            $scope.history=data;
        });
        $scope.ta=!$scope.ta;
    };

    $scope.save  = function(name,account,message) {
        $scope.theTime= new Date().toLocaleDateString();
        $http({method:'GET',url:'save?filename='+name+'&date='+$scope.theTime+'&account='+account+'&usertext='+message})
            .success(function (data) {
                if(data !== "f") {
                    alert("保存成功!");
                }
                else {
                    alert("文件名重复!");
                }
        });
    };

    $scope.lookup = function (account,filename) {
        $http({method:'GET',url:'lookup?account='+account+'&filename='+filename})
            .success(function (data) {
                $scope.res=data;
            });
    };

    $scope.message = "";
    $scope.ta=false;
    $scope.theTime="";
    $scope.left  = function() {return 500 - $scope.message.length;};
    $scope.clear = function() {$scope.message = "";};
});


