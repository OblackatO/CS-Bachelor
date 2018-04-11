package exercise5;

import com.google.gson.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.net.*;
import java.io.*;


public class Launcher {

	public static void main(String[] args) throws IOException{

		URL url = new URL("https://coast.uni.lu/teaching/programming1/team.xml");
		
		InputStream in_stream = url.openStream();
		
		XStream xstream = new XStream(new StaxDriver());
		xstream.alias("team", TeachingTeam.class) ;
		xstream.alias("teacher", Teacher.class); 
		xstream.alias("phone", PhoneNumber.class);
		
		
		TeachingTeam teachers = (TeachingTeam) xstream.fromXML(in_stream);
		
		System.out.println(teachers);
		
		
		/*
		 * I am not using the ObjectOutputStream to the serialization, but anyway why we do not 
		 * need a serialization number for the json serialization ?
		 */
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonRepresentation = gson.toJson(teachers);
		System.out.println("Serialization in json of teachers:");
		System.out.println(jsonRepresentation);
	}
}
