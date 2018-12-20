package display;

public class Score {
	
	int combo=1;
	int score=0;
	
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
