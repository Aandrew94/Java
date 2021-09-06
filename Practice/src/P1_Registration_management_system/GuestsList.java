package P1_Registration_management_system;

import java.util.ArrayList;
import java.util.Scanner;

public class GuestsList {
    private ArrayList<Guest>    guests;
    private final int           capacityEvent;

    public  GuestsList(){   this(10);   }
    public  GuestsList(int guestsCapacity) {
        this.capacityEvent = guestsCapacity;                            // number of seats available at the event
        this.guests = new ArrayList<>(this.capacityEvent);              // list of participants
    }


    /**
     * Add a new Guest, unique, on the list
     *
     * @param oneGuest  -   the guest to be added
     * @return          -   [-1]    if the guest is already present on the list
     *                  -   [0]     if the guest is receiving a place
     *                  -   [x]     if no capacity, return the nr on the waiting list
     */
    public int add(Guest oneGuest){
        if(isAllreadyOnList(oneGuest)){
            return -1;
        }

        if(this.guests.size() < this.capacityEvent){
            System.out.println("[ " + oneGuest.getFullName() + " ] \t Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
            this.guests.add(oneGuest);
            return 0;
        } else {
            this.guests.add(this.guests.size(),oneGuest);
            System.out.println("\n[ " + oneGuest.getFullName() + " \t Numar ordine: " + getOrderNumber(oneGuest) + " ]");
            System.out.print("\tTe-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine <" + getOrderNumber(oneGuest)
                    + ">. \n\tTe vom notifica daca un loc devine disponibil.\n");
        }

        return getOrderNumber(oneGuest);
    }
    /**
     * Check if a Guest is already present on the list
     *
     * @param searchedGuest  -   the guest which we are looking for
     * @return               -   true    if the guest is present, regardless of guest data
     *                       -   false   if the guest is not present, regardless of guest data
     */
    private boolean isAllreadyOnList(Guest searchedGuest){
        for(Guest theGuest : this.guests){
            if(searchedGuest.equals(theGuest)){
                System.out.println("\t[ ! ]\t Persoana cu numele [" + theGuest.getFullName() + "] este deja inregistrata.");
                return true;
            }

            if(searchedGuest.getPhoneNumber().equals(theGuest.getPhoneNumber())){
                System.out.println("\t[ ! ]\t Numarul de telefon este deja inregistrat");
                return true;
            }

            if(searchedGuest.getEmail().equals(theGuest.getEmail())){
                System.out.println("\t[ ! ]\t Adresa de email este deja inregistrata");
                return true;
            }

        }
        return false;
    }
    /**
     * Get the order number if a Guest is already present on the list waiting list
     *
     * @param waitingGuest  -   the guest which we are looking for
     * @return              -   [x]    'x' represents the order number of waitingGuest
     */
    private int getOrderNumber(Guest waitingGuest){
        return (this.guests.indexOf(waitingGuest) - this.capacityEvent) + 1;
    }


    /**
     *  Check if a Guest is registered for the event (in any list).
     */
    public void check(){
        System.out.println("\t[0]\t Check by first and last name");
        System.out.println("\t[1]\t Check by email");
        System.out.println("\t[2]\t Check by phone number");
        System.out.print("\tEnter option: ");
        Scanner input = new Scanner(System.in);
        int getData = input.nextInt();
        switch (getData) {
            case    0   :   checkByFullName();
                            break;
            case    1   :   checkByEmail();
                            break;
            case    2   :   checkByPhoneNumber();
                            break;
            default     :   System.out.println("Invalid command number");
                            break;
        }
    }
    /**
     * Check if a Guest is registered by its full name
     *
     * @return  Guest   -   if Guest found as registered, return it
     *          null    -   if not
     */
    private Guest checkByFullName(){
        System.out.print("\nEnter first name:\t");
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        System.out.print("Enter last name:\t");
        String lastName = sc.nextLine();
        String fullName = firstName + " " + lastName;

        for(Guest theGuest : this.guests) {
            if(fullName.equalsIgnoreCase(theGuest.getFullName())){

                if(this.guests.indexOf(theGuest) < this.capacityEvent){
                    System.out.println("*\t Persoana cu numele " + theGuest.getFullName() + " are locul confirmat la eveniment");
                    return theGuest;
                } else {
                    System.out.println("*\t Persoana cu numele " + theGuest.getFullName() + " se afla pe lista de asteptare - pozitia <" + getOrderNumber(theGuest) + ">");
                    return theGuest;
                }

            }
        }
        return null;
    }
    /**
     * Check if a Guest is registered by its email adress
     *
     * @return  Guest   -   if Guest found as registered, return it
     *          null    -   if not
     */
    private Guest checkByEmail(){
        System.out.print("\nEnter email:\t");
        Scanner sc = new Scanner(System.in);
        String emailInput= sc.nextLine();
        for(Guest theGuest : this.guests){

            if(emailInput.equalsIgnoreCase(theGuest.getEmail())){

                if(this.guests.indexOf(theGuest) < this.capacityEvent){
                    System.out.println("*\t Email-ul " + theGuest.getEmail() + " este deja in sistem, loc confirmat");
                    return theGuest;
                } else {
                    System.out.println("*\t Email-ul " + theGuest.getEmail() + " este inregistrat pentru o persoana afalata pe lista de asteptare, pozita <" + getOrderNumber(theGuest) + ">");
                    return theGuest;
                }

            }
        }
        return null;
    }
    /**
     * Check if a Guest is registered by its phone number
     *
     * @return  Guest   -   if Guest found as registered, return it
     *          null    -   if not
     */
    private Guest checkByPhoneNumber(){
        System.out.print("\nEnter phone number:\t");
        Scanner sc = new Scanner(System.in);
        String phoneNumber= sc.nextLine();
        for(Guest theGuest : this.guests){

            if(phoneNumber.equalsIgnoreCase(theGuest.getPhoneNumber())){

                if(this.guests.indexOf(theGuest) < this.capacityEvent){
                    System.out.println("*\t Numarul de telefon " + theGuest.getPhoneNumber() + " este deja in sistem, loc confirmat");
                    return theGuest;
                } else {
                    System.out.println("*\t Numarul de telefon " + theGuest.getPhoneNumber() + " este inregistrat pentru o persoana afalata pe lista de asteptare, pozita <" + getOrderNumber(theGuest) + ">");
                    return theGuest;
                }

            }
        }
        return null;
    }


    /**
     *  Remove a Guest registered for the event (in any list).
     */
    public void remove(){
        System.out.println("\t[0]\t Remove by first and last name");
        System.out.println("\t[1]\t Remove by email");
        System.out.println("\t[2]\t Remove by phone number");
        System.out.print("\tEnter option: ");
        Scanner input = new Scanner(System.in);
        int getData = input.nextInt();
        switch (getData) {
            case    0   :   removeByFullName();
                            break;
            case    1   :   removeByEmail();
                            break;
            case    2   :   removeByPhoneNumber();
                            break;
            default     :   System.out.println("Invalid command number");
                break;
        }
    }
    /**
     * Remove a Guest after its full name
     *
     * @return  true     -   if Guest found as registered
     *          false    -   if the Guest is not found as registered
     */
    private boolean removeByFullName(){
        Guest guest = checkByFullName();
        if(guest == null){
            System.out.println("-\t Persoana nu se afla in sistem sau nu este inscrisa");
            return false;
        }
        return removeThe(guest);
    }
    /**
     * Remove a Guest after its email adress
     *
     * @return  true     -   if Guest found as registered
     *          false    -   if the Guest is not found as registered
     */
    private boolean removeByEmail(){
        Guest guest = checkByEmail();
        if(guest == null){
            System.out.println("-\t Email-ul nu se afla in sistem sau nu este inscris");
            return false;
        }
        return removeThe(guest);
    }
    /**
     * Remove a Guest after its phone number
     *
     * @return  true     -   if Guest found as registered
     *          false    -   if the Guest is not found as registered
     */
    private boolean removeByPhoneNumber(){
        Guest guest = checkByPhoneNumber();
        if(guest == null){
            System.out.println("-\t Numarul de telefon nu se afla in sistem sau nu este inscris");
            return false;
        }
        return removeThe(guest);
    }
    /**
     * Remove the founded Guest
     *
     * @param   toRemove    -   the guest founded for remove
     * @return  true        -   if Guest was removed from the eveniment
     *          false       -   if the was not removed/founded at the eveniment
     */
    private boolean removeThe(Guest toRemove){
        int index = this.guests.indexOf(toRemove);
        System.out.println("[ " + this.guests.get(index).getFullName() + " ] \t A fost stears/stearsa din lista!");
        this.guests.remove(index);
        if(index < this.capacityEvent){
            notifyGuest();
        }
        return true;
    }
    /**
     * Notify if a Guest on the waiting list is eligible for confirmation
     *
     */
    private void notifyGuest(){
        if(this.guests.size() < this.capacityEvent) return;     //  if we just don't have people on the waiting list
        Guest toNotify = this.guests.get(this.capacityEvent - 1);
        if(toNotify == null)    return;
        System.out.println("[ " + toNotify.getFullName() + " ] \t Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
    }


    /**
     *  Update a Guest details.
     */
    public void update(){
        System.out.println("\t[0]\t Update by first and last name");
        System.out.println("\t[1]\t Update by email");
        System.out.println("\t[2]\t Update by phone number");
        System.out.print("\tEnter option: ");
        Scanner input = new Scanner(System.in);
        int getData = input.nextInt();
        switch (getData) {
            case    0   :   updateByFullName(getData);
                break;
            case    1   :   updateByEmail(getData);
                break;
            case    2   :   updateByPhoneNumber(getData);
                break;
            default     :   System.out.println("Invalid command number");
                break;
        }
    }
    /**
     * Update the founded Guest by its full name
     *
     * @param   opt     -   depending on what data we want to update
     * @return  true    -   if Guest is registered
     *          false   -   if Guest is not registered
     */
    private boolean updateByFullName(int opt){
        Guest guest = checkByFullName();
        if(guest == null){
            System.out.println("-\t Persoana nu se afla in sistem sau nu este inscrisa");
            return false;
        }
        System.out.print("+\t Nume si prenume initial:\t" + guest.getFullName());
        return updateThe(guest, opt);
    }
    /**
     * Update the founded Guest by its email adress
     *
     * @param   opt     -   depending on what data we want to update
     * @return  true    -   if Guest is registered
     *          false   -   if Guest is not registered
     */
    private boolean updateByEmail(int opt){
        Guest guest = checkByEmail();
        if(guest == null){
            System.out.println("-\t Persoana nu se afla in sistem sau nu este inscrisa");
            return false;
        }
        System.out.print("+\t Email-ul initial:\t" + guest.getEmail());
        return updateThe(guest, opt);
    }
    /**
     * Update the founded Guest by its phone number
     *
     * @param   opt     -   depending on what data we want to update
     * @return  true    -   if Guest is registered
     *          false   -   if Guest is not registered
     */
    private boolean updateByPhoneNumber(int opt){
        Guest guest = checkByPhoneNumber();
        if(guest == null){
            System.out.println("-\t Persoana nu se afla in sistem sau nu este inscrisa");
            return false;
        }
        System.out.print("+\t Numarul de telefon initial:\t" + guest.getPhoneNumber());
        return updateThe(guest, opt);
    }
    /**
     * Update the founded Guest by its full name
     *
     * @param   theGuest     -   depending on what Guest we want to update
     * @param   opt          -   depending on what data we want to update
     * @return  true         -   if Guest is registered, founded and updated (in the end)
     *          false        -   data/opt is not valid
     */
    private boolean updateThe(Guest theGuest, int opt){
        int index = this.guests.indexOf(theGuest);
        Scanner sc = new Scanner(System.in);

        if(opt == 0){
            System.out.print("\nIntroduceti noul nume:\t");
            String newFirstName = sc.nextLine();
            System.out.print("Introduceti noul prenume:\t");
            String newLastName = sc.nextLine();

            this.guests.get(index).setFirstName(newFirstName);
            this.guests.get(index).setLastName(newLastName);
            System.out.println("*\t Nume si prenume updatat\t" + this.guests.get(index).getFullName());

        }else if (opt == 1){
            System.out.print("\nIntroduceti noul email:\t");
            String newEmail = sc.nextLine();

            this.guests.get(index).setEmail(newEmail);
            System.out.println("*\t Email updatat\t" + this.guests.get(index).getEmail());

        }else if (opt == 2){
            System.out.print("\nIntroduceti noul numar de telefon:\t");
            String newPhoneNumber = sc.nextLine();

            this.guests.get(index).setPhoneNumber(newPhoneNumber);
            System.out.println("*\t Numar de telefon updatat:\t" + this.guests.get(index).getPhoneNumber());

        } else {
            System.out.println("Invalid command number");
            return false;
        }

        return true;
    }


    /**
     *  List of participants of the event (already confirmed)
     */
    public void guests(){
        if(this.guests.size() == 0){
            System.out.println("Nu exista participanti la eveniment - lista participantilor este goala");
            return;
        }
        int diff = this.capacityEvent - this.guests.size();
        if(diff <= 0){                                                              //  participation list is full
            for(int i=0;i<this.capacityEvent;++i){
                System.out.println("[" + (i+1) + "]\t" + this.guests.get(i).getFullName() + ", " + this.guests.get(i).getEmail() + ", " + this.guests.get(i).getPhoneNumber());
            }
        } else {                                                                    //  the participation list still has places available
            for(int i=0;i<this.guests.size();++i){
                System.out.println("[" + (i+1) + "]\t" + this.guests.get(i).getFullName() + ", " + this.guests.get(i).getEmail() + ", " + this.guests.get(i).getPhoneNumber());
            }
        }



    }

    /**
     *  Waiting list of participants of the event
     */
    public void waitlist(){
        if(this.guests.size() == 0){                            //  if the participation list is empty -> we do not have the waiting list
            System.out.println("Nu exista participanti la eveniment - lista de asteptare este goala");
            return;
        }
        int diff = this.guests.size() - this.capacityEvent;
        if(diff <= 0){                                          //  we don't have a waiting list - because the places on the participation list are not finished
            System.out.println("Lista de asteptare este goala");
            return;
        }

        for(int i=this.capacityEvent;i<this.guests.size();++i){
            System.out.println("[" + getOrderNumber(this.guests.get(i)) + "]\t" + this.guests.get(i).getFullName() + ", " + this.guests.get(i).getEmail() + ", " + this.guests.get(i).getPhoneNumber());
        }
    }

    /**
     *  Number of vacancies places
     *
     * @return  int     -   [> 0] if there are vacancies places in the participation list
     *                  -   [0] if there are no more vacancies places in the participation list
     */
    public int available(){
        int availableSeats = this.capacityEvent - this.guests.size();
        if(availableSeats <= 0){
            System.out.println("Locuri disponibile in lista de participare:\t0\nNu mai sunt locuri livere in lista de particioare");
            return 0;
        }

        System.out.print("Locuri disponibile in lista de participare:\t" + availableSeats);
        return availableSeats;
    }

    /**
     *  Number of participants (i.e. on the participation list)
     *
     * @return  int     -   [capacityEvent] if participation is full and there are guests on waiting list
     *                  -   [-1] if participation list is empty
     *                  -   [x] if participation is not full and there are no guests on waiting list
     */
    public int guests_no(){
        if(this.guests.size() == 0){
            System.out.println("Nu exista participanti la eveniment - lista participantilor este goala");
            return -1;
        }
        int guests_no = this.capacityEvent - this.guests.size();
        if (guests_no <= 0){
            System.out.println("\nNumarul total de persoane confirmate:\t" + this.capacityEvent);
            return this.capacityEvent;
        }
        System.out.println("Numarul total de persoane confirmate:\t" + guests_no);
        return guests_no;
    }

    /**
     *  Number of people from the waiting list
     *
     * @return  int     -   [0] if participation is not full and there are no guests on waiting list
     *                  -   [-1] if participation/waiting list is empty
     *                  -   [x] if participation is full and there are guests on waiting list
     */
    public int waitlist_no(){
        if(this.guests.size() == 0){
            System.out.println("Nu exista participanti la eveniment - lista participantilor/de asteptare este goala");
            return -1;
        }
        int waitlist_no = this.guests.size() - this.capacityEvent;
        if (waitlist_no <= 0){
            System.out.println("\nNumarul total de persoane in asteptare:\t" + 0);
            return 0;
        }
        System.out.println("Numarul total de persoane in asteptare:\t" + waitlist_no);
        return waitlist_no;
    }

    /**
     *  Total number of people registered
     *
     * @return  int     -   [-1] if participation list is empty
     *                  -   [x] if there are guests
     */
    public int subscribe_no(){
        if(this.guests.size() == 0){
            System.out.println("Nu exista participanti la eveniment - lista participantilor este goala");
            return -1;
        }
        System.out.println("Numarul total de persoane (cu prezenta confirmata / in asteptare):\t" + this.guests.size());
        return this.guests.size();
    }

    /**
     * Search all invitations according to the string entered
     *
     * @param str     -   string entered for searching
     */
    public void search(String str){
        if(this.guests.size() == 0){
            System.out.println("Cautarea nu poate fi realizata.\nNu exista participanti la eveniment - lista participantilor este goala");
            return;
        }

        for(Guest theGuest  : this.guests){
            if(theGuest.getFullName().toLowerCase().contains(str.toLowerCase())){
                System.out.println(theGuest.getFullName() + " - contine in nume " + theGuest.getFullName());
            }
            if(theGuest.getEmail().toLowerCase().contains(str.toLowerCase())){
                System.out.println(theGuest.getFullName() + " - contine in email " + theGuest.getEmail());
            }
            if(theGuest.getPhoneNumber().toLowerCase().contains(str.toLowerCase())){
                System.out.println(theGuest.getFullName() + " - contine in numarul de telefon " + theGuest.getPhoneNumber());
            }
        }
    }

}
