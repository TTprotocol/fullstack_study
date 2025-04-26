package ch11.axam;

public class MaleMatchGame extends MatchGame {

    private Celebrity[] input;

    public MaleMatchGame(MaleCelebrity[] input) {
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
    public void printCandidates() {
        System.out.println("[남자 연예인 월드컵 참가자 명단]");
        super.printCandidates();
    }
}
