    /*
     *This is a B(or better) grade solution
     */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Reverser implements Stringifier {

    @Override
    public ArrayList<String> stringify(Object[] objs) {

        /*
         * This is our final resultant arraylist, which will be returned.
         */
        ArrayList<String> result = new ArrayList<String>();


        /*
         * We get the result from concatenator for normal order, and strip the full-stop.
         */
        Concatenator concat = new Concatenator();

        String origConcatResNormal = concat.stringify(objs).get(0);
        String strippedConcatResNormal = origConcatResNormal.substring(0, origConcatResNormal.length() -1);


        /*
         * We reverse the input object-array.
         */
        Collections.reverse(Arrays.asList(objs));

        /*
         * We now get the result from concatenator for reversed order of object-array,
         * and strip the full-stop.
         */
        String origConcatResReversed = concat.stringify(objs).get(0);
        String strippedConcatResReversed = origConcatResReversed.substring(0, origConcatResReversed.length() -1);


        /*
         * We compare the two stripped results,
         * and add the stringified-form to the result.
         */
        boolean doNormalAndReversedResultsMatch = strippedConcatResNormal.equals(strippedConcatResReversed);

        result.add(Boolean.toString(doNormalAndReversedResultsMatch));
        return result;
    }

}