package com.teste.primeiro_exemplo.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.model.exception.ResourcesNotFoundException;


@Repository
public class ProdutoRepositoryold {
    //Simulando um banco de dados com uma lista
    private final List<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;
    /**
     * Metodo para retorna uma lista de produtos
     * @return lista de produtos.
     */
    
    public List<Produto> obterTodos() {
        return produtos;
    }
        /* o  metodo que retorna produto encontrado pelo id
        @param id do produto que será localizado
        @return Retorna o produto caso seja encontrado.
        */
    public Optional<Produto> obterPorId(Integer id) {
        
        return produtos
                .stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst();
                
                
    }

    /**
     * Metodo para adicionar um produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto adicionado na lista
     */
    public Produto adicionar(Produto produto) {
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }
    /**
     * Metodo para deletar um produto da lista por id.
     * @param id do produto que será deletado.
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
    }
    


    /**
     * Metodo para atualizar um produto na lista
     * @param produto que será atualizado
     * @return Retorna o produto apos atualizar na lista
     */
    public Produto atualizar(Produto produto) {
       //Encontrar o produto na lista 
       Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        if(produtoEncontrado.isEmpty()) {
            throw new ResourcesNotFoundException("Produto não foi encontrado com essas informações ");
        }

       //Eu tenho que remover o produto antigo e adicionar o atualizado
       deletar(produto.getId());
       //Depois adicionar o produto atualizado na lista
       produtos.add(produto);
       return produto;
    }
}
