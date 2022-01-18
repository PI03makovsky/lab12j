package lab5;
import java.util.Scanner;
import java.lang.*;

/*-------------------------------------------------------------------*/
class date implements Cloneable{
    private int day;
    private int month;
    private int year;

    public void output(){
        System.out.printf("%d.%d.%d", this.day, this.month, this.year);
    }
    public date(){
    }

    public date(int value){
        this.day = value;
        this.month = value;
        this.year = value;
    }

    public date(int day, int month, int year){
        if(day<0 || day>31){
            this.day = 0;
        }
        else{
            this.day = day;
        }
        if(month<0 || month>12){
            this.month = 0;
        }
        else{
            this.month = month;
        }
        if(year<0){
            this.year = 0;
        }
        else{
            this.year = year;
        }
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        int day;
        int month;
        int year;
        boolean input;
        do{
            try{

                System.out.print("Input day: ");
                day = in.nextInt();
                if(day < 1 || day > 31){
                    throw new Exception("Wrong input. Please input number between 1 and 31");
                }
                input = false;
                this.day = day;
            }
            catch(Exception e){
                System.out.println("Wrong input! Please retry!");
                input = true;

            }
        }while(input);
        do{
            try{

                System.out.print("Input month: ");
                month = in.nextInt();
                if(month < 1 || month > 12){
                    throw new Exception("Wrong input. Please input number between 1 and 12");
                }
                input = false;
                this.month = month;
            }
            catch(Exception e){
                System.out.println("Wrong input! Please retry!");
                input = true;

            }
        }while(input);
        do{
            try{
                System.out.print("Input year: ");
                year = in.nextInt();
                if(year < 1 || year > 2021){
                    throw new Exception("Wrong input. Please input number between 1 and 2021");
                }
                input = false;
                this.year = year;
            }
            catch(Exception e){
                System.out.println("Wrong input! Please retry!");
                input = true;

            }
        }while(input);
    }

    public date clone() throws CloneNotSupportedException{

        return (date) super.clone();
    }

