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
@Document(collection = "revenues")
@Builder
public class RevenuesDTO {
    
    @Field("_id")
    private ObjectId  id;

    @Field("report_id") // Foreign key
    private String reportId;

    @Field("order_id") // Foreign key   
    private String orderId;

    private String source;

    private double amount;

    @Field("created_at")
    private String createdAt;
}
