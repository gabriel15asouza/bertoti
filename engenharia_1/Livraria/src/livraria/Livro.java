/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livraria;

/**
 *
 * @author gabal
 */
public class Livro {
    private String titulo;
    private Especificacao espec;
    private boolean disponivel = true;
    private int quantAlugueis = 0;

    public Livro(String titulo, Especificacao espec) {
        this.titulo = titulo;
        this.espec = espec;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Especificacao getEspec() {
        return espec;
    }
    public void setEspec(Especificacao espec) {
        this.espec = espec;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean status) {
        this.disponivel = status;
    }    
    
    public int getQuantAlugueis() {
        return quantAlugueis;
    }
    public void setQuantAlugueis(int quantAlugueis) {
        this.quantAlugueis = quantAlugueis;
    }
    
    public void aluga(){
        this.quantAlugueis += 1;
    }
    
    public boolean comparar(Especificacao especificacao){
        return this.getEspec().getGenero().equals(especificacao.getGenero()) && this.getEspec().getAutor().equals(especificacao.getAutor())&& this.getEspec().getPaginas() == especificacao.getPaginas();
    }

    @Override
    public String toString() {
        return this.getTitulo(); 
    }
    
    

}
