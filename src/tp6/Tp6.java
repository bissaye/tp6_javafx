/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6;  


import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author bissaye
 */
public class Tp6 extends Application {
    
    @Override
    public void start(Stage fen) throws Exception{
        
        fen.setTitle("tp6");
        fen.setWidth(600);
        fen.setHeight(600);
        
        StackPane root = new StackPane();
        root.getChildren().add(new Rectangle(600, 600)) ;
        root.getChildren().add(new Label("hello dans 5 s la fenetre va se fermer"));
         
        Scene scene = new Scene(root);
        
        fen.setResizable(false);
        fen.setScene(scene);
        fen.show();
        fen.centerOnScreen();
        
        
        new Thread( new Runnable(){
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                    System.out.println("test test test ");
                    AudioClip audio = new AudioClip(this.getClass().getResource("test.mp3").toExternalForm()) ;
                    audio.play();
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
//                            fen.hide();
//                            Stage fen2 = new Stage();
//                            fen2.setWidth(600);
//                            fen2.setHeight(600);
                            
                            HBox root2 = new HBox();
                            root2.getChildren().add(new Label("seconde fenetre"));
                            root2.setAlignment(Pos.CENTER);
                            
                            fen.setScene(new Scene(root2));
                            fen.setResizable(false);
//                            fen2.show();
//                            fen2.centerOnScreen();
                        }
                        
                    }); 
                    
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
               
            }
            
        }).start();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
