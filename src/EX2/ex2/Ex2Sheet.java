package EX2.ex2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
// Add your documentation below:

/**
 *
 */
public class Ex2Sheet implements Sheet {
    private Cell[][] table;
    // Add your code here

    // ///////////////////

    /**
     * @param x
     * @param y
     */
    public Ex2Sheet(int x, int y) {
        table = new SCell[x][y];
        for (int i = 0; i < x; i = i + 1) {
            for (int j = 0; j < y; j = j + 1) {
                table[i][j] = new SCell(i, j, "");

            }
        }
        eval();
    }

    public Ex2Sheet() {
        this(Ex2Utils.WIDTH, Ex2Utils.HEIGHT);
    }

    /**
     * give the value of cordenate of x and y for exsample 1A =1,0 while (x=1 y=0)
     *
     * @param x integer, x-coordinate of the cell.
     * @param y integer, y-coordinate of the cell.
     * @return
     */
    @Override
    public String value(int x, int y) {
        String ans = Ex2Utils.EMPTY_CELL;

        // Add your code here

        Cell c = get(x, y);
        if (c != null) {
            ans = c.toString();
        }

        /////////////////////
        return ans;
    }

    @Override
    public Cell get(int x, int y) {
        return table[x][y];
    }

    /**
     * @param cords
     * @return
     */
    @Override
    public Cell get(String cords) {
        Cell ans = null;
        // Add your code here

        /////////////////////
        return ans;
    }

    @Override
    public int width() {
        return table.length;
    }

    @Override
    public int height() {
        return table[0].length;
    }

    /**
     * @param x integer, x-coordinate of the cell.
     * @param y integer, y-coordinate of the cell.
     * @param s - the string representation of the cell.
     */
    @Override
    public void set(int x, int y, String s) {
        if (s == null || s.isEmpty()) {
            set(x, y, Ex2Utils.EMPTY_CELL);
        }
        if (s == Ex2Utils.ERR + "") {
            set(x, y, Ex2Utils.ERR_FORM);
        }

        Cell c = new SCell(x, y, s);
        table[x][y] = c;
        // Add your code here

        /////////////////////
    }

    /**
     * caculte the value of all cell in the table
     */
    @Override
    public void eval() {
        for (int x = 0; x < width(); x++) {
            for (int y = 0; y < height(); y++) {
                eval(x, y);
            }
        }
    }

    /**
     * need to chack if the cordinate is in the table
     *
     * @param xx - integer, x-coordinate of the table (starts with 0).
     * @param yy - integer, y-coordinate of the table (starts with 0).
     * @return
     */
    @Override
    public boolean isIn(int xx, int yy) {
        boolean ans = xx >= 0 && yy >= 0;
        // Add your code here

        /////////////////////
        return ans;
    }

    /**
     * chack who is depend on who for exsample empty cell depth=0
     *
     * @return
     */
    @Override
    public int[][] depth() {
        int[][] ans = new int[width()][height()];
        for (int i = 0; i < width(); i = i + 1) {
            for (int j = 0; j < height(); j = j + 1) {
                ans[i][j] = SCell.deapthOfCell(i, j);
            }
            return ans;
        }
        // Add your code here

        // ///////////////////
        return ans;
    }

    /**
     * @param fileName a String representing the full (an absolute or relative path to the loaded file).
     * @throws IOException
     */
    @Override
    public void load(String fileName) throws IOException {
        // Add your code here
        //try {
        File myObj = new File(fileName);
        Scanner myReader = new Scanner(myObj);
        int i = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(i + "" + data);
            i = i + 1;
        }
        myReader.close();

        /////////////////////
    }

    /**
     * @param fileName a String representing the full (an absolute or relative path tp the saved file).
     * @throws IOException
     */
    @Override
    public void save(String fileName) throws IOException {
        // Add your code here
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write("Text file named: " + fileName + "\n");
            myWriter.write(Ex2Sheet.this.toString() + "\n");
            for (int x = 0; x < width(); x++) {
                for (int y = 0; y < height(); y++) {
                    String p1 = get(width(), height()) + "";
                    if (p1 != null) {
                        myWriter.write("Cell " + p1.toString());
                        myWriter.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /// //////////////////


    @Override
    public String eval(int x, int y) {
        String ans = null;
        if (get(x, y) != null) {
            ans = get(x, y).toString();
            if (ans == null) {
                return Ex2Utils.EMPTY_CELL;
            } else if (Ex2Funcstion.isForm(ans) == true || Ex2Funcstion.isText(ans) == true) {
                return Ex2Utils.ERR_FORM_FORMAT + "";
            } else if (Ex2Funcstion.isText(ans) == true) {
                return get(x, y) + "";
            } else if (Ex2Funcstion.isNumber(ans) == true) {
                return get(x, y) + "";
            } else if (Ex2Funcstion.isForm(ans) == true) {
                ans = SCell.NewFurmulaAfterChangeReferance(ans);
                return Ex2Funcstion.calculateFormula(ans);
            }
        }
        // Add your code here

        /////////////////////
        return ans;
    }
}