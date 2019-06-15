package miniville.ihm;
import miniville.metier.*;;

public class Controleur 
{
	public final static boolean DEBUG = true ;
	private Metier metier;
	private IHM    ihm;

	public Controleur() 
	{
		this.ihm    = new IHM(this);
		char choix = this.ihm.debut();
		if(choix == 'N')
			 this.metier = new Metier(this, this.ihm.nombreDeJoueur());
		else this.metier = new Metier(this, 0);
		//boucle du jeu
		do
			metier.jouer();
		while (!this.metier.getIsEnd());
	}

	//----------------------------------------------------------------------------------------------------------------
	//                                             LIEN SCANNERS
	public String creeJoueur() { return this.ihm.creeJoueur(); }
	public String commence  () { return this.ihm.commence();   }
	public char   choix     () { return this.ihm.choix();      }
	public char   choixDe   () { return this.ihm.choixDe();    }
	public String nomFichier() { return this.ihm.nomFichier(); }

	//----------------------------------------------------------------------------------------------------------------
	//                                             LIEN ACHAT
	public String achatEtablissement ()                               { return this.ihm.achatEtablissement(); }
	public String achatMonument      ()                               { return this.ihm.achatMonument();      }
	public void   achatValide        ( Joueur joueur , Carte carte )  { this.ihm.achatValide(joueur,carte) ;  }
	public void   achatErreur        ()                               { this.ihm.achatErreur() ;              }
	public void   achatMonumentErreur()                               { this.ihm.achatMonumentErreur() ;      }
	public void   achatVioletErreur  ()                               { this.ihm.achatVioletErreur() ;        }

	//----------------------------------------------------------------------------------------------------------------
	//                                             LIEN CARTE
	public void effetCarte(String nomJoueur,String nomCarte , int piece)
	{
		this.ihm.effetCarte(nomJoueur,nomCarte,piece);
	}
	public void effetCartePaimment(String joueurActif , String joueurProprietaire,String nomCarte ,int nbPiece)
	{
		this.ihm.effetCartePaimment(joueurActif , joueurProprietaire,nomCarte ,nbPiece);
	}
	//----------------------------------------------------------------------------------------------------------------
	//                                             LIEN AFFICHAGE

	public void transition        (Joueur joueur) { this.ihm.transition(joueur);        }
	public void afficherBanque    ()              { this.ihm.afficherBanque();          }
	public void jetDe             (Joueur joueur) { this.ihm.jetDe(joueur);             }
	public void afficherEtatJoueur(Joueur joueur) { this.ihm.afficherEtatJoueur(joueur);}
	public void afficherEtat      ()              { this.ihm.afficherEtat();            }
	public void erreurLanceDe     ()              { this.ihm.erreurLanceDe();           }
	public void gagner            (Joueur joueur) { this.ihm.gagner(joueur);            }
	public void rejouer           (Joueur joueur) { this.ihm.rejouer(joueur);           }

	//----------------------------------------------------------------------------------------------------------------
	//                                             DEBUG

	public int debugJetDe() { return this.ihm.debugJetDe() ;}

	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------violet
	public String choisitUnJoueur       ()              { return this.ihm.choisitUnJoueur(); }
	public void   erreurSaisirNomJoueur ()              { this.ihm.erreurSaisrNomJoueur();   }
	public String choisitUnCarte        ()              { return this.ihm.choisitUnCarte();  }
	public void   erreurSaisirNomCarte  ()              { this.ihm.erreurSaisrNomCarte();    }
	public void   donnerLeCarteAQu      (Joueur joueur) { this.ihm.donnerLeCarte(joueur);    }

	//----------------------------------------------------------------------------------------------------------------
	//                                             GET
	public Banque getBanque() { return this.metier.getBanque(); }
	public Metier getMetier() { return this.metier;             }

	//----------------------------------------------------------------------------------------------------------------
	//                                             MAIN
	public static void main(String agrs[]) {
		new Controleur();
	}
}
