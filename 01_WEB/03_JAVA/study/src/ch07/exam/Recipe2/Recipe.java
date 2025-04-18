package ch07.exam.Recipe2;

public abstract class Recipe {
    protected String title;

    public Recipe(String title) {
        this.title = title;
    }

    public abstract String getDescription();
}
