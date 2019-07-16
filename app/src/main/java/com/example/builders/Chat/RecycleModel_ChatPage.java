package com.example.builders.Chat;


public class RecycleModel_ChatPage {

    //채팅 화면의 아이템 정보를 담을 양식 클래스

    //정보를 저장할 변수 선언
    private String name, to, msg, time, date, profile, toprofile;
    //private int profilenum;


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getToprofile() {
        return toprofile;
    }

    public void setToprofile(String toprofile) {
        this.toprofile = toprofile;
    }

    public RecycleModel_ChatPage(String name, String to, String msg, String time, String date, String profile, String toprofile){ //클래스 양식 지정
        this.name=name;
        this.to=to;
        this.msg=msg;
        this.time=time;
        this.date=date;
        this.profile = profile;
        this.toprofile = toprofile;
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
