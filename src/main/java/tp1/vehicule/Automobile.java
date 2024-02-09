package tp1.vehicule;

public class Automobile {
    public static final int KILOMETRAGE_AVANT_BRIS = 100;
    public static final int KILOMETRAGE_AVANT_GRAND_BRIS = 200;
    public static final int COUT_BASE_TENTRETIEN = 5;
    public enum Etat {TRES_BRISE, BRISE, REPARE, NEUF}
    private double kilometrageSansReparation;
    private double coutTotalEntretien;
    private Etat etat = Etat.NEUF;

    public Automobile(double kilometrage) {
        this.kilometrageSansReparation = kilometrage;
    }

    public void roule(double nombreKilometre) {
        kilometrageSansReparation += nombreKilometre;
        if (kilometrageSansReparation > KILOMETRAGE_AVANT_BRIS) {
            etat = Etat.BRISE;
            if (kilometrageSansReparation > KILOMETRAGE_AVANT_GRAND_BRIS) {
                etat = Etat.TRES_BRISE;
            }
        }
    }

    public double repare() {
        double coutBrute = 0;

        if (etat == Etat.BRISE || etat == Etat.TRES_BRISE) {
            coutBrute += COUT_BASE_TENTRETIEN;
            if (etat == Etat.TRES_BRISE) {
                coutBrute *= 2;
            }
            etat = Etat.REPARE;
            kilometrageSansReparation = 0;
            coutTotalEntretien += coutBrute;
        }
        // TODO gérer la garantie. Un montant de base

        return coutBrute;
    }

    public double calculeCout() {
        return COUT_BASE_TENTRETIEN;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "kilometrageSansReparation=" + kilometrageSansReparation +
                ", coutTotalEntretien=" + coutTotalEntretien +
                ", etat=" + etat +
                '}';
    }
}
