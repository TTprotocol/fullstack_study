package ch17.exam.parents_gift_suggester.model;

public class GiftItem {
    private String name;    // 선물 이름
    private String category;    // 카테고리 (건강식품, 의류 등)
    private int price;
    private int preferenceScore; // 1~100
    private boolean forMom;
    private boolean forDad;

    public GiftItem(String name, String category, int price, int preferenceScore, boolean forMom, boolean forDad) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.preferenceScore = preferenceScore;
        this.forMom = forMom;
        this.forDad = forDad;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getPreferenceScore() {
        return preferenceScore;
    }

    public boolean isForMom() {
        return forMom;
    }

    public boolean isForDad() {
        return forDad;
    }
}
