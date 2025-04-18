package ch07.exam.Recipe3;

public class Main {
    public static void main(String[] args) {
        Recipe[] recipes = {
                new KoreanRecipe(),
                new VeganRecipe(),
                new FusionRecipe()
        };

        String[] names = {"현수", "소영", "민재"};

        for (int i = 0; i < recipes.length; i++) {
            System.out.println(recipes[i].getDescription());
            if (recipes[i] instanceof KoreanRecipe recipe) {
                System.out.println(recipe.getSpicinessLevel());
            }
        }
    }
}
