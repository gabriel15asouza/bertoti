import java.util.List;

public class CentralMensagem {
    private List<String> comunicados;
    private List<Observador> observadores = new ArrayList<>();

    public void adicionarComunicado(String comunicado){
        comunicados.add(comunicado);

        this.enviarComunicado(comunicado);
    }

    public void adicionarObservador(Observador observador){
        observadores.add(observador);
    }

    public void enviarComunicado(Spring comunicado){
        for (Observador o : observadores) {
            o.enviarComunicado(comunicado);
        }
    }
}
