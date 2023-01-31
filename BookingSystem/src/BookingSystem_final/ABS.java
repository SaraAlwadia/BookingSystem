package BookingSystem_final;

import java.util.Scanner;

public class ABS {
    Scanner input = new Scanner(System.in);
    int arrSize = 100;
    int countAdmin=0;
    int countUser=0;
    int appCount=0;
    int idch=0;
    int[] lectID=new int[arrSize];
    String[] lectName=new String[arrSize];
    String[] lectPW=new String[arrSize];
    String[] appDate= new String[arrSize];
    String[] appTime=new String [arrSize];
    int [] avb= new int[arrSize];
    int [] Lida= new int[arrSize];
    int lectI=0;
    
    public void Menu(){
        System.out.println("1. Admin");
        System.out.println("2. User");
        int choose=input.nextInt();
        switch(choose){
            case 1:{
            menuAdmin();
                break;
            }
            case 2:{
            menuUser();
                break;
            }
            default:{
               System.out.println("Wrong choice");
               Menu();
            }
        }
    }
    
    public void menuAdmin(){
        String name[]={"admin","mohammed","zahhar"};
        String pass[]={"123","456","123"};
        int k=0;
        if(countAdmin==0){
            System.out.print("Enter username: ");
            String nAdmin=input.next();
            for(int i=0;i<pass.length;i++){
                if(name[i].equals(nAdmin)){
                    k=1;
                    System.out.print("Enter password: ");
                    String pAdmin=input.next();
                    if(pass[i].equals(pAdmin)){
                        countAdmin=1;
                        adminT();
                    }
                    else{
                        System.out.println("Wrong password");
                        Menu();
                    }
                }
            }
            if(k==0){
                System.out.println("Username does not exist");
                Menu();
            }
        }
        else{
            adminT();
        }
    }
      
    public void menuUser(){
        int k=0;
        if(countUser==0){
            System.out.print("Enter lecturer ID: ");
            int id=input.nextInt();
            for(int i=0;i<lectPW.length;i++){
                if(lectID[i]==id){
                    k=1;
                    System.out.print("Enter password: ");
                    String pAdmin=input.next();
                    if(lectPW[i].equals(pAdmin)){
                        countUser=1;
                        idch=lectID[i];
                        usert();
                    }
                    else{
                        System.out.println("Wrong password");
                        Menu();
                    }
                }
            }
        }
        else{
            usert();
        }
        if(k==0){
            System.out.println("This lecturer does not regist");
            Menu();
        }
    }
    public void usert(){
        System.out.println("1. Appintment Booking\n2. Dispaly Available Appointments\n3. Display appointments according to\n4. Main Menu\n5. Log Out ");
        int ch=input.nextInt();
        switch(ch){
            case 1:{
                int k=0;
                System.out.print("Enter date(dd/mm/yyyy): ");
                String dates=input.next();
                for(int i=0;i<appTime.length;i++){
                    if(appTime[i]!=null){
                        if(appDate[i].equals(dates)) {
                            k=1;
                            System.out.print("Enter time (hh:mm - hh:mm): ");
                            String times=input.next();
                            if(appTime[i].equals(times)){
                                avb[i]=1;
                                Lida[i]=idch;
                            }
                        } 
                    }
                }
                if(k==0){
                    System.out.println("Date does not exist");
                    usert();
                }
                usert();
                break;
            }
            
            case 2:{
                int k=0;
                for(int s=0;s<avb.length;s++){
                    if(appTime[s]!=null){
                        if(avb[s]==0){
                            k=1;
                            System.out.println("The date: "+ appDate[s] + " | " + "The time: "+ appTime[s]);
                        } 
                    }
                }
                if(k==0){
                    System.out.println("No appointments");
                }
                usert();
                break;
            }
            
            case 3:{
                int k=0;
                System.out.println(idch);
                for(int i=0;i<appTime.length;i++){
                    if(appTime[i]!=null){
                        if(avb[i]==1){
                            if(Lida[i]==idch){
                                k=1;
                                System.out.println("The date: "+ appDate[i] + " | " + "The time: "+ appTime[i]);
                            }
                        }
                    }
                }
                if(k==1){
                    System.out.println("You don't have any appointment");
                }
                usert();
                break;
            }
            
            case 4:{
                Menu();
                break;
            }
            
            case 5:{
                countUser=0;
                idch=0;
                System.out.println("Log out successfully");
                Menu();
                break;
            }
            
             default:{
                System.out.println("Wrong choice");
                Menu();
            }
        }
    }

