package com.tiyssa;

public class MovieGenreWeatherMethods {

	static String[] rainList = { "drizzle", "rain", "mist", "spray", "squals", "showers" };
	static String[] cloudyList = { "haze", "thunderstorm", "cloud", "overcast", "cloudy" };
	static String fogList = "fog";
	static String[] hailList = { "crystals", "ice", "hail", "thunderstorms and ice", "thunderstorms with hail" };
	static String[] snowList = { "snow", "thunderstorms and snow" };
	static String clearList = "clear";
	static String[] otherList = { "smoke", "ash", "sand", "dust", "funnel", "unknown" };
	static String weather = null;
	static String condition = null;

	public static String weatherConditions(String weather) {

		weather = weather.toLowerCase();

		do {
			for (int i = 0; i < hailList.length; i++) {
				if (weather.contains(hailList[i])) {
					condition = "hail";
					break;
				}
			}
			for (int i = 0; i < snowList.length; i++) {
				if (weather.contains(snowList[i])) {
					condition = "snowy";
					break;
				}
			}

			for (int i = 0; i < rainList.length; i++) {
				if (weather.contains(rainList[i])) {
					condition = "rain";
					break;
				}
			}

			for (int i = 0; i < cloudyList.length; i++) {
				if (weather.contains(cloudyList[i])) {
					condition = "cloudy";
					break;
				}
			}

			for (int i = 0; i < otherList.length; i++) {
				if (weather.contains(otherList[i])) {
					condition = "other";
					break;
				}
			}

			if (weather.contains(fogList)) {
				condition = "fog";
				break;
			}

			if (weather.contains(clearList)) {
				condition = "clear";
				break;

			}

		} while (condition == null);

		return condition;

	}
}