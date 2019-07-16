package com.example.builders.Write;

public class LikeModel {


    private String name, key;
    private int num;

    public LikeModel() {
    }

    public LikeModel(String name, int num, String key) { //클래스 양식 지정
        this.name = name;
        this.num = num;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



    //Getter & Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
