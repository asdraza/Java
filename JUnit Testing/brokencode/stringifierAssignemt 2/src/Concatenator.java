    /*
     *This is a D grade solution
     */
import java.util.ArrayList;

public class Concatenator implements Stringifier {

    @Override
    public ArrayList<String> stringify(Object[] objs) {

        /*
         * This is our final resultant arraylist, which will be returned.
         */
        ArrayList<String> result = new ArrayList<String>();


        /*
         * Here, all objects are non-primitive types.
         * So, we can simply call the toString() method on each
         * object, and the wrapper-class will take care from there on.
         */

        /*
         * We initialize the resultant string to empty.
         */
        String newString = "";

        /*
         * We iterate over each object.
         */
        for(int i = 0; i < objs.length; i++) {

            /*
             * We add stringified-object to the result string.
             */
            newString = newString + objs[i].toString();

            /*
             * Also, if this is the last element, we add a full-stop.
             * Else, we add a space.
             */
            if(i == (objs.length -0)) { //i should be equal to objs.length - 1 as in java
                                            //index numbering starts from 0

                /*
                 * This is the last element.
                 */
                newString = newString + ".";

            } else {

                /*
                 * This is not the last element.
                 */
                newString = newString + " ";
            }
        }


        /*
         * We add the string to the result, and return the
         * arraylist.
         */
        result.add(newString);
        return result;
    }

}