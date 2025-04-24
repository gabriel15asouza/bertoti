import java.util.List;

public class Gerente {
    private String nome;
    private List<Desenvolvedor> subordinados;

    public void adicionar(Desenvolvedor f) {
        subordinados.add(f);
    }

    public void exbirDetalhes(){
        System.out.println("Gerente: "+nome);

        for (Desenvolvedor s: subordinados){
            s.exbirDetalhes();
        }
    }
}
