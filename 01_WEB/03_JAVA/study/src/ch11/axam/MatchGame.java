package ch11.axam;

public abstract class MatchGame {
    protected Celebrity[] candidates;

    public abstract void initializeCandidates();
    public abstract Celebrity playGame();

    public void printCandidates() {
        for (Celebrity c : candidates) {
            System.out.println(c);
        }
    }
}
