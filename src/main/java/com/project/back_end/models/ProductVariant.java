package com.project.back_end.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
public class ProductVariant {
    
    @Field("_id")
    private ObjectId id;

    @Field("product_id") // Foreign key
    private String productId;

    @Field("color_id") // Foreign key
    private String colorId;

    @Field("size_id") // Foreign key
    private String sizeId;

    private int stock;

}
