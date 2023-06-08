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
    static String test = "[{\"name\":\"Moris\",\"skills\":[\"offence\",\"serve\"]},{\"name\":\"Jivko\",\"skills\":[\"offence\",\"serve\",\"set\",\"receive\"]},{\"name\":\"Stelyo\",\"skills\":[\"offence\",\"serve\",\"receive\"]},{\"name\":\"Moritz\",\"skills\":[\"serve\",\"offence\"]},{\"name\":\"Berni\",\"skills\":[\"offence\",\"receive\"]},{\"name\":\"Sophie\",\"skills\":[\"set\",\"receive\",\"offence\",\"serve\"]},{\"name\":\"Sasho B.\",\"skills\":[\"offence\",\"serve\"]},{\"name\":\"Kristina\",\"skills\":[\"\"]},{\"name\":\"Drago\",\"skills\":[\"offence\"]},{\"name\":\"Borislava\",\"skills\":[\"receive\"]},{\"name\":\"Dimitar.\",\"skills\":[\"offence\",\"serve\",\"receive\"]},{\"name\":\"Niki\",\"skills\":[\"offence\",\"set\",\"serve\",\"receive\"]},{\"name\":\"Viki\",\"skills\":[\"offence\"]},{\"name\":\"Ivan B.\",\"skills\":[\"offence\",\"set\",\"serve\"]},{\"name\":\"Ivan\",\"skills\":[\"offence\",\"serve\"]},{\"name\":\"Asen\",\"skills\":[\"set\",\"receive\",\"offence\",\"serve\"]},{\"name\":\"Stefan\",\"skills\":[\"offence\",\"receive\"]},{\"name\":\"BorislavaFr\",\"skills\":[\"\"]},{\"name\":\"Ivan B. Fr 1 \",\"skills\":[\"\"]},{\"name\":\"Ivan B. Fr 2 \",\"skills\":[\"\"]},{\"name\":\"Ivan B. Fr 3 \",\"skills\":[\"\"]},{\"name\":\"Hristian\",\"skills\":[\"serve\",\"set\",\"receive\"]},{\"name\":\"Marlene\",\"skills\":[\"receive\"]},{\"name\":\"Sasho\",\"skills\":[\"set\",\"receive\"]}]";
    
    public static ArrayList<Player> convertPlayerJsonToList(String playerJson){
        ArrayList<Player> playerList = new ArrayList<Player>();
        String jsonResponse = playerJson.toString();
        JsonReader jsonReader = Json.createReader(new StringReader(jsonResponse));
        JsonArray array = jsonReader.readArray();
        jsonReader.close();
        
        for (JsonValue object : array){
            String name = ((JsonObject)object).get("name").toString();
            ArrayList<String> skills = new ArrayList<String>();
            for(JsonValue skill : (JsonArray)((JsonObject)object).get("skills")){
                skills.add(skill.toString());
            }
            playerList.add(new Player(name, skills));
        }
        for(Player p : playerList){
            System.out.println(p.getName());
        }
        return playerList;
    
    }
    
    public static void main(String[] args) {
        convertPlayerJsonToList(test);
    }
}
