/*
 * Classe faussaire pour les
 * tests unitaires du code
 * ecrit dans la classe PassagerStandard.
 */


package tec;

class Autobus{


static final byte PLACEASSISE=0;
static final byte PLACEDEBOUT=1;
byte status = 0;


final Messages messages = new Messages();

  public Autobus(int assis, int debout) {
	if (assis != 0) status=0;
	else if (debout != 0) status=1;

  }
  
  
  public void allerArretSuivant() { 
  
	messages.add("allerArretSuivant");
  }

  public boolean aPlaceAssise() {
    return status==PLACEASSISE;
  }

  public boolean aPlaceDebout() {
    return status==PLACEDEBOUT;
  }
  
  public void demanderChangerEnAssis(/*PassagerStandard p*/) {
  
	messages.add("demanderChangerEnAssis");
  }
  
  public void demanderChangerEnDebout(/*PassagerStandard p*/) {
  
	messages.add("demanderChangerEnDebout");
  }

  public void demanderPlaceAssise(/*PassagerStandard p*/) {
  
	messages.add("demanderPlaceAssise");
  }

  public void demanderPlaceDebout(/*PassagerStandard p*/) {
  
	messages.add("demanderPlaceDebout");
  }

  public void demanderSortie(/*PassagerStandard p*/) {
  
	messages.add("demanderSortie");
  }


}
