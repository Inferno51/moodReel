$(function(counter) {
			// Function occurs on lookupButton click
			$("#lookupButton").click(
					function() {
						// Builds API query to request weather conditions for user-provided zip code.
						$.get("http://api.wunderground.com/api/b6882d76267c419a/conditions/q/" + $("#zipcode").val() + ".json",
								function(data) {
									// This area gathers and stores the weather conditions data.
									var conditionVar = data['current_observation']['weather'];
									$("#icon_url").html('<img src="' + data.current_observation.icon_url + '">')	
									$("#condition").html(conditionVar)
									$("#temp_f").html(data.current_observation.temp_f)
									$("#wind_dir").html(data.current_observation.wind_dir)
									$("#wind_mph").html(data.current_observation.wind_mph)
									
									// Database linking code
									var promise = $.get("/condition/"+ conditionVar,
										function([data]) {
																			
											var genre = data[0];
								
											var image = data[1];
																					
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
														var poster_path = data.results[i].poster_path;
														var overview = data.results[i].overview;

												        var txt = "";
												        txt += '<table><tr><td><img src="https://image.tmdb.org/t/p/w92' + poster_path + '"></img></td><td><a href="#movieDetail" data-movieid="' + id + '" id="movieDetailButton">' + title + '</a></td><td>' + vote_average + '</td><td>' + overview + '</td></tr>';
												        $("#div1").append(txt)
												    }
												})
									});
					});			
		

	$( "#div1" ).delegate( "a", "click", function() {
		$.get("https://api.themoviedb.org/3/movie/" + $(this).data("movieid") + "?api_key=c9bd9d09ec5086253a01a6d67f5a1a75",
			function(data) {

				var poster_path = data.poster_path;
				$("#poster_path").html('<img src="https://image.tmdb.org/t/p/w92' + poster_path + '"></img>');	

				var imdb_id = data.imdb_id;
				var title = data.title;
				$("#title").html('<a href="http://www.imdb.com/title/' + imdb_id + '" target="_blank">' + title + '</a>');

				var tagline = data.tagline;
				$("#tagline").html(tagline);
				
				var overview = data.overview;
				$("#overview").html(overview);

				var release_date = data.release_date;
				$("#release_date").html(release_date);

				var runtime = data.runtime;
				$("#runtime").html(runtime + " minutes");
				
		})
	});

});
});

