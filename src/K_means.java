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
public class K_means {
	
	/**
	 * choix aléatoire des centres
	 */
	public ArrayList<Float> ChoixCentres(int K, ArrayList<Float> donnees){
		ArrayList<Float> centers = new ArrayList<Float>();
		for (int i=0; i<K; i++){
			int random = (int)(Math.random()*(donnees.size()-1));
			centers.add(G.get(random));
		}
		return centers;
	}
	
	/**
	 * allocation des données dans un groupe
	 * @param K nombre de centres
	 * @param donnees
	 * @param centers liste des centres
	 */
	public void allocationInitialeDonneesAGroupe(ArrayList<Float> donnees, ArrayList<Float> centers, ArrayList<Groupe> groupes){
		for (int i=0; i<donnees.size(); i++){
			int groupeCategorie = 0;
			Float donneeEtudiee = donnees.get(i);
			Float distance = Math.abs(donneeEtudiee-centers.get(0));
			for (int j=1; j<centers.size(); j++){
				if(distance>Math.abs(donneeEtudiee-centers.get(j))){
					distance = Math.abs(donneeEtudiee-centers.get(j));
					groupeCategorie = j;
				}
			}
			groupes.get(groupeCategorie).addMember(donneeEtudiee);	
		}
	}
	
	public boolean reallocationDonneesAGroupe(ArrayList<Float> centers, ArrayList<Groupe> groupes){
		boolean reallocation = false;
		
		ArrayList<Groupe> groupesRealloués = new ArrayList<Groupe>(groupes.size());
		
		//parcours des groupes
		for (int i=0; i<groupes.size(); i++){
			// création du groupe copie de même centre
			groupesRealloués.get(i).setCenter((groupes.get(i).getCenter())); 
			
			//parcours des membres du groupe de référence
			for (int j=0; j<groupes.get(i).getMembers().size(); j++){
				Float donneeEtudiee = groupes.get(i).getMembers().get(j);
				
				//distance par rapport au centre de son groupe
				float distance = Math.abs(donneeEtudiee- groupes.get(i).getCenter());
				
				// parcours des distances aux autres centres
				int newGroupeNumber = -1;
				for (int k=0; k<centers.size(); k++){
					// changement si distance inférieure
					if (distance>Math.abs(donneeEtudiee-centers.get(k))){
						distance = Math.abs(donneeEtudiee-centers.get(k));
						reallocation = true;
						newGroupeNumber = k;
					}
				}
				if (!reallocation){
					groupesRealloués.get(i).addMember(donneeEtudiee);
				} else {
					groupesRealloués.get(newGroupeNumber).addMember(donneeEtudiee);
				}
			}
		}
		return reallocation;
	}
}
