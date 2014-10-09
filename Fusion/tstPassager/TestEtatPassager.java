package tec;
class TestEtatPassager{
	
	void TestEtatPassager(){
	
	};
	
	public void lancer(){
		
		int i=0;
		testEstAssis();
		i++;
		System.out.println(".");
		testEstDebout();
		i++;
		System.out.println(".");
		testEstDehors();
		i++;
		System.out.println("Nombre de test est : " + i + " OK");
	
	};
	
	/*public void testExterieur(){
		EtatPassager etatP=new EtatPassager();
		etatP.dehors();
		assert !etatP.estAssis() : "etatP n'est pas assis";
		assert !etatP.estDebout() : "etatP n'est pas debout";
		assert !etatP.estInterieur() : "etatP n'est pas a l'interieur";
		assert etatP.estExterieur() : "etatP est a l'exterieur";		
	
	};*/
	
	public void testEstAssis(){
		System.out.println("testEstAssis ");
		EtatPassager etatP=new EtatPassager();
		etatP=etatP.assis();
		System.out.println("toString.... " + etatP.toString());
		assert etatP.estAssis() : "etatP est assis";
		assert !etatP.estDebout() : "etatP n'est pas debout";
		assert etatP.estInterieur() : "etatP est a l'interieur";
		assert !etatP.estExterieur() : "etatP n'est pas a l'exterieur";	
	};

	public void testEstDebout(){
		System.out.println("testEstDebout ");
		EtatPassager etatP=new EtatPassager();
		etatP=etatP.debout();
		System.out.println("toString.... " + etatP.toString());
		assert !etatP.estAssis() : "etatP n'est pas assis";
		assert etatP.estDebout() : "etatP est debout";
		assert etatP.estInterieur() : "etatP est a l'interieur";
		assert !etatP.estExterieur() : "etatP n'est pas a l'exterieur";	

	};

	public void testEstDehors(){
		System.out.println("testEstDehors ");
		EtatPassager etatP=new EtatPassager();
		etatP=etatP.dehors();
		System.out.println("toString.... " + etatP.toString());
		assert !etatP.estAssis() : "etatP n'est pas assis";
		assert !etatP.estDebout() : "etatP n'est pas debout";
		assert !etatP.estInterieur() : "etatP n'est pas a l'interieur";
		assert etatP.estExterieur() : "etatP est a l'exterieur";	

	};

	
}


