/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package desc.frances.volleyballteamgenerator;

import static desc.frances.volleyballteamgenerator.GeneratedTeam.generateTeam;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author slasherer
 */
public class VolleyballTeamGenerator {
    private static int availableCount;
    private static int numOfTeamMembers = 0;
    private static ArrayList<Player> availablePlayers;
    private static ArrayList<GeneratedTeam> teams = new ArrayList<>();
    
   private static void initAvailablePlayers(){
        availablePlayers = new ArrayList<Player>();
        availablePlayers.add(new Player("Moris", new ArrayList<String>(Arrays.asList("offence", "serve"))));
        availablePlayers.add(new Player("Asen", new ArrayList<String>(Arrays.asList("set", "receive","offence", "serve"))));
        availablePlayers.add(new Player("Borislava", new ArrayList<String>(Arrays.asList("receive"))));
        availablePlayers.add(new Player("Stelyo", new ArrayList<String>(Arrays.asList("offence", "serve", "receive"))));
        availablePlayers.add(new Player("Kristina", new ArrayList<String>(Arrays.asList(""))));
        
        availablePlayers.add(new Player("Ivan B.", new ArrayList<String>(Arrays.asList("offence", "receive", "set", "serve"))));
        availablePlayers.add(new Player("Stefan", new ArrayList<String>(Arrays.asList("serve", "set", "receive"))));
        availablePlayers.add(new Player("Hristian", new ArrayList<String>(Arrays.asList("serve", "set", "receive"))));
        availablePlayers.add(new Player("Marlene", new ArrayList<String>(Arrays.asList( "receive"))));
        availablePlayers.add(new Player("Nasko", new ArrayList<String>(Arrays.asList("offence", "serve", "set", "receive"))));
        
        availablePlayers.add(new Player("Sasho", new ArrayList<String>(Arrays.asList("set", "receive"))));
        availablePlayers.add(new Player("Drago", new ArrayList<String>(Arrays.asList("offence"))));
        availablePlayers.add(new Player("Ivan", new ArrayList<String>(Arrays.asList("offence"))));
        availablePlayers.add(new Player("Sasho B.", new ArrayList<String>(Arrays.asList("offence"))));
        Collections.shuffle(availablePlayers);
        availableCount = availablePlayers.size();
   }
    public static void main(String[] args) {
        numOfTeamMembers = 6;
        initAvailablePlayers();
        
        for(int i=1 ; i<3 ; i++){
            //if (availableCount < numOfTeamMembers) initAvailablePlayers();
            GeneratedTeam team = new GeneratedTeam(availablePlayers, numOfTeamMembers, availableCount);
            availableCount = availableCount - numOfTeamMembers;
            teams.add(team);
            
            System.out.println("\nTeam Number " + i + ":");
                for(Player player: team.getPlayerList()){
                    System.out.println("    Player Name: " + player.getName());
                    
                    String skillString = "";
                    for(String skill : player.getSkills()){
                        skillString = skillString + skill + " ";
                    }
                    System.out.println("         Relevant Skills: " + skillString);   
                }
            }
        }


        
    }
    

    
}