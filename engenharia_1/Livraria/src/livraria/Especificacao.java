/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package livraria;

/**
 *
 * @author gabal
 */
public class Especificacao {
    public String autor;
    private String genero;
    private int paginas;
    private int quantAlugueis;

    public Especificacao(String autor, String genero, int paginas, int quantAlugueis) {
        this.autor = autor;
        this.genero = genero;
        this.paginas = paginas;
        this.quantAlugueis = quantAlugueis;
    }
    
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getQuantAlugueis() {
        return quantAlugueis;
    }
    public void setQuantAlugueis(int quantAlugueis) {
        this.quantAlugueis = quantAlugueis;
    }
}
