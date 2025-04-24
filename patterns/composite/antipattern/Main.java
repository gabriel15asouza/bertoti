public class Main {
    public static void main(String[] args) {
        Desenvolvedor dev1 = new Desenvolvedor("Alice");
        Desenvolvedor dev2 = new Desenvolvedor("Bob");

        Gerente gerenteTI = new Gerente("Carla");
        gerenteTI.adicionar(dev1);
        gerenteTI.adicionar(dev2);

        Diretor diretor = new Gerente("Daniel");
        diretor.adicionar(gerenteTI);

        diretor.exibirDetalhes();
    }
}
