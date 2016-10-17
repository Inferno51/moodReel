$(function(counter) {
			// Function occurs on lookupButton click
			$("#lookupButton").click(
					function() {
						// Builds API query to request weather conditions for user-provided zip code.
						$.get("http://api.wunderground.com/api/b6882d76267c419a/conditions/q/" + $("#zipcode").val() + ".json",
								function(data) {
									// This area gathers and stores the weather conditions data.
									var conditionVar = data['current_observation']['weather'];
										
									$("#condition").html(conditionVar)
									$("#temp_f").html(data.current_observation.temp_f)
									$("#wind_dir").html(data.current_observation.wind_dir)
									$("#wind_mph").html(data.current_observation.wind_mph)
									
									// Database linking code
									var promise = $.get("/condition/"+ conditionVar,
										function([data]) {
																			
											var genre = data[0];
											console.log(genre);
											
											var image = data[1];
											console.log(image);
																					
									})
									
									
									$.when(promise).then(function([data]){

										var genre = data[0];
										
										var promise = $.get("https://api.themoviedb.org/3/discover/movie?api_key=c9bd9d09ec5086253a01a6d67f5a1a75&language=en-US&primary_release_year=2016&with_genres="+ genre + ".json",
												function(data) {
									var htmlElements = "";
									
									// Populate the movie display table with movie suggestions.
									for (var i = 0; i < data.results.length; i++) {
										

										data[i];

										var id = data.results[i].id;

										var title = data.results[i].title;

										var vote_average = data.results[i].vote_average;

										var backdrop_path = data.results[i].backdrop_path;

										var overview = data.results[i].overview;

								        var txt = "";
								        txt += '<table><tr><td><img src="https://image.tmdb.org/t/p/w92' + backdrop_path + '"></img></td><td><a href="https://api.themoviedb.org/3/movie/' + id + '?api_key=c9bd9d09ec5086253a01a6d67f5a1a75" target="_blank">' + title + '</a></td><td>' + vote_average + '</td><td>' + overview + '</td></tr>';
								        htmlElements += '<div id="div1">' + txt + '</div>';
								    }
								    var div1 = document.getElementById("div1");
								    div1.innerHTML = htmlElements;
									})
									
								});

					
					});			
			});
});


