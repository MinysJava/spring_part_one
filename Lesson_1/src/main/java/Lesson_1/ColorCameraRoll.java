package Lesson_1;

import org.springframework.stereotype.Component;

//@Component("ColorCameraRoll")
public class ColorCameraRoll implements CameraRoll {
    @Override
    public void processing() {
        System.out.println("-1 цветной кадр");
    }
}