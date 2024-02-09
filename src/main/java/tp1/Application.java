package tp1;


import tp1.vehicule.Automobile;
import tp1.vehicule.Bolide;
import tp1.vehicule.Camion;

public class Application {
    public static void main(String[] args) {

        //On crée le garage
        Application application = new Application();
        Garage garage = new Garage(6);

        // On crée les vehicules
        Automobile[] vehicules = new Automobile[6];

        vehicules[0] = new Automobile(15);
        vehicules[1] = new Automobile(20);
        //TODO Créez 2 bolides et 2 camions



        //On ajuste les chargements des camions


        //Répéter tout le scénario 10 fois. On augmenter la distance prévue de 20km à chaque fois

            System.out.println("boucle numeré" );
            System.out.println("Les véhicules roulent");
            //TODO tous les vehicules parcoure la distance prévue




            application.afficheTousVehicules(vehicules);

            System.out.println("Les bolides font la course");
            // TODO les 2 bolides font la distance enourse


            System.out.println("On stationne les véhicules au garage");
            //TODO on entre les vehicules au garage


            //TODO on entre les vehicules au garage 2 par deux : 0 et 1 puis 2 et 3 puis 4 et 5
           // puis on les répare, on les sort dans le stationnement et on fait leur départ





            application.afficheTousVehicules(vehicules);
            System.out.println("revenus du garage = "+ garage.getRevenus());

            System.out.println("fin de la boucle numéro" );

            // TODFaites générés des rapports d'assurance pour les camions et les bolides
        // puis faites les afficher



    }

    public void afficheTousVehicules(Automobile[] vehicules){
        for (int i = 0; i < vehicules.length; i++) {
            System.out.println(vehicules[i].toString());
        }
    }
}
