package com.example.builders.Chat;


public class RecycleModel_Chat {

    //채팅 탭의 아이템 정보를 담을 양식 클래스

    //정보를 저장할 변수 선언
    private String name, text, time;

    public RecycleModel_Chat(String name, String text, String time){ //클래스 양식 지정
        this.name=name;
        this.text=text;
        this.time=time;
    }


    //Getter & Setter

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) { this.text = text; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

