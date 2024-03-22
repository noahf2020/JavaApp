package com.example.javaapp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.io.*;

public class CustomController {
    public Label PFP;
    public Label Standing;
    public Label AOV;
    public Text Welcomeback;

    public Button Uploadpicture;
    public Button LOGOUT;
    public Stage stage;
    public Scene scene;
    public Parent root;

    static User currentUser;

    public void logout(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    ImageView imageView = new ImageView(new Image("your_image_file_path.jpg"));


    public void onActionUpload() {
        FileChooser fileChooser = new FileChooser();

        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            saveImageToFile(imageView.getImage(), selectedFile);
        }
    }

    ;
    private void saveImageToFile(Image image, File file) {
        try {
            OutputStream outputStream = new FileOutputStream(file);
            // Use the appropriate image format when writing to the file
            javafx.scene.image.PixelReader reader = image.getPixelReader();
            java.awt.image.BufferedImage bufferedImage = new java.awt.image.BufferedImage(
                    (int) image.getWidth(),
                    (int) image.getHeight(),
                    java.awt.image.BufferedImage.TYPE_INT_ARGB);

            // Copy the pixels of the Image to the BufferedImage
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    bufferedImage.setRGB(x, y, reader.getArgb(x, y));
                }
            }

            // Write the BufferedImage to the output stream
            ImageIO.write(bufferedImage, "png", outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initialize() throws IOException {
        currentUser = User.allUsers.get(0);


        System.out.println(currentUser);
        String Name = currentUser.getVisitorname();
        Welcomeback.setText("Welcome Back: " + Name);


    }

}
