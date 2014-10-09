package tec;

class TestPassagerStandard {

  void testFaussaire() {
    
	Autobus autobus=new Autobus(50, 0);
	autobus.allerArretSuivant();
	assert "allerArretSuivant"==autobus.messages.getLast(): "Autobus n'a pas demandé d'aller a l'arret suivante";
	//assert false;
  }

  void testNom(){
	PassagerStandard passagerS= new PassagerStandard("ALADIN", 0);
	assert "ALADIN"==passagerS.nom(): "Le nom du passager est faux";
  }

  void testAccepterPlaceAssise(){
	PassagerStandard passagerS= new PassagerStandard(null,0);
	passagerS.accepterPlaceAssise();
	assert true==passagerS.estAssis(): "Le passager n'a pas accepté la place assise";


  }

  void testAccepterPlaceDebout(){
	PassagerStandard passagerS= new PassagerStandard(null,0);
	passagerS.accepterPlaceDebout();
	assert true==passagerS.estDebout(): "Le passager n'a pas accepté la place debout";


  }


  void testAccepterSortie(){
	PassagerStandard passagerS= new PassagerStandard(null,0);
	passagerS.accepterSortie();
	assert true==passagerS.estDehors(): "Le passager n'a pas accepté sortie";


  }


  void testMonterDans(){

	//System.out.println("testMonterDans cas autobus vide... ");
	Autobus autobus= new Autobus(50,50);
	PassagerStandard passagerS= new PassagerStandard(null,3);
	passagerS.monterDans(autobus);
	assert autobus.messages.getLast() == "demanderPlaceAssise": "Le passager n'a pas demandé une place assise lors de la montée";
	assert false == passagerS.estDehors():"Passager est a l'extérieur";
	assert true == passagerS.estAssis():"Passager n'est pas assis";

	//System.out.println("testMonterDans cas autobus uniquement place debout... ");
	Autobus autobus1= new Autobus(0,50);
	PassagerStandard passagerS1= new PassagerStandard(null,0);
	passagerS1.monterDans(autobus1);
	assert autobus1.messages.getLast() == "demanderPlaceDebout": "Le passager n'a pas demandé une place debout malgré qu'il n'a pas trouvé de place assise lors de la montée";
	assert false == passagerS1.estDehors():"Passager est a l'intérieur";
	assert true == passagerS1.estDebout():"Passager n'est pas debout";
	

  }


  void testNouvelArret(){

	System.out.println("testNouvelArret cas numero arret inferieur a destination... ");
	Autobus autobus= new Autobus(50,50);
	PassagerStandard passagerS= new PassagerStandard(null, 3);
	passagerS.nouvelArret(autobus, 1);
	//assert true == passagerS.estAssis();
	assert "allerArretSuivant"==autobus.messages.getLast(): "Le passager n'a pas demandé d'aller arret suivant";
	 

	System.out.println("testNouvelArret cas numero arret egale a destination... ");
	Autobus autobus1= new Autobus(50,50);
	PassagerStandard passagerS1= new PassagerStandard(null, 3);
	passagerS1.nouvelArret(autobus1, 3);
	//assert true == passagerS.estDehors();
	assert autobus1.messages.getLast() == "demanderSortie": "Le passager n'a pas demandé de sortir";

  }


  


  void lancer() {
    int nbTest = 0;

    System.out.print('.'); nbTest++;
    //testFaussaire();
    testNom();
    nbTest++;
    testAccepterPlaceAssise();
    nbTest++;
    testAccepterPlaceDebout();
    nbTest++;
    testAccepterSortie();
    nbTest++;
    testMonterDans();
    nbTest++;
    testNouvelArret();

    System.out.println("(" + nbTest + "):OK: " + getClass().getName()); 
  }
}
