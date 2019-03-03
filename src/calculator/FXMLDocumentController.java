/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class FXMLDocumentController implements Initializable {
    
   
    private BigDecimal left;
    private String selectedOperator;
    private boolean numberInputting;
    
    @FXML
    private TextField textField;
    
    
    public FXMLDocumentController(){
        this.left = BigDecimal.ZERO;
        this.selectedOperator = "";
        this.numberInputting = false;
        
    }
    
    
    @FXML
    public void operateButton(ActionEvent evt){
        Button button = (Button)evt.getSource();
        String buttonText = button.getText();
        
        if(buttonText.equals("C")){
            if(buttonText.equals("C")){
                left = BigDecimal.ZERO;
            }
            
            selectedOperator = "";
            numberInputting = true;
            textField.clear();
            return;
        }
        
        if(buttonText.matches("[0-9\\.]")){
           if(!numberInputting){
               numberInputting = true;
               textField.clear();
               
           }
           textField.appendText(buttonText);
           return;
        }
        
        if(buttonText.matches("\\+")||buttonText.matches("-")||buttonText.matches("\\*")||buttonText.matches("\\/")){
            
            left = new BigDecimal(textField.getText());
            selectedOperator = buttonText;
            numberInputting = false;
            
            return;
        } 
        
        
        
        if(buttonText.equals("=")){
            final BigDecimal right = numberInputting ? new BigDecimal(textField.getText()) : left;
            
            left = calculate(selectedOperator, left, right);
            textField.setText(left.toString());
            numberInputting = false;
        }
        
    }   
       public static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right){
           switch(operator){
               case "+":
                   return left.add(right);
                case "-":
                   return left.subtract(right);
                case "*":
                   return left.multiply(right);
                case "/":
                   return left.divide(right);
           }
              
        return right;
       }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
