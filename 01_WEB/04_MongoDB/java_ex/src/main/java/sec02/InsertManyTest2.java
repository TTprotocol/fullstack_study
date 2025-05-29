package sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertManyTest2 {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");

        List<Document> insertList = new ArrayList<>();

        // 10부터 20까지의 값을 사용해서 문서 생성 후 리스트에 추가
        for (int i = 10; i < 21; i++) {
            Document document = new Document();

            document.append("name", "user_" + i);
            document.append("age", i);
            document.append("created", new Date());
            insertList.add(document);
        }

        InsertManyResult result = collection.insertMany(insertList);
        System.out.println("==> InsertManyResult : " + result.getInsertedIds());

        Database.close();
    }
}
