package display;

import games.Motus;

public class Score {
	
	private int combo;
	private int score;
	private String name;
	
	public Score() {
		this.combo=1;
		this.score=0;
	}
	
	
	public Score(int score,String string) {
        this.score=score;
        this.name=string;

    }
	/*
	 * Bonne réponse
	 */
	public void GoodAnswer(int x) {
		this.score += x*this.combo;
		this.combo++;
	}
	/*
	 * Bonne réponse (motus)
	 */
	public void GoodAnswer(int x, int tries) {
		this.score += x*tries;
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
