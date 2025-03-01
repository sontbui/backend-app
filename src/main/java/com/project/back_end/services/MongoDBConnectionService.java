package com.project.back_end.services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MongoDBConnectionService {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    public MongoDBConnectionService() {
    }

    public boolean checkConnection() {
        try (MongoClient mongoClient = MongoClients.create(this.mongoUri)) {
            MongoDatabase database = mongoClient.getDatabase(this.databaseName);
            if (database != null) {
                MongoIterable<String> collections = database.listCollectionNames();
                System.out.println("Successfully connected to the database: " + this.databaseName);
                System.out.println("\nCollections in database '" + this.databaseName + "':");
                try (MongoCursor<String> cursor = collections.iterator()) {
                    while (cursor.hasNext()) {
                        String collectionName = cursor.next();
                        System.out.println("- " + collectionName);
                    }
                }
                return true;
            } else {
                System.out.println("Failed to connect to the database: " + this.databaseName);
                return false;
            }
        } catch (Exception e) {
            System.out.println("An error occurred while trying to connect to the database: " + e.getMessage());
            return false;
        }
    }
}