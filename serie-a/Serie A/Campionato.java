/*
Campionato Java
Galdini Matteo 4CIN 17/10/2024
*/

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Campionato{
    
    //Attributi 
	int squadre_presenti;
	int DIM;
	int i;
	String rteam, mteam;

    //Dichiaro teams
    Team[] teams;
    
    //Costruttore
    public Campionato(String file){

		//DIM
		//DIM = file.length();
		DIM = 20;

		i = DIM;

        //Creo teams
        teams = new Team[DIM];
        
        try{ //Se trova il file
        
            // Creo file e Scanner
    	    File f = new File (file);
    	    Scanner scan = new Scanner (f);
    	    
    	    //For per prendere le squadre
    	    for (int i = 0; i<DIM && scan.hasNextLine(); i++){
    	        String Line = scan.nextLine();
    	        teams[i] = new Team(Line);
				squadre_presenti = i;
    	    }
    	    
    	    //Chiusura scanner
    	    scan.close();
    	    
	    } catch ( /*FileNotFound*/ Exception e) { //In caso non trovi il file
	        System.out.println("No such file found " + e.getMessage());
	    } 
    }
    
    //Metodi 
    
    public String toString(){
        String s = "\nTeams in Serie A 2024/2025: \n";
        for (Team t : teams){
	        s+=t+"\n";
	    }
	    return s;
    }

	public void aggiungiTeam(Scanner scan){
		if (squadre_presenti + 1 >= DIM){
			System.out.println("Errore: Non si possono aggiungere altre squadre");
			return;
		}
		System.out.print("Inserisci squadra: ");
		String newteam = scan.nextLine();
		//newteam = newteam.toUpperCase();;
		squadre_presenti += 1;
		teams[squadre_presenti] = new Team(newteam);
	}

	public void rimuoviUltimoteam(){
		i--;
		if (i <= 0){
			System.out.println("Errore: Non ci sono squadre");
			return;
		}
		System.out.println("Squadra [" + teams[i] + "] rimossa");
		teams[i] = null;
	}

	public void rimuoviTeam(int posizione) {
		if (posizione < 0 || posizione >= DIM - 1){
			System.out.println("Errore: Posizione non valida");
			return;
		}
		System.out.println("Squadra [" + teams[posizione] + "] rimossa");
		teams[posizione] = null;
		for (int i = posizione + 1; i < teams.length; i++){
			teams[i - 1] = teams[i];
		}
		i = i - 1;
	}

	public void modificaTeam(int posizione, Scanner scan){
		if (posizione < 0 || posizione >= DIM - 1){
			System.out.println("Errore: Posizione non valida");
			return;
		}
		mteam = scan.nextLine();
		System.out.println("Squadra [" + teams[posizione] + "] modificata");
		teams[posizione] = new Team(mteam);
		i = i - 1;
	}
    
    
}