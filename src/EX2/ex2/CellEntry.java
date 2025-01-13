package EX2.ex2;
// Add your documentation below:

public class CellEntry implements Index2D {
    public static final CellEntry[][] AllCell = new CellEntry[25][99];
    private int x, y;

    public CellEntry(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public String toString(int x, int y) {
        char Letter = Ex2Funcstion.intToLetters(x);
        String ans = "" + Letter + "" + y;
        return ans;
    }

    @Override
    public boolean isValid() {
        // Ensure the cell is within the valid range of the spreadsheet (e.g., A1, B2, etc.)
        String ref = toString();  // Get the reference string (e.g., "A1")
        if (ref.length() < 2) return false;  // Invalid if too short

        // Ensure the first character is a valid column letter (A-Z)
        char column = ref.charAt(0);
        if (column < 'A' || column > 'Z') return false;

        // Ensure the rest is a valid number (representing the row)
        String rowStr = ref.substring(1);
        try {
            Integer.parseInt(rowStr);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }


    @Override
    public int getX() {
        return Ex2Funcstion.ValueOfLetters(toString().charAt(0));
    }


    @Override
    public int getY() {
        String rowStr = toString().substring(1);
        return Integer.parseInt(rowStr) - 1;
    }
}
