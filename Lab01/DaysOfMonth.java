import java.util.Scanner;
public class DaysOfMonth {
    public static void main(String[] args) {
        String[] validmonth = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                    "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December",
                    "Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec.",
                    "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the month");
        int flag=0;
        int month=0, year=0;
        String strMonth, strYear;
        while(flag==0) {
            strMonth = keyboard.nextLine();
            for(int i=0; i<48; i++) {
                if(strMonth.equals(validmonth[i])) {
                    flag = 1;
                    month=i%12+1;
                }
            }
            if(flag==1) break;
            else System.out.println("Please input a valid month!");
        }
        flag=0;
        System.out.println("Enter the year");
        while(flag==0) {
            strYear = keyboard.nextLine();
            if(!isNumeric(strYear)) {
                System.out.println("Please input a valid year!");
            }
            else {
                year=Integer.parseInt(strYear);
                if(year<0) System.out.println("Please input a valid year!");
                else break;
            }
        }
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)  System.out.println("31");
        else if(month==4||month==6||month==9||month==11) System.out.println("30");
        else {
            if(year%100==0) {
                if(year%400==0) System.out.println("29");
                else System.out.println("28");
            }
            else if(year%4==0) System.out.println("29");
            else System.out.println("28");
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}



    
