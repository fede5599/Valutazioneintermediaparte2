package org.generation.italy;

import java.util.ArrayList;

public class MobileApp {
	/*
	 * Scrivere una classe MobileApp contenente i seguenti attributi: nome: stringa
	 * sistemaOperativo: stringa prezzo: float elencoRecensioni: ArrayList di
	 * Recensione ricavoTotale: float
	 */

	// INSERIMENTO ATTRIBUTI
	private String nomeApp, sistemaOperativo;
	private float prezzo, ricavoTotale;
	private ArrayList<Recensione> elencoRecensioni;

	// CREAZIONE METODI
	public MobileApp(String nomeApp, String sistemaOperativo, float prezzo) 
			throws Exception {
		
		// CONTROLLO VALIDITA NOME APP
		if (!nomeApp.isBlank()) {
			this.nomeApp = nomeApp;
		} else {
			throw new Exception("Nome app non valido!");
		}

		// CONTROLLO VALIDITA SISTEMA OPERATIVO
		if (!sistemaOperativo.isBlank()) {
			this.sistemaOperativo = sistemaOperativo;
		} else {
			throw new Exception("Sistema operativo non valido!");
		}

		// CONTROLLO VALIDITA PREZZO
		if (prezzo >= 0f) {
			this.prezzo = prezzo;
		} else {
			throw new Exception("Il prezzo non può essere negativo!");
		}

		// INIZIALIZZO ATTRIBUTI A ZERO
		elencoRecensioni = new ArrayList<Recensione>();
		ricavoTotale = 0f;
	}

	// DOWNLOAD
	public void download() {
		ricavoTotale = ricavoTotale + prezzo;
	}

	// DOWNLOAD MULTIPLO
	public void download(int numeroDownload) throws Exception {
		if (numeroDownload > 0) {
			ricavoTotale = ricavoTotale + (prezzo * numeroDownload);
		} else {
			throw new Exception("Il numero dei download non può essere negativo");
		}
	}

	public void riceviRecensione(Recensione recensione) {
		elencoRecensioni.add(recensione);
	}

	public String valutazioneMedia() {
		String valutazioneMedia;
		float media;
		int totStelle = 0;

		// INIZIALIZZO LE VALUTAZIONI
		if (elencoRecensioni.size() == 0) {
			valutazioneMedia = "Non sono presenti recensioni";
		} else {
			
			// SOMMA LE STELLE DELLE RECENSIONI PER LA MEDIA
			for (Recensione r : elencoRecensioni) {
				totStelle = totStelle + r.getNumeroStelle();
			}
			media = ((float) totStelle) / ((float) elencoRecensioni.size());
			valutazioneMedia = String.format("%.1f", media) + "/5 stelle";
		}
		return valutazioneMedia;
	}

	public String getNome() {
		return nomeApp;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public ArrayList<Recensione> getElencoRecensioni() {
		return elencoRecensioni;
	}

	public int getNumRecensioni() {
		return elencoRecensioni.size();
	}

	public float getRicavoTotale() {
		return ricavoTotale;
	}
}
