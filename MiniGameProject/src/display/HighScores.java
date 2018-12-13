package display;

import java.util.ArrayList;

public class HighScores {

    ArrayList<Score> classement = new ArrayList<Score>();
    
    public void initialize() {
    Score score1 = new Score(2000,"ART");
    classement.add(score1);
    }
}