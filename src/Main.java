//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    String num ="=50=";
     boolean ans = Ex2.isAritmaticaction(num);
     System.out.println(ans);
     boolean ans2 = Ex2.isAllCharsAreValid(num);
     System.out.println(ans2);
     int a  = Ex2.valueOfChar(num);
     System.out.println(a);
     boolean ans1 = Ex2.isNumber(num);
     System.out.println(ans1);
      boolean ans3 = Ex2.isForm(num);
      System.out.println(ans3);
    }
}