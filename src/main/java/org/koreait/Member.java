package org.koreait;

public class Member {
    int number;
    String ID;
    String passWord;
    String nickName;
    String regDate;

    public Member(int number, String ID, String passWord, String nickName, String regDate) {
        this.number = number;
        this.ID = ID;
        this.passWord = passWord;
        this.nickName = nickName;
        this.regDate = regDate;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
