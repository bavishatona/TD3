package tec;
import tec.EtatPassager;

public class PassagerStandard {


  private String nom;
  private int destination;
  private EtatPassager etat;

  public PassagerStandard(String nom, int destination) {
	this.nom=nom;
	this.destination=destination;
	this.etat=new EtatPassager();

  }

  public String nom() {
    return this.nom;
  }

  public boolean estDehors() {
    return etat.estExterieur();
  }

  public boolean estAssis() {
    return etat.estAssis();
  }

  public boolean estDebout() {
    return etat.estDebout();
  }

  public void accepterSortie() {
	etat= etat.dehors();
  }

  public void accepterPlaceAssise() {
	etat= etat.assis();
  }

  public void accepterPlaceDebout() {
	etat= etat.debout();
  }

  public void nouvelArret(Autobus bus, int numeroArret) {
	if (numeroArret== this.destination)
		bus.demanderSortie();
	else bus.allerArretSuivant();
	
  }

  public void monterDans(Autobus t) { 

	if (t.aPlaceAssise())
		{
			t.demanderPlaceAssise();
			etat=etat.assis();
		}
	else if (t.aPlaceDebout())
		{
			t.demanderPlaceDebout();
			etat=etat.debout();
		}
  }
}
