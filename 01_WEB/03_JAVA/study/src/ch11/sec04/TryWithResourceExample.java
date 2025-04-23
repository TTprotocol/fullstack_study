package ch11.sec04;

public class TryWithResourceExample {
    public static void main(String[] args) {
        // 예제 1 : 단일 리소스 (정상 실행)
        try (MyResource res = new MyResource("A")) {
            String data = res.read1();
            int value = Integer.parseInt(data);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        // 예제 2 : 단일 리소스 (NumberFormatException 발생)
        try (MyResource res = new MyResource("A")) {
            String data = res.read2();
            // NumberFormatException 발생
            int value = Integer.parseInt(data);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }
        System.out.println();

        // 예제 3 : 다중 리소스 (구버전 문법)
        /* try (
            MyResource res1 = new MyResource("A");
            MyResource res2 = new MyResource("B")
        ) {
            String data1 = res1.read1(); 
            String data2 = res2.read1();
        } catch(Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        } */
        
        // 예제 4 : 최신 문법
        MyResource res1 = new MyResource("A");
        MyResource res2 = new MyResource("B");
        try (res1; res2) {
            String data1 = res1.read1();
            String data2 = res2.read1();
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }
    }
}