    public int indays(date date1){
        int sum;
        int sum1;
        if (this.month < 3) {
            this.year--; this.month += 12;
        }
        sum=365 * this.year + this.year / 4 - this.year / 100 + this.year / 400 + (153 * this.month - 457) / 5 + this.day - 306;
        if (date1.month < 3) {
            date1.year--; date1.month += 12;
        }
        sum1 = 365 * date1.year + date1.year / 4 - date1.year / 100 + date1.year / 400 + (153 * date1.month - 457) / 5 + date1.day - 306;
        if(sum < sum1){
            System.out.print("The first date is greater than the first");
        }
        return 0;
    }

}


    /*-------------------------------------------------------------------*/
    class tenant { //Класс арендатор
        String name; //имя
        String surname; //фамилия
        String patronymic; //отчество

        public void input() {

            String name;

            String surname;

            String patronymic;

            System.out.print("\nTenant info: ");

            Scanner in = new Scanner(System.in);

            do {

                System.out.print("\nInput name: ");

                name = in.nextLine();

                if (name.trim().length() == 0 || name == " " || name == "\n") {

                    System.out.println("You haven't entered anything!");

                }

            } while (name.trim().length() == 0 || name == " " || name == "\n");

            this.name = name;

            do {

                System.out.print("\nInput surname: ");

                surname = in.nextLine();

                if (surname.trim().length() == 0 || surname == " " || surname == "\n") {

                    System.out.println("You haven't entered anything!");

                }

            } while (surname.trim().length() == 0 || surname == " " || surname == "\n");

            this.surname = surname;

            do {

                System.out.print("\nInput patronymic: ");

                patronymic = in.nextLine();

                if (patronymic.trim().length() == 0 || patronymic == " " || patronymic == "\n") {

                    System.out.println("You haven't entered anything!");

                }

            } while (patronymic.trim().length() == 0 || patronymic == " " || patronymic == "\n");

            this.patronymic = patronymic;
        }


        public tenant() {

        }

        public tenant(String value) {

            this.name = value;
        }

        public tenant(String name, String s) {

            this.name = name;

            this.surname = surname;


        }

        public void enterT() { //Метод ввода
            System.out.printf("\nEnter the name: ");
            Scanner tn = new Scanner(System.in);
            name = tn.nextLine();
            System.out.printf("Enter the surname: ");
            surname = tn.nextLine();
            System.out.printf("Enter the patronymic: ");
            patronymic = tn.nextLine();
            System.out.printf("Enter the birthday:\n");
        }

        public int printer(date date3) { //Метод вывода
            System.out.printf("\nName: %s Surname: %s Patronymic %s ", name, surname, patronymic);
            System.out.println("\nBirthday: ");
            date3.output();
            return 0;
        }
    }

    /*-------------------------------------------------------------------*/
    class orginf { //Класс организационная информация
        private int price; //цена закупа еды
        private int rent; //время аренды

        public void init(int p, int r) { // Метод создания
            price = p;
            rent = r;
        }

        public void enterOI() { //Метод ввода
            System.out.printf("\nEnter purchase price: ");
            Scanner OI = new Scanner(System.in);
            price = OI.nextInt();
            System.out.printf("Enter rental time (hourly): ");
            rent = OI.nextInt();
            System.out.println("Enter the Surname First name Patronymic of the guarantor in case of force majeure: ");
        }

        public int valueOrginf() { //Метод расчета цены
            int sum; // общая цена
            int fsum = 500; // фиксированная цена
            sum = fsum + price * rent;
            System.out.printf("\nRent price: %d ", sum);
            return sum;
        }

        public int printOI() { //Метод вывода
            System.out.printf("\nFood purchase price: %d", price);
            System.out.printf("\nLease time: %d", rent);
            return 0;
        }
    }

    /*-------------------------------------------------------------------*/
    class player { //Класс игрок
        private String position; //позиция
        private int weigh; // вес
        private int height; // рост
        private final date plrD; // дата рождения

        public void init(String p, int w, int h) { //Метод создания
            position = p;
            weigh = w;
            height = h;
        }

        public player() { // Конструктор
            this.position = "";
            this.weigh = 0;
            this.height = 0;
            this.plrD = new date();
        }

        public player getPlayer() {
            return this;
        }

        public void enter() { //Метод ввода
            System.out.printf("\n\nEnter position: ");
            Scanner PL = new Scanner(System.in);
            position = PL.nextLine();
            System.out.printf("\nEnter weight: ");
            weigh = PL.nextInt();
            System.out.printf("\nEnter height: ");
            height = PL.nextInt();
            System.out.printf("\nEnter the minimum date of birth: ");
            plrD.input();

        }

        public int print(date date4) { //Метод вывода
            System.out.printf("\n\nInformation: %s %d %d", position, weigh, height);
            System.out.printf("\nBirthday: ");
            date4.output();
            return 0;
        }

        public void printArray() {
            System.out.printf("\n\nInformation: %s %d %d", position, weigh, height);
            System.out.printf("\nBirthday: ");
            plrD.output();
        }
    }

    /*-------------------------------------------------------------------*/
    class inventory implements Cloneable{
        private int nballs;
        private int ngates;
        private date createdate = new date();

        public void output(){
            System.out.print("\nEngine info: ");
            System.out.printf("\nNumber: %d", nballs );
            System.out.printf("\nPower: %d", ngates );
            System.out.printf("\nCreatedate: ");
            createdate.output();
        }

        public inventory(){
        }

        public void init(int nballs, int ngates, date createdate){
            this.nballs = nballs;
            this.ngates = ngates;
            this.createdate = createdate;
        }

        public void input(){
            int nballs;
            int ngates;
            date createdate = new date();
            System.out.print("\nInfo: ");
            Scanner in = new Scanner(System.in);
            do{
                System.out.print("Input nballs: ");
                while(!in.hasNextInt()){
                    System.out.println("That's not a number!");
                    System.out.print("Input nballs: ");
                    in.next();
                }
                nballs = in.nextInt();
            }while(nballs <= 0);
            this.nballs = nballs;
            do{
                System.out.print("Input power: ");
                while(!in.hasNextInt()){
                    System.out.println("That's not a number!");
                    System.out.print("Input power: ");
                    in.next();
                }
                ngates = in.nextInt();
            }while(ngates <= 0);
            this.ngates = ngates;
            createdate.input();
            this.createdate = createdate;
        }

        public inventory clone() throws CloneNotSupportedException{

            inventory newInventory = (inventory) super.clone();
            newInventory.createdate=(date) createdate.clone();
            return newInventory;
        }

        public void tokvt(){
            double ls=1000, res = 0;
            res = this.ngates * ls;
            System.out.printf("\nPower in kVt: %.2f", res);
        }
    }


