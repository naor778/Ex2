package EX2.ex2;
// Add your documentation below:

import java.util.Scanner;

public class SCell implements Cell {
    private String line;
    private int type;
    // Add your code here

    public SCell(String s) {
        Scanner scanner =new Scanner(System.in);
        s=scanner.next();
        // Add your code here
        setData(s);
    }

    /**
     *  at this moment i can only konw if he is text or number
     *   than the order will be 0 according to what the interface mean
     *
     * @return
     */
    @Override
    public int getOrder() {
        // Add your code here
        int ans=0;
       if(getType()==2||getType()==1) {
           ans = 0;
       }
        // ///////////////////
        return ans;
    }

    //@Override
    @Override
    public String toString() {
        return getData();
    }

    /**
     * lets the scanner(user) make up his mind on what line will be
     *  and overraide it
     * @param s
     */
    @Override
public void setData(String s) {
        Scanner scanner = new Scanner(System.in);
        s=scanner.next();
        // Add your code here
        line = s;
        /////////////////////
    }
    @Override
    public String getData() {
        return line;
    }

    /**
     * did is form is number and is text but the other type like Err
     *  or Err loop of formula and other is not set yet cuse i dont have info on this
     * @return
     */
    @Override
    public int getType() {
         if(Ex2.isOnlyNumber(getData())==true){
             this.type=2;
         } else if (Ex2.isText(getData())==true) {
             this.type=1;

         } else if (Ex2.isForm(getData())==true) {
             this.type=3;
         }
        return this.type;
    }

    @Override
    public void setType(int t) {
        type = t;
    }

    @Override
    public void setOrder(int t) {
        // Add your code here

    }

}
