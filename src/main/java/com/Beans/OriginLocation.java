package com.Beans;

import java.io.Serializable;

public class OriginLocation implements Serializable {
    private String hometown;
    private int count;

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
