import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task10 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        if (line == null) return;

        int n = Integer.parseInt(line.trim());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            line = reader.readLine();
            if (line == null) break;

            StringTokenizer tokenizer = new StringTokenizer(line);
            String username = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";
            String password = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "";

            if (isValidLogin(username, password)) {
                result.append("SUCCESS\n");
            } else {
                result.append("FAILURE\n");
            }
        }

        System.out.print(result);
    }

    private static boolean isValidLogin(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        int uLen = username.length();
        int pLen = password.length();

        if (uLen < 3 || uLen > 20) {
            return false;
        }

        if (pLen < 6 || pLen > 20) {
            return false;
        }

        return true;
    }
}