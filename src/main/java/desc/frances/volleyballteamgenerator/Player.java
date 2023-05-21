/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desc.frances.volleyballteamgenerator;

import java.util.ArrayList;

/**
 *
 * @author slasherer
 */
public class Player {
    private String name;
    private ArrayList<String> skills;
    private boolean taken;

    public Player(String name, ArrayList<String>  skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String>  getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
    public boolean hasSkill(String skillToFind){
        for(String skill : this.skills){
            if(skill.equals(skillToFind)) return true;
        }
        return false;
    }
    
}
