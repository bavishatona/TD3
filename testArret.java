  /*
   * Deux cas
   *  - numero d'arret < a la destination
   *  - numero d'arret >= a la destination 
   */
  void testArret() {
    PassagerStandard p = new PassagerStandard("yyy", 5);
    
    Autobus faux = new Autobus(Autobus.VIDE);

    /*******************************************/
    p.nouvelArret(faux, 1);
    
    // test interaction.
    assert 0 == faux.messages.size() : "pas a destination";

    /*******************************************/
    p.nouvelArret(faux, 5);
    
    // test interaction.
    assert "demanderSortie" == faux.messages.getLast() : "destination";    
  }
