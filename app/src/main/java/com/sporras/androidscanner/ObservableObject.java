package com.sporras.androidscanner;

import java.util.Observable;

/**
 * Created by sporras on 1/8/2018.
 */

public class ObservableObject extends Observable {
    private static ObservableObject instance = new ObservableObject();

    public static ObservableObject getInstance() {
        return instance;
    }

    private ObservableObject() {
    }

    public void updateValue(Object data) {
        synchronized (this) {
            setChanged();
            notifyObservers(data);
        }
    }
}