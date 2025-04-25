import java.util.Scanner;
public class Stars {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the height of the triangle");
        int n = keyboard.nextInt();
        for(int i=1; i<=n; i++) {
            String stars = "";
            for(int j=1; j<=i; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }
    }
}
