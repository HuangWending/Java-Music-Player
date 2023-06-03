# Java-Music-Player
Java音乐播放器
import语句引入所需的JavaFX类和其他相关类。

MusicPlayer类继承自Application类，是JavaFX应用程序的入口点。

private MediaPlayer mediaPlayer;声明了一个私有成员变量mediaPlayer，用于控制音乐的播放。

private Slider speedSlider;声明了一个私有成员变量speedSlider，用于调整播放速度的滑块。

public static void main(String[] args)是Java应用程序的入口方法，通过调用launch方法启动JavaFX应用程序。

start方法是JavaFX应用程序的入口方法，在其中创建窗口界面和处理用户操作。

VBox root = new VBox();创建一个垂直布局容器。

Button chooseFileButton = new Button("选择文件");创建一个名为"选择文件"的按钮。

chooseFileButton.setOnAction(event -> { ... });为"选择文件"按钮设置点击事件处理程序。

FileChooser fileChooser = new FileChooser();创建一个文件选择器。

File file = fileChooser.showOpenDialog(primaryStage);显示文件选择器对话框，并获取用户选择的文件。

playMusic(file);如果用户选择了文件，则调用playMusic方法来播放选中的音乐。

speedSlider = new Slider(0.5, 2, 1);创建一个范围在0.5到2之间、初始值为1的滑块。

speedSlider.setMajorTickUnit(0.25);设置滑块的主要刻度单位为0.25。

speedSlider.setMinorTickCount(0);设置滑块的次要刻度数为0。

speedSlider.setSnapToTicks(true);将滑块对齐到刻度线。

Button playButton = new Button("播放");创建一个名为"播放"的按钮。

playButton.setOnAction(event -> { ... });为"播放"按钮设置点击事件处理程序。

mediaPlayer.setRate(speedSlider.getValue());获取滑块的值，并设置给媒体播放器的播放速度。

mediaPlayer.play();播放音乐。

root.getChildren().addAll(chooseFileButton, speedSlider, playButton);将选择文件按钮、播放倍数滑块和播放按钮添加到布局容器中。

Scene scene = new Scene(root, 300, 150);创建一个场景，将布局容器作为根节点，设置场景的宽度为300，高度为150。

primaryStage.setScene(scene);将场景设置到舞台（窗口）中。

primaryStage.setTitle("音乐播放器");设置舞台的标题为"音乐播放器"。

primaryStage.show();显示舞台（窗口）。

private void playMusic(File file) { ... }是一个方法，用于播放音乐。

Media media = new Media(file.toURI().toString());创建一个媒体对象，使用选中的文件的URI。

mediaPlayer.stop();停止当前正在播放的音乐。

mediaPlayer = new MediaPlayer(media);创建一个新的媒体播放器对象。

mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.stop());当音乐播放完毕时停止播放。
使用JavaFX库提供的控件和功能来实现窗口界面和音乐播放功能。用户可以选择音乐文件，调整播放倍速，然后点击播放按钮开始播放音乐。
