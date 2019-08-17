public class ZigzagString {

    public static void main(String[] args) {
        ZigzagString zigzagString = new ZigzagString();
        System.out.println("converted string is: " + zigzagString.convert("I Liketo code", 3));
    }

    public String convert(String s, int numRows) {
        if(s == null || s.length() < 2 || numRows<=1 || (s.length() < numRows)) {
            return s;
        }
        StringBuilder[] builder = new StringBuilder[numRows];
        for(int i = 0;i <numRows;i++) {
            builder[i] = new StringBuilder("");
        }

        boolean down = true;
        int position = 0;
        for(int i = 0; i<s.length();i++) {
            builder[position].append(s.substring(i, i+1));
            if(down) {
                if(position == numRows -1) {
                    down = false;
                    position--;
                } else {
                    position++;
                }
            } else {

                if(position == 0) {
                    down = true;
                    position++;
                } else {
                    position--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb : builder) {
            result.append(sb);
        }
        return result.toString();
    }
}
