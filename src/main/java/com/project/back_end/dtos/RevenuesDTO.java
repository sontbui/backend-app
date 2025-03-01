package com.project.back_end.dtos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@Document(collection = "revenues")
@Builder
public class RevenuesDTO {
    
    @Field("_id")
    private ObjectId  id;

    @Field("report_id") // Foreign key
    @NotNull(message = "Report ID is required")
    private String reportId;

    @Field("order_id") // Foreign key   
    @NotNull(message = "Order ID is required")
    private String orderId;

    private String source;

     @Size(min = 1, max = 1000000000, message = "Total amout must be between 1 and 1000000000")
    private double amount;

    @Field("created_at")
    private String createdAt;
}
