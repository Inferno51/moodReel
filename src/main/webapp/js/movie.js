$(function() {

			$("#lookupButton").click(
					function() {
						$.get('https://api.themoviedb.org/3/discover/movie?api_key=c9bd9d09ec5086253a01a6d67f5a1a75&language=en-US&primary_release_year=2016&with_genres='
										+ $("#genre").val() ,
								function(data) {
									for (var i = 0; i < data.results.length; i++) {
										data[i];

										var id = data.results[i].id;
										console.log('id : ', id);

										var title = data.results[i].title;
										console.log('title : ', title);

										var vote_average = data.results[i].vote_average;
										console.log('vote_averagey : ', vote_average);

										var backdrop_path = data.results[i].backdrop_path;
										console.log('backdrop_path : ', backdrop_path);

										var overview = data.results[i].overview;
										console.log('overview : ', overview);


										// $('body').append(
										// 		"Name:   " + id + '<hr>' + "Title:   "
										// 				+ title + '<hr>' + "Vote Average:   "
										// 				+ vote_average + '<hr>'
										// 				+ "Path:    " + backdrop_path + '<hr>' + "Overview   " + overview + '<hr>'
										// 				+ '<hr><br><br>');
									}
								});
					})
})