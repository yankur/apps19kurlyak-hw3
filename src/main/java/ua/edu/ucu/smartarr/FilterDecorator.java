package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyPredicate;
import java.util.Arrays;


// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate pr) {
        super(smartArray);
        this.predicate = pr;
        filter();
    }

    private void filter() {
        Object[] baseArr = toArray();
        Object[] newArr = new Object[size()];
        int index = 0;
        for (int i = 0; i < size(); i++)
        {
            if (predicate.test(baseArr[i])) {
                newArr[index] = baseArr[i];
                index += 1;
            }
        }
        this.smartArray = new BaseArray(Arrays.copyOf(newArr, index));
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Tests every element and removes it if it doesn't satisfy MyPredicate";
    }

    @Override
    public int size() {
        return this.smartArray.size();
    }
}
