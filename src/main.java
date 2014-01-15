import java.util.ArrayList;

/**
 * Project: TP-ANREC
 * Creation date: 15 janv. 2014
 * Author: Audrey
 */

/**
 * @author Audrey
 *
 */

public class main {
	
	
/**
 * 
 * @param K nombre de centres
 * @param G	
 */
	public void Kmeans(int K, ArrayList<Float> donnees){
		K_means methodeKMeans = new K_means();
		ArrayList<Float> centers = methodeKMeans.ChoixCentres(K, donnees);
		
		// création des groupes
		ArrayList<Groupe> groupes = new ArrayList<Groupe>();
		for (int i=0; i<centers.size(); i++){
			groupes.add(new Groupe(centers.get(i)));
		}
		
		// remplissage des groupes
		methodeKMeans.allocationInitialeDonneesAGroupe(donnees, centers, groupes);
		
		// calcul nouveaux centres
		ArrayList<Float> newCenters = new ArrayList<Float>();
		for (int i=0; i<groupes.size(); i++){
			ArrayList<Float> members = groupes.get(i).getMembers();
			Float resultat = new Float(0);
			for(int j=0; j< members.size(); j++){
				  resultat = resultat + members.get(j);
			}
			Float center = resultat/(members.size());
			groupes.get(i).setCenter(center);
			newCenters.add(center);
		}
		
	}
	
	
}


