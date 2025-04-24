public class Main {
    public static void main(String[] args) {
        Funcionario dev1 = new Desenvolvedor("Alice");
        Funcionario dev2 = new Desenvolvedor("Bob");

        Gerente gerenteTI = new Gerente("Carla");
        gerenteTI.adicionar(dev1);
        gerenteTI.adicionar(dev2);

        Gerente diretor = new Gerente("Daniel");
        diretor.adicionar(gerenteTI);

        diretor.exibirDetalhes();
    }
}
