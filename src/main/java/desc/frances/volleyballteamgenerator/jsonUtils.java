/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desc.frances.volleyballteamgenerator;
import javax.json.Json;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.ArrayList;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;

/**
 *
 * @author slasherer
 */
public class jsonUtils {

    public static ArrayList<Player> convertPlayerJsonToList(String playerJson){
        ArrayList<Player> playerList = new ArrayList<Player>();
        String jsonResponse = playerJson.toString();
        JsonReader jsonReader = Json.createReader(new StringReader(jsonResponse));
        JsonArray array = jsonReader.readArray();
        jsonReader.close();
        
        for (JsonValue object : array){
            String name = ((JsonObject)object).get("name").toString().replaceAll("\"", "");
            ArrayList<String> skills = new ArrayList<String>();
            for(JsonValue skill : (JsonArray)((JsonObject)object).get("skills")){
                skills.add(skill.toString().replaceAll("\"", ""));
            }
            playerList.add(new Player(name, skills));
        }
        return playerList;
    
    }
   
}
