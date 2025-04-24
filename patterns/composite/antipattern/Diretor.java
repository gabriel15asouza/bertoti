import java.util.List;

public class Diretor {
    private String nome;
    private List<Gerente> subordinados;

    public void adicionar(Gerente g) {
        subordinados.add(g);
    }

    public void exbirDetalhes(){
        System.out.println("Diretor: "+nome);

        for (Gerente s: subordinados){
            s.exbirDetalhes();
        }
    }
}
