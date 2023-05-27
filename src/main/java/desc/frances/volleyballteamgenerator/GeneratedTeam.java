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
    
    //number of players on the team to be generated
    private int playerCount;
    //number of available players
    private static int availableCount;
    //list of players in the generated team
    private static ArrayList<Player> playerList;
    //skills that the players of the generated team need to have and the number of players that have to posses them 
    private static ArrayList<Skill> neededSkills;
    
    //constructor for the generaed team; the whole class is written to return an a ready to use generated team object
    public GeneratedTeam(ArrayList<Player> availablePlayers, int playerCount, int availableCount) {
        neededSkills = new ArrayList<Skill>(
            Arrays.asList( 
                    new Skill("set", 2), 
                    new Skill("receive", 3),
                    new Skill("offence", 2)));
        this.availableCount = availableCount;
        playerList = new ArrayList<>();
        this.playerCount = playerCount; 
        generateTeam(availablePlayers, playerCount);
    }
    

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
    //generates the player list and saves it to the playerList ArrayList
    private static void generateTeam(ArrayList<Player> availablePlayers, int playerCount){
        //main algorithm
        addPlayers(availablePlayers, playerCount);
        //if the available players hit 0 while in the function, that could imply that there are less people than the needed number, so the algorithm is repeated;
        //right now just results in the first n players being added to the last team
        if (availableCount==0) addPlayers(availablePlayers, playerCount);

    }
    //main algorithm
    private static void addPlayers(ArrayList<Player> availablePlayers, int playerCount){
        //first adds the players that have a needed skill
        addWithSkills(availablePlayers, playerCount);
        //if there is not enough players after the addWithSkills() function, adds players regardless of skills
        addWithoutSkills(availablePlayers, playerCount);
    }
    //loops through the needed skills for ther new team; continues to the next skill if the counter of the given skill is 0
    private static void addWithSkills(ArrayList<Player> availablePlayers, int playerCount){
        for(Skill skill : neededSkills)
        {
            checkIfSkillCovered(skill);
            for(Player player: availablePlayers)
            {
                //breaks the loop if the needed skill is found as many times as needed
                if (!(skill.neededNumber > 0)) break;
                //breaks the loop if the player list is as big as the number of players needed
                if(playerList.size() >= playerCount) break;
                //continues if a player is taken and if there are enough available players; 
                //stops checking if player is taken if a team needs more members than the number of available players
                if (availableCount>0 && player.isTaken() ) continue;
                //add a player if the required skill is there; decrements counters and sets the player as taken
                if(player.hasSkill(skill.name)){
                    skill.neededNumber--;
                    playerList.add(player);
                    availableCount --;
                    player.setTaken(true); 
                } 
            }
        }
    }
    
    //adds players regardless of skills
    private static void addWithoutSkills(ArrayList<Player> availablePlayers, int playerCount) {
        for(Player player: availablePlayers)
        {
            if(!(playerList.size() < playerCount)) break;
            if (availableCount > 0 && player.isTaken()) continue;
            playerList.add(player);
            availableCount --;
            player.setTaken(true);
        }
    
    }
    private static void checkIfSkillCovered(Skill skill){
        for(Player player : playerList){
            if(player.hasSkill(skill.name)){
                if (!(skill.neededNumber > 0)) break;
                skill.neededNumber --;
            }
        }
    }
    
}
