package com.trello.qa.model;

public class BoardData {
    private String boardName;


    public BoardData withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }

    @Override
    public String toString() {
        return "BoardData{" +
                "boardName='" + boardName + '\'' +
                '}';
    }
}
