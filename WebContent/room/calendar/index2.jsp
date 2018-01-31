
<link href='https://fonts.googleapis.com/css?family=Roboto:400,500,300,700' rel='stylesheet' type='text/css'>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel='stylesheet' type='text/css' href='dist/rm-datepicker.css'>
<style>
    .container {
        max-width: 800px;
    }
</style>

<div ng-app="myApp" ng-controller="MyCtrl" class="container">
    <br>
    <div rm-datepicker ng-model="oDate1" rm-config="rmConfig1"></div>
    <div></div>
    <hr>
  	<input type="text"  name = selected value = "{{oDate1 | date: 'yyyy-MM-dd'}}">
    <input rm-datepicker type="text" ng-model="oDate2" rm-config="rmConfig2">
    <br>
    <button data-ng-click="clearInput()">Clear Input</button>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
<script src="src/scripts/rm-datepicker.js"></script>
<script>

    var app = angular.module("myApp", ["rmDatepicker"]);

    /* Datepicker global configuration */
    app.config(["rmDatepickerConfig", function (rmDatepickerConfig) {
        rmDatepickerConfig.mondayStart = true;
        rmDatepickerConfig.initState = "month";
    }]);

</script>
<script>

    (function () {

        var app = angular.module("myApp");

        var MyCtrl = function ($scope) {

            /* Datepicker local configuration */
            $scope.rmConfig1 = {
                mondayStart: false,
                initState: "month", /* decade || year || month */
                maxState: null,
                minState: "month",
                decadeSize: 12,
                monthSize: 42, /* "auto" || fixed nr. (35 or 42) */
                min: new Date('2000-11-21'),
                max: new Date('2023-11-21'),
                format: "yyyy-MM-dd" /* https://docs.angularjs.org/api/ng/filter/date */
            };

            $scope.rmConfig2 = { format: "d MMM yyyy" };

            $scope.oDate1 = new Date('2015-12-12');
            $scope.oDate2 = null;
            $scope.clearInput = function(){
                $scope.oDate2 = null;
            }
        };
        app.controller("MyCtrl", ['$scope', MyCtrl]);

    }());

    // Init waves (OPTIONAL) :)
    // window.onload = Waves.init();

</script>
</body>
</html>



