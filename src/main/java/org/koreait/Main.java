package org.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 실행 ==");

        int lastId = 0;
        List<Article> articles = new ArrayList<>();

        while(true){
            System.out.print("명령어 ) ");
            String cmd = sc.nextLine().trim();

            if(cmd.length() == 0){
                System.out.println("등록된 명령어가 없습니다");
                continue;
            }
            if(cmd.equals("exit")){
                break;
            }
            if(cmd.equals("등록")){

                int id =lastId +1;
                System.out.print("명언 : ");
                String word = sc.nextLine();
                System.out.print("작가 : ");
                String writer = sc.nextLine();

                Article article = new Article(id, word, writer);
                articles.add(article);

                System.out.println(id+"번 명언이 등록되었습니다");
                lastId++;

            } else if (cmd.equals("목록")) {

                System.out.println("번호   /   작가   /   명언");
                System.out.println("==============================");

                for(int i = articles.size() - 1; i >= 0; i--){
                    Article article = articles.get(i);
                    System.out.println(article.getId()+"\t"+article.getWord()+"\t"+article.getWriter());
                }

            } else if (cmd.startsWith("상세보기?id=")) {

               int id = Integer.parseInt(cmd.split("=")[1]);

               Article foundarticle = null;

                for(Article article : articles){
                    if(article.getId() == id){
                        foundarticle = article;
                    }

                } if(foundarticle == null){
                    System.out.println(id+"번 명언은 존재하지 않습니다");
                    continue;
                }
                 System.out.printf("번호 : %d\n작가 : %s\n내용\n : %s",foundarticle.getId(),foundarticle.getWriter(),foundarticle.getWord());
                
            }else if (cmd.startsWith("수정?id=")) {

                int id = Integer.parseInt(cmd.split("=")[1]);

                Article foundarticle = null;

                for (Article article : articles) {
                    if (article.getId() == id) {
                        foundarticle = article;
                    }

                }
                if (foundarticle == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다");
                    continue;
                }
                System.out.println("명언(기존) :" + foundarticle.getWord());
                System.out.println("작가(기존) :" + foundarticle.getWriter());
                System.out.print("명언 : ");
                String newWord = sc.nextLine();
                System.out.print("작가 : ");
                String newWriter = sc.nextLine();

                foundarticle.setWord(newWord);
                foundarticle.setWriter(newWriter);
                System.out.println(id + "번 명언이 수정되었습니다");


            }else if (cmd.startsWith("삭제?id=")) {

                int id = Integer.parseInt(cmd.split("=")[1]);

                Article foundarticle = null;

                for (Article article : articles) {
                    if (article.getId() == id) {
                        foundarticle = article;
                    }

                }
                if (foundarticle == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다");

                } else {
                    articles.remove(foundarticle);
                    System.out.println(id + "번 명언이 삭제되었습니다");
                }
            }

        }
        System.out.println("== 명언 앱 종료 ==");
        sc.close();

    }
}
