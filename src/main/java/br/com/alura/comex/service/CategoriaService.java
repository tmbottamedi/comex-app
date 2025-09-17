package br.com.alura.comex.service;

import org.springframework.stereotype.Service;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public void cadastrar(Categoria categoria) {
        if (categoria == null)
            return;
        repository.save(categoria);
    }
}