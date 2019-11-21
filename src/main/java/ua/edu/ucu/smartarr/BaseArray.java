package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] arr;
    private int size;

    public BaseArray(Object[] newArr) {
        if (newArr.length == 0) {
            throw new IllegalArgumentException();
        }
        arr = Arrays.copyOf(newArr, newArr.length);
        size = arr.length;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, arr.length);
    }

    @Override
    public String operationDescription() {
        return "Base array for decorators";
    }

    @Override
    public int size() {
        return size;
    }
}
