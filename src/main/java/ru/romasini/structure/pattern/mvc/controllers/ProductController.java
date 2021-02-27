package ru.romasini.structure.pattern.mvc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.romasini.structure.pattern.mvc.dto.ProductDto;
import ru.romasini.structure.pattern.mvc.entities.Product;
import ru.romasini.structure.pattern.mvc.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProductList(){
        return productService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new RuntimeException("Unable to find product with id: " + id));
    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody Product p){
        return new ProductDto(productService.save(p));
    }

}
