public class ComunicacaoProfessores implements Observador {
    public void enviarMensagem(String comunicado) {
        System.out.println("Prezados professores,"+comunicado);
    }
}
