package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyFunction;
import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.function = func;
        map();
    }

    private void map() {
        Object[] baseArr = smartArray.toArray();
        Object[] newArr = new Object[size()];
        for (int i = 0; i < size(); i++) {
            newArr[i] = function.apply(baseArr[i]);
        }
        this.smartArray = new BaseArray(Arrays.copyOf(newArr, size()));
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Map every element to another object using MyFunction";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}

