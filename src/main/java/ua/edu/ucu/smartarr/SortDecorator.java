package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.comparator = cmp;
        sort();
    }

    private void sort() {
        Object[] newArr = new Object[size()];
        System.arraycopy(toArray(), 0, newArr, 0, size());
        Arrays.sort( newArr, comparator);
        smartArray = new BaseArray(newArr);
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sorts elements using MyComparator to compare them";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
