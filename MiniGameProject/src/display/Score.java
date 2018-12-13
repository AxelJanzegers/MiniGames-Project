package display;

public class Score {
	
	int combo;
	int score;
	String name;
	
	public Score() {
		this.combo=1;
		this.score=0;
	}
	
	
	public Score(int score,String string) {
        this.score=score;
        this.name=string;

    }
	
	public void GoodAnswer(int x) {
		this.score += x*this.combo;
		this.combo++;
	}
	
	public void BadAnswer() {
		this.combo=1;
	}
	
	public void AfficheScore() {
		System.out.println("Score actuel : " + this.score);
	}

	public int getCombo() {
		return combo;
	}

	public void setCombo(int combo) {
		this.combo = combo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
