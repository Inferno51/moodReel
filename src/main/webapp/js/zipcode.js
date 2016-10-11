$(function() {
	
			$("#lookupButton").click(
					function() {
						$.get("http://api.wunderground.com/api/b6882d76267c419a/conditions/q/" + $("#zipcode").val() + ".json",
								function(data) {
									$("#condition").html(data.current_observation.weather)
									$("#temp_f").html(data.current_observation.temp_f)
									$("#wind_dir").html(data.current_observation.wind_dir)
									$("#wind_mph").html(data.current_observation.wind_mph)
								});
					});

		});
$(function() {

			$("#lookupButton").click(
					function() {
						$.get("https://api.themoviedb.org/3/discover/movie?api_key=c9bd9d09ec5086253a01a6d67f5a1a75&language=en-US&primary_release_year=2016&with_genres=18",
										// + $("#genre").val() 

								function(data) {
									for (var i = 0; i < data.results.length; i++) {
										data[i];

										var id = data.results[i].id;
										// console.log('id : ', id);

										var title = data.results[i].title;
										// console.log('title : ', title);

										var vote_average = data.results[i].vote_average;
										// console.log('vote_average : ', vote_average);

										var backdrop_path = data.results[i].backdrop_path;
										// console.log('backdrop_path : ', backdrop_path);

										var overview = data.results[i].overview;
										// console.log('overview : ', overview);

										$("#movieDisplay").append(
												
										 		// '<td>' + "Name:" + '</td><td>' + id + '</td>' + "Title:   "
										 		// 		+ title + '<hr>' + "Vote Average:   "
										 		// 		+ vote_average + '<hr>'
										 		// 		+ "Path:    " + backdrop_path + '<hr>' + "Overview   " + overview + '<hr>'
										 		// 		+ '<hr><br><br>'

										 		// 		'<tr><th>' + "ID" + '</th><th>' + "Title" + '</th><th>' + "Vote Average" + '</th><th>' + "Backdrop Path" + '</th><th>' + "Overview" + '</th></tr>'
										 				'<tr><th>' + id + '</th><th>' + title + '</th><th>' + vote_average + '</th><th>' + backdrop_path + '</th><th>' + overview + '</th></tr>'
										);


									}
								});
					})
})