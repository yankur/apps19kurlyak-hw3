package ua.edu.ucu.smartarr;

import ua.edu.ucu.Student;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        filter();
    }

    private void filter() {
        Object[] baseArr = Arrays.copyOf(smartArray.toArray(), size());

        int index = 0;
        int count = size();
        for (int i = 0; i < size() -1; i++) {
            if (equals(baseArr[i], baseArr[i+1])) {
                baseArr[i] = null;
                count -= 1;
            }
        }

        Object[] newArr = new Object[count];
        for (int i = 0; i < size(); i++) {
            if (baseArr[i] != null) {
                newArr[index] = baseArr[i];
                index += 1;
            }
        }
        this.smartArray = new BaseArray(Arrays.copyOf(newArr, index));
    }

    private boolean equals(Object o1, Object o2) {
        if (o1 == o2)
            return true;
        if (o2 == null)
            return false;
        if (o1.getClass() != o2.getClass())
            return false;
        return ((Student) o1).getName().equals(((Student) o2).getName());
    }

    @Override
    public Object[] toArray() {
        return smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Removes duplicates from SmartArray";
    }

    @Override
    public int size() {
        return smartArray.size();
    }
}
