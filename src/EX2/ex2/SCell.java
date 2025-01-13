package EX2.ex2;
// Add your documentation below:

import java.util.List;

import static EX2.ex2.Ex2Utils.*;

public class SCell implements Cell {
    private static String _DataFirst;
    private String line;
    private int type;
    private static final String[][] AllCell = new String[25][99];
    private static final String[][] AllCell2 = new String[25][99];
    private int x, y;
    private int order;
    // Add your code here

    public SCell(int x, int y, String s) {
        this.x = x;
        this.y = y;
        this._DataFirst=s;
        setData(s); // Set the data after assigning the coordinates
        if (s == ERR_CYCLE || s == ERR_FORM || s == EMPTY_CELL) {
            setType(-1);
            this.type = Ex2Utils.TEXT; // Default type is TEXT (until we parse it).
            this.order = 0;
        }
    }


    @Override
    public int getOrder() {
        return this.order;
        // Add your code here
    }

    @Override
    public String toString() {
        return getData();
    }


    @Override
    public void setData(String s) {
        // Add your code here
        _DataFirst=s;
        this.type = determineCellType(s);  // Classify the type of data (text, number, formula)
        this.line = s;

        if (this.line.length() > 1 && this.type == 3) {

            while (Ex2Funcstion.IsItCellCords(s)==true) {
                s = SCell.NewFurmulaAfterChangeReferance(s);
            } try {
                this.line = Ex2Funcstion.calculateFormula(s);
            } catch (NumberFormatException e) {
                this.type = ERR;
                this.line = Ex2Utils.ERR_FORM;
            }
        }
        System.out.println("Updating cell at [" + x + "][" + y + "] with value: " + this.line);
        AllCell[x][y]=this.line;
        AllCell2[x][y] = this._DataFirst;
    }

    @Override
    public String getData() {
        return this.line;
    }

    /**
     * did is form is number and is text but the other type like Err
     * or Err loop of formula and other is not set yet cuse i dont have info on this
     *
     * @return
     */
    @Override
    public int getType() {
        //  if(Ex2Funcstion.isOnlyNumber(getData())==true){
        //  this.type=2;
        // } else if (Ex2Funcstion.isText(getData())==true) {
        //   this.type=1;

        //  } else if (Ex2Funcstion.isForm(getData())==true) {
        //      this.type=3;
        //  } else {
        //    this.type=-1;}
        return this.type;
    }

    @Override
    public void setType(int t) {
        this.type = t;
    }

    @Override
    public void setOrder(int order) {
        this.order = order;
        // Add your code here

    }

    /**
     * need to add the other ERR stuff later on like loops and this kind of stuff
     *
     * @param s
     * @return
     */
    public int determineCellType(String s) {

        if (s.startsWith("=")) {
            setType(3);  // Formula
            return 3;
        } else if (isNumber(s)) {
            setType(2); // Numeric value
            return 2;
        } else if (Ex2Funcstion.isText(s)) {
            setType(1); // Text data
            return 1;
        } else {
            setType(-1);  // Error type for unrecognized data
            return -1;
        }

    }

    public boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String evaluateFormula(Ex2Sheet sheet) {

        if (type == 3) {
            String formula = getData().substring(1);  // Remove the '=' sign to get the actual formula content

            // Call your custom function that calculates the formula
            return Ex2Funcstion.calculateFormula(formula) + "";
        }
        return getData();  // If it's not a formula, just return the data as-is
    }


    public static String getCellValueOf2D(String furmula) {

        char xchar = furmula.charAt(0);
        String yString = furmula.substring(1);
        int x = Character.toUpperCase(xchar) - 'A';
        int y = Integer.parseInt(yString);
        String ans = AllCell[x][y];
        if (ans == null || ans == "") {
            ans = "";

        }
        if (ans.startsWith("=")) {
            return ans.substring(1);
        }
        return ans;
    }
    public static String NewFurmulaAfterChangeReferance(String form) {
        if (form.startsWith("=")) {
            form = form.substring(1);
        }

        List<String> ListOfFurmula = Ex2Funcstion.NumbersOnlyByOrderV2(form);
        for (int i = 0; i < ListOfFurmula.size(); i = i + 1) {
            while (Ex2Funcstion.IsItCellCords(ListOfFurmula.get(i)) == true) {

                ListOfFurmula.set(i, getCellValueOf2D(ListOfFurmula.get(i)));
            }
        }if (ListOfFurmula.get(0) == "("){
            String resulte = String.join("(",ListOfFurmula);
            return resulte;

        }
        String resulte = String.join("",ListOfFurmula);
        return resulte;
    }

    public static int deapthOfCell(int x, int y) {
        int counter = 0;
        if(AllCell[x][y]==null||AllCell[x][y].isEmpty()){
            return counter;
        }
        List<String> ListOfCell = Ex2Funcstion.NumbersOnlyByOrderV2(AllCell[x][y]);
        for (int i = 0; i < ListOfCell.size(); i = i + 1) {
            if (Ex2Funcstion.IsItCellCords(ListOfCell.get(i)) == true) {
                counter = counter + 1;
            }
        }
        if (counter > (1500)) {
            return ERR_CYCLE_FORM;
        }
        return counter;
    }

}
