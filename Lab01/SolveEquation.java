import javax.swing.JOptionPane;
public class SolveEquation {
    public static void main(String[] args) {
    Object [] options = {"The first-degree equation (linear equation) with one variable",
    "The system of first-degree equations (linear system) with two variables",
    "The second-degree equation with one variable"};
    int n = JOptionPane.showOptionDialog(null, "What kind of equation would you like to solve?",
                            "Choose the kind of equation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[2]);
{
    if(n==0) {
        String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, 
                    "Please input the first parameter: ", "Input the first parameter", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, 
                    "Please input the second parameter: ", "Input the second parameter", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        while (num1==0) {
            strNum1 = JOptionPane.showInputDialog(null, 
                    "Please input a parameter different from 0!: ", "Input the first parameter", JOptionPane.INFORMATION_MESSAGE);
            num1 = Double.parseDouble(strNum1);
        }
        double ans=-num2/num1;
        String strNotification = "The answer is: " + ans;
        JOptionPane.showMessageDialog(null, strNotification,
                    "The answer", JOptionPane.INFORMATION_MESSAGE);
    }
    else if(n==1) {
        String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6;
        strNum1 = JOptionPane.showInputDialog(null, 
                    "Please input the first parameter of the first equation: ", "Input the first equation", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, 
                    "Please input the second parameter of the first equation: ", "Input the first equation", JOptionPane.INFORMATION_MESSAGE);
        strNum3 = JOptionPane.showInputDialog(null, 
                    "Please input the third parameter of the first equation: ", "Input the first equation", JOptionPane.INFORMATION_MESSAGE);
        strNum4 = JOptionPane.showInputDialog(null, 
                    "Please input the first parameter of the second equation: ", "Input the second equation", JOptionPane.INFORMATION_MESSAGE);
        strNum5 = JOptionPane.showInputDialog(null, 
                    "Please input the second parameter of the second equation: ", "Input the second equation", JOptionPane.INFORMATION_MESSAGE);
        strNum6 = JOptionPane.showInputDialog(null, 
                    "Please input the third parameter of the second equation: ", "Input the second equation", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double num3 = Double.parseDouble(strNum3);
        double num4 = Double.parseDouble(strNum4);
        double num5 = Double.parseDouble(strNum5);
        double num6 = Double.parseDouble(strNum6);
        double D = num1 * num5 - num4 * num2;
        double D1 = num3 * num5 - num6 * num2;
        double D2 = num1 * num6 - num4 * num3;
        if(D!=0) {
        double ans1 = D1/D;
        double ans2 = D2/D;
        String strNotification = "The answer is: " + ans1 + " and " + ans2;
        JOptionPane.showMessageDialog(null, strNotification,
                    "The answer", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(D==0&&D1!=0&&D2!=0) {
        String strNotification = "There is no answer for the equations!";
        JOptionPane.showMessageDialog(null, strNotification,
                    "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(D==0&&D1==0&&D2==0) {
        String strNotification = "There is an infinite number of answers for the equations!";
        JOptionPane.showMessageDialog(null, strNotification,
                    "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    else {
        String strNum1, strNum2, strNum3;
        strNum1 = JOptionPane.showInputDialog(null, 
                    "Please input the first parameter: ", "Input the equation", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, 
                    "Please input the second parameter: ", "Input the equation", JOptionPane.INFORMATION_MESSAGE);
        strNum3 = JOptionPane.showInputDialog(null, 
                    "Please input the third parameter: ", "Input the equation", JOptionPane.INFORMATION_MESSAGE);
    
    double num1 = Double.parseDouble(strNum1);
    double num2 = Double.parseDouble(strNum2);
    double num3 = Double.parseDouble(strNum3);
    while (num1==0) {
        strNum1 = JOptionPane.showInputDialog(null, 
                "Please input a number different from 0 for the first parameter!: ", "Input the first parameter", JOptionPane.INFORMATION_MESSAGE);
        num1 = Double.parseDouble(strNum1);
    }
    double delta = num2*num2-4*num1*num3;
    if(delta<0) {
        String strNotification = "There is no answer for the equation!";
        JOptionPane.showMessageDialog(null, strNotification,
                    "Error!", JOptionPane.INFORMATION_MESSAGE);
    }
    else if(delta==0) {
        double ans=-num2/(2*num1);
        String strNotification = "The answer is: " + ans;
        JOptionPane.showMessageDialog(null, strNotification,
                    "The answer", JOptionPane.INFORMATION_MESSAGE);
    }
    else {
        delta = Math.sqrt(delta);
        double ans1 = (-num2+delta)/(2*num1);
        double ans2 = (-num2-delta)/(2*num1);
        String strNotification = "The answer is either " +ans1 + " or " + ans2;
        JOptionPane.showMessageDialog(null, strNotification,
                    "The answer", JOptionPane.INFORMATION_MESSAGE);
    }
}
}
    }}