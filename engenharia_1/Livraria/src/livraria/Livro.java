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
    private boolean disponivel;

    public Livro(String titulo, Especificacao espec, boolean disponivel) {
        this.titulo = titulo;
        this.espec = espec;
        this.disponivel = disponivel;
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
    
    public boolean comparar(Especificacao especificacao){
        return this.getEspec().getGenero().equals(especificacao.getGenero()) && this.getEspec().autor.equals(especificacao.autor)&& this.getEspec().getPaginas() == especificacao.getPaginas();
    }

}
