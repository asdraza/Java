    /*
     *This is a B(or better) grade solution
     */

public class Main {


    /*
     * For all the following methods, we simply instantiate a new
     * instance of the required type, and return the reference.
     */
    public Stringifier getConcatenate() {
        return new Concatenator();
    }

    public Stringifier getTranslator() {
        return new Translator();
    }

    public Stringifier getSumUp() {
        return new SumUp();
    }

    public Stringifier getReverser() {
        return new Reverser();
    }

}