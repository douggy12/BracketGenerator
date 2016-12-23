
public class Joueur implements Player {
	private int id;
	private int prio;
	/**
	 * @param id
	 * @param prio
	 */
	public Joueur(int id, int prio) {
		super();
		this.id = id;
		this.prio = prio;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (" Joueur"+id);
	}
	
	public String afficher() {
		// TODO Auto-generated method stub
		return (" Joueur"+id);
	}
	
	

}
