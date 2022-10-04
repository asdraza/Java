    /*
     *This is a B(or better) grade solution
     */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator implements Stringifier {

    /*
     * A map to store the mappings.
     */
    static Map<String, String> map = new HashMap<String, String>();

    static {

        /*
         * We populate the map with the mappings.
         */
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");
        map.put("5", "five");
        map.put("6", "six");
        map.put("7", "seven");
        map.put("8", "eight");
        map.put("9", "nine");
        map.put("10", "ten");

        map.put("+", "plus");
        map.put("-", "minus");

        /*
         * Using the same mapping for * and x.
         */
        map.put("*", "times");
        map.put("x", "times");

        map.put("/", "divided by");
        map.put("=", "equals");
    }


    @Override
    public ArrayList<String> stringify(Object[] objs) {

        /*
         * This is our final resultant arraylist, which will be returned.
         */
        ArrayList<String> result = new ArrayList<String>();


        /*
         * We iterate over each input string.
         */
        for(int i = 0; i < objs.length; i++) {

            String expression = (String) objs[i];

            /*
             * The converted string.
             */
            String converted = "";


            /*
             * We use scanner to scan the string.
             */
            Scanner scanned = new Scanner(expression);

            /*
             * We now extract each part, and get its corresponding mapping from the map.
             */
            while(scanned.hasNext()) {

                String token = scanned.next().strip();
                String mapping = map.get(token);

                converted = converted + mapping + " ";
            }

            scanned.close();


            /*
             * We add the converted expression to our result arraylist
             * after removing all leading/trailing whitespaces.
             */
            result.add(converted.strip());
        }

        /*
         * We return the result.
         */
        return result;
    }

}
