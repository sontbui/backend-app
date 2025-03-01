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
@Document(collection = "expenses")
@Builder
public class ExpenseDTO {
    

    @Field("_id")
    private ObjectId id;

    @Field("expense_date")
    private Date expenseDate;

    @Field("description")
    private String categoryExpense;

    private double amount;
    
    private String descryption;

    @Field("created_at")
    private Date createdAt;
}
