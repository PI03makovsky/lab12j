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



    public tenant(){

    }

    public tenant(String value) {

        this.name = value;
    }
    public tenant(String name, String s){

        this.name = name;

        this.surname = surname;


    }

    public void enterT() { //Метод ввода
        System.out.printf("\nEnter the name: "); Scanner tn = new Scanner(System.in); name=tn.nextLine(); System.out.printf("Enter the surname: "); surname=tn.nextLine(); System.out.printf("Enter the patronymic: "); patronymic=tn.nextLine(); System.out.printf("Enter the birthday:\n");
    }
    public int printer(date date3) { //Метод вывода
        System.out.printf("\nName: %s Surname: %s Patronymic %s ", name, surname, patronymic); System.out.println("\nBirthday: "); date3.print(); return 0;
    }
};
