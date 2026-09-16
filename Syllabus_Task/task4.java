import java.util.*;
import java.io.*;

public class task4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String text = br.readLine().trim();
        String pattern = br.readLine().trim();
        
        List<Integer> positions = kmpSearch(text, pattern);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < positions.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(positions.get(i));
        }
        System.out.println(sb.toString());
    }

    private static List<Integer> kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        List<Integer> result = new ArrayList<>();

        if (m == 0 || m > n) return result;

        int[] lps = computeLPS(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j);      // match found
                j = lps[j - 1];         // continue searching
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}