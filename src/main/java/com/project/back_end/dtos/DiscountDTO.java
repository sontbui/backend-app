package com.project.back_end.dtos;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
@Document(collection = "discounts")
@Builder
public class DiscountDTO {
 
    @Field("_id")
    private ObjectId id;

    @NotBlank(message = "Discount's code is required")
    @NotNull(message = "Discount's code cannot be null")
    private String code;
    
    @Field("discount_type")
    private String discountType;

    @Field("discount_value")
    @NotBlank(message = "Discount's value is required")
    @Min(value = 0, message = "Discount's value must be greater than 0")
    private int discountValue;

    @Field("min_order_value")
    @NotBlank(message = "Discount's minimum order value is required")
    @Min(value = 0, message = "Discount's minimum order value must be greater than 0")
    private double minOrderValue;

    @Field("max_discount")
    @NotBlank(message = "Discount's maximum discount is required")
    @Min(value = 100, message = "Discount's maximum discount must be greater than 0")
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
