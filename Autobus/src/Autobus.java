package tec;

public class Autobus {

    final private PassagerStandard[] passagers;
    private JaugeNaturel jauge;
    final private int assis;
    final private int debout;
    private int nbPassagersAssis;
    private int nbPassagersDebout;
    private int arret;


  public Autobus(int assis, int debout) {
	this.debout=debout;
	this.assis=assis;
	this.arret = 0;
        this.nbPassagersDebout = 0;
        this.nbPassagersAssis = 0;
	passagers= new PassagerStandard[assis+debout];
	jauge=new JaugeNaturel(0, assis+debout);
  }

  public boolean aPlaceAssise() {
    return assis>nbPassagersAssis;
  }

  public boolean aPlaceDebout() {
    return debout>nbPassagersDebout;
  }

  public void demanderPlaceAssise(PassagerStandard p) {

	if(this.aPlaceAssise())
		{
		p.accepterPlaceAssise();
		this.nbPassagersAssis++;
		for (int i=0; i< (assis+debout); i++)
		{
			if (passagers[i]==null)
				passagers[i]=p;
		}
		jauge.incrementer();
		}
	else System.out.println("Plus de places assises dans le bus !");
  }

  public void demanderPlaceDebout(PassagerStandard p) {
	if(this.aPlaceDebout())
		{
		p.accepterPlaceDebout();
		this.nbPassagersDebout++;
		for (int i=0; i< (assis+debout); i++)
		{
			if (passagers[i]==null)
				passagers[i]=p;
		}
		jauge.incrementer();
		
		}
	else System.out.println("Plus de places debout dans le bus !");
		
  }

  public void demanderSortie(PassagerStandard p) {
	
	if(p.estAssis())
		{
			this.nbPassagersAssis--;
		}
	if(p.estDebout()){
			this.nbPassagersDebout--;
		}
	for (int i=0; i< (assis+debout); i++)
	{
		if (passagers[i]!=null){
			if ( passagers[i].nom() == p.nom() && passagers[i].estAssis()==p.estAssis() && passagers[i].estDebout()==p.estDebout())
				passagers[i]=null;
		}
	}
		p.accepterSortie();
		jauge.decrementer();
  }

  public void demanderChangerEnDebout(PassagerStandard p) {

	if(this.aPlaceDebout())
		{
		   this.nbPassagersAssis--;
		   p.accepterPlaceDebout();
		   this.nbPassagersDebout++;
		   for (int i=0; i<(assis + debout); i++)
		   {
		     if (passagers[i]!=null){
		   	if (passagers[i].nom()==p.nom()&& passagers[i].estAssis()==p.estAssis() && passagers[i].estDebout()==p.estDebout())
					passagers[i].accepterPlaceDebout();
			}
		   }
		
		}
	else System.out.println("Le passager ne peut pas changer en etat debout");

  }

  public void demanderChangerEnAssis(PassagerStandard p) {
	if(this.aPlaceAssise())
		{
			this.nbPassagersDebout--;
			p.accepterPlaceAssise();
			this.nbPassagersAssis++;
			for (int i=0; i<(assis + debout); i++)
		        {
			  if (passagers[i]!=null){
		   	    if (passagers[i].nom()==p.nom()&& passagers[i].estAssis()==p.estAssis() && passagers[i].estDebout()==p.estDebout())
				passagers[i].accepterPlaceAssise();
			  }
			}
		
		}
	else System.out.println("Le passager ne peut pas changer en etat assis");
  }

  public void allerArretSuivant() { 
	for (int i=0; i<(assis + debout); i++)
			{   if (passagers[i]!=null)
				{if (passagers[i].destination==this.arret)
				{
					this.demanderSortie(passagers[i]);
				}}
			}
	this.arret++;

  }
}
