package com.teste.primeiro_exemplo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.repository.ProdutoRepository;
import com.teste.primeiro_exemplo.shared.ProdutoDTO;



@Service
public class ProdutoServices {
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Metodo para retorna uma lista de produtos
     * @return Lista de produtos.
     */
    public List<ProdutoDTO> obterTodos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
        .map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
        .collect(Collectors.toList());

    }

    /**
     * Metodo que retorna produto encontrado pelo id
     * @param id do produto que será localizado
     * @return Retorna o produto caso seja encontrado.
     */
    public Optional<ProdutoDTO> obterPorId(Integer id) {
        //Obtendo optional de  produto pelo ID
        Optional<Produto> produto = produtoRepository.findById(id);

        //Se não encontrar , lançar expection
        if(produto.isEmpty()){
            throw new RuntimeException("Produto não encontrado com id: " + id );
        }
        //Convertendo produto para ProdutoDTO
        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        //criando e retornando o optional de ProdutoDTO
        return Optional.of(dto);
    }
    /**
     * Metodo para adicionar um produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto adicionado na lista
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDTO) {
        produtoDTO.setId(null); //Garantir que o ID seja nulo para criar um novo produto
        //criando um objecto de mapameamento
        ModelMapper mapper = new ModelMapper();
        //Conveter em prduto Dto para produto
        Produto produto = mapper.map(produtoDTO, Produto.class);
        //Salvar o produto no banco de dados
        produto = produtoRepository.save(produto);
        produtoDTO.setId(produto.getId());
        //Converter o produto salvo em ProdutoDTO e retornar
       

        return produtoDTO;
        


     
    }

    public void deletar(Integer id) {
        //Verificar se o produto existe
        Optional<Produto> produto = produtoRepository.findById(id);
        //Se não encontrar , lançar expection
        if(produto.isEmpty()){
            throw new RuntimeException("Produto não encontrado com id: " + id + " produto não existe.");
        }
        //Deletar o produto pelo id


        produtoRepository.deleteById(id);
    }


    public ProdutoDTO atualizar(Integer id,ProdutoDTO produtoDTO) {
      //Passar o id para o produtoDTO
      produtoDTO.setId(id);
      //Criar o objeto de mapeamento
        ModelMapper mapper = new ModelMapper();
        //Converter o produtoDTO para produto
        Produto produto = mapper.map(produtoDTO, Produto.class);
        //atualizar o produto no banco de dados
        produtoRepository.save(produto);
        //retornar o produto atualizado convertido em ProdutoDTO
        return produtoDTO;
    }
    
}
