package com.trello.qa.manager;

public class BoardData {
    private String boardName;


    public BoardData withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }


}
