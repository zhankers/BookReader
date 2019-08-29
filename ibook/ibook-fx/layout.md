**布局面板之 AnchorPane**

AnchorPane 布局面板允许你将控件停靠在窗口的上下左右位置，即使窗口改变了大小，控件也会保持它们停靠的位置不变。同一个控件可以设置多个停靠属性，同一个位置可以停靠多个控件。
public class AnchorPaneExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Anchor Pane Example!");

        AnchorPane anchorPane = new AnchorPane();
        
        Button topBtn = new Button("Top Button");
        Button bottomBtn = new Button("Bottom Button");
        Button leftBtn = new Button("Left Button");
        Button rightBtn = new Button("Right Button");
        
        anchorPane.getChildren().addAll(topBtn,bottomBtn,leftBtn,rightBtn);
        AnchorPane.setBottomAnchor(bottomBtn, 8.0);
        AnchorPane.setRightAnchor(rightBtn, 5.0);
        AnchorPane.setTopAnchor(topBtn, 20.0);
        AnchorPane.setLeftAnchor(leftBtn, 40.0);
        AnchorPane.setBottomAnchor(leftBtn, 40.0);

        primaryStage.setScene(new Scene(anchorPane, 400, 250));
        primaryStage.show();
    }

}

