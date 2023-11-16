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
        Livraria livraria = new Livraria();        
        Livro narnia = new Livro("As Crônicas de Nárnia", new Especificacao("C.S.Lewis", "Fantasia", 700));
        Livro ladraoDeRaios = new Livro("Percy Jackson e o Ladrão de Raios", new Especificacao("Rick Ryordan", "Fantasia", 300));
        Cliente roberto = new Cliente("Roberto Almirante", "1234567890");
        
        livraria.cadastrarLivro(narnia);
        livraria.cadastrarLivro(ladraoDeRaios);
        livraria.cadastrarCliente(roberto);
        System.out.println(livraria.mostrarLivrosDispon(true));
        
        roberto.alugarLivro(narnia);
        System.out.println(livraria.mostrarLivrosDispon(true));
        
        roberto.devolverLivro(narnia);
        System.out.println(livraria.mostrarLivrosDispon(true));
        
        System.out.println("Quantidade de alugueis Narnia: " + narnia.getQuantAlugueis());
        System.out.println("Quantidade de alugueis Ladrão de Raios : " + ladraoDeRaios.getQuantAlugueis());
        
        System.out.println("Historico Roberto: " + roberto.getHistoricoAlugueis());
        System.out.println("Livros encontrados: " + livraria.buscarLivroPorEspec(new Especificacao("Rick Ryordan", "Fantasia", 300)));    
    }
    
}
