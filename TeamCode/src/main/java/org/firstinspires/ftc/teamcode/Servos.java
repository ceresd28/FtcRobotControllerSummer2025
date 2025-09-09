package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Servos {
    public static Servo create(String name) {
        Servo part = Robot.hwMap.get(Servo.class,name);
        Robot.servos.add(part);
        return part;
    }
    public static void runTo(Servo servo, double targetPos, double maxTimeoutSecs) {
        servo.setPosition(targetPos);
        ElapsedTime timer = new ElapsedTime();
        timer.reset();
        while (
            Robot.opMode.opModeIsActive() &&
            timer.seconds() < maxTimeoutSecs
        ) {
            Robot.opMode.idle();
        }
    }
    public static void runToIncrement(Servo servo, double targetPosToAdd, double maxTimeoutSecs) {
        runTo(servo,servo.getPosition()+targetPosToAdd,maxTimeoutSecs);
    }
    public static void changeRangeOfMotion(Servo servo, boolean forward) {
        Servo.Direction dir;
        if (forward) { dir = Servo.Direction.FORWARD; }
        else { dir = Servo.Direction.REVERSE; }
        servo.setDirection(dir);
    }
    public static void changeRangeOfMotion(Servo servo, double min, double max, boolean forward) {
        servo.scaleRange(min,max);
        changeRangeOfMotion(servo,forward);
    }
}
