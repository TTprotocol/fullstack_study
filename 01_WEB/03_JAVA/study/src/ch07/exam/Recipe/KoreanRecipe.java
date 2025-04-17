package ch07.exam.Recipe;

public class KoreanRecipe extends Recipe {


    public KoreanRecipe() {
        super("매콤한 김치찌개", 20, false);
    }

    @Override
    public void getDescription() {
        System.out.println(title + "를 추천합니다.");
    }

    @Override
    public void toStringMethod() {
        System.out.println(title + "(" + cookTime + ") - " + (isVegan ? "비건" : "비건 아님"));
    }
}
