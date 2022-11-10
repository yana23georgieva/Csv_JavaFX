package com.example.task17;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CsvApplication.class.getResource("hello-view.fxml"));

        TilePane tilepane = new TilePane();
        tilepane.setTileAlignment(Pos.CENTER);
        tilepane.setHgap(25);
        tilepane.setVgap(20);
        tilepane.setPadding(new Insets(10, 20, 10,20));

        Label label = new Label("Year:");
        TextField fieldYear = new TextField("Enter year");

        tilepane.getChildren().add(label);
        tilepane.getChildren().add(fieldYear);

        Label labelAge = new Label("Age:");
        TextField fieldAge = new TextField("Enter age");

        tilepane.getChildren().add(labelAge);
        tilepane.getChildren().add(fieldAge);

        Label labelName = new Label("Name:");
        TextField fieldName = new TextField("Enter name");

        tilepane.getChildren().add(labelName);
        tilepane.getChildren().add(fieldName);

        Label labelMovie = new Label("Movie:");
        TextField fieldMovie = new TextField("Enter movie");

        tilepane.getChildren().add(labelMovie);
        tilepane.getChildren().add(fieldMovie);

        Button button_save = new Button("Save");
        Button button_csv = new Button("Csv");

        tilepane.getChildren().add(button_save);
        tilepane.getChildren().add(button_csv);

        List<Oscars> movies = new ArrayList<>();

        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                Oscars oscars = new Oscars(Integer.toString(movies.size() + 1), fieldYear.getText(),
                        fieldAge.getText(), fieldName.getText(), fieldMovie.getText());
                movies.add(oscars);

                System.out.println(movies);
            }
        };

        button_save.setOnAction(event);

        // action event
        EventHandler<ActionEvent> eventCsv = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                try(CSVReader reader = new CSVReader(new FileReader("src/main/resources/oscar_age_female.csv"))) {
                    List<String[]> result = reader.readAll();

                    List<Oscars> movies = new ArrayList<>();

                    for (String[] item :
                            result) {
                        String index = item[0];
                        String year = item[1];
                        String age = item[2];
                        String name = item[3];
                        String movie = item[4];
                        Oscars oscars = new Oscars(index, year, age, name, movie);
                        movies.add(oscars);
                    }
                    System.out.println(movies);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (CsvException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };

        button_csv.setOnAction(eventCsv);

        Scene scene = new Scene(tilepane, 200, 480);
        stage.setTitle("CSV!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}