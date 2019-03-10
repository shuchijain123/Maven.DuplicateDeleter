package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;

    public DuplicateDeleter(T[] array) {
        this.array = array;
    }

    abstract public T[] removeDuplicates(int maxNumberOfDuplications);








    abstract public T[] removeDuplicatesExactly(int exactNumberOfDuplications);


}
