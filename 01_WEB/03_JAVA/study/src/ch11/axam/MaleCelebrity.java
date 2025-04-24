package ch11.axam;

public class MaleCelebrity implements Celebrity{
    private String name;
    private String[] list;

    public MaleCelebrity(String name) throws InvalidNameException {
        if (!name.matches("[가-힣]{2,10}")) {
            throw new InvalidNameException("이름은 한글 2~10자여야 합니다.");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
//        if (!(o instanceof MaleCelebrity that)) return false;
//        return Objects.equals(name, that.name) && Objects.deepEquals(list, that.list);

        Celebrity other = (Celebrity) obj;
        return this.name.equals(other.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "남자 연예인: " + name;
    }
}
