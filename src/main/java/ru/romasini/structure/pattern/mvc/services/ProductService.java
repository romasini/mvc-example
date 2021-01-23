package ru.romasini.structure.pattern.mvc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.romasini.structure.pattern.mvc.entities.Product;
import ru.romasini.structure.pattern.mvc.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete(Product product){
        productRepository.delete(product);
    }

}
