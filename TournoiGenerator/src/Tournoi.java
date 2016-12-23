import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tournoi {
	
	private int nbJoueur,nbTour,byes;
	private double puissance = 0;
	private ArrayList<Player> pool = new ArrayList<>();
	private ArrayList<Match<Player>> bracketWin = new ArrayList<>();
	private ArrayList<Match<Player>> bracketLoose = new ArrayList<>();
	
	
	public Tournoi(ArrayList<Player> pool){
		this.pool = pool;
		this.nbJoueur = pool.size();
		
		while(Math.pow(2, puissance)<nbJoueur){
			puissance++;
		}
		nbTour = (int)puissance;
		
		byes = ((int)Math.pow(2, puissance))-nbJoueur;
	}
	
	public String info(){
		return ("Le Tournoi contient : "+nbJoueur+" joueurs et s'effectuera en "+nbTour+" tours.\nPour le premier tour, il y aura " +byes+" joueurs abstenus");
	}
	
	public void genererBrackets(){
		//Génère le premier tour sans les joueurs abstenus;
		for (int i=0; i<(nbJoueur-byes)/2;i++){
			bracketWin.add(new Match<Player>(bracketWin.size(),1,this.tiragePool(), this.tiragePool(),true));
		}
		
		//Genere le 2nd tour avec les gagnants et les joueurs abstenus du 1er tour
		
		ArrayList<Match<Player>> bracketcache = new ArrayList<>();
		for (Match<Player> match : bracketWin){
			bracketcache.add(match);
		}
		
		for (int i=0; i<(byes+bracketWin.size())/2;i++){
			while(bracketcache.size()>=2){
				bracketWin.add(new Match<>(bracketWin.size(), 2, bracketcache.remove(bracketcache.size()-1), bracketcache.remove(bracketcache.size()-1), true));
			}
			if (bracketcache.size()==1 && !pool.isEmpty()){
				bracketWin.add(new Match<>(bracketWin.size(), 2, bracketcache.remove(bracketcache.size()-1), pool.remove(pool.size()-1), true));
				}
			if (bracketcache.isEmpty()&& pool.size()>=2){
				bracketWin.add(new Match<>(bracketWin.size(), 2, this.tiragePool(),this.tiragePool(), true));
			}
			
		}
		
		//Genere le tournoi sur la base de 2i
		int cptTour = 2;
		
		while (this.nbMatch(cptTour) >= 2){
			ArrayList<Match<Player>> survivor = this.poolTour(cptTour);
			while (!survivor.isEmpty()){
				bracketWin.add(new Match<>(bracketWin.size(), cptTour+1, survivor.remove(survivor.size()-1), survivor.remove(survivor.size()-1), true));
			}
			cptTour++;
		}
			
	}
	/**
	public ArrayList<Match<Player>> genererLooserBracket(){
		int byes = ((int)Math.pow(2, puissance))-nbJoueur;
		ArrayList<Match<Player>> startPool = new ArrayList<>();
		startPool = poolTour(1);
		
		
	}
	*/
	
	
	
	/**
	 * tir un joueur au sort et l'enlève de la pool de départ
	 * @return
	 */
	private Player tiragePool(){
		
		int tirage = (int)(Math.random()*(pool.size()));
		
		
		return pool.remove(tirage);
	}
	/**
	 * retourne une arraylist contenant tous les matchs du bracket du numTour
	 * @param numTour
	 * @return
	 */
	public ArrayList<Match<Player>> poolTour(int numTour){
		ArrayList<Match<Player>> survivor = new ArrayList<>();
		for(Match<Player> match : bracketWin){
			if (match.getNtour() == numTour){
				survivor.add(match);
			}
		}
		return survivor;
	}
	
	public int nbMatch(int numTour){
		int cpt = 0;
		for (Match<Player> match : bracketWin){
			if(match.getNtour() == numTour)cpt++;
		}
		return cpt;
	}
	

	
	public String afficher(){
		String result = "";
		
		for (int i =0 ; i<bracketWin.size();i++){
			result += bracketWin.get(i).toString();
			
		}
		return result;
	}
	
	

}
