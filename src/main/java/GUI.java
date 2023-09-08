import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
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

    Button addBtn = new Button("+");
    Button subBtn = new Button("-");
    Button mulBtn = new Button("x");
    Button divBtn = new Button("/");
    Button eqBtn = new Button("=");
    Button clearBtn = new Button("CLEAR");
    Button powBtn = new Button("x²");
    Button sqrtBtn = new Button("√");
    Button toggleBtn = new Button("Toggle");
    boolean toggle = false;
    memory mem = new memory(-1,-1,"");
    operations opp = new operations();
    conversion conv = new conversion();
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

        addEventListener(zeroBtn,oneBtn,twoBtn,threeBtn,addBtn,subBtn,mulBtn,divBtn,powBtn,sqrtBtn,clearBtn,eqBtn,toggleBtn);


        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addEventListener(Button... buttons) {
        for (Button button : buttons) {
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleButtonClick(button.getText()));
        }
    }
    private void handleButtonClick(String buttonText) {
        if (mem.getOperation().isEmpty() && opp.isNumeric(buttonText)) {
            appendToDisplay(buttonText);
        } else if (!mem.getOperation().isEmpty() && opp.isNumeric(buttonText)) {
            appendToDisplay(buttonText);
            mem.setMemory(mem.getFirst(), Integer.parseInt(displayArea.getText()), mem.getOperation());
        } else if (isOperator(buttonText)) {
            handleOperatorButtonClick(buttonText);
        } else if (isSpecialOperator(buttonText)&&!displayArea.getText().isEmpty()) {
            handleSpecialOperation(buttonText);
        } else if (buttonText.equals("=")) {
            handleEqualsButtonClick();
        } else if (buttonText.equals("CLEAR")) {
            clearMemoryAndDisplay();
        }else if(buttonText.equals("Toggle")){
            handleToggleButtonClick(toggle = !toggle);
        }
    }

    private void appendToDisplay(String text) {
        displayArea.setText(displayArea.getText() + text);
    }

    private boolean isOperator(String text) {
        return text.equals("+") || text.equals("-") || text.equals("x") || text.equals("/");
    }

    private void handleOperatorButtonClick(String operator) {
        mem.setMemory(Integer.parseInt(displayArea.getText()), -1, operator);
        displayArea.setText("");
    }

    private  void handleToggleButtonClick(boolean mode) {
        if(mode){
            try{
                int parsedDisplayArea = Integer.parseInt(displayArea.getText());
                int decimal = conv.convert4To10(parsedDisplayArea);
                displayArea.setText(String.valueOf(decimal));
            }catch (inputBoundException e){
                throw new RuntimeException(e);
            }
        }else{
            try{
                int parsedDisplayArea = Integer.parseInt(displayArea.getText());
                int quant = conv.convert10To4(parsedDisplayArea);
                displayArea.setText(String.valueOf(quant));
            }catch (inputBoundException e){
                throw new RuntimeException(e);
            }
        }

    }

    private boolean isSpecialOperator(String text) {
        return text.equals("x²") || text.equals("√");
    }

    private void handleSpecialOperation(String function) {
        try {
            int result = opp.operate(function, Integer.parseInt(displayArea.getText()), 0);
            displayArea.setText(String.valueOf(result));
        } catch (inputBoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void handleEqualsButtonClick() {
        try {
            int first = mem.getFirst();
            int second = mem.getSecond();
            int result = opp.operate(mem.getOperation(), first, second);
            displayArea.setText(String.valueOf(result));
        } catch (inputBoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearMemoryAndDisplay() {
        mem.clearMemory();
        displayArea.setText("");
    }

    private void createDisplayArea(GridPane grid) {
        Rectangle border = new Rectangle(420, 100);
        border.setFill(null);
        border.setStroke(Color.BLACK);
        border.setStrokeWidth(2);

        displayArea.setFont(Font.font(25));
        GridPane.setColumnSpan(displayArea, 3);
        GridPane.setColumnSpan(border,3);
        GridPane.setValignment(toggleBtn, VPos.BOTTOM);
        GridPane.setHalignment(toggleBtn, HPos.RIGHT);

        grid.add(displayArea,2,0);
        grid.add(toggleBtn,4,0);
        grid.add(border,2,0);

    }


    private void createBorder(GridPane grid){
        Rectangle border = new Rectangle(480, 530);
        border.setFill(null);
        border.setStroke(Color.BLACK);
        border.setStrokeWidth(2);
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
