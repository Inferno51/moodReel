package com.tiyssa;



	import java.util.ArrayList;
	import java.util.Scanner;

	public class MovieGenreWeatherMethods {

		static String[] rainList = {"Drizzle","Rain","Mist","Spray","Squals"};
		static String[] cloudyList = {"Haze","Thunderstorm","Cloud","Overcast"};
		static String fogList = "Fog";
		static String[] hailList = {"Crystals","Ice","Hail","Thunderstorms and Ice","Thunderstorms with Hail"};
		static String[] snowList = {"Snow","Thunderstorms and Snow"};
		static String clearList = "Clear";
		static String[] otherList = {"Smoke","Ash","Sand","Dust","Funnel","Unknown"};
		static String weather = null;
		static Scanner sc = new Scanner(System.in) ;                                                        
		
		public static String weatherConditions(String weather){
	//	public static void main(String[] args) {
			
	//	weather = sc.nextLine();
			String condition = "Snow";
		

//		do {
//			for(int i = 0; i < hailList.length; i++){
//				if(weather.contains(hailList[i])){
//					condition = "Hail";
//				}
//			}
//			for(int i = 0; i < snowList.length; i++){
//				if(weather.contains(snowList[i]) ){
//					condition = "Snow";
//				}
//			}
//			for(int i = 0; i < cloudyList.length; i++){
//				if(weather.contains(cloudyList[i]) ){
//					condition = "Cloudy";
//				}
//			}
//			for(int i = 0; i < rainList.length; i++){
//				if(weather.contains(rainList[i]) ){
//					condition = "Rain";
//				}
//			}
//			for(int i = 0; i < otherList.length; i++){
//				if(weather.contains(otherList[i]) ){
//					condition = "Other";
//				}
//			}
//			
//				if(weather.contains(fogList) ){
//					condition = "Fog";
//				}
//				if(weather.contains(clearList) ){
//					condition = "Clear";
//				}
//			
//		} while (condition == null);
		return condition;
	//	System.out.println(condition);
	}
	
}
