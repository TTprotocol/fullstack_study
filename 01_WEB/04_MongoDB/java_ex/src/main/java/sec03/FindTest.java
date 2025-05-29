package sec03;

import app.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Iterator;

public class FindTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        // 컬렉션에서 모든 문서 찾기
        FindIterable<Document> doc = collection.find();

        Iterator itr = doc.iterator();
        // 반복자 사용해서 모든 문서 출력
        while (itr.hasNext()) {
            System.out.println("==> findResultRow : "+itr.next());
        }

        Database.close();
    }
}
