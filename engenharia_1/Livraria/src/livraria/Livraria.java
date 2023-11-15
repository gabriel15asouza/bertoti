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
public class Livraria {
    private List<Livro> livros = new LinkedList<>();
    private List<Cliente> clientes = new LinkedList<>();
    
    public void cadastrarLivro(Livro livro){
        livros.add(livro);
    }
    
    public List buscarLivroPorEspec(Especificacao espec){
        List<Livro>livrosEncontrados = new LinkedList<>();
        for (Livro livro:livros){
            if(livro.comparar(espec)){
                livrosEncontrados.add(livro);                
            }
        }
        return livrosEncontrados;
    }
    
    public List mostrarLivrosDispon(boolean status){
        List<Livro> disponiveis = new LinkedList<>();
        for (Livro livro:livros){
            if(livro.isDisponivel() == true){
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }
    
    public void cadastrarCliente(Cliente cliente){
        clientes.add(cliente);
    }
}
