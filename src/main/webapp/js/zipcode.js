$(function() {
	
			$("#lookupButton").click(
					function() {
						$.get("http://api.wunderground.com/api/b6882d76267c419a/conditions/q/" + $("#zipcode").val() + ".json",
								function(data) {
									
									var conditionVar = data['current_observation']['weather'];
									$("#conditionVar").html(conditionVar)
									$("#temp_f").html(data.current_observation.temp_f)
									$("#wind_dir").html(data.current_observation.wind_dir)
									$("#wind_mph").html(data.current_observation.wind_mph)
									var conVar = String(conditionVar)
									console.log(conVar)
								});
					});
			
			$.get("/condition",
//			$.get("/genre/2",
					function(data){
				console.log(data)
			});
			
			$(document).ready(function() {
		        $('#conditionVar').blur(function(event) {
		                var name = $('#conditionVar').val();
		                $.get('JqueryServlet', {
		                	conditionVar : name
		                }, function(responseText) {
		                        $('#ajaxResponse').text(responseText);
		                });
		        });
		});

		});