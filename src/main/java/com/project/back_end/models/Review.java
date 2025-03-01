package com.project.back_end.models;

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
@Document(collection = "reviews")
@Builder
public class Review {
    

    @Field("_id")
    private ObjectId id;

    @Field("user_id") // Foreign key
    private String userId;

    @Field("product_id") // Foreign key
    private String productId;

    private double rating;

    private String comment;

    @Field("created_at")
    private String createdAt;
}
