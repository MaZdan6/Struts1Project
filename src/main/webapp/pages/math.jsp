<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!doctype html>
<html lang="en">
<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="js/Chart.js"></script>
</head>
<body>
	<h1>Math</h1>


	<div id="arithmeticForm">
		<h3>
			<bean:message key="label.math.arithmetic.name" />
		</h3>
		<html:form action="/Math">

			<div style="color: red">
				<html:errors property="operator"/>
			</div>
			<!--


		<html:messages id="err_name" property="common.name.err">
		<div style="color:red">
			<bean:write name="err_name" />
		</div>
		</html:messages>

-->
			<div style="padding: 16px">
				
				<html:errors property="operator"/>
				<html:errors property="org.apache.struts.action.GLOBAL_MESSAGE"/>
				
				<html:text property="a" size="10" maxlength="20" />
				<html:text property="operator" size="1" maxlength="1" />
				<html:text property="b" size="10" maxlength="20" />
				=
				<bean:write name="mathForm" property="result" />
			</div>

			<div style="padding: 16px">
				<div style="float: left; padding-right: 8px;">
					<html:submit>
						<bean:message key="label.common.button.submit" />
					</html:submit>
				</div>
				<html:reset>
					<bean:message key="label.common.button.reset" />
				</html:reset>
			</div>

		</html:form>
	</div>





	<div id="quadraticConrainer" class="container">
		<div class="card-deck mb-3 text-center">
			<div class="card mb-4 box-shadow">
				111
				<div id="guadraticForm">
					<h3>
						<bean:message key="label.math.quatratic.name" />
					</h3>

					<html:form action="/Math2">

						<div style="color: red">
							<html:errors />
						</div>

						<div style="padding: 16px">

							<html:text property="a" size="5" maxlength="5" />
							x^2+
							<html:text property="b" size="5" maxlength="5" />
							x+
							<html:text property="c" size="5" maxlength="5" />
						</div>

						<div style="padding: 16px">
							<div style="float: left; padding-right: 8px;">
								<html:submit property="method" value="quadratic">
									<bean:message key="label.common.button.submit" />
								</html:submit>
							</div>
							<html:reset>
								<bean:message key="label.common.button.reset" />
							</html:reset>
						</div>

					</html:form>
				</div>
			</div>
			<div class="card mb-4 box-shadow">
				222
				<div id="points">
					<h3>Points</h3>
					<!-- jeśli lista nie jest pusta, to tworzona jest tabela punktów -->
					<logic:present name="points">
						<table id="pointsTable">
							<th>x</th>
							<th>y</th>
							<logic:iterate name="points" id="point">
								<tr>
									<td><bean:write name="point" property="x" /></td>
									<td><bean:write name="point" property="y" /></td>
								</tr>
							</logic:iterate>
						</table>
					</logic:present>

				</div>
			</div>
			<div class="card mb-4 box-shadow">
				333
				<div id="chart">
					<h3>Chart</h3>
					<canvas id="myChart" width="400px" height="400px"></canvas>
				</div>
			</div>
		</div>
	</div>







	<script>
		function getPoints() {

			var table = document.getElementById("pointsTable");

			console.log('getPoints() - start');

			/* console.log(table); */
			var points = [];

			var rows = table.rows;
			for (var i = 1; i < table.rows.length; i++) {
				var row = rows.item(i);
				var x = row.cells[0].innerHTML;
				var y = row.cells[1].innerHTML;
				/* console.log("x: " + Number(x));
				console.log("y: " + Number(y)); */

				var point = {}

				point.x = x;
				point.y = y;

				/* console.log(point) */
				points.push(point);
			};

			return points
		}

		var points = getPoints();
		
		function getXValues(points){
			console.log('getXValues - start')
			
			var xValues=[];
			for(var i=0 ; i<points.length; i++){
				xValues.push(points[i].x)
			}
			
			return xValues
		}
		
		var xValues = getXValues(points);
		
		console.log(xValues);
		console.log(points)

		var ctx = document.getElementById("myChart").getContext('2d');
		var myChart = new Chart(ctx, {
			type : 'line',
			data : {
				labels : xValues,
				datasets : [ {
					label : 'Quadratic function',
					/* dane */
					data : points,

					/* formatowanie linii */
					borderWidth : 5,
					fill : false,
					borderColor : "rgb(75,192,192)"
				} ]
			},
			options : {
				scales : {
					yAxes : [ {
						ticks : {
							beginAtZero : false
						}
					} ],
					xAxes : [ {
						ticks : {
							beginAtZero : false,
							min : -10,
							max : 10,
							stepSize : 1
						}
					} ]

				}
			}
		});
	</script>


	<!-- skrypty js od bootstrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>


</body>
</html>