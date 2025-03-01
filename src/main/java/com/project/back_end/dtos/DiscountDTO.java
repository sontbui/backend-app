package com.project.back_end.dtos;

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
@Document(collection = "discounts")
@Builder
public class DiscountDTO {
 
    @Field("_id")
    private ObjectId id;

    private String code;
    
    @Field("discount_type")
    private String discountType;

    @Field("discount_value")
    private int discountValue;

    @Field("min_order_value")
    private double minOrderValue;

    @Field("max_discount")
    private double maxDiscount;

    @Field("apply_to")
    private String applyTo;

    @Field("usage_limit")
    private double usageLimit;

    @Field("is_stackable")
    private boolean isStackable;

    @Field("start_date")
    private Date startDate;

    @Field("end_date")
    private Date endDate;

    private String status;

    @Field("created_at")
    private Date createdAt;

    @Field("updated_at")  
    private Date updatedAt;
}
