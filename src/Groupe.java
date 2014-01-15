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
public class Groupe {

	private Float center;
	private ArrayList<Float> members;
	
	public Groupe(Float center){
		this.center = center;
		this.members = new ArrayList<Float>();
		this.members.add(center);
	}
	
	/**
	 * @return the center
	 */
	public Float getCenter() {
		return center;
	}
	
	/**
	 * @param center the center to set
	 */
	public void setCenter(Float center) {
		this.center = center;
	}
	
	/**
	 * @return the members
	 */
	public ArrayList<Float> getMembers() {
		return members;
	}
	
	/**
	 * @param members the members to set
	 */
	public void setMembers(ArrayList<Float> members) {
		this.members = members;
	}
	
	/**
	 * @param member the member to add
	 */
	public void addMember(Float member) {
		this.members.add(member);
	}
	
	
}
