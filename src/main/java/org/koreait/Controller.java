package org.koreait;

import java.util.ArrayList;
import java.util.List;

public abstract class Controller {

    protected List<Article> articleList;
    protected List<Member> memberList;

    public Controller() {
        articleList = new ArrayList<>();
        memberList = new ArrayList<>();
    }

    public void addTeseDate() {
//        System.out.println("== test data add..... ==");
//        System.out.println("== test data add done ==");
    }

    public abstract void doAction(String methodName, String option);
}
