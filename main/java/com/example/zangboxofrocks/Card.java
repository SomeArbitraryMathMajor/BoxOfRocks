package com.example.zangboxofrocks;
public class Card {
    private String questions;
    private int answers;
    private String explanation;

    public Card(String question, int i, String s) {
        questions = question;
        answers = i;
        explanation = s;
    }
    public String getQuestions(){
        return questions;
    }
    public int getAnswers(){
        return answers;
    }
    public String getExplanation(){
        return explanation;
    }
    public boolean equals(int a){
        return (a == getAnswers());
    }
    public int compareTo(int a, int b){
        int r = 0;
        if(a > b)
            r = 1;
        else if(a < b)
            r = -1;
        else if(a == b)
            r = 0;
        return r;
    }
}