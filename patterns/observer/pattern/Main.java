public class Main {
    CentralMensagem escola = new Escola();
    ComunicacaoPais pais = new Pais();
    ComunicacaoProfessores professores = new Professores();

    escola.adicionarObservador(pais);
    escola.adicionarObservador(professores);
    escola.adicionarComunicado("Comunicado");
}
