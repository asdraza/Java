import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringSearch {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Pattern Search - Brute force");
        System.out.print("Enter the Text: ");
        String text = reader.readLine();

        System.out.print("Enter the Pattern: ");
        String pattern = reader.readLine();

        List<Integer> occurences = searchString(text, pattern);

        System.out.println(occurences);

    }

    public static List<Integer> searchString(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        List<Integer> occurences = new ArrayList<>();

        for (int pos = 0; pos < n - m; pos++) {
            if (text.substring(pos, pos + (m)).equals(pattern)) {
                System.out.println(pos);
                occurences.add(pos);
            }
        }

        return occurences;
    }
}
//The worst case complexity of this brute force algorithm is O((n-m).m)
//Time Complexity is O(n*m)