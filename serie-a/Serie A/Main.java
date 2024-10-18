/*
Serie A Java
Galdini Matteo 4CIN 17/10/2024
*/

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	    
	    Campionato seriea = new Campionato ("files/seriea.csv");
		Campionato championsleague = new Campionato ("files/championsleague.csv");

		stampaMenu();

		Scanner scanner = new Scanner(System.in);
		int selezione, s, posizione;
		do{

			//Fa la cosa che dice l'untente finchè non viene chiuso il programma
			System.out.print("Selezione: ");
			selezione = scanner.nextInt();
			scanner.nextLine();

			//switch
			switch (selezione){

				default:
					break;
				case 1:
					System.out.println("1) Serie A");
					System.out.println("2) Champions League");
					s = scanner.nextInt();
					scanner.nextLine();
					if (s == 1)System.out.println(seriea.toString());
					else if (s == 2)System.out.println(championsleague.toString());
					break;
				case 2:
					System.out.println("1) Serie A");
					System.out.println("2) Champions League");
					s = scanner.nextInt();
					scanner.nextLine();
					if (s == 1)seriea.aggiungiTeam(scanner);
					else if (s == 2)championsleague.aggiungiTeam(scanner);
					break;
				case 3:
					System.out.println("1) Serie A");
					System.out.println("2) Champions League");
					s = scanner.nextInt();
					scanner.nextLine();
					if (s == 1)seriea.rimuoviUltimoteam();
					else if (s == 2)championsleague.rimuoviUltimoteam();
					break;
				case 4:
					System.out.println("1) Serie A");
					System.out.println("2) Champions League");
					s = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Scegli squadra da eliminare: ");
					posizione = scanner.nextInt();
					if (s == 1)seriea.rimuoviTeam(posizione);
					else if (s == 2)championsleague.rimuoviTeam(posizione);
					break;
				case 5:
					System.out.println("1) Serie A");
					System.out.println("2) Champions League");
					s = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Scegli squadra da modificare: ");
					posizione = scanner.nextInt();
					if (s == 1)seriea.modificaTeam(posizione, scanner);
					else if (s == 2)championsleague.modificaTeam(posizione, scanner);
					break;
				case 6:
					break;
				case 99:
					stampaMenu();
			}

		}while(selezione!=0);

		scanner.close();


	    
	//System.out.println("Hello World");
	}
	public static void stampaMenu(){
		System.out.println("Menu: ");
		System.out.println("0) Chiudi il programma");
		System.out.println("1) Stampa squadre");
		System.out.println("2) Aggiungi squadra");
		System.out.println("3) Rimuovi ultima squadra");
		System.out.println("4) Rimuovi squadra a piacere");
		System.out.println("5) Modifica nome squadra");
		System.out.println("6) Salva modifiche");
		System.out.println("99) Stampa menu");
	}
}




// I file cvs sono file che contengono righe separate dalla virgola, dopo la virgola legge l'input dopo (1,2,3,4,5,6)
