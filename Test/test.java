
import org.junit.Test;
import static groovy.util.GroovyTestCase.assertEquals;

public class test {

    @Test
    public void scoreYahtzeeNormal() {
        // STEP 1:
        int[] scoreboard = {-1,-1,-1,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {1,1,1,1,1};

        int prevScore = myGame.score();
        myGame.scoreYahtzee(roll);

        assertEquals(prevScore+50,myGame.score());
    }

    @Test
    public void scoreYahtzeeInsufficientDice(){
        int[] scoreboard = {-1,-1,-1,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {2,1,1,1,1};
        int prevScore = myGame.score();
        myGame.scoreYahtzee(roll);

        assertEquals(prevScore,myGame.score());
    }

    @Test
    public void yahtzeeAlreadyScored(){
        int[] scoreboard = {50,-1,-1,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {1,1,1,1,1};
        int prevScore = myGame.score();
        myGame.scoreYahtzee(roll);

        assertEquals(prevScore,myGame.score());

    }

    @Test
    public void getCurrentScore(){
        int[] scoreboard = {50,-1,25,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);

        assertEquals(75,myGame.score());
    }

    @Test
    public void scoreLargeStraightNormal(){
        int[] scoreboard = {-1,-1,-1,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {1,2,3,4,5};

        int prevScore = myGame.score();
        myGame.scoreLargeStraight(roll);

        assertEquals(prevScore+40,myGame.score());
    }

    @Test
    public void scoreLargeStraightInsufficientDice(){
        int[] scoreboard = {-1,-1,-1,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {3,2,3,4,5};

        int prevScore = myGame.score();
        myGame.scoreLargeStraight(roll);

        assertEquals(prevScore,myGame.score());
    }

    @Test
    public void largeStraightAlreadyScored(){
        int[] scoreboard = {-1,0,-1,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {1,2,3,4,5};

        myGame.scoreLargeStraight(roll);

        assertEquals(0,myGame.score());
    }

    @Test
    public void scoreFullHouseNormal(){
        int[] scoreboard = {-1,-1,-1,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {1,1,1,2,2};

        int prevScore = myGame.score();
        myGame.scoreFullHouse(roll);

        assertEquals(prevScore+25,myGame.score());
    }

    @Test
    public void scoreFullHouseInsufficientDice(){
        int[] scoreboard = {-1,-1,-1,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {1,1,1,1,2};

        int prevScore = myGame.score();
        myGame.scoreFullHouse(roll);

        assertEquals(prevScore,myGame.score());
    }

    @Test
    public void fullHouseAlreadyScored(){
        int[] scoreboard = {-1,-1,0,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {1,1,1,2,2};

        myGame.scoreFullHouse(roll);

        assertEquals(0,myGame.score());
    }

    @Test
    public void scoreThreeOfAKindNormal(){
        int[] scoreboard = {-1,-1,-1,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {1,2,3,3,3};

        int prevScore = myGame.score();
        myGame.scoreThreeOfAKind(roll);

        assertEquals(prevScore+12,myGame.score());
    }

    @Test
    public void scoreThreeOfAKindInsufficientDice(){
        int[] scoreboard = {-1,-1,-1,-1};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {1,2,3,6,3};

        int prevScore = myGame.score();
        myGame.scoreThreeOfAKind(roll);

        assertEquals(prevScore,myGame.score());
    }

    @Test
    public void threeOfAKindAlreadyScored(){
        int[] scoreboard = {-1,-1,-1,0};
        YahtzeeScorer myGame = new YahtzeeScorer(scoreboard);
        int[] roll = {1,2,3,3,3};

        myGame.scoreThreeOfAKind(roll);

        assertEquals(0,myGame.score());
    }
}

