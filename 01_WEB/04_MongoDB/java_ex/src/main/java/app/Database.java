package app;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Database {
    static MongoClient client;
    static MongoDatabase database;

    static {
        // POJO를 위한 준비작업 추가.
        // POJO Code Provider를 자동 설정으로 빌드
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();

        // 기본 Codec Registry와 결합하여 POJO codec Registry를 생성합니다.
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

        // -------------------------------------------------------------------------------------------------------------

        // MongoDB 연결 문자열 설정
        ConnectionString connectionString = new ConnectionString("mongodb://127.0.0.1:27017");

        // MongoDB 클라이언트 생성
        client = MongoClients.create(connectionString);
        
        // todo_db 데이터베이스에 POJO Codec Registry를 설정
        // POJO를 사용하기 위해 뒤에 .withCodecRegistry(pojoCodecRegistry)가 추가되었다.
        database = client.getDatabase("todo_db").withCodecRegistry(pojoCodecRegistry);
    }

    public static void close() {
        client.close();
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    // 특정 컬렉션을 Document 특정 형식으로 반환하는 메서드
    public static MongoCollection<Document> getCollection(String colName) {
        MongoCollection<Document> collection = database.getCollection(colName);

        return collection;
    }

    // 특정 컬렉션을 지정된 클래스 타입으로 반환하는 메서드
    public static <T> MongoCollection<T> getCollection(String colName, Class<T> clazz) {
        MongoCollection<T> collection = database.getCollection(colName, clazz);
        return collection;
    }
}
