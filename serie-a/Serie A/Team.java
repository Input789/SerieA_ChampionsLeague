/*
Team Java
Galdini Matteo 4CIN 17/10/2024
*/


public class Team {
    
    //Attributi
    private String name;
    
    //Costruttore
    public Team (String name){
        this.name = name;
    }
    
    
    //Metodi   
    
    //Getter   
    public String getName(){
        return name;
    }
    
    
    //To String
    public String toString(){
        return "Squadra: " + name;
    }
}