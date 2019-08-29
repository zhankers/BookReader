package com.ibook.fx;

import com.ibook.fx.fxmlview.IndexFxmlView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {
    public static void main(String[] args) {
        launch(Main.class, IndexFxmlView.class, args);
 
    }
}