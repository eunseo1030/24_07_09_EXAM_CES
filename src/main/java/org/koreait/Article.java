package org.koreait;

class Article{

    int id;
    String word;
    String writer;

    public Article(int id, String word, String writer) {
        this.id = id;
        this.word = word;
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}