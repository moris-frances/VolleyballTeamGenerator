/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package desc.frances.volleyballteamgenerator;


import static desc.frances.volleyballteamgenerator.jsonUtils.convertPlayerJsonToList;
import java.util.ArrayList;
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
    private static int numberOfTeams = 3;
    
   private static void initAvailablePlayers(String playerJson){
        availablePlayers = convertPlayerJsonToList(playerJson);
        Collections.shuffle(availablePlayers);
        availableCount = availablePlayers.size();
   }
    public static void main(String[] args) {
        numOfTeamMembers = Integer.parseInt(args[0]);
        numberOfTeams = Integer.parseInt(args[1]);
        initAvailablePlayers(args[2]);
        if(args[2]==null){
            System.out.println("NO PLAYERS");
            return;
        }
        for(int i=1 ; i<=numberOfTeams ; i++){
            GeneratedTeam team = new GeneratedTeam(availablePlayers, numOfTeamMembers, availableCount);
            availableCount = availableCount - numOfTeamMembers;
            teams.add(team);
            
            System.out.println("\nTeam Number " + i + ":");
                for(Player player: team.getPlayerList()){
                    System.out.println("    Player: " + player.getName());
                    
                    String skillString = "";
                    for(String skill : player.getSkills()){
                        skillString = skillString + skill + " ";
                    }
                    System.out.println("       Relevant Skills: " + skillString);   
                }
            }
        }


        
    }
    

    

