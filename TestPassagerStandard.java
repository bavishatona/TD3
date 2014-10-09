package tec;

class TestPassagerStandard {
  void testFaussaire() {
    assert false;
  }

  void lancer() {
    int nbTest = 0;

    System.out.print('.'); nbTest++;
    testFaussaire();

    System.out.println("(" + nbTest + "):OK: " + getClass().getName()); 
  }
}
