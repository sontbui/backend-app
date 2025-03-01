package com.project.back_end.dtos;

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
@Document(collection = "order_items")
@Builder
public class OrderItemDTO {
    

    @Field("_id")
    private ObjectId id;

    @Field("order_id") // Foreign key
    private String orderId;

    @Field("product_variant_id") // Foreign key
    private String productVariantId;

    private int quantity;

    private double price;
}
