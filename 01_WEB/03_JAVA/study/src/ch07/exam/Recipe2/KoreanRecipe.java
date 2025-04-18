package ch07.exam.Recipe2;

public class KoreanRecipe extends Recipe {
    public KoreanRecipe() {
        super("매콤한 김치찌개를 추천합니다!");
    }

    @Override
    public String getDescription() {
        return title;
    }
}
