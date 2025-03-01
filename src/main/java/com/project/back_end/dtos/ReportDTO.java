package com.project.back_end.dtos;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@Document(collection = "reports")
@Builder
public class ReportDTO {
    
    @Field("_id")   
    private ObjectId id;

    @Field("report_date")
    private Date reportDate;

    @Field("total_revenue")
    @Size(min = 1, max = 1000000000, message = "Total revenue must be between 1 and 1000000000")
    private double totalRevenue;

    @Field("total_orders")
    @Size(min = 1, max = 1000000000, message = "Total orders must be between 1 and 1000000000")
    private int totalOrders;

    @Field("total_expenses")
    @Size(min = 1, max = 1000000000, message = "Total expense must be between 1 and 1000000000")
    private double totalExpenses;

    @Size(min = 1, max = 1000000000, message = "Total profit must be between 1 and 1000000000")
    private double profit;

    @Field("created_at")
    private Date createdAt;
}
