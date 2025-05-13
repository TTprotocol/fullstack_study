package exam1;

import framework.Product;

public class CardTemplate implements Product {
    private String title;
    private String FrameChar;

    public CardTemplate(String title, String frameChar) {
        this.title = title;
        FrameChar = frameChar;
    }

    @Override
    public void use(String s) {
        System.out.println("[" + title + "]");
        int len = s.length();

        for (int i = 0; i < len; i++) {
            System.out.print(FrameChar);
        }

        System.out.println();
        System.out.println(s);

        for (int i = 0; i < len; i++) {
            System.out.print(FrameChar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p = null;

        try {
            p = (Product) clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return p;
    }
}
