package com.project.back_end.dtos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product_variants")
@Builder
public class ProductVariantDTO {
    
    @Field("_id")
    private ObjectId id;

    @Field("product_id") // Foreign key
    @NotNull(message = "Product ID is required")
    private String productId;

    @Field("color_id") // Foreign key
    @NotNull(message = "Color ID is required")
    private String colorId;

    @Field("size_id") // Foreign key
    @NotNull(message = "Size ID is required")
    private String sizeId;

    private int stock;

}
