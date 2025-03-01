package com.project.back_end.models;

import java.util.Date;

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
@Document(collection = "reports")
@Builder
public class Report {
    
    @Field("_id")   
    private ObjectId id;

    @Field("report_date")
    private Date reportDate;

    @Field("total_revenue")
    private double totalRevenue;

    @Field("total_orders")
    private int totalOrders;

    @Field("total_expenses")
    private double totalExpenses;

    private double profit;

    @Field("created_at")
    private Date createdAt;
}
