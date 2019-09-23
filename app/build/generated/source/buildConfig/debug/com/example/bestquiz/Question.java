package com.example.bestquiz;

public class Question {
    private int questionResId;
    private boolean answer;

    /**
     * This is the question object used to pass quiz questions
     * @param questionResId is the id of said questions
     * @param answer is the value of the correct answer
     */
    public Question(int questionResId, boolean answer) {
        this.questionResId = questionResId;
        this.answer = answer;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public void setQuestionResId(int questionResId) {
        this.questionResId = questionResId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
