package ch07.exam.Recipe2;

public class VeganRecipe extends Recipe {
    public VeganRecipe() {
        super("신선한 두부 샐러드를 추천합니다!");
    }

    @Override
    public String getDescription() {
        return title;
    }
}
