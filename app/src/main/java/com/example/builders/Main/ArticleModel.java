package com.example.builders.Main;

public class ArticleModel {

    //유저 정보를 담을 양식 클래스

    //유저 정보 저장에 필요한 변수 선언
    private String name, title, text, want, team, port;
    int num;

    public ArticleModel(){}

    public ArticleModel(String name, String title, String text, String want, String team, String port, int num){ //클래스 양식 지정
        this.name = name;
        this.title = title;
        this.text = text;
        this.want = want;
        this.team = team;
        this.port = port;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }



}
