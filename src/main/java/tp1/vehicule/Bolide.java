package tp1.vehicule;

public class Bolide {
    public static final int KILOMETRAGE_AVANT_BRIS = 100;
    public static final int KILOMETRAGE_AVANT_GRAND_BRIS = 200;
    public static final int COUT_BASE_TENTRETIEN = 5;

    public enum Etat {TRES_BRISE, BRISE, REPARE, NEUF}

    private double kilometrageSansReparation;
    private double coutTotalEntretien;
    private Etat etat = Etat.NEUF;
    private boolean estEnCourse;

    public Bolide(double kilometrageSansReparation, boolean estEnCourse) {
        this.estEnCourse = estEnCourse;
        this.kilometrageSansReparation = kilometrageSansReparation;
        this.coutTotalEntretien = 0;
    }

    public boolean estEnCourse() {
        return estEnCourse;
    }

    public void setEstEnCourse(boolean estEnCourse) {
        this.estEnCourse = estEnCourse;
    }



    public void roule(double nombreKilometre) {
        kilometrageSansReparation += nombreKilometre;
        if (kilometrageSansReparation > KILOMETRAGE_AVANT_BRIS) {
            etat = Etat.BRISE;
            if (kilometrageSansReparation > KILOMETRAGE_AVANT_GRAND_BRIS) {
                etat = Etat.TRES_BRISE;
            }
        }
        // TODO le kilometrage compte double lorsqu'on est en course


    }

    public double repare() {
        double coutFinal = 0;
        double cout = COUT_BASE_TENTRETIEN;


        if (etat == Etat.BRISE || etat == Etat.TRES_BRISE) {
            coutFinal = cout;
            if (etat == Etat.TRES_BRISE) {
                coutFinal += coutFinal;
            }
            etat = Etat.REPARE;
            kilometrageSansReparation = 0;
            coutTotalEntretien += coutFinal;
        }

        //TODO si le kilometrage excède 150 sans réparation le cout devient quadratique (cout exp 2)

        return coutFinal;
    }
    public String genereRapport(){
        return "Le garage a chargé "+coutTotalEntretien+"$ en frais de réparation.";
    }

    @Override
    public String toString() {
        return "Bolide{" +
                "kilometrageSansReparation=" + kilometrageSansReparation +
                ", coutTotalEntretien=" + coutTotalEntretien +
                ", etat=" + etat +
                ", estEnCourse=" + estEnCourse +
                '}';
    }
}
