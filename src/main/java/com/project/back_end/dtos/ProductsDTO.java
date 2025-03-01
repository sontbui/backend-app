package com.project.back_end.dtos;

import java.util.ArrayList;

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
@Document(collection = "products")
@Builder
public class ProductsDTO {

    @Field("_id")
    private ObjectId id;

    private String name;

    @Field("brand_id") // Foreign key  
    @NotNull(message = "Brand's id is required") 
    private String brandId;

    @Field("category_id") // Foreign key
    @NotNull(message = "Category's id is required")
    private String categoryId;

    private double price;

    private Object desciption;

    @Field("image_urls")
    private ArrayList<String> imageUrls; 

    private String status;

    @Field("material_id") // Foreign key
    @NotNull(message = "Material's id is required")
    private String materialId;

    @Field("created_at")
    private String createdAt;

    @Field("updated_at")
    private String updatedAt;
    
}
