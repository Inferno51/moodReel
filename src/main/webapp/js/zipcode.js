$(function(counter) {
	
			$("#lookupButton").click(
					function() {
						$.get("http://api.wunderground.com/api/b6882d76267c419a/conditions/q/" + $("#zipcode").val() + ".json",
								function(data) {
									
									var conditionVar = data['current_observation']['weather'];
										
									$("#condition").html(conditionVar)
									$("#temp_f").html(data.current_observation.temp_f)
									$("#wind_dir").html(data.current_observation.wind_dir)
									$("#wind_mph").html(data.current_observation.wind_mph)
									
									console.log(conditionVar);
									
									var promise = $.get("/condition/"+ conditionVar,
										function(data) {
																				
											var genre = data[0];
											console.log(genre);
																					
									})

//									$.when(promise).then(function(data){
//										
//										var promise = $.get("api movie call"+ genre,
//												function(data) {
//												
//										})
//									})
									
								});

					
					});

			
		

			
});


