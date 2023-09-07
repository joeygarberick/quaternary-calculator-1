import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class GUI extends Application{
    Button zeroBtn = new Button("0");
    Button oneBtn = new Button("1");
    Button twoBtn = new Button("2");
    Button threeBtn = new Button("3");
    Text displayArea = new Text("");
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(25);
        createDisplayArea(grid);
        createDigitalButtons(grid);
        createOperationButtons(grid);
        createBorder(grid);
        Scene scene = new Scene(grid,500, 500);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void createDisplayArea(GridPane grid) {
        Rectangle border = new Rectangle(420, 100);
        border.setFill(Color.WHITE);
        border.setStroke(Color.BLACK);
        border.setStrokeWidth(2);


        displayArea.setFont(Font.font(20));
        GridPane.setColumnSpan(displayArea, 3);
        GridPane.setColumnSpan(border,3);
        grid.add(displayArea,2,0);
        grid.add(border,2,0);

    }

    private void createBorder(GridPane grid){
        Rectangle border = new Rectangle(480, 530);
        border.setFill(null);
        border.setStroke(Color.BLACK); // Border color
        border.setStrokeWidth(2); // Border width
        GridPane.setColumnSpan(border,4);
        GridPane.setRowSpan(border,6);
        grid.add(border,1,0);
    }

    private void setButtonsSize(int width, int height,Button ...buttons){
        for (Button button:buttons) {
            button.setPrefSize(width,height);
        }
    }

    private void setButtonsStyle(String fontFamily, FontWeight fontWeight, Color backgroundColor, int fontSize, Button ...buttons){
        for (Button button:buttons) {
            button.setFont(Font.font(fontFamily,fontWeight,fontSize));
            button.setBackground(Background.fill(backgroundColor));
            button.setBorder(new Border(
                    new javafx.scene.layout.BorderStroke(
                            Color.BLACK,
                            BorderStrokeStyle.SOLID,
                            new CornerRadii(5),
                            new BorderWidths(2)
                    )
            ));
        }
    }
    private void createDigitalButtons(GridPane grid){
        setButtonsSize(150,150,zeroBtn,oneBtn,twoBtn,threeBtn);
        setButtonsStyle("Verdana",FontWeight.BOLD,Color.DARKGRAY,24,zeroBtn,oneBtn,twoBtn,threeBtn);
        GridPane.setRowSpan(zeroBtn, 2);
        GridPane.setRowSpan(oneBtn,2);
        grid.add(zeroBtn,2,2);
        grid.add(oneBtn,3,2);
        grid.add(twoBtn,2,1);
        grid.add(threeBtn,3,1);
    }
    private void createOperationButtons(GridPane grid){
        Button addBtn = new Button("+");
        Button subBtn = new Button("-");
        Button mulBtn = new Button("x");
        Button divBtn = new Button("/");
        Button eqBtn = new Button("=");
        Button clearBtn = new Button("CLEAR");
        Button powBtn = new Button("x²");
        Button sqrtBtn = new Button("√");
        setButtonsStyle("Verdana",FontWeight.BOLD,Color.DARKGRAY,20,addBtn,subBtn,mulBtn,divBtn,eqBtn);
        setButtonsStyle("Verdana",FontWeight.BOLD,Color.DARKGRAY,10,powBtn,sqrtBtn);
        setButtonsStyle("Verdana",FontWeight.BOLD,Color.rgb(255,170,170),20,clearBtn);
        setButtonsSize(70,70,addBtn,subBtn,mulBtn,divBtn);
        setButtonsSize(30,70,powBtn,sqrtBtn);
        setButtonsSize(150,70,eqBtn,clearBtn);

        GridPane.setValignment(addBtn, VPos.TOP);
        GridPane.setValignment(subBtn, VPos.BOTTOM);
        GridPane.setValignment(divBtn, VPos.TOP);
        GridPane.setValignment(eqBtn, VPos.BOTTOM);
        GridPane.setHalignment(powBtn, HPos.LEFT);
        GridPane.setHalignment(sqrtBtn, HPos.RIGHT);


        grid.add(addBtn,4,1);
        grid.add(subBtn,4,1);
        grid.add(mulBtn,4,2);
        grid.add(divBtn,4,3);
        grid.add(powBtn,4,4);
        grid.add(sqrtBtn,4,4);
        grid.add(eqBtn,3,4);
        grid.add(clearBtn,2,4);

    }

}
