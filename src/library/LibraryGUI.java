package library;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LibraryGUI extends Application {

    private Library library = new Library();

    @Override
    public void start(Stage primaryStage) {

        // Layout
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.TOP_CENTER);

        // Labels and text fields
        Label titleLabel = new Label("Book Title:");
        titleLabel.getStyleClass().add("label-title");
        TextField titleInput = new TextField();

        Label authorLabel = new Label("Author:");
        authorLabel.getStyleClass().add("label-author");
        TextField authorInput = new TextField();

        // Buttons
        Button addBookBtn = new Button("Add Book");
        Button viewBooksBtn = new Button("View All Books");
        Button clearListBtn = new Button("Clear List");

        HBox buttonBar = new HBox(20);
        buttonBar.setAlignment(Pos.CENTER);
        buttonBar.getChildren().addAll(addBookBtn, viewBooksBtn, clearListBtn);

        // Display area for books
        TextArea booksDisplay = new TextArea();
        booksDisplay.setEditable(false);

        // Add children to layout
        layout.getChildren().addAll(titleLabel, titleInput, authorLabel, authorInput, buttonBar, booksDisplay);

        // Button actions
        addBookBtn.setOnAction(e -> {
            String title = titleInput.getText();
            String author = authorInput.getText();
            if (!title.isEmpty() && !author.isEmpty()) {
                Book newBook = new Book(title, author);
                library.addBook(newBook);
                titleInput.clear();
                authorInput.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill in both title and author.");
                alert.showAndWait();
            }
        });

        viewBooksBtn.setOnAction(e -> {
            booksDisplay.clear();
            if (library.getBooks().isEmpty()) {
                booksDisplay.appendText("No books in the library.\n");
            } else {
                for (Book b : library.getBooks()) {
                    booksDisplay.appendText(b.getTitle() + " by " + b.getAuthor() + "\n");
                }
            }
        });

        clearListBtn.setOnAction(e -> booksDisplay.clear());

        // Scene
        Scene scene = new Scene(layout, 500, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
