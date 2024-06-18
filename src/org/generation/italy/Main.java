package org.generation.italy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * SECONDO ESERCIZIO
		 * 
		 * Scrivere una classe “Recensione” che contiene i seguenti attributi: LocalDate
		 * data String nomeUtente int numeroStelle String testo e opportuni metodi
		 * costruttore, getters, setters, facendo in modo che non si possa creare
		 * un’istanza non valida di Recensione (ad esempio il numero di stelle deve
		 * essere compreso tra 1 e 5)
		 */

		/*
		 * TERZO ESERCIZIO
		 * 
		 * Scrivere una classe MobileApp contenente 
		 * i seguenti attributi: 
		 * nome: stringa
		 * sistemaOperativo: stringa 
		 * prezzo: float 
		 * elencoRecensioni: ArrayList di Recensione 
		 * ricavoTotale: float
		 *  e i seguenti metodi: MobileApp(String nome, String sistemaOperativo, float prezzo) (costruttore della classe: inizializza
		 * gli attributi nome, sistemaOperativo, prezzo in base ai parametri passati
		 * verificando la validità dei parametri; 
		 * inizializza elencoRecensioni,
		 * numeroValutazioni, 
		 * ricavoTotale a 0) download(): incrementa il ricavoTotale del valore del prezzo download(int numeroDownload): incrementa il
		 * ricavoTotale del valore del prezzo*numeroDownload riceviRecensione(Recensione
		 * recensione): l'app riceve una nuova recensione float valutazioneMedia():
		 * restituisce la media delle recensioni ricevute finora (nr stelle) getter e
		 * setter (verificare la validità dei dati dei parametri dei setter) Nella
		 * classe Main: ◦ chiedere all'utente di inserire nome, sistemaOperativo, prezzo
		 * dell'app ◦ creare un oggetto della classe MobileApp passando al costruttore i
		 * parametri inseriti dall'utente ◦ creare un menu con le seguenti voci: ▪
		 * download singolo ▪ download multiplo (in questo caso chiedere all'utente il
		 * numero di download da effettuare) ▪ ricevi recensione (in questo caso
		 * chiedere all'utente il nome, il stelle da assegnare, il testo della
		 * recensione; impostare la data automaticamente al giorno corrente) ▪
		 * visualizza recensioni ▪ esci ◦ dopo ogni chiamata ad una voce di menu
		 * visualizzare i dati della mobile app (valutazione media, ricavo totale)
		 */
			
			//INIZIALIZZO VARIABILI
		
			String nomeApp = new String();
			String nomeSistemaOperativo = new String();
			float prezzo;
			boolean appFatta=false;
			MobileApp app;
			String scelta;
			int nDownload, numeroStelle;
			String nomeUtente = new String();
			String testo = new String();
			String oggettoRec = new String();
			Recensione r;
			ArrayList<Recensione> elencoRecensioni;
			String ricavo = new String();
			Scanner sc=new Scanner(System.in);

			
			System.out.print("Benvenuto! ");
			
			
			//APRO UN CICLO PER LA CREAZIONE DELL'APP
			do {
				try {
					System.out.println("Crea la tua App!");
					System.out.print("Digita il suo nome: ");
					nomeApp = sc.nextLine();
					System.out.print("Inserire il nome del sistema operativo dell'App: ");
					nomeSistemaOperativo = sc.nextLine();
					System.out.print("Inserisci il prezzo di vendita:  ");
					prezzo = Float.parseFloat(sc.nextLine());
					
					//CREAZIONE APP
					app = new MobileApp(nomeApp, nomeSistemaOperativo, prezzo);
					System.out.println("Applicazione creata con successo!");
					appFatta=true;
					
					
					// MENU APP
					do {
						System.out.println("\n\nMenù di gestione dell'applicazione: "+app.getNome());
						System.out.println("Scegliere l'azione da eseguire con il numero associato");
						System.out.println("1) Download applicazione\n"
								+ "2) Download multiplo\n"
								+ "3) Ricevi recensione\n"
								+ "4) Visualizza recensioni\n"
								+ "5) ESCI");
						scelta = sc.nextLine();
						
						switch (scelta) {
						case "1":
							System.out.println("\nDownload dell'applicazione in corso...");
							app.download();
							System.out.println("Download completato!");
							break;
							
							
						case "2":
							System.out.println("\nQuanti download vuoi compiere?");
							nDownload=Integer.parseInt(sc.nextLine());
							System.out.println("Download multipli dell'applicazione in corso...");
							try {
								app.download(nDownload);
								System.out.println("Download completati!");
							} catch (Exception e) {
								System.err.println("ATTENZIONE! "+e.getMessage());
							}
							break;
							
						case "3":
							System.out.print("Inserire il numero delle stelle: ");
							numeroStelle = Integer.parseInt(sc.nextLine());
							System.out.println("\nInserimento recensione.");
							System.out.print("Inserire il nome utente: ");
							nomeUtente = sc.nextLine();
							System.out.println("Inserire il commento alla recensione (facoltativo):");
							oggettoRec=sc.nextLine();
							try {
								if (oggettoRec.isBlank()&& testo.isBlank()) {
									r = new Recensione (numeroStelle, nomeUtente);
								}else if (oggettoRec.isBlank()) {
									r = new Recensione (numeroStelle, nomeUtente,testo);
								} else {
									r = new Recensione (numeroStelle, nomeUtente, oggettoRec, testo);
								}
								app.riceviRecensione(r);
								System.out.println("Recensione aggiunta con successo!");
							} catch (Exception e) {
								System.err.println("Inserimento non riuscito! "+e.getMessage());
							}
							break;
							
						case "4":
							if (app.getNumRecensioni()>0) {
								//ci sono delle recensioni dell'app
								System.out.println("Ecco le recensioni ricevute fino ad ora:");
								//ciclo for in cui mostro le varie recensioni
								elencoRecensioni = new ArrayList<Recensione>();
								elencoRecensioni = app.getElencoRecensioni();
								for (int i = 0; i < app.getNumRecensioni(); i++) {
									System.out.println("Numero "+(i+1)+":");
									System.out.println(elencoRecensioni.get(i).toString());
									System.out.println();
								}
								
							} else {
								//RECENSIONI NON PRESENTI
								System.out.println("Non ci sono recensioni dell'applicazione");
							}
							break;
							
						case "5":
							System.out.println("Arrivederci!");
							break;
						default:
							System.out.println("Inserimento non valido!");
						}
						//STATO DELL'APPLICAZIONE FINCHE' L'UTENTE NON ESCE 
						if (!scelta.equals("5")) {
							System.out.println("\nValutazione media dell'app: "+app.valutazioneMedia());
							ricavo = String.format("%.2f", app.getRicavoTotale());
							System.out.println("Ricavo totale dell'app: "+ricavo+"€");
							System.out.println("\n\nPremere INVIO per continuare");
							sc.nextLine();
						}
					} while (!scelta.equals("5"));
					
				} catch (Exception e) {
					System.err.println("ATTENZIONE!! "+e.getMessage());
				}
			} while (!appFatta);
			
			sc.close();
		}

	}


