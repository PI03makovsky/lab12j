package lab;
import java.util.Scanner;
import java.lang.*;

/*-------------------------------------------------------------------*/
class date { // класс дата
    private int day; // день
    private int month; // месяц
    private int year; // год
    date() { } public void init(int d, int m, int y) { // Метод создания
        this.day = d; this.month = m; this.year = y; }
    public void enterD() { // Метод ввода
        Scanner inp = new Scanner(System.in);
        System.out.printf("\nEnter the day: ");
        day=inp.nextInt();
        System.out.printf("\n\nEnter the month: ");
        month=inp.nextInt();
        System.out.printf("\n\nEnter the year: ");
        year=inp.nextInt();
    }
    public void print() { // Метод вывода
        System.out.printf("%d %d %d", this.day, this.month, this.year); }
    public int difDate(date date1, date date2) { //Метод рассчета дней между датами
        if (date1.month < 3) { --date1.year; date1.month += 12; } int sum = 365 * date1.year + date1.year / 4 - date1.year / 100 + date1.year / 400 + (153 * date1.month - 457) / 5 + date1.day - 306; if (date2.month < 3) { --date2.year; date2.month += 12; } int sum1 = 365 * date2.year + date2.year / 4 - date2.year / 100 + date2.year / 400 + (153 * date2.month - 457) / 5 + date2.day - 306; if (sum < sum1) { System.out.printf("Error. The second date is greater than the first."); return 0; } else { return sum - sum1; }
    }
}
/*-------------------------------------------------------------------*/
class tenant { //Класс арендатор
    String name; //имя
    String surname; //фамилия
    String patronymic; //отчество
    public static int password;
    public void init1 (String n, String s, String p){ //Метод создания
        name = n; surname = s; patronymic = p;
    }
    public void enterT() { //Метод ввода
        System.out.printf("\nEnter the name: "); Scanner tn = new Scanner(System.in); name=tn.nextLine(); System.out.printf("Enter the surname: "); surname=tn.nextLine(); System.out.printf("Enter the patronymic: "); patronymic=tn.nextLine(); System.out.printf("Enter the birthday:\n");
    }
    public int printer(date date3) { //Метод вывода
        System.out.printf("\nName: %s Surname: %s Patronymic %s ", name, surname, patronymic); System.out.println("\nBirthday: "); date3.print(); return 0;
    }
    public int printerA(int n1){
        System.out.printf("\nПароль: %s ", n1);
    }
};
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
};
/*-------------------------------------------------------------------*/
class player { //Класс игрок
    private String position; //позиция
    private int weigh; // вес
    private int height; // рост
    private date plrD; // дата рождения
    public void init(String p, int w, int h){ //Метод создания
        position = p; weigh = w; height =h;
    }
    public player() { // Конструктор
        this.position = "";
        this.weigh = 0;
        this.height = 0;
        this.plrD = new date();
    }
    public player getPlayer(){
        return this;
    }

    public void enter(){ //Метод ввода
        System.out.printf("\n\nEnter position: ");
        Scanner PL = new Scanner(System.in);
        position =PL.nextLine();
        System.out.printf("\nEnter weight: ");
        weigh = PL.nextInt();
        System.out.printf("\nEnter height: ");
        height = PL.nextInt();
        System.out.printf("\nEnter the minimum date of birth: ");
        plrD.enterD();

    }
    public int print(date date4){ //Метод вывода
        System.out.printf("\n\nInformation: %s %d %d", position, weigh, height); System.out.printf("\nBirthday: "); date4.print(); return 0;
    }
    public void printArray(){
        System.out.printf("\n\nInformation: %s %d %d", position, weigh, height);
        System.out.printf("\nBirthday: ");
        plrD.print();
    }
};
/*-------------------------------------------------------------------*/
class inventory { // класс инвентарь
    public int nballs; // количество мячей
    public int ngates; // количество ворот
    public String typeOFc; // тип покрытия
    private void init(int nb, int ng, String toc){ // Метод создания
        nballs = nb; ngates = ng; typeOFc = toc;
    }
    private void enter(){ //Метод ввода
        System.out.printf("\n\nEnter the number of balls: "); Scanner IY = new Scanner(System.in); nballs = IY.nextInt(); System.out.printf("Enter the number of gates: "); ngates = IY.nextInt(); System.out.println("Enter the type of coverage (Artificial or Natural): "); typeOFc=IY.nextLine(); System.out.printf("\nEnter one of the referees who will serve your match (Linesman or Referee): ");
    }
    private int valueInventory(){ //Метод расчета цены
        int rREF = 0; rREF = (nballs * 100) + (ngates * 75); System.out.printf("\n\nValue Added: %d ", rREF); return rREF;
    }
    private void print(){ //Метод вывода
        System.out.printf("\nNumber of balls: %d", nballs); System.out.printf("\nLease time: %d", ngates); System.out.printf("\n\nCover type: %s", typeOFc);
    }
};
/*-------------------------------------------------------------------*/
class IntValue{
    public static int ReadInt(){
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
/*-------------------------------------------------------------------*/
public class Main {

    public static void main(String[] args) {
        /*date dataINPUT = new date();
        date dataEST = new date();
        date rd = new date();
        dataINPUT.init(20, 12, 2021); // дата основания
        dataEST.init(20, 12, 2020); // дата аренды
        int a = rd.difDate(dataINPUT, dataEST); // расчёт разницы дней
        dataINPUT.print(); //вывод даты аренды
        System.out.println(" ");
        dataEST.print(); // вывод даты основания
        System.out.printf("\nNumber of days between dates: %d", a);
        tenant tenantFIO = new tenant();
        date tenantFIO1 = new date();
        tenantFIO.enterT(); // ввод фио
        tenantFIO1.enterD(); // ввод даты
        int b = tenantFIO.printer(tenantFIO1); // информация об арендаторе
        orginf ofINF1 = new orginf();
        tenant ofINF2 = new tenant();
        date ofINF3 = new date();
        player playerP1 = new player();
        date playerP2 = new date();
        inventory inv1 = new inventory();
        orginf inv2 = new orginf();
        date inv3 = new date();*/

        /*---------------------------------Lab 7----------------------------------*/

        tenant tenantFIO = new tenant();
        int n1;
        int i=0;
        tenantFIO.printerA = 5555;
        // Array();

        //player Player = new player();
        //Player.enter();
        //player Player_2 = Player.getPlayer();
        //System.out.print("\n  Игрок 1:\n");
        //Player.printArray();
        //System.out.print("\n  Игрок 2:\n");
        //Player_2.printArray();
        //}

        //static void Array(){
        //int size;
        //int index;
        //System.out.print("\n  Сколько игроков создать?: ");
        //size = IntValue.ReadInt();
        //player[] list = new player[size];

        //for(int i=0;i<size;i++){
        //list[i] = new player();
        // list[i].enter();
        //}
        //System.out.print("\n\n  Печать:");
        //for(int i=0;i<size;i++){
        //list[i].printArray();
        // }
        //System.out.print("\n  Какого игорока редактировать?: ");
        //do{
        //    index = IntValue.ReadInt();
        //}while(index > size || index <= 0);
        //index--;
        //list[index] = new player();
        //list[index].enter();
        //System.out.print("\n\n  Печать:");
        //for(int i=0;i<size;i++){
        // list[i].printArray();
        //}
        //System.out.print("\n");
        // }
    }