package tec;
class TestJaugeNaturel{

	void TestJaugeNaturel(){
	
	};
	
	public void lancer(){
		int i=0;
		testEstRouge();
		i++;
		System.out.println(".");
		testEstBleu();
		i++;
		System.out.println(".");
		testEstVert();
		i++;
		System.out.println(".");
		testIncrementer();
		i++;
		System.out.println(".");
		testDecrementer();
		i++;
		System.out.println("Nombre de test est : " + i + " OK");
	};
	
	public void testDansIntervalle(long maxVigie, long depart){
		JaugeNaturel jaugeN=new JaugeNaturel(maxVigie,depart);
		assert !jaugeN.estBleu() : "jaugeN n'est pas bleu";
		assert ! jaugeN.estRouge() : "jaugeN n'est pas rouge";
		assert jaugeN.estVert() : " jaugeN est verte ";
	};
	
	public void testEstRouge() {
	
		System.out.println("testEstRougeCas1");
		JaugeNaturel jaugeN=new JaugeNaturel(67899, 80000);
		assert ! jaugeN.estBleu() : "jaugeN n'est pas bleu";
		assert ! jaugeN.estVert() : "jaugeN n'est pas vert";
		assert jaugeN.estRouge() : "jaugeN est pas rouge";
		
		System.out.println("testEstRougeCas2");
		JaugeNaturel jaugeN1=new JaugeNaturel(67899, 67899);
		assert ! jaugeN1.estBleu() : "jaugeN n'est pas bleu";
		assert ! jaugeN1.estVert() : "jaugeN n'est pas vert";
		assert jaugeN1.estRouge() : "jaugeN est pas rouge";
		
		
		
 };


	public void testEstBleu(){
	
		System.out.println("testEstBleu");
		JaugeNaturel jaugeN=new JaugeNaturel(67899, -400);
		assert !jaugeN.estRouge() : "jaugeN n'est pas rouge";
		assert !jaugeN.estVert() : "jaugeN n'est pas vert";
		assert jaugeN.estBleu() : "jaugeN est bleu";
		
	};

	public void testEstVert(){
	
		
		
		System.out.println("testEstVert");
		JaugeNaturel jaugeN1=new JaugeNaturel(67899,0);
		assert !jaugeN1.estBleu() : "jaugeN n'est pas bleu";
		assert !jaugeN1.estRouge() : "jaugeN n'est pas rouge";
		assert  jaugeN1.estVert() : " jaugeN est vert ";
	};


	public void testIncrementer(){

		System.out.println("testIncrementer");
		JaugeNaturel jaugeN=new JaugeNaturel(69899,0);
		System.out.println("toString... "+ jaugeN.toString());
		jaugeN.incrementer();
		System.out.println("toString... "+ jaugeN.toString());

	};

	public void testDecrementer(){

		System.out.println("testDecrementer");
		JaugeNaturel jaugeN=new JaugeNaturel(69899,0);
		System.out.println("toString... "+jaugeN.toString());
		jaugeN.decrementer();
		System.out.println("toString... "+jaugeN.toString());
	};

}
