package classes;

public class Voo {
    private Piloto piloto;
    private Aeronave aeronave;
    private String destino;

    public Voo(Piloto piloto, Aeronave aeronave, String destino) {
        this.piloto = piloto;
        this.aeronave = aeronave;
        this.destino = destino;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Voo com destino a " + destino + " operado por " + piloto.getNome() + " na aeronave " + aeronave.getModelo();
    }
}