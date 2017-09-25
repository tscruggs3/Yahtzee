/**
 * Created by scruggst on 9/25/17.
 */
public class YahtzeeScorer {

    private int[] scoreboard;

    //Constructor
    public YahtzeeScorer(int[] scoreboard) {
        this.scoreboard = scoreboard;
    }

    public int score(){
        int result = 0;
        for(int i = 0; i<4; i ++){
            if (scoreboard[i] != -1){
                result += scoreboard[i];
            }
        } return result;
    }

    public void scoreYahtzee(int[] roll){
        if (scoreboard[0] != -1){
            System.out.println("Yahtzee already scored");
            return;
        }
        boolean sufficientDice = true;
        for(int i = 1; i<5; i ++){
            if (roll[0]!=roll[i]){
                sufficientDice = false;
            }
        }
        if (sufficientDice == true){
            scoreboard[0] = 50;
        } else{
            scoreboard[0] = 0;
        }
    }


    public void scoreLargeStraight(int[] roll) {
        if (scoreboard[1] != -1){
            System.out.println("Large Straight already scored");
            return;
        }
        boolean sufficientDice = true;
        for(int i = 0; i<4; i ++) {
            for (int j = i+1; j < 5; j++) {
                if(roll[i] == roll[j]){
                    sufficientDice = false;
                }
            }
        }

        if (sufficientDice == true){
            scoreboard[0] = 40;
        } else{
            scoreboard[0] = 0;
        }
    }

    public void scoreFullHouse(int[] roll){
        if (scoreboard[2] != -1){
            System.out.println("Full House already scored");
            return;
        }
        boolean sufficientDice = true;
        int first = roll[0];
        int firstAcc = 1;
        int second = 0;
        int secondAcc = 0;
        for (int i = 1; i<5; i++){
            if (first == roll[i]){
                firstAcc++;
            }else if(second==0 || second == roll[i]){
                second = roll[i];
                secondAcc++;
            }else{
                sufficientDice = false;
            }
        }
        if (firstAcc > 3 || secondAcc > 3){
            sufficientDice = false;
        }
        if (sufficientDice == true){
            scoreboard[0] = 25;
        } else{
            scoreboard[0] = 0;
        }
    }

    public void scoreThreeOfAKind(int[] roll) {
        if (scoreboard[3] != -1){
            System.out.println("Three of a Kind already scored");
            return;
        }
        boolean sufficientDice = true;
        int first = roll[0];
        int firstAcc = 1;
        int second = 0;
        int secondAcc = 0;
        int third = 0;
        int thirdAcc = 0;
        for (int i = 1; i<5; i++){
            if (first == roll[i]){
                firstAcc++;
            }else if(second==0 || second == roll[i]){
                second = roll[i];
                secondAcc++;
            }else if(third == 0 || third == roll[i]){
                third = roll[i];
                thirdAcc++;
            } else{
                sufficientDice = false;
            }
        }
        if ((firstAcc < 3) && (secondAcc < 3) && (thirdAcc < 3)){
            sufficientDice = false;
        }
        if (sufficientDice == true){
            int sum = 0;
            for (int i = 0; i<5; i++){
                sum += roll[i];
            }
            scoreboard[0] = sum;
        } else{
            scoreboard[0] = 0;
        }
    }
}