    public void adminT(){
        System.out.println("1. Add lecturer\n2. Add Appointment\n3. Display Available Appointments\n4. Display Booking Appointment\n5. Cancel Booking\n6. Display Booking Appointment According Lecturer Name\n7. Main Menu");
        int ch=input.nextInt();
        switch(ch){
            case 1:{
                int id=12022000;
                System.out.print("How many lecturer you want to add: ");
                int num=input.nextInt();
                int t=num+lectI;
                for(;lectI<t;lectI++){
                    lectID[lectI]=++id;
                    System.out.print("Lecturer Name: ");
                    lectName[lectI]=input.next();
                    System.out.print("Lecturer Password: ");
                    lectPW[lectI]=input.next();
                    System.out.println("ــــــــــــــــــــــــــــــــــــــــ");
                }
                System.out.println("Added Successfully");
                adminT();
                break;
            }
            
            case 2:{
                System.out.print("How many appointment you want to add: ");
                int num=input.nextInt();
                int t=num+appCount;
                for(;appCount<t;appCount++){
                    System.out.print("Enter date (dd/mm/yyyy): ");
                    appDate[appCount]=input.next();
                    System.out.print("Enter Time (hh:mm - hh:mm): ");
                    appTime[appCount]=input.next();
                }
                adminT();
                break;
            }
            
            case 3:{
               int k=0;
               for(int i=0;i<avb.length;i++){
                    if(appTime[i]!=null){
                        if(avb[i]==0){
                            k=1;
                            System.out.println("The date: "+ appDate[i] + " | " + "The time: "+ appTime[i]);
                        } 
                    }
                }
                if(k==0){
                    System.out.println("There is no any appointment");
                }
                System.out.println("TEST");
                adminT();
                break;
            }
            
            case 4:{
                int k=0;
                for(int s=0;s<avb.length;s++){
                    if(appTime[s]!=null){
                        if(avb[s]==1){
                            k=1;
                            System.out.println("The date: "+ appDate[s] + " | " + "The time: "+ appTime[s]);
                        } 
                    }
                }
                if(k==0){
                    System.out.println("There is no any appointment");
                }
                adminT();
                break;
            }
            
            case 5:{
                int k=0;
                System.out.print("Enter date(dd/mm/yyyy): ");
                String dates=input.next();
                for(int i=0;i<appTime.length;i++){
                    if(appTime[i]!=null){
                        if(appDate[i].equals(dates)) {
                            k=1;
                            System.out.print("Enter time (hh:mm - hh:mm): ");
                            String times=input.next();
                            if(appTime[i].equals(times)){
                                avb[i]=0;
                                Lida[i]=0;
                            }
                            else{
                                System.out.println("Time does not exist");
                                adminT();
                            }
                        }
                    }
                }
              
                if(k==0){
                    System.out.println("Date does not exist");
                    adminT();
                }
                else{
                    System.out.println("Booing canceled successfully");
                     adminT();
                }
                adminT();
                break;
            }
            
            case 6:{
                int k=0;
                System.out.print("Enter Lecturer ID: ");
                int idss=input.nextInt();
                System.out.println(idch);
                for(int i=0;i<appTime.length;i++){
                    if(appTime[i]!=null){
                        if(avb[i]==1){
                            if(Lida[i]==idss){
                                k=1;
                                System.out.println("The date: "+ appDate[i] + " | " + "The time: "+ appTime[i]);
                            }
                        }
                    }
                }
                if(k==1){
                    System.out.println("No appointments for this ID");
                }
                adminT();
                break;
            }
            
            case 7:{
                Menu();
                break;
            }
            
            default:{
                System.out.println("Wrong Choice");
                menuAdmin();
            }
        }
    }
}
