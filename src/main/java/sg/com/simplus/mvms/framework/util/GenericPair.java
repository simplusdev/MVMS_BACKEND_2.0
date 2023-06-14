package sg.com.simplus.mvms.framework.util;


import java.io.Serializable;

/**
 *
 * @author SimPlus Pte Ltd
 */
public class GenericPair<T1, T2> implements Serializable {

    private T1 object_first;
    private T2 object_second;

    public GenericPair(T1 object_first, T2 object_second) {
        this.object_first = object_first;
        this.object_second = object_second;
    }

    public T1 getFirstObject() {
        return object_first;
    }

    public T2 getSecondObject() {
        return object_second;
    }

    public void setFirstObject(T1 object_first) {
        this.object_first = object_first;
    }

    public void setSecondObject(T2 object_second) {
        this.object_second = object_second;
    }
}
