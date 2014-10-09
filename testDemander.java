  /*
   * Remplir toutes les places assises d'un autobus.
   * Remplir toutes les places debout d'un autobus.
   */
  void testDemander() {
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
