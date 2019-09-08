package com.profile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;


@Component
public class ProductQueryDB {

    public UserPrefList getItemFromTable(int year) {
    	List<UserPref> userPref =  new ArrayList<UserPref>();

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-1"))
            .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Movies");

        HashMap<String, String> nameMap = new HashMap<String, String>();
        nameMap.put("#yr", "year");

        HashMap<String, Object> valueMap = new HashMap<String, Object>();
        valueMap.put(":yyyy", year);

        QuerySpec querySpec = new QuerySpec().withKeyConditionExpression("#yr = :yyyy").withNameMap(nameMap)
            .withValueMap(valueMap);

        ItemCollection<QueryOutcome> items = null;
        Iterator<Item> iterator = null;
        Item item = null;
        
        try {
            System.out.println("Movies from 2019");
            
            items = table.query(querySpec);

            iterator = items.iterator();
            while (iterator.hasNext()) {
                item = iterator.next();
                String prefName = item.getString("title");
                UserPref pref = UserPref.create(prefName);
                userPref.add(pref);
                
                System.out.println(item.getNumber("year") + ": " + item.getString("title"));
             
            }
            
           /* int pageNumber = 0;
            for (Page<Item, QueryOutcome> page : items.pages()) {
                pageNumber++;
                System.out.println("Page: " + pageNumber + " #####");
                for (Item item1 : page) {
                    System.out.println(item1.toJSONPretty());
                }
            }*/

        }
        catch (Exception e) {
            System.err.println("Unable to query movies from 2019");
            System.err.println(e.getMessage());
        }
        
        UserPrefList userPrefList2 = UserPrefList.create(userPref);
		return userPrefList2;

    }
    
}
  