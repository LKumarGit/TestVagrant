package com.test.cricket;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.main.base.ReadDataFromJSONFile;
import com.main.base.TestBase;





public class PlayersSelection extends TestBase{

	TestBase base;
	String jsonfolderpath;
	String jsonfilename;
	String jsonfilepath;
	
	@BeforeMethod
	public void setUp()
	{
		base = new TestBase();
	    jsonfolderpath = prop.getProperty("JSONFolderPath");
		jsonfilename = prop.getProperty("JSONFileRCB");
		jsonfilepath = jsonfolderpath + jsonfilename;
	}
	
	@Test
	public void verifyForeignPlayers() throws IOException, ParseException
	{
		ReadDataFromJSONFile readJson = new ReadDataFromJSONFile();
		JSONObject teamobj=readJson.readJsonFile(jsonfilepath);
        JSONArray players = (JSONArray)teamobj.get("player");
        int NumOfForeignPlayers = 0;
		
		for(int i=0; i< players.size();i++)
		{
			JSONObject player_details = (JSONObject)players.get(i);
			String player_country = (String)player_details.get("country");
			if(!(player_country.equals("India")))
			{
				NumOfForeignPlayers++;
			}
		}
		Assert.assertEquals(NumOfForeignPlayers, 4);
	}
	
	@Test
	public void verifyWicketKeeper() throws IOException, ParseException
	{
		ReadDataFromJSONFile readJson = new ReadDataFromJSONFile();
		JSONObject teamobj=readJson.readJsonFile(jsonfilepath);
        JSONArray players = (JSONArray)teamobj.get("player");
        int NumOfWicketKeeper = 0;
		
		for(int i=0; i< players.size();i++)
		{
			JSONObject player_details = (JSONObject)players.get(i);
			String player_role = (String)player_details.get("role");
			if(player_role.equals("Wicket-keeper"))
				NumOfWicketKeeper++;
		}
		Assert.assertEquals(NumOfWicketKeeper, 1);
	}
}
