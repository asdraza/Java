    /*
     *This is a D grade solution
     */
import java.util.ArrayList;

public class SumUp implements Stringifier {

    @Override
    public ArrayList<String> stringify(Object[] objs) {

        /*
         * This is our final resultant arraylist, which will be returned.
         */
        ArrayList<String> result = new ArrayList<String>();


        /*
         * We first check the presence of strings and numbers in the inputs.
         */
        boolean stringPresent = false;
        boolean numberPresent = false;


        for(int i = 0; i < objs.length; i++) {
            if(objs[i] instanceof String) {
                stringPresent = true;

            } else {
                numberPresent = true;
            }
        }


        if((stringPresent == true) && (numberPresent == false)) {

            /*
             * Everything is a string.
             * Thus, we simply want the result of Concatenator !
             */
            String concatenatorResult = new Concatenator().stringify(objs).get(0);
            result.add(concatenatorResult);

        } else {

            /*
             * We try parsing everything as a int into a double, and get the total sum.
             */
            double sum = 0.0;

            for(int i = 0; i < objs.length; i++) {
                sum = sum + Integer.parseInt(objs[i].toString());//int not double
            }

            /*
             * We add the sum as a string, to our result arraylist.
             */
            result.add(Double.toString(sum));
        }

        /*
         * We return the result.
         */
        return result;
    }

}