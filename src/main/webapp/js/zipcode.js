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

									$.when(promise).then(function(data){
										
										var promise = $.get("https://api.themoviedb.org/3/discover/movie?api_key=c9bd9d09ec5086253a01a6d67f5a1a75&language=en-US&primary_release_year=2016&with_genres="+ genre,
												function(data) {
									var htmlElements = "";
									for (var i = 0; i < data.results.length; i++) {
										

										data[i];

										var id = data.results[i].id;

										var title = data.results[i].title;

										var vote_average = data.results[i].vote_average;

										var backdrop_path = data.results[i].backdrop_path;

										var overview = data.results[i].overview;

										
								
								        var txt = "";
								        txt += '<table><tr><th>' + id + '</th><th>' + title + '</th><th>' + vote_average + '</th><th>' + backdrop_path + '</th><th>' + overview + '</th></tr>';
								        htmlElements += '<div id="div1">' + txt + '</div>';
								    }
								    var div1 = document.getElementById("div1");
								    div1.innerHTML = htmlElements;
									})
									
								});

					
					});			
			});
});


