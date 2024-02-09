package tp1;

import tp1.vehicule.Automobile;

public class Garage {
    private Automobile[] stationnements;
    private Automobile[] garages;

    private double revenus = 0;


    /**
     * crée un Garage avec le nombre de place de stationnement demandé et toujours 2 places de garage pour les réparations.
     *
     * @param nombrePlacesStationnement le nombre de places requises.
     */
    public Garage(int nombrePlacesStationnement) {
        assert nombrePlacesStationnement > 0 : "valeur négative";

        garages = new Automobile[2];
        stationnements = new Automobile[nombrePlacesStationnement];
    }

    /**
     * Stationne l'auto dans le premier emplacement vide, s'il y en a un.
     *
     * @param auto l'auto à placer dans le stationnement
     * @return faux s'il n'y a plus de place de stationnement disponible.
     */
    public boolean stationne(Automobile auto) {
        assert auto != null : "paramètre Null";

        boolean retVal = !stationnementEstPlein();
        if (retVal) {
            stationnements[trouveIndexPlaceLibre()] = auto;
        }
        return retVal;
    }

    /**
     * indique si le stationnement est plein
     *
     * @return vrai s'il est plein
     */
    private boolean stationnementEstPlein() {
        boolean retVal = true;
        for (int i = 0; i < stationnements.length && retVal != false; i++) {
            if (stationnements[i] == null) {
                retVal = false;
            }
        }
        return retVal;
    }

    /**
     * trouve la première place libre. On doit vérifier qu'il y a une place libre avant d'appeler cette méthode
     *
     * @return l'indice de la place libre (de 0 à n-1) ou ArrayIndexOutOfBoundsException si le stationnement est plein
     */
    private int trouveIndexPlaceLibre() {
        int retVal = -1;
        do {
            retVal++;
        } while (stationnements[retVal] != null);
        return retVal;
    }

    /**
     * trouve la première place libre. On doit vérifier qu'il y a une place libre avant d'appeler cette méthode.
     *
     * @return l'indice de la place libre (de 1 à n) ou ArrayIndexOutOfBoundsException si le stationnement est plein
     */
    public int trouvePlace() {
        return trouveIndexPlaceLibre() + 1;
    }


    /**
     * entre le vehicule demandé dans le garage à la place demandée (la place et non l'index).
     *
     * @param vehiculeRepare le vehicule à entrer (il doit être dans le stationnement)
     * @param placeGarage    la place du garage (elle ne doit pas contenir de vehicule)
     * @return vrai si le vehicule a pu être entré
     */
    public boolean entreVehiculeGarage(Automobile vehiculeRepare, int placeGarage) {
        int indexGarage = placeGarage - 1;
        assert vehiculeRepare != null : "null Vehicule";
        assert indexGarage >= 0 : "place négative";
        assert indexGarage < garages.length : "place inexistante";

        boolean retVal = false;

        //On cherche le vehicule dans le stationnement
        int positionStationnement = chercheVehiculeStationnement(vehiculeRepare);

        //On deplace le vehicule si on le trouve dans garage
        if (positionStationnement != -1 && garages[indexGarage] == null) {
            stationnements[positionStationnement] = null;
            garages[indexGarage] = vehiculeRepare;
            retVal = true;
        }
        return retVal;
    }

    /**
     * trouve le vehicule reçu en paramètre dans le stationnement et retourne son index
     *
     * @param vehiculeRepare le véhicule à trouver (avec méthode equals)
     * @return l'index du vehicule ou -1 s'il n'a pas été trouvé
     */
    private int chercheVehiculeStationnement(Automobile vehiculeRepare) {
        assert vehiculeRepare != null : "parametre null";

        int positionStationnement = -1;
        for (int i = 0; i < stationnements.length && positionStationnement == -1; i++) {
            if (vehiculeRepare.equals(stationnements[i])) {
                positionStationnement = i;
            }
        }
        return positionStationnement;
    }

    /**
     * sort le vehicule du garage et le remet dans le stationnement.
     *
     * @param placeGarage       la place du garabe où prendre le vehicule à sortir ( il doit y avoir un vehicule à cette place)
     * @param placeStationement la place de stationnement où mettre le vehicule (le stationnement doit être libre)
     * @return retourne vrai si le vehicule est sorti.
     */
    public boolean sortVehicule(int placeGarage, int placeStationement) {
        int indexGarage = placeGarage - 1;
        int indexStationnement = placeStationement - 1;

        assert indexGarage >= 0 : "place garage négative";
        assert indexGarage < garages.length : "place garage inexistante";
        assert indexStationnement >= 0 : "place stationnement négative";
        assert indexStationnement < garages.length : "place stationnement inexistante";

        boolean retVal = false;
        if (stationnements[indexStationnement] == null && garages[indexGarage] != null) {

            //On sort le vehicule du garage et on le met dans le stationnement
            stationnements[indexStationnement] = garages[indexGarage];
            garages[indexGarage] = null;
            retVal = true;
        }
        return retVal;
    }

    /**
     * gère le départ d'un véhicule en l'effacant du stationnement et en retournant sa valeur
     *
     * @param auto le vehicule qui doit être retiré
     * @return le vehicule qui doit être retiré sii il est trouvé null autrement.
     */
    public Automobile faitDepartVehicule(Automobile auto) {
        assert auto != null : "parametre null";

        int position = chercheVehiculeStationnement(auto);
        if (position != -1) {
            stationnements[position] = null;
        }
        return auto;
    }

    /**
     * répare tous les dommages du vehicule en indiquant l'état réparé.
     * Défi: essayez de gérer le cout des réparations.
     */
    public void repare() {
        for (int i = 0; i < garages.length; i++) {
            Automobile auto = garages[i];
            if (auto != null) {
                revenus += auto.repare();
            }
        }
    }

    public double getRevenus() {
        return revenus;
    }
}
