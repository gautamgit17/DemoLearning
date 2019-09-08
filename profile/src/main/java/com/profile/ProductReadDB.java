package com.profile;


import org.springframework.stereotype.Component;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

@Component
public class ProductReadDB {

   public Item readProduct(int year) {
	   Item outcome =  new Item();
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-1"))
            .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Movies");

        GetItemSpec spec = new GetItemSpec().withPrimaryKey("year", year);

        try {
            System.out.println("Attempting to read the item...");
            outcome = table.getItem(spec);
            System.out.println("GetItem succeeded: " + outcome);
            
        }
        
        catch (Exception e) {
            System.err.println("Unable to read item: " + year);
            System.err.println(e.getMessage());
            
        }
		return outcome;

    }
}