package exam2;

import exam2.framework.Product;

public class CardTemplate implements Product {
    private String title;
    private String frameChar;

    public CardTemplate(String title, String frameChar) {
        this.title = title;
        this.frameChar = frameChar;
    }

    public String getTitle() {
        return title;
    }

    public String getFrameChar() {
        return frameChar;
    }

    @Override
    public void use(String content) {
        int len = content.length();

        System.out.println("["+title+"]");
        for (int i = 0; i < len; i++) {
            System.out.print(frameChar);
        }

        System.out.println();
        System.out.println(content);

        for (int i = 0; i < len; i++) {
            System.out.print(frameChar);
        }
    }

    @Override
    public Product createCopy() {
        Product p = null;

        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
