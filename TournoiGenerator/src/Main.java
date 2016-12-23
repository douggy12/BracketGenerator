import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Player> pool = new ArrayList<>();
		
		for (int i = 0 ;i<13;i++){
			
			pool.add(new Joueur(i,0));
		}
		
		
		
		Tournoi monTournoi = new Tournoi(pool);
		System.out.println(monTournoi.info());
		monTournoi.genererBrackets();
		
		System.out.println(monTournoi.afficher());
		
		

	}

}
