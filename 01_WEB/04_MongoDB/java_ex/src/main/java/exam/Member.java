package exam;

public class Member extends BandComponent{
    private String name;    // 멤버 이름
    private String mbti;    // 성격 유형
    private String position;    // 역할
    private int energyLevel;    // 에너지 수치

    public Member(String name, String mbti, String position, int energyLevel) {
        this.name = name;
        this.mbti = mbti;
        this.position = position;
        this.energyLevel = energyLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void perform() {
        if (energyLevel < 30) System.out.println("\uD83D\uDE35 [" + mbti + "] " + name + ": 너무 지쳐서 공연을 못 하겠어요...");

        switch (mbti) {
            case "ENFP": {
                System.out.println("\uD83D\uDD25 [ENFP] " + name + ": 여러분 안녕!! 불태워볼까요?");
                break;
            }
            case "ISTJ": {
                System.out.println("\uD83E\uDDCA [ISTJ] " + name + ": 공연 시작합니다.");
                break;
            }
            case "ISFP": {
                System.out.println("\uD83C\uDF19 [ISFP] " + name + ": 조용히 시작해볼게요.");
                break;
            }
            case "INTP": {
                System.out.println("\uD83E\uDDE0 [INTP] " + name + ": 이 곡은 구조적으로 매우 완벽합니다.");
                break;
            }
            case "ESFJ": {
                System.out.println("\uD83D\uDC95 [ESFJ] " + name + ": 다들 잘 지냈죠? 오늘도 힘내요!");
                break;
            }
            default: {
                System.out.println("\uD83C\uDFB6 [기타] " + name + ": 준비됐어요!");
            }
        }
    }

    @Override
    public void printStructure(String prefix) {
//        System.out.println(prefix + " \uD83C\uDFB8 " + position + " - " + name + " (" + mbti + ")");
        System.out.println(prefix + "|- \uD83C\uDFA4 " + this);
    }


}
