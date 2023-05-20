/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desc.frances.volleyballteamgenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author slasherer
 */
public class GeneratedTeam {
    
    
    private int playerCount;
    private static int availableCount;
    private static ArrayList<Player> playerList;
    private static ArrayList<Skill> neededSkills = new ArrayList<Skill>(
            Arrays.asList(new Skill("receive", 3), 
                    new Skill("set", 2), 
                    new Skill("offence", 2)));
    
    
    public GeneratedTeam(ArrayList<Player> availablePlayers, int playerCount, int availableCount) {
        this.availableCount = availableCount;
        playerList = new ArrayList<>();
        this.playerCount = playerCount; 
        generateTeam(availablePlayers, playerCount);
    }
    

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
    public static void generateTeam(ArrayList<Player> availablePlayers, int playerCount){
        
        
        loopPlayers(availablePlayers, playerCount);
        if (availableCount==0) loopPlayers(availablePlayers, playerCount);
        
        
        
    }
    
    private static void loopPlayers(ArrayList<Player> availablePlayers, int playerCount){
        for(Skill skill : neededSkills)
        {
            
            
            for(Player player: availablePlayers)
            {
                if (!(skill.neededNumber > 0)) break;
                if(playerList.size() >= playerCount) break;
                if ( availableCount>0 && player.isTaken() ) continue;

                if(hasSkill(skill.name, player)){
                    skill.neededNumber--;
                    playerList.add(player);
                    availableCount --;
                    player.setTaken(true); 
                } 
            }
        }

        for(Player player: availablePlayers)
        {
            if(!(playerList.size() < playerCount)) break;
            if (availableCount > 0 && player.isTaken()) continue;
            playerList.add(player);
            availableCount --;
            player.setTaken(true);
        }
    }
    public static boolean hasSkill(String skillToFind, Player player){
            for(String skill : player.getSkills()){
                if(skill.equals(skillToFind)){
                    return true;
                }
            }
            return false;
    }
    
    
    
}
