package ru.romasini.structure.pattern.mvc.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.romasini.structure.pattern.mvc.dto.ProductDto;
import ru.romasini.structure.pattern.mvc.entities.Product;
import ru.romasini.structure.pattern.mvc.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<ProductDto> findAll(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public Optional<ProductDto> findById(Long id){
        Optional<Product> op = productRepository.findById(id);
        return op.stream().map(ProductDto::new).findFirst();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete(Product product){
        productRepository.delete(product);
    }

}
