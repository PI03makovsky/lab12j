public void enter(){
        Scanner in = new Scanner(System.in);
        int day;
        int month;
        int year;
        boolean enter;
        do{
        try{

        System.out.print("Input day: ");
        day = in.nextInt();
        if(day < 1 || day > 31){
        throw new Exception("Wrong input. Please input number between 1 and 31");
        }
        enter = false;
        this.day = day;
        }
        catch(Exception e){
        System.out.println("Wrong input! Please retry!");
        enter = true;

        }
        }while(enter);
        do{
        try{

        System.out.print("Input month: ");
        month = in.nextInt();
        if(month < 1 || month > 12){
        throw new Exception("Wrong input. Please input number between 1 and 12");
        }
        enter  = false;
        this.month = month;
        }
        catch(Exception e){
        System.out.println("Wrong input! Please retry!");
        enter = true;

        }
        }while(enter);
        do{
        try{
        System.out.print("Input year: ");
        year = in.nextInt();
        if(year < 1 || year > 2021){
        throw new Exception("Wrong input. Please input number between 1 and 2021");
        }
        enter = false;
        this.year = year;
        }
        catch(Exception e){
        System.out.println("Wrong input! Please retry!");
        enter = true;

        }
        }while(enter);
        }
