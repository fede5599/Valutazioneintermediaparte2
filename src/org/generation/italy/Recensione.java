package org.generation.italy;

import java.time.LocalDate;

public class Recensione {
	private String nomeUtente, testo, oggettoRec;
	private int numeroStelle;
	private LocalDate data;

	/*
	 * Requisiti di una recensione:
	 * 
	 * - Le stelle di gradimento - Inserire il nome/nickname dell'utente che fa la
	 * recensione - Si può inserire anche un titolo oggetto (oggettoRec) -
	 * Inserimento testo (testo) - la data della recensione (local date)
	 * 
	 * ci proviamo....
	 */

	// PRIMO METODO COSTRUTTORE CON TUTTI GLI ELEMENTI
	public Recensione(int numeroStelle, String nomeUtente, String oggettoRec, String testo)
			throws Exception {
		
		// CONTROLLO VALIDITA NUMERO STELLE INSERITE
		if (numeroStelle < 1 || numeroStelle > 5) // stelle da 1 a 5
			this.numeroStelle = numeroStelle;
		else
			throw new Exception("il numero di stelle deve essere un numero tra 1 e 5");
		
		
		// CONTROLLO VALIDITA NOME INSERITO
		if (!nomeUtente.isBlank())
			this.nomeUtente = nomeUtente;
		else
			throw new Exception("nome utente il campo non può essere vuoto");

		if (!oggettoRec.isBlank())
			this.oggettoRec = oggettoRec;
		else
			throw new Exception("Oggetto recensione il campo non può essere vuoto");

		if (!testo.isBlank())
			this.testo = testo;
		else
			throw new Exception("Inserisci il testo il campo non può essere vuoto");

		//IMPOSTO LA DATA CORRENTE
				data=LocalDate.now();
	}
	
	// SECONDO METODO COSTRUTTORE SENZA L'OGGETTO MA CON IL TESTO
		public Recensione(int numeroStelle, String nomeUtente, String testo)
				throws Exception {
			
			// CONTROLLO VALIDITA NUMERO STELLE INSERITE
			if (numeroStelle < 1 || numeroStelle > 5) // stelle da 1 a 5
				this.numeroStelle = numeroStelle;
			else
				throw new Exception("il numero di stelle deve essere un numero tra 1 e 5");
			
			
			// CONTROLLO VALIDITA NOME INSERITO
			if (!nomeUtente.isBlank())
				this.nomeUtente = nomeUtente;
			else
				throw new Exception("nome utente il campo non può essere vuoto");

				this.oggettoRec = "NESSUN OGGETTO";
			

			if (!testo.isBlank())
				this.testo = testo;
			else
				throw new Exception("Inserisci il testo il campo non può essere vuoto");

			//IMPOSTO LA DATA CORRENTE
					data=LocalDate.now();
		}
		
		// TERZO METODO COSTRUTTORE SENZA L'OGGETTO E IL TESTO
				public Recensione(int numeroStelle, String nomeUtente)
						throws Exception {
					
					// CONTROLLO VALIDITA NUMERO STELLE INSERITE
					if (numeroStelle < 1 || numeroStelle > 5) // stelle da 1 a 5
						this.numeroStelle = numeroStelle;
					else
						throw new Exception("il numero di stelle deve essere un numero tra 1 e 5");
					
					
					// CONTROLLO VALIDITA NOME INSERITO
					if (!nomeUtente.isBlank())
						this.nomeUtente = nomeUtente;
					else
						throw new Exception("nome utente il campo non può essere vuoto");

						this.oggettoRec = "NESSUN OGGETTO";
					
						this.testo = "NESSUN COMMENTO INSERITO";

					//IMPOSTO LA DATA CORRENTE
							data=LocalDate.now();
				}
		
	
	
	// CHIUSURA COSTRUTTORE

	
	// GENERO GETTER E SETTER

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public String getOggettoRec() {
		return oggettoRec;
	}

	public void setOggettoRec(String oggettoRec) {
		this.oggettoRec = oggettoRec;
	}

	public int getNumeroStelle() {
		return numeroStelle;
	}

	public void setNumeroStelle(int numeroStelle) {
		this.numeroStelle = numeroStelle;
	}

	@Override
	public String toString() {

		return "Recensione [Numero Stelle=" + numeroStelle + ", Nome Utente=" + nomeUtente + ", Oggetto Recensione="
				+ oggettoRec + ", Testo=" + testo + ", Data=" + data + "]";
	}

}
