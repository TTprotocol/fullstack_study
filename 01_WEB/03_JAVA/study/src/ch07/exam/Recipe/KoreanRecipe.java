package ch07.exam.Recipe;

public class KoreanRecipe extends Recipe {

    public KoreanRecipe() {
        super("김치찌개", 20, false);
    }

    @Override
    public String getDescription() {
        return "매콤한" + title + "를 추천합니다.";
    }

    @Override
    public String toString() {
        return (title + "(" + cookTime + "분) - " + (isVegan ? "비건" : "비건 아님"));
    }
}
