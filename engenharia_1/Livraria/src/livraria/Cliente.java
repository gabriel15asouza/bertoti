/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livraria;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gabal
 */
public class Cliente {
    private String nome;
    private String cpf;
    private List<Livro> historicoAlugueis = new LinkedList<Livro>();

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Livro> getHistoricoAlugueis() {
        return historicoAlugueis;
    }
    
    public void alugarLivro(Livro livro){
        historicoAlugueis.add(livro);
        livro.setDisponivel(false);
        livro.aluga();
    }
    
    public void devolverLivro(Livro livro){
        livro.setDisponivel(true);
    }
}
