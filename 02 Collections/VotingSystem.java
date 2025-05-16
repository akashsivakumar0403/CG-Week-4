import java.util.*;

public class VotingSystem {
    private HashMap<String, Integer> voteMap = new HashMap<>();
    private LinkedHashMap<String, Integer> voteInsertionOrderMap = new LinkedHashMap<>();

    public void casteVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteInsertionOrderMap.put(candidate, voteInsertionOrderMap.getOrDefault(candidate, 0) + 1);
    }

    public void displayVotes() {
        System.out.println("Votes in insertion order: ");
        for (Map.Entry<String, Integer> entry : voteInsertionOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayVotesSorted() {
        System.out.println("Votes in sorted order:");
        TreeMap<String, Integer> sortedMap = new TreeMap<>(voteMap);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void displayWinner() {
        String winner = null;
        int maxVotes = -1;
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        System.out.println("Winner = " + winner + " with " + maxVotes + " votes");
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.casteVote("Ruchi");
        votingSystem.casteVote("Vandit");
        votingSystem.casteVote("Ami");
        votingSystem.casteVote("Bhadrik");
        votingSystem.casteVote("Vandit");
        votingSystem.casteVote("Ruchi");
        votingSystem.casteVote("Ruchi");
        votingSystem.casteVote("Ami");
        votingSystem.casteVote("Ruchi");

        votingSystem.displayVotes();
        System.out.println();

        votingSystem.displayVotesSorted();
        System.out.println();

        votingSystem.displayWinner();
    }
}
