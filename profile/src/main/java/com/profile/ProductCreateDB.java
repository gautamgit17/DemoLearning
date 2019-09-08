package com.profile;

import org.springframework.stereotype.Component;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

@Component
public class ProductCreateDB {
	
	
	public void  createProduct(int year, String title) {
		
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
	            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-1"))
	            .build();

	        DynamoDB dynamoDB = new DynamoDB(client);

	        Table table = dynamoDB.getTable("Movies");


	        try {
	            System.out.println("Adding a new item...");
	            System.out.println("Adding a new item...");
	            
	            Item item =  new Item();
	            item.withPrimaryKey("year", year);
	            item.with("title", title);
	            table.putItem(item);
	            
	            Item item1 =  new Item();
	            item1.withPrimaryKey("year", 2019);
	            item1.with("title", "tst");
	            table.putItem(item1);
	            System.out.println("PutItem succeeded:\n");


        }
        catch (Exception e) {
            System.err.println("Unable to add item: " + year + " " + title);
            System.err.println(e.getMessage());
        }
			
}}
