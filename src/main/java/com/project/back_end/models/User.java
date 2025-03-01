package com.project.back_end.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
@Builder
public class User {
 
    @JsonProperty("_id")
    private ObjectId id;

    private String name;
    private String gender;
    private String age;
    private String email;
    private String phone;
    private String password;
    private String address;
    private String role;
    private String avatar_url;
    
    @Field("is_active")
    private boolean isActive;
    
    @Field("last_login")
    private Date lastLogin;
    @Field("created_at")
    private Date createdAt;
    @Field("updated_at")
    private Date updatedAt;
}
