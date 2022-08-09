package Earthquakedata;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

import javaobjects.Features;
import javaobjects.MainObject;

public class GetEarthquakeData {

	public static void main(String[] args) {
		USGSApi ob =new USGSApi();
		String JSON = ob.response.asString();
//		System.out.println(JSON);
		
		//Pattern pattern=Pattern.compile("");//It gives all the palce where earthquakes occurs
		Pattern pattern=Pattern.compile("Pune|pune|Bijapur");//It only gives the place mentioned
		MainObject ob1=new Gson().fromJson(JSON, MainObject.class);
		List<Features> features=ob1.features;
		for(Features feature:features)
		{
			Matcher matcher=pattern.matcher(feature.properties.place);
			if(matcher.find()==true)
			{
				System.out.println("Earthquake in " + feature.properties.place);
			}
			//System.out.println(feature.properties.place);
			//System.out.println(feature.properties.mag);
			
		}
	}
}
