package tp1.vehicule;


public class Camion {
    public enum Etat {TRES_BRISE, BRISE, REPARE, NEUF}

    public static final int COUT_BASE_TENTRETIEN = 5;

    private double usure;

    private double kilometrageSansReparation;
    private double coutTotalEntretien;
    private Etat etat = Etat.NEUF;

    public Camion(double kilometrageSansReparation) {
        this.coutTotalEntretien = 0;
        this.usure = 0;
        this.kilometrageSansReparation = kilometrageSansReparation;
    }

    public void roule(double nombreKilometre) {
        kilometrageSansReparation += nombreKilometre;


        //gérer l'usure
        //TODO


        // Gérer l'état en fonction de l'usure

    }

    /**
     * Repare l'etat demandé et applique le cout lorsque
     *
     * @return un cout supérieur à 0 (si la piece a dû être réparée). 0 s'il n'y a pas de réparation
     */
    public double repare() {
        double coutFinal = 0;

        if (etat == Etat.BRISE || etat == Etat.TRES_BRISE) {
            coutFinal += Math.max(COUT_BASE_TENTRETIEN * 5, usure * 2);
            if (etat == Etat.TRES_BRISE) {
                coutFinal *= 2;
            }
            etat = Etat.REPARE;
            kilometrageSansReparation = 0;
            coutTotalEntretien += coutFinal;
            usure = 0;
        }
        return coutFinal;
    }

    public String genereRapport() {
        return "Le garage a chargé " + coutTotalEntretien + "$ en frais de réparation.";
    }


    @Override
    public String toString() {
        return "Camion{" +
                ", usure=" + usure +
                ", kilometrageSansReparation=" + kilometrageSansReparation +
                ", coutTotalEntretien=" + coutTotalEntretien +
                ", etat=" + etat +
                '}';
    }
}
