
import org.junit.Test;

import static groovy.util.GroovyTestCase.assertEquals;

public class YahtzeeScorer {

    //roll is an array with the values of the five dice
    private int[] roll;

    //scoreboard is an array with the values of the scores of following, in order, or null if no value:
    //Yahtzee, Large straight, Full house, Three of a kind
    private int[] scoreboard;

    public YahtzeeScorer(int[] roll, int[] scoreboard){
        this.roll = roll;
        this.scoreboard = scoreboard;
    }

    @Test
    public void scoreYahtzee(int[] roll) {
        // STEP 1: Create some objects

        // STEP 2: Send some messages


        // STEP 3: Verify the results.org.junit.Assert.
        assertEquals(50, 20);
        assertEquals(70, 50);
    }
    public static void main(String[] args) {
        int[] roll = new int[5];
        int[] scoreboard = new int[5];
        YahtzeeScorer myGame = new YahtzeeScorer(roll, scoreboard);
    }
}

