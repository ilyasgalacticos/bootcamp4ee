package kz.bitlab.javaee.db;

import java.util.ArrayList;

public class Speaker <T> {

    private T myObj;
    private ArrayList<T> list;

    public Speaker(){
        list = new ArrayList<>();
    }

    public Speaker(T myObj){
        this.myObj = myObj;
        list = new ArrayList<>();
    }

    T getObj(){
        return myObj;
    }

    void setMyObj(T myObj){
        this.myObj = myObj;
    }

    void addObj(T myObj){
        list.add(myObj);
    }

    void printAll(){
        for(T t : list){
            System.out.println(t);
        }
    }

}
