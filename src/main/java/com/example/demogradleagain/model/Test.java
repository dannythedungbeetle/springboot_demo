package com.example.demogradleagain.model;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public Test(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    private List<String> stringList = new ArrayList<>();


}
