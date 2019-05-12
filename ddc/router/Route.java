package ddc.router;

public class Route {
	public static final String APPROBATION_CONGE_PAGE = "A";
	public static final String DEMANDE_CONGE_PAGE = "D";
	public static final String LISTE_CONGE_PAGE = "L";
	public static final String PRINCIPAL_PAGE = "P";
	public static final String QUIT_PAGE = "Q";	

	public String nom;
	public Object bag;
	/**
	 * 
	 */
	public Route() {
		super();
	}
	/**
	 * @param nom
	 */
	public Route(String nom) {
		super();
		this.nom = nom;
	}
	/**
	 * @param nom
	 * @param bag
	 */
	public Route(String nom, Object bag) {
		super();
		this.nom = nom;
		this.bag = bag;
	}
	
}
