package exam;

public class MainStep2_SubBand {
    public static void main(String[] args) {
        System.out.println("");
        Band band = new Band("DreamStage");
        Band band1 = new Band("스윗즈");

        Band mem1 = new Band("제로비트");
        Band mem2 = new Band("민트초코");
        Band mem3 = new Band("아이시스");
        Band mem4 = new Band("허니콩");

        band.add(mem1);
        band1.add(mem2);
        band1.add(mem3);
        band1.add(mem4);

        band.printStructure("");;
    }
}
