
public class Match<T> implements Player{
	Player p1,p2;
	int id;
	int ntour;
	boolean gagnant;
	

	/**
	 * @param joueur1
	 * @param joueur2
	 */
	public Match(int id,int ntour,Player p1, Player p2,boolean gagnant) {
		this.id = id;
		this.ntour = ntour;
		this.p1 = p1;
		this.p2 = p2;
		this.gagnant = gagnant;
	}
	
	

	public Joueur estGagnant(Joueur joueurGagnant){
		return joueurGagnant;
	}
	
	public Joueur estPerdant(Joueur joueurPerdant){
		return joueurPerdant;
	}

	@Override
	public String toString() {
		return "Match " + id + " [ntour="+ntour+" , p1=" + p1.afficher() + ", p2=" + p2.afficher() + "]\n";
	}
	
	public String afficher() {
		// TODO Auto-generated method stub
		return (" Match"+id);
	}



	public int getNtour() {
		return ntour;
	}
	

}
