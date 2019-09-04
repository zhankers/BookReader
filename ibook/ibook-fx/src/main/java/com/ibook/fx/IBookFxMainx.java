package com.ibook.fx;

import com.ibook.fx.fxmlview.Index2FxmlView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IBookFxMainx extends AbstractJavaFxApplicationSupport {
    public static void main(String[] args) {
        launch(IBookFxMainx.class, Index2FxmlView.class, args);
 
    }
}