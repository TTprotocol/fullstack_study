package ch07.exam.Recipe;

public class VeganRecipe extends Recipe {

    public VeganRecipe() {
        super("두부 샐러드", 10, true);
    }

    @Override
    public String getDescription() {
        return "신선한 " + title + "를 추천합니다.";
    }

    @Override
    public String toString() {
        return (title + "(" + cookTime + "분) - " + (isVegan ? "비건" : "비건 아님"));
    }
}
