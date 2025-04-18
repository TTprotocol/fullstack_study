package ch07.exam.Recipe2;

public class FusionRecipe extends Recipe {

    public FusionRecipe() {
        super("매콤달콤한 불닭파스타를 추천합니다!");
    }

    @Override
    public String getDescription() {
        return title;
    }

}
