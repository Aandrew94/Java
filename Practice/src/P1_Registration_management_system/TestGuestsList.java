package P1_Registration_management_system;

import java.util.Scanner;

public class TestGuestsList {
    Scanner sc = new Scanner(System.in);

    public void start(){
        System.out.println("P1: \t\t Registration management system\n\n");
        System.out.print("Introduceti numarul de locuri disponibile:\t");

        int size = sc.nextInt();
        sc.nextLine();

        while(size <= 0){
            System.out.println("Capacitatea evenimentului trebuie sa fie > 0");
            System.out.print("Introduceti numarul de locuri disponibile:\t");
            size = sc.nextInt();
            sc.nextLine();
        }

        GuestsList guestsList = new GuestsList(size);
        waitCommand();
        helpMenu(guestsList);
    }

    private void waitCommand(){
        System.out.println("\nComanda:\t(help -> afiseaza lista comenzi)");
    }

    private void helpMenu(GuestsList guestsList){
        boolean reset = true;

        while(reset){
            System.out.print(">\t");
            String command = sc.nextLine();
            System.out.println();

            switch (command){
                case "help"     :   showCommand();
                    break;
                case "add"      :   addGuest(sc,guestsList);
                    break;
                case "check"    :   guestsList.check();
                    break;
                case "remove"   :   guestsList.remove();
                    break;
                case "update"   :   guestsList.update();
                    break;
                case "guests"   :   guestsList.guests();
                    break;
                case "waitlist" :   guestsList.waitlist();
                    break;
                case "available":   guestsList.available();
                    break;
                case "guests_no":   guestsList.guests_no();
                    break;
                case "waitlist_no": guestsList.waitlist_no();
                    break;
                case "subscribe_no":guestsList.subscribe_no();
                    break;
                case "search"       :search(sc,guestsList);
                    break;
                case    "quit"  :   System.out.println("Iesire aplicatie ...");
                                    reset = false;
                    break;
                default :   System.out.println("Comanda invalida");
                            System.out.println("Incercati din nou.");
                    break;
            }

            if(reset)    waitCommand();
        }
    }

    private void showCommand(){
        System.out.println("help\t\t\t-\tAfiseaza lista comenzi");
        System.out.println("add \t\t\t-\tAdauga/Inscrie o persoana noua");
        System.out.println("check\t\t\t-\tVerifica daca o persoana este inscrisa");
        System.out.println("remove\t\t\t-\tSterge o persoana din lista (de inscriere/asteptare)");
        System.out.println("update\t\t\t-\tActualizeaza datele unei persoane");
        System.out.println("guests\t\t\t-\tAfiseaza lista de persoana care se afla pe lista de inscriere");
        System.out.println("waitlist\t\t-\tAfiseaza lista de persoane care se afla pe lista de asteptare");
        System.out.println("available\t\t-\tNumarul de locuri libere");
        System.out.println("guests_no\t\t-\tNumarul de persoane care se afla pe lista de inscriere");
        System.out.println("waitlist_no\t\t-\tNumarul de persoane care se afla pe lista de asteptare");
        System.out.println("subscribe_no\t-\tNumarul total de persoane prezente la eveniment");
        System.out.println("search\t\t\t-\tCautare conform unui sir de caractere");
        System.out.println("quit\t\t\t-\tInchide aplicatie");
    }

    private void addGuest(Scanner sc, GuestsList guestsList){
        System.out.println("Adaugare persoana noua");

        System.out.print("Introduceti numele:\t");
        String firstName = sc.nextLine();

        System.out.print("Introduceti prenumele:\t");
        String lastName = sc.nextLine();

        System.out.print("Introduceti email:\t");
        String email = sc.nextLine();

        System.out.print("Introduceti numar de telefon:\t");
        String phoneNr = sc.nextLine();

        guestsList.add(new Guest(firstName,lastName,email,phoneNr));
    }
    private void search(Scanner sc, GuestsList guestsList){
        System.out.println("Introdu sirul de caractere pentru cautare:");
        String searchFor = sc.nextLine();
        guestsList.search(searchFor);
    }

    public void testPeople(){
        GuestsList guestsListTP = new GuestsList(2);

        Guest Andrei = new Guest("Andrei", "Zamfir", "aandrei.zamfir@yahoo.com", "0766172300");
        guestsListTP.add(Andrei);
        guestsListTP.add(new Guest("Cristia", "Graure", "cristinutza@yahoo.com", "0736332501"));
        Guest AndreiClone = Andrei;
        guestsListTP.add(AndreiClone);
        guestsListTP.add(new Guest("Stef", "Fets", "theStef@yahoo.com", "1122334455"));
        guestsListTP.add(new Guest("Sefa", "San", "SeFaSSan@gmail.com", "007"));

        helpMenu(guestsListTP);
    }

}
