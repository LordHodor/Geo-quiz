package com.example.hodorviii.geoquiz;

/**
 * Created by Hodor VIII on 3/26/2017.
 */

public class Question {

    private  int mAnswered;
    private int mTextResId;
    public int getTextResId() {
        return mTextResId;
    }
    public void setTextResId(int textResId) {

        mTextResId = textResId;
    }


    public boolean isAnswerTrue() {

        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    private boolean mAnswerTrue;


    public Question(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        mAnswered =0;
    }
    public  int isAnswered() {return mAnswered;}

    public void setAnswered(int answered) {
        mAnswered = answered;
    }
}
