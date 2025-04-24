import java.util.List;

public class Gerente implements Funcionario{
    private String nome;
    private List<Funcionario> subordinados;

    public void adicionar(Funcionario f) {
        subordinados.add(f);
    }

    public void exbirDetalhes(){
        System.out.println("Gerente: "+nome);

        for (Funcionario s: subordinados){
            s.exbirDetalhes();
        }
    }
}