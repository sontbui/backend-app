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
@Document(collection = "payments")
@Builder
public class PaymentDTO {
    
    @Field("_id")
    private ObjectId id;

    @Field("order_id") // Foreign key
    @NotNull(message = "Order ID is required")
    private String orderId;

    @Field("payment_method")
    private String paymentMethod;

    @Field("status")
    private String status;

    @Field("transaction_id")
    @NotNull(message = "Transaction ID is required")
    private String transactionId;

    private double amount;

    @Field("payment_gateway")
    private String paymentGateway;

    @Field("paid_at")
    private String paidAt;
}
