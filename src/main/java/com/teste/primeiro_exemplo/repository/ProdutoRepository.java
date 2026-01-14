package com.teste.primeiro_exemplo.repository;
import org.springframework.stereotype.Repository;

import com.teste.primeiro_exemplo.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    
}
