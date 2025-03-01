package com.project.back_end.dtos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "categories")
@Builder
public class CategoryDTO {
    

    @Field("_id")
    private ObjectId id;

    @NotBlank(message = "Category's name is required")
    private String name;

    @Field("created_at")
    private String createdAt;

    @Field("updated_at")
    private String updatedAt;
}
