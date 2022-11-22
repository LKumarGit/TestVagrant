package com.main.base;


import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 public class ReadDataFromJSONFile {

	
	public JSONObject readJsonFile(String jsonFilePath) throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(jsonFilePath);
		Object obj = jsonParser.parse(reader);
		JSONObject jsonobj = (JSONObject)obj; 
		
		return jsonobj;
		
	}
}
