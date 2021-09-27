import java.util.ArrayList;
import java.util.List;

public class q6 {

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();

        for(int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean down = false;

        for(char c : s.toCharArray()){
            rows.get(curRow).append(c);

            if(curRow == 0 || curRow == numRows - 1) down = !down;

            curRow += down ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for(StringBuilder str : rows)   ret.append(str);
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new q6().convert("PAYPALISHIRING", 4));
    }

}
