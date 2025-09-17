package br.com.alura.comex.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.alura.comex.controller.RequestProduto;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Produto cadastrar(RequestProduto request) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(request.getCategoriaId());
        if (categoriaOptional.isEmpty()) {
            throw new IllegalArgumentException("ID de categoria inválido.");
        }
        Categoria categoria = categoriaOptional.get();
        Produto produto = request.toProduto(categoria);
        return produtoRepository.save(produto);
    }
}