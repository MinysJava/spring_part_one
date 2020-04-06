package Lesson_1;

public class CameraImpl implements Camera{
    private CameraRoll cameraRoll;

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void doPhotograph() {
        System.out.println("Щелк!");
        cameraRoll.processing();
    }

}
