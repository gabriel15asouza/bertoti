/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package livraria;
/**
 *
 * @author gabal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        livraria.cadastrarLivro(new Livro("As Crônicas de Nárnia", new Especificacao("C.S.Lewis", "Fantasia", 700, 0), false));
        System.out.println(livraria.livros);
    }
    
}
