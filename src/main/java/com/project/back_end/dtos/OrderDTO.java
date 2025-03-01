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
@Document(collection = "orders")
@Builder
public class OrderDTO {
    
    @Field("_id")
    private ObjectId id;

    @Field("user_id") // Foreign key
    private String userId;

    private String address;

    private String phone;   

    @Field("total_price")
    private double totalPrice;

    private String status;

    @Field("payment_status")
    private String paymentStatus;

    @Field("shipping_id") // Foreign key
    private String shippingId;

    @Field("discount_id") // Foreign key    
    private String discountId;

    @Field("created_at")
    private String createdAt;

    @Field("updated_at")
    private String updatedAt;
}
