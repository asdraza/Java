import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    /**
     This is an implementation of the Bogo Sort
     The time complexity for this is:
     best = Ω(n)
     average = θ((n+1)!)
     worst = O((n+1)!)
     average space complexity = O(1)
     */
    public static <T extends Comparable<T>> void bogoSort(final List<T> list, final Comparator<T> comparator) {
        while (!isSorted(list, comparator)) {
            for (int i=0; i<list.size(); i++) {
                int j = (int) (Math.random() * list.size() - 1);

                T temp = list.get(j);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
    }

    static <T extends Comparable<T>> boolean isSorted(final List<T> list, final Comparator<T> comparator) {
        for (int i=0; i<list.size()-1; i++) {
            final T current = list.get(i);
            final T next = list.get(i + 1);
            if (comparator.compare(current, next) > 0) {return false;}
        }
        return true;
    }

    public static <T extends Comparable<T>> void bogoSort(final T[] array, final Comparator<T> comparator) {
        while (!isSorted(array, comparator)) {
            for (int i=0; i<array.length; i++) {
                int j = (int) (Math.random() * array.length - 1);
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }

    static <T extends Comparable<T>> boolean isSorted(final T[] array, final Comparator<T> comparator) {
        return isSorted(Arrays.asList(array), comparator);
    }
    /**
     This is an implementation of the Bubble Sort
     The time complexity for this is:
     best = Ω(n)
     average = θ(n^2)
     worst = O(n^2)
     */
    public static <T extends Comparable<T>> void bubbleSort(final List<T> list, final Comparator<T> comparator) {
        for (int i=0; i<list.size()-1; i++) {
            for (int j=0; j<list.size()-i-1; j++) {
                if (comparator.compare(list.get(j), list.get(j+1)) >= 1) {
                    T temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(final T[] array, final Comparator<T> comparator) {
        for (int i=0; i<array.length-1; i++) {
            for (int j=0; j<array.length-i-1; j++) {
                if (comparator.compare(array[j], array[j+1]) >= 1) {
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    /**
     This is an implementation of the Selection Sort
     The time complexity for this is:
     best = Ω(n^2)
     average = θ(n^2)
     worst = O(n^2)
     average space complexity = O(1)
     */
    public static <T extends Comparable<T>> void selectionSort(final List<T> list, final Comparator<T> comparator) {
        for (int i=0; i<list.size()-1; i++) {
            int min = i;
            for (int j=i+1; j<list.size(); j++) {
                if (comparator.compare(list.get(min), list.get(j)) >= 1) {min = j;}
            }
            T temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
        }
    }

    public static <T extends Comparable<T>> void selectionSort(final T[] array, final Comparator<T> comparator) {
        for (int i=0; i<array.length-1; i++) {
            int min = i;
            for (int j=i+1; j<array.length; j++) {
                if (comparator.compare(array[min], array[j]) >= 1) {min = j;}
            }
            T temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
    /**
     This is an implementation of the Merge Sort
     The time complexity for this is:
     best = Ω(nlog(n))
     average = θ(nlog(n))
     worst = O(nlog(n))
     average space complexity = O(n)
     */
    private static <T extends Comparable<T>> void mergeList(final List<T> l, final List<T> r, final List<T> list, Comparator<T> comparator){
        int m=0, n=0, k=0;
        while (m < l.size() && n < r.size()) {
            if (comparator.compare(l.get(m), r.get(n)) < 0) {list.set(k++, l.get(m++));}
            else {list.set(k++, r.get(n++));}
        }
        while (m < l.size()) {list.set(k++, l.get(m++));}
        while (n < r.size()) {list.set(k++, r.get(n++));}
    }

    public static <T extends Comparable<T>> void mergeSort(final List<T> list, final Comparator<T> comparator) {
        int s = list.size();
        if (s < 2) {return;}
        int mid = s/2;
        List<T> l = new ArrayList<>(list.subList(0, mid)); //left
        List<T> r = new ArrayList<>(list.subList(mid, s)); //right
        mergeSort(l,comparator);
        mergeSort(r,comparator);
        mergeList(l, r, list, comparator);
    }

    private static <T extends Comparable<T>> void mergeArray(final T[] array, int beg, int mid, int end, final Comparator<T> comparator){
        T[] l = (T[]) new Comparable[mid - beg + 1]; //left
        T[] r = (T[]) new Comparable[end - mid]; //right

        System.arraycopy(array, beg, l, 0, l.length);

        for (int i=0; i<r.length; ++i) {r[i] = array[mid + 1 + i];}

        int m=0, n=0, k=beg;
        while (m < l.length && n < r.length){
            if (comparator.compare(l[m], r[n]) < 0) {array[k++] = l[m++];}
            else {array[k++] = r[n++];}
        }
        while (m<l.length) {array[k++] = r[m++];}
        while (n<r.length){array[k++] = r[n++];}
    }

    private static <T extends Comparable<T>> void mergeSortArray(final T[] array, int beg, int end, final Comparator<T> comparator){
        if (beg < end) {
            int mid = (beg + end)/2;
            mergeSortArray(array, beg, mid, comparator);
            mergeSortArray(array, mid + 1, end, comparator);
            mergeArray(array, beg, mid, end, comparator);
        }
    }

    public static <T extends Comparable<T>> void mergeSort(final T[] array, final Comparator<T> comparator) {
        int n = array.length;
        mergeSortArray(array, 0, n-1, comparator);
    }


    /**
     This is an implementation of the Quick Sort
     The time complexity for this is:
     best = Ω(nlog(n))
     average = θ(nlog(n))
     worst = O(n^2)
     average space complexity --> O(n)

     About Enhancing QuickSort:
     * Worst case time complexity of quick sort is O(n^2). So we can use random pivoting algorithm which will improve the average case time complexity.
     * Worst case scenario will occur when array elements are repeated. We can eliminate this by using a three-way partioning scheme instead of a one way scheme.
     * This will improve the time complexity
     */
    public static <T extends Comparable<T>> void quickSort(final List<T> list, final Comparator<T> comparator) {
        quickSortHelperList(list, 0, list.size()-1, comparator);
    }

    public static <T extends Comparable<T>> int partitionList(final List<T> list, int low, int high, final Comparator<T> comparator)
    {
        T pivot = list.get(high);
        T temp;
        int i = (low - 1);

        for (int j=low; j<=high-1; j++) {
            if (comparator.compare(list.get(j), pivot) < 0) {
                i++;
                temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        temp = list.get(i+1);
        list.set(i+1, list.get(high));
        list.set(high, temp);
        return (i + 1);
    }

    public static <T extends Comparable<T>> void quickSortHelperList(final List<T> list, int low, int high, final Comparator<T> comparator)
    {
        if (low < high) {
            int pi = partitionList(list, low, high, comparator);

            quickSortHelperList(list, low, pi - 1, comparator);
            quickSortHelperList(list, pi + 1, high, comparator);
        }
    }

    public static <T extends Comparable<T>> void quickSort(final T[] array, final Comparator<T> comparator) {
        quickSortHelperArray(array, 0, array.length-1, comparator);
    }

    public static <T extends Comparable<T>> int partitionArray(final T[] array, int low, int high, final Comparator<T> comparator)
    {
        T pivot = array[high];
        T temp;

        int i = (low - 1);

        for (int j=low; j<=high-1; j++) {
            if (comparator.compare(array[j], pivot) < 0)
            {
                i++;
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return (i + 1);
    }

    public static <T extends Comparable<T>> void quickSortHelperArray(final T[] array, int low, int high, final Comparator<T> comparator)
    {
        if (low < high) {
            int pi = partitionArray(array, low, high, comparator);

            quickSortHelperArray(array, low, pi - 1, comparator);
            quickSortHelperArray(array, pi + 1, high, comparator);
        }
    }
}
