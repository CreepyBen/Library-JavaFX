package library;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LibraryGUI extends Application{
    private Library library = new library.Library();
    private TextArea bookListArea = new TextArea();

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Library");

        // Input fields
        TextField titleInput = new TextField();
        titleInput.setPromptText("Book Title");
        TextField authorInput = new TextField();
        authorInput.setPromptText("Book Author");

        // Buttons
        Button addBookBtn = new Button("Add Book");
        Button viewBooksBtn = new Button("View All Books");
        Button clearListBtn = new Button("Clear List");

        // Layout
        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20; -fx-background-color: gray;");
        layout.getChildren().addAll(
                new Label("Library System"),
                new Label("Add a Book: "),
                titleInput,
                authorInput,
                addBookBtn,
                viewBooksBtn,
                clearListBtn,
                new Label("Books in Library: "),
                bookListArea
        );

        bookListArea.setEditable(false);

        // Button Actions
        addBookBtn.setOnAction(e -> {
            String title = titleInput.getText().trim();
            String author = authorInput.getText().trim();

            if(!title.isEmpty() && !author.isEmpty()){
                Book book = new Book(title, author);
                library.addBook(book);
                titleInput.clear();
                authorInput.clear();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book Added");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter both title and author.");
                alert.showAndWait();
            }
        });

        viewBooksBtn.setOnAction(e -> {
            bookListArea.clear(); // Clear before displaying
            if(library.getBooks().isEmpty()){
                bookListArea.setText("No books in library");
            } else {
                for(Book book : library.getBooks()){
                    bookListArea.appendText("- " + book.getTitle()+ " by " + book.getAuthor()+ "\n");
                }
            }
        });
        clearListBtn.setOnAction(e -> {
            bookListArea.clear();
        });

        Scene scene = new Scene(layout, 400,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
