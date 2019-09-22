import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 4 && args[0].equals("-c")) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String fileName = br.readLine();
                BufferedReader brf = new BufferedReader(new FileReader(fileName));
                BufferedWriter fbw = new BufferedWriter(new FileWriter(fileName, true));
                ArrayList<String> arrString = new ArrayList<>();

                String line;
                while ((line = brf.readLine()) != null) {
                    arrString.add(line);
                }

                int currentId = 0;
                int maxId = 0;
                for (String s : arrString) {
                    currentId = Integer.parseInt(s.substring(0, 8).trim());
                    if (currentId > maxId)
                        maxId = currentId;
                }

                StringBuilder sb = new StringBuilder();
                sb.append("\n");
                sb.append(++maxId);
                while (sb.length() < 9)
                    sb.append(" ");
                String productName = args[1];
                String price = args[2];
                String quantity = args[3];
                sb.append(productName);
                while (sb.length() < 39)
                    sb.append(" ");

                sb.append(price);
                while (sb.length() < 47)
                    sb.append(" ");
                sb.append(quantity);
                while (sb.length() < 51)
                    sb.append(" ");

                String s = sb.toString();
                br.close();

                fbw.write(s);
                brf.close();
                fbw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
