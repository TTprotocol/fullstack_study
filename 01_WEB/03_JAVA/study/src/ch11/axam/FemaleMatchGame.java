package ch11.axam;

public class FemaleMatchGame extends MatchGame {

    private Celebrity[] input;

    public FemaleMatchGame(FemaleCelebrity[] input) {
        this.input = input;
        initializeCandidates();
    }

    @Override
    public void initializeCandidates() {
        candidates = new Celebrity[input.length];
        for (int i = 0; i < input.length; i++) {
            candidates[i] = input[i];
        }
    }

    @Override
    public Celebrity playGame() {
        return null;
    }

    @Override
    public void printCandidates() {
        System.out.println("[여자 연예인 월드컵 참가자 명단]");
        super.printCandidates();
    }
}
