package com.example.builders.Chat;


public class RecycleModel_ChatPage {

    //채팅 화면의 아이템 정보를 담을 양식 클래스

    //정보를 저장할 변수 선언
    private String name, to, msg, time, date;
    //private int profilenum;


    public RecycleModel_ChatPage(String name, String to, String msg, String time, String date){ //클래스 양식 지정
        this.name=name;
        this.to=to;
        this.msg=msg;
        this.time=time;
        this.date=date;
    }

    //Getter & Setter
    public RecycleModel_ChatPage(){}

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
