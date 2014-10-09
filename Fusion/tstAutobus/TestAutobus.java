package tec;

class TestAutobus {
  void testFaussaire() {
  
	PassagerStandard passagerS= new PassagerStandard(null, 3);
	assert true == passagerS.estDehors(): "le passager n'est pas dehors";
	passagerS.accepterPlaceAssise();
	assert "accepterPlaceAssise"== passagerS.messages.getLast(): "Le passager n'a pas accepté une place assise";
    //assert false;
  }


  void testConstructeur(){
	Autobus[] bus= {new Autobus(50,0), new Autobus(0,50)};
	assert bus[0].aPlaceAssise()==true: "Le bus1 n'a pas de place assise";
	assert bus[0].aPlaceDebout()==false: "Le bus1 a des places debouts";
	assert bus[1].aPlaceAssise()==false: "Le bus2 a des places assises";
	assert bus[1].aPlaceDebout()==true: "Le bus2 n'a pas de place debout";
  }

  void testDemander(){
	PassagerStandard[] faux = {null,
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard()}; //9

    Autobus bus = new Autobus(5, 3);

    /*******************************************/
    for (int i = 1; i <= 5; i++) {

      bus.demanderPlaceAssise(faux[i]);

      // test etat.
      if (i == 5)
	assert false == bus.aPlaceAssise() : "fin assis";
      else
	assert true == bus.aPlaceAssise() : "demande " + i;	
    }

    // test interaction.
    for (int i = 1; i <= 5; i++) {
      assert 1 == faux[i].messages.size() : "faux " + i;
      assert "accepterPlaceAssise" == faux[i].messages.getLast() 
	: "message " + i;
    }
    
    /*******************************************/
    for (int i = 6; i <= 8; i++) {

      bus.demanderPlaceDebout(faux[i]);

      // test etat.
      if (i == 8)
	assert false == bus.aPlaceDebout() : "fin debout";
      else
	assert true == bus.aPlaceDebout() : "demande " + i;	
    }

    // test interaction.
    for (int i = 6; i <= 8; i++) {
      assert "accepterPlaceDebout" == faux[i].messages.getLast() 
	: "message " + i;
    }
  }

  void testDemanderSortie(){
	PassagerStandard[] faux = {
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       }; //5

    	Autobus bus = new Autobus(2, 3);

    
    	for (int i = 0; i < 2; i++) {
      		bus.demanderPlaceAssise(faux[i]);
				}
    	for (int i = 2; i < 5; i++) {
      		bus.demanderPlaceDebout(faux[i]);
				}
	bus.demanderSortie(faux[0]);
	bus.demanderSortie(faux[2]);
	assert true == bus.aPlaceAssise(): "Il n'y a plus de places assises";
	assert true == bus.aPlaceDebout(): "Il n'y a plus de places debouts";

	////*********////
	bus.demanderPlaceDebout(faux[0]);
	assert "accepterPlaceDebout" == faux[0].messages.getLast() : "message DemanderSortie";
	
	
      

  }

  void testAllerArretSuivant(){
	PassagerStandard[] faux = {
			       new PassagerStandard(null, 2),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       }; //5

    	Autobus bus = new Autobus(2, 3);

    
    	for (int i = 0; i < 2; i++) {
      		bus.demanderPlaceAssise(faux[i]);
				}
        bus.demanderPlaceDebout(faux[4]);
	
	bus.allerArretSuivant();
	bus.allerArretSuivant();
	bus.allerArretSuivant();
	assert "accepterSortie" == faux[0].messages.getLast() : "message AllerArretSuivant";


	/****************/
	bus.demanderSortie(faux[1]);
	bus.demanderSortie(faux[4]);	
	assert "accepterSortie" == faux[1].messages.getLast(): "Le passager 0 n'a pas accepté de sortir";
	assert "accepterSortie" == faux[4].messages.getLast(): "Le passager 4 n'a pas accepté de sortir";

		

  }

  void testDemanderChangement(){
	PassagerStandard[] faux = {
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       new PassagerStandard(),
			       }; //5

    	Autobus bus = new Autobus(2, 3);

    
    	for (int i = 0; i < 2; i++) {
      		bus.demanderPlaceAssise(faux[i]);
				}
    	for (int i = 2; i < 4; i++) {
      		bus.demanderPlaceDebout(faux[i]);
				}
	bus.demanderChangerEnDebout(faux[0]);
	assert "accepterPlaceDebout" == faux[0].messages.getLast(): "Le passager 0 n'a pas accepterPlaceDebout";
	assert true== faux[0].estDebout(): "Le passager 0 est assis";
	
	/***********/
	bus.demanderChangerEnAssis(faux[2]);
	assert "accepterPlaceAssise" == faux[2].messages.getLast(): "Le passager 2 n'a pas accepterPlaceAssise";
	assert true== faux[2].estAssis(): "Le passager 2 est assis";
  }


  void lancer() { 
    int nbTest = 0;

    System.out.print('.'); nbTest++;
    //testFaussaire();
    testConstructeur();
    System.out.print('.'); nbTest++;
    testDemander();
    System.out.print('.'); nbTest++;
    testDemanderSortie();
    System.out.print('.'); nbTest++;
    testAllerArretSuivant();
    System.out.print('.'); nbTest++;
    testDemanderChangement();

    System.out.println("(" + nbTest + "):OK: " + getClass().getName()); 
  }
}
