package ch18.sec10;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamExample {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("C:/test/object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Member m1 = new Member("fall", "단풍이");
        Product p1 = new Product("노트북", 15000);
        int[] arr1 = {1, 2, 3};
        oos.writeObject(m1);
        oos.writeObject(p1);
        oos.writeObject(arr1);

        oos.flush(); oos.close(); fos.close();


    }
}
