/*
 * Classe faussaire pour les
 * tests unitaires du code
 * ecrit dans la classe Autobus.
 */

package tec;

class PassagerStandard{
static final byte ASSIS=0;
static final byte DEBOUT=1;
static final byte DEHORS=2;
byte status = ASSIS;

private String nom;
public int destination;
final Messages messages = new Messages();

  PassagerStandard(){
	status = DEHORS;
  }

  PassagerStandard (String nom, int destination) {
    this.nom=nom;
    this.destination=destination;
    status = DEHORS;
  }

  public boolean estAssis() {
    return status == ASSIS;
  }

  public boolean estDebout() {
    return status == DEBOUT;
  }

  public boolean estDehors() {
    return status == DEHORS;
  }
  
  public String nom() {
	return this.nom;
  }

  public void accepterSortie() {
	status=DEHORS;
	messages.add("accepterSortie");
  }

  public void accepterPlaceAssise() {
	status=ASSIS;
	messages.add("accepterPlaceAssise");
  }

  public void accepterPlaceDebout() {
	status=DEBOUT;
	messages.add("accepterPlaceDebout");
  }

  public void nouvelArret(/*Autobus bus, int numeroArret*/) {
	messages.add("nouvelArret");
  }

  public void monterDans(/*Autobus t*/) { 
	messages.add("monterDans");
  }
  

}