/*-------------------------------------------------------------------*/
    class IntValue {
        public static int ReadInt() {
            while (true) {
                Scanner in = new Scanner(System.in);
                String line = in.nextLine();
                try {
                    return Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.err.println("Введите число");
                }
            }
        }
    }


    abstract class Human {
        private String name;
        private String lastname;
        private date birthdate = new date();

        public String toString() {
            return "\nName: " + this.name + "\n"
                    + "Lastname: " + this.lastname + "\n"
                    + "\nBirthdate: " + this.birthdate + "\n";
        }

        public Human() {
        }

        public Human(String value) {
            this.name = value;
        }

        public Human(String name, String lastname, date birthdate) {
            this.name = name;
            this.lastname = lastname;
            this.birthdate = birthdate;
        }

        public void input() {
            String name;
            String lastname;

            Scanner in = new Scanner(System.in);
            do {
                System.out.print("\nInput name: ");
                name = in.nextLine();
                if (name.trim().length() == 0 || name == " " || name == "\n") {
                    System.out.println("You haven't entered anything!");
                }
            } while (name.trim().length() == 0 || name == " " || name == "\n");
            this.name = name;
            do {
                System.out.print("\nInput lastname: ");
                lastname = in.nextLine();
                if (lastname.trim().length() == 0 || lastname == " " || lastname == "\n") {
                    System.out.println("You haven't entered anything!");
                }
            } while (lastname.trim().length() == 0 || lastname == " " || lastname == "\n");
            this.lastname = lastname;
            System.out.print("Input birthdate: ");
            date birthdate = new date();
            birthdate.input();
            this.birthdate = birthdate;
        }
    }

    class tenant1 extends Human {

        protected player tH = new player();

        public tenant1() {
        }

        public tenant1(String name, String lastname, date birthdate, player tH) {
            super(name, lastname, birthdate);
            this.tH = tH;
        }

        public void Input() {
            System.out.print("\nInfo: ");
            this.input();
            System.out.print("\nInfo pl: ");
            tH.enter();
        }

        public String toString() {
            return "\nInfo: " + this + "\n"
                    + "Info pl: " + tH + "\n";
        }

    }

    class Passenger extends Human {
        public Passenger() {
        }
    }

    interface Sale {
        int sale(int sl1);
    }

    class t {
        static private int count;
        private int id;
        private int sum;
        private String address;
        private int hours;
        private int minutes;
        private Passenger passenger = new Passenger();

        public static void ChangeDestination(t t1, String address) {
            t1.address = address;
        }

        public void output() {
            System.out.print("\nInfo: ");
            System.out.printf("\nAddress: %s", this.address);
            System.out.printf("\nId:", this.id);
            System.out.printf("\nSum: %d", this.sum);
            System.out.printf("\nTime: %d:%d", this.hours, this.minutes);
            System.out.println(this.passenger);
        }

        public t() {
        }

        public t(int value) {
            this.sum = value;
        }

        public t(String address, int sum, int hours, int minutes, Passenger passenger) {
            this.address = address;
            if (sum < 0) {
                this.sum = 0;
            } else {
                this.sum = sum;
            }
            if (hours < 0 || hours > 24) {
                this.hours = 0;
            } else {
                this.hours = hours;
            }
            if (minutes < 0 || minutes > 60) {
                this.minutes = 0;
            } else {
                this.minutes = minutes;
            }
            count++;
            id = count;

        }

        public void input() {
            int sum;
            String address;
            int hours;
            int minutes;
            Passenger passenger = new Passenger();
            System.out.print("\nInfo: ");
            Scanner in = new Scanner(System.in);
            do {
                System.out.print("\nInput address: ");
                address = in.nextLine();
                if (address.trim().length() == 0 || address == " " || address == "\n") {
                    System.out.println("You haven't entered anything!");
                }
            } while (address.trim().length() == 0 || address == " " || address == "\n");
            this.address = address;
            do {
                System.out.print("Input sum: ");
                while (!in.hasNextInt()) {
                    System.out.println("That's not a number!");
                    System.out.print("Input sum: ");
                    in.next();
                }
                sum = in.nextInt();
            } while (sum < 0);
            this.sum = sum;
            do {
                System.out.print("Input hours: ");
                while (!in.hasNextInt()) {
                    System.out.println("That's not a number!");
                    System.out.print("Input hours: ");
                    in.next();
                }
                hours = in.nextInt();
            } while (hours < 0 || hours > 24);
            this.hours = hours;
            do {
                System.out.print("Input minutes: ");
                while (!in.hasNextInt()) {
                    System.out.println("That's not a number!");
                    System.out.print("Input minutes: ");
                    in.next();
                }
                minutes = in.nextInt();
            } while (minutes < 0 || minutes > 60);
            this.minutes = minutes;
            passenger.input();
            this.passenger = passenger;
            count++;
            id = count;
        }

        int sale(int sl1) {
            int sl2 = 0;
            Scanner in = new Scanner(System.in);
            sl2 = this.sum - (this.sum * sl1 / 100);
            return sl2;

        }


        public class Main {

            public static void main(String[] args) {
                System.out.println("That's not a number!");
            }
        }
    }
