package com.project.back_end.dtos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "User ID is mandatory")
    private String userId;

    @NotNull(message = "Address is mandatory")
    @Size(min = 10, message = "Address is mandatory")
    private String address;

    @NotNull(message = "Phone is mandatory")
    @Size(min = 10, max = 11, message = "Phone is mandatory")
    private String phone;   

    @Field("total_price")
    private double totalPrice;

    private String status;

    @Field("payment_status")
    private String paymentStatus;

    @Field("shipping_id") // Foreign key
    @NotNull(message = "Shipping ID is mandatory")
    private String shippingId;

    @Field("discount_id") // Foreign key    
    @NotNull(message = "Discount ID is mandatory")
    private String discountId;

    @Field("created_at")
    private String createdAt;

    @Field("updated_at")
    private String updatedAt;
}
