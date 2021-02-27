package ru.romasini.structure.pattern.mvc.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.romasini.structure.pattern.mvc.entities.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Integer price;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}
