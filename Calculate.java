import javax.swing.JOptionPane;
public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "The sum, difference, product, and quotient of ";
        strNum1 = JOptionPane.showInputDialog(null, 
                    "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null, 
                    "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2 + " are: ";

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        while (num2==0) {
            strNum2 = JOptionPane.showInputDialog(null, 
                    "Please input a number different from 0!: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
            num2 = Double.parseDouble(strNum2);
        }
        double sum = num1 + num2;
        double diff = num1-num2;
        double product = num1 * num2;
        double quotient = num1/num2;
        strNotification += sum + ", " + diff + ", " + product + ", " + quotient;

        JOptionPane.showMessageDialog(null, strNotification,
                    "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}