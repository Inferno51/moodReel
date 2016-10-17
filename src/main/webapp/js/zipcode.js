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
										function(data) {
																				
											var genre = data[0];
											console.log(genre);
																					
									})
									
									
									$.when(promise).then(function(data){

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

														var poster_path = data.results[i].poster_path;

														var overview = data.results[i].overview;

												        var txt = "";
												        txt += '<table><tr><td><img src="https://image.tmdb.org/t/p/w92' + poster_path + '"></img></td><td><a href="#movieDetail"><button type="button" id="movieDetailButton">' + title + '</button></a></td><td>' + vote_average + '</td><td>' + overview + '</td></tr>';
												        htmlElements += '<div id="div1">' + txt + '</div>';


												    }
												var div1 = document.getElementById("div1");
												div1.innerHTML = htmlElements;
												})
									});

					
					});			
			});
$(function(movieDetailButton){
															$("#movieDetailButton").click(
																	function() {
												                        var id = data.results[i].id;
																		console.log(id),
																		$.get("https://api.themoviedb.org/3/movie/" + id + "?api_key=c9bd9d09ec5086253a01a6d67f5a1a75",
																			console.log(id),
																			function(data) {



																				
																				var poster_path = data.results.poster_path;
																				$("#poster_path").html(poster_path)	

																				var title = data.results.title;
																				$("#title").html(title);

																				var tagline = data.results.tagline;
																				$("#tagline").html(tagline);
																				
																				var overview = data.results[i].overview;
																				$("#overview").html(overview)
																				
																				var imdb_id = "http://www.imdb.com/title/" + data.results.imdb_id;
																				$("#imdb_id").html(imdb_id)
																				
																			})
															})
														})
});



