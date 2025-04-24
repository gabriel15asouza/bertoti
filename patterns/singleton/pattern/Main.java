public class Main {
    public static void main(String[] args) {
        Impressora imp1 = Impressora.getInstancia();
        Impressora imp2 = Impressora.getInstancia();

        impressora1.imprimir("Boletim Escolar");
        impressora2.imprimir("Contrato de Trabalho");

        System.out.println(impressora1 == impressora2); 
    }
}
