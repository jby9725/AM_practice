package org.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        Scanner scanner = Container.getScanner();
        int sys_status = 0;
        String cmd = "";

        int lastMemberID = 0;
        int lastArticleID = 0;

        boolean isLogined = false;

        List<Member> members = new ArrayList<>();
        List<Article> articles = new ArrayList<>();

        Member user = null;

        while (sys_status != -1) {
            System.out.print("명령어 ) ");
            cmd = scanner.nextLine();

            if (cmd.equals("exit")) {
                sys_status = -1;
                continue;
            }

            String[] cmd_bits = cmd.split(" ");

            if (cmd_bits.length < 2) {
                System.out.println("올바른 명령어가 아님");
                continue;
            }

            String startWith = cmd_bits[0];
            String methodName = cmd_bits[1];
            String option = null;
            if (cmd_bits.length == 3) {
                option = cmd_bits[2];
            }

            if (startWith.equals("article")) {
                if (methodName.equals("write")) {
                    System.out.println("article write");

                    if (isLogined) {
                        System.out.print("제목 : ");
                        String title = scanner.nextLine();
                        System.out.print("내용 : ");
                        String body = scanner.nextLine();


                        String formatedTime = Util.getNowTime();

                        Article article = new Article(++lastArticleID, title, body, user, formatedTime, formatedTime);
                        articles.add(article);

                    } else {
                        System.out.println("로그인 필요");
                    }

                } else if (methodName.equals("list")) {
                    System.out.println("article list");
                    if (option != null) { // 옵션 입력됨
                        System.out.println("Option : " + option);
                        List<Article> optionedArticles = new ArrayList<>();
                        for (Article article : articles) {
                            if (article.getId() == Integer.parseInt(option)) {
                                optionedArticles.add(article);
                            }
                        }
                        for (Article article : optionedArticles) {
                            System.out.println(article.toString());
                        }
                    } else {
                        System.out.println("Full article list");
                        for (Article article : articles) {
                            System.out.println(article.toString());
                        }
                    }
                } else if (methodName.equals("detail")) {
                    System.out.println("article detail");
                    Article foundArticle = null;
                    if (option == null) {
                        System.out.println("option is null");
                        continue;
                    } else {
                        for (Article article : articles) {

                            if (article.getId() == Integer.parseInt(option)) {
                                foundArticle = article;
                                break;
                            }
                        }
                        if (foundArticle == null) {
                            System.out.println("찾는 게시물이 없습니다.");
                        } else {
                            System.out.print("번호 : " + foundArticle.getId() + "\n");
                            System.out.print("제목 : " + foundArticle.getTitle() + "\n");
                            System.out.print("내용 : " + foundArticle.getBody() + "\n");
                            System.out.print("작성자 : " + foundArticle.getAuthor().getNickName() + "\n");
                            System.out.print("작성일 : " + foundArticle.getRegDate() + "\n");
                            System.out.print("수정일 : " + foundArticle.getUpdateDate() + "\n");
//                        foundArticle.toString();
                        }

                    }
                } else if (methodName.equals("edit")) {
                    System.out.println("article edit");
                    if (isLogined) {
                        if (option == null) {
                            System.out.println("올바른 옵션이 아닙니다.");
                        } else {
                            Article foundArticle = null;
                            for (Article article : articles) {
                                if (article.getId() == Integer.parseInt(option)) {
                                    foundArticle = article;
                                    break;
                                }
                            }
                            if (foundArticle == null) {
                                System.out.println("수정할 게시물이 없습니다.");
                            } else {
                                System.out.print("수정 제목 : ");
                                String title = scanner.nextLine();
                                System.out.print("수정 내용 : ");
                                String body = scanner.nextLine();
                                foundArticle.setTitle(title);
                                foundArticle.setBody(body);
                                String formatedTime = Util.getNowTime();
                                foundArticle.setUpdateDate(formatedTime);
                            }
                        }
                    } else {
                        System.out.println("로그인 필요");
                    }

                } else if (methodName.equals("delete")) {
                    System.out.println("article delete");
                    if (!isLogined) {
                        System.out.println("로그인 필요");
                    } else {
                        if (option == null) {
                            System.out.println("올바른 옵션이 아닙니다.");
                        } else {
                            Article foundArticle = null;
                            for (Article article : articles) {
                                if (article.getId() == Integer.parseInt(option)) {
                                    foundArticle = article;
                                    break;
                                }
                            }
                            if (foundArticle == null) {
                                System.out.println("삭제할 게시물이 없습니다.");
                            } else {
                                articles.remove(foundArticle);
                            }
                        }
                    }
                } else {

                    System.out.println("올바른 명령어가 아님");

                }
            } else if (startWith.equals("member")) {
                if (methodName.equals("join")) {
                    System.out.println("member join");

                    if (!isLogined) {

                        System.out.print("아이디 : ");
                        String id = scanner.nextLine();
                        System.out.print("비밀번호 : ");
                        String pwd = scanner.nextLine();
                        System.out.print("닉네임 : ");
                        String nickname = scanner.nextLine();

                        Member member = new Member(++lastMemberID, id, pwd, nickname, "2024-12-12 12:12:12");
                        members.add(member);

                    } else {
                        System.out.println("로그아웃 필요");
                    }

                } else if (methodName.equals("login")) {
                    System.out.println("member login");
                    if (!isLogined) {
                        System.out.print("아이디 : ");
                        String id = scanner.nextLine();
                        System.out.print("비밀번호 : ");
                        String pwd = scanner.nextLine();
                        for (Member member : members) {
                            if (member.getID().equals(id))
                                if (member.getPassWord().equals(pwd)) {
                                    user = member;
                                    isLogined = true;
                                    System.out.println("로그인함");
                                    break;
                                } else
                                    System.out.println("비번오류");
                            System.out.println("아이디/비번오류");
                        }
                    } else {
                        System.out.println("로그아웃 필요");
                    }

                } else if (methodName.equals("logout")) {
                    System.out.println("member logout");

                    if (isLogined) {
                        user = null;
                        isLogined = false;
                    } else {
                        System.out.println("로그인 필요");
                    }

                } else if (methodName.equals("edit")) {
                    System.out.println("member edit");

                    if (isLogined) {

                    } else {
                        System.out.println("로그인 필요");
                    }
                } else if (methodName.equals("delete")) {
                    System.out.println("member delete");
                    if (isLogined) {

                    } else {
                        System.out.println("로그인 필요");
                    }
                } else {
                    System.out.println("올바른 명령어가 아님");
                }
            } else {
                System.out.println("올바른 명령어가 아님");
            }

        }

    }
}
