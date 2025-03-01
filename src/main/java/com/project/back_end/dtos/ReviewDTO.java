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
@Document(collection = "reviews")
@Builder
public class ReviewDTO {
    

    @Field("_id")
    private ObjectId id;

    @Field("user_id") // Foreign key
    @NotNull(message = "User ID is required")
    private String userId;

    @Field("product_id") // Foreign key
    @NotNull(message = "Product ID is required")
    private String productId;

    @NotNull(message = "Rating is required")
    private double rating;

    @NotNull(message = "Comment is required")
    private String comment;

    @Field("created_at")
    private String createdAt;
}
