package com.github.checketts.controller;

import java.util.List;

public class ListWrapper<T> {
    
    List<T> list;
    
    public ListWrapper() {
    }
    
    public ListWrapper(List<T> list) {
        this.list = list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    
    public List<T> getList() {
        return list;
    }

}
