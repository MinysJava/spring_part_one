package Lesson_1;

import org.springframework.stereotype.Component;

//@Component("BWCameraRoll")
public class BlackAndWhiteCameraRoll implements CameraRoll {
    @Override
    public void processing() {
        System.out.println("-1 черно-белый кадр");
    }
}