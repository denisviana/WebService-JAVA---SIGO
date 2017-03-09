package br.com.sigo.entidade;

import java.util.List;

public class Itinerario {

    private int idItinerario;
    private List<Parada> paradas;

    public int getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(int idItinerario) {
        this.idItinerario = idItinerario;
    }

    public List<Parada> getParadas() {
        return paradas;
    }

    public void setParadas(List<Parada> paradas) {
        this.paradas = paradas;
    }
	
}
