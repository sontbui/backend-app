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
@Document(collection = "shippings")
@Builder
public class ShippingDTO {
    

    @Field("_id")
    private ObjectId id;

    @Field("order_id") // Foreign key   
    private String orderId;

    @Field("shipping_address")
    private String shippingAddress;

    @Field("tracking_number")   
    private String trackingNumber;

    private String carrier;

    private String status;
}
