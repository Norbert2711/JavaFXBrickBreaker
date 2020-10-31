package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TextLabel extends Label {

    public TextLabel(String text) {

        setWidth(280);
        setPrefHeight(200);
        setAlignment(Pos.BOTTOM_LEFT);
        setWrapText(true);
        setText(text);
        setTextFont();

    }

    private void setTextFont() {
        String FONT_PATH = "/sample/resources/kenvector_future.ttf";
        setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 23));

    }

}
