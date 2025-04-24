public class ComunicacaoPais implements Observador {
    public void enviarMensagem(String comunicado) {
        System.out.println("Prezados pais,"+comunicado);
    }
}
