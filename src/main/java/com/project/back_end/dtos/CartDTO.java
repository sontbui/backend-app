package com.project.back_end.dtos;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "carts")
@Builder
public class CartDTO {
    

    @Field("_id")
    private ObjectId id;

    @Field("user_id") // Foreign key
    @NotBlank(message = "User ID is mandatory")
    private String userId;

    @Field("product_variant_id") // Foreign key
    @NotBlank(message = "Product Variant ID is mandatory")
    private String productVariantId;

    private int quantity;

    @Field("created_at")
    private String createdAt;

    @Field("updated_at")
    private String updatedAt;
    
    private String status;
}
