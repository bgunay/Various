package com.github.pnowy.various.nosql.mongo;

import com.mongodb.*;

import java.net.UnknownHostException;

public class MongoFiles {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient mongo = new MongoClient("localhost", 27017);
        for (String db : mongo.getDatabaseNames()) {
            System.out.println("database: " + db);
        }
        DB db = mongo.getDB("local");
        for (String coll : db.getCollectionNames()) {
            System.out.println("collection: " + coll);
        }

		/* INSERT EXAMPLE */
        DBCollection table = db.getCollection("user");
//		BasicDBObject document = new BasicDBObject();
//		document.put("firstName", "przemek");
//		document.put("age", 30);
//		document.put("createdDate", new Date());
//		table.insert(document);

		/* UPDATE EXAMPLE*/
//		BasicDBObject query = new BasicDBObject();
//		query.put("firstName", "przemek");
//		BasicDBObject newDocument = new BasicDBObject();
//		newDocument.put("firstName", "przemek-updated");
//		BasicDBObject updateObj = new BasicDBObject();
//		updateObj.put("$set", newDocument);
//		table.update(query, updateObj);

		/* SEARCH EXAMPLE */
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("firstName", "przemek-updated");
        DBCursor cursor = table.find(searchQuery);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
}
