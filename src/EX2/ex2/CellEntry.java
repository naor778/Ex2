package EX2.ex2;
// Add your documentation below:

public class CellEntry  implements Index2D {

    @Override
    public boolean isValid() {
        boolean ans = false;
        if ("ABCDEFGJIKLMNOPQRSTUVWXYZabcdefgjiklmnopqrstuvwxyz".contains(toString().substring(0, 0)) && "0123456789".contains(toString().substring(1, toString().length()))) {
            ans = true;
        }
        return ans;
    }


    @Override
    public int getX() {
        char c = toString().charAt(0);
        int ans = Ex2.ValueOfLetters(c);
        if (c < 0 || c > 25) {
            return Ex2Utils.ERR;
        }
        return ans;
    }

    @Override
    public int getY() {
        String ansOfNumbers = toString().substring(1, toString().length());
        int ansOfY = Integer.parseInt(ansOfNumbers);
        if (ansOfNumbers.isEmpty() || !"0123456789".contains(ansOfNumbers)) {
            return Ex2Utils.ERR;
        }
        return ansOfY;
    }

}

