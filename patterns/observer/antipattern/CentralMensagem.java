import java.util.List;

public class CentralMensagem {
    private List<String> comunicados;

    private ComunicacaoPais pais = new ComunicacaoPais();
    private ComunicacaoProfessores professores = new ComunicacaoProfessores();

    public void adicionaComunicado(String comunicado){
        comunicados.add(comunicado);

        pais.enviarMensagem(comunicado);
        professores.enviarMensagem(comunicado);
    }
}
