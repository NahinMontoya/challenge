package challenge;

public class TravelVacation {

	
    private int pasajeros;
    private int dias;
    private String opcional;
    
    public TravelVacation() {
    }

    public TravelVacation(int pasajeros, int dias) {
        this.pasajeros = pasajeros;
        this.dias = dias;
        this.opcional = null;
    }
    
    public TravelVacation(int pasajeros, int dias, String opcional) {
        this.pasajeros = pasajeros;
        this.dias = dias;
        this.opcional = opcional;
    }

    public String getOpcional() {
		return opcional;
	}

	public void setOpcional(String opcional) {
		this.opcional = opcional;
	}

	public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }


    @Override
	public String toString() {
		return "TravelVacation [pasajeros=" + pasajeros + ", dias=" + dias + ", opcional=" + opcional + "]";
	}
}
