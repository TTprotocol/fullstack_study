package sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

import javax.xml.crypto.Data;

public class InsertOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        Document document = new Document();

        // 새 문서 생서앟고 필드 추가
        document.append("title", "MongoDB");
        document.append("desc", "MongoDB 공부하기");
        document.append("done", false);

        // 문서를 todo 컬렉션에 삽입
        InsertOneResult result = collection.insertOne(document);
        // 삽입된 문서 ID를 출력
        System.out.println("==> InsertOneResult : " + result.getInsertedId());
        // DB 연결 닫기
        Database.close();
    }
}
