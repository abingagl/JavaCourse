package com.starter;

import java.util.List;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/28
 */
public class School {

    private List<Klass> klasses;

    public School(List<Klass> myClasses) {
        this.klasses = myClasses;
    }

    @Override
    public String toString() {
        return "klasses:" + klasses.toString();
    }
}

