$(function() {

			$("#lookupButton").click(
					function() {
						
							
						$.get("https://api.themoviedb.org/3/discover/movie?api_key=c9bd9d09ec5086253a01a6d67f5a1a75&language=en-US&primary_release_year=2016&with_genres=18",
										// + $("#genre").val() 

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
								        txt += '<table><tr><th>' + id + '</th><img src="https://image.tmdb.org/t/p/w92' + backdrop_path + '"></img><th>' + title + '</th><th>' + vote_average + '</th><th>' + overview + '</th></tr>';
								        htmlElements += '<div id="div1">' + txt + '</div>';
								    }
								    var div1 = document.getElementById("div1");
								    div1.innerHTML = htmlElements;
					
										
									
								});
					})
})