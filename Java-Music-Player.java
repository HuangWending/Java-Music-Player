import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MusicPlayer extends Application {

    private MediaPlayer mediaPlayer; // 媒体播放器
    private Slider speedSlider; // 播放倍数滑块

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 创建垂直布局容器
        VBox root = new VBox();

        // 创建选择文件按钮
        Button chooseFileButton = new Button("选择文件");
        chooseFileButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                playMusic(file);
            }
        });

        // 创建播放倍数滑块
        speedSlider = new Slider(0.5, 2, 1); // 初始值为1，范围为0.5到2
        speedSlider.setMajorTickUnit(0.25); // 主要刻度单位为0.25
        speedSlider.setMinorTickCount(0); // 无次要刻度
        speedSlider.setSnapToTicks(true); // 滑块对齐到刻度线

        // 创建播放按钮
        Button playButton = new Button("播放");
        playButton.setOnAction(event -> {
            if (mediaPlayer != null) {
                mediaPlayer.setRate(speedSlider.getValue()); // 设置播放速度
                mediaPlayer.play(); // 播放音乐
            }
        });

        // 将按钮和滑块添加到布局容器中
        root.getChildren().addAll(chooseFileButton, speedSlider, playButton);

        // 创建场景并设置到舞台
        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("黄文定音乐播放器");
        primaryStage.show();
    }

    // 播放音乐方法
    private void playMusic(File file) {
        Media media = new Media(file.toURI().toString()); // 创建媒体对象
        if (mediaPlayer != null) {
            mediaPlayer.stop(); // 停止当前正在播放的音乐
        }
        mediaPlayer = new MediaPlayer(media); // 创建媒体播放器对象
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.stop()); // 当音乐播放完毕时停止播放
    }
}
