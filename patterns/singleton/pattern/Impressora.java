public class Impressora {
    private static Impressora instancia;

    private Impressora() {}

    public static Impressora getInstancia() {
        if (instancia == null) {
            instancia = new Impressora();
        }
        return instancia;
    }

    public void imprimir(String documento) {
        System.out.println("📄 Imprimindo: " + documento);
    }
}
