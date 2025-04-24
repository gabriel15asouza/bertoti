public class Dispositivo {
    private Transmissao transmissao;

    public void setTransmissao(Transmissao transmissao){
        this.transmissao = transmissao;
    };

    public void transmitir(){
        transmissao.transmitir();
    }
}

