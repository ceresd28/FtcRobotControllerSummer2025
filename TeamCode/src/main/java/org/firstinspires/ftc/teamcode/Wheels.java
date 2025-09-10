package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

import java.util.ArrayList;

public class Wheels {
    public static DcMotorEx topLeft;
    public static DcMotorEx topRight;
    public static DcMotorEx bottomLeft;
    public static DcMotorEx bottomRight;
    public static ArrayList<DcMotorEx> wheels = new ArrayList<>();
    private static double angle, dist;
    public static void create(String tL, String tR, String bL, String bR, boolean rollable) {
        topLeft = Motors.create(tL,rollable);
        topRight = Motors.create(tR,rollable);
        bottomLeft = Motors.create(bL,rollable);
        bottomRight = Motors.create(bR,rollable);
        Robot.wheels.add(topLeft);
        Robot.wheels.add(topRight);
        Robot.wheels.add(bottomLeft);
        Robot.wheels.add(bottomRight);
    }
    public static void move(double x, double y, double r) {
        Motors.runControlled(topLeft,y+x+r);
        Motors.runControlled(topRight,y-x-r);
        Motors.runControlled(bottomLeft,y-x+r);
        Motors.runControlled(bottomRight,y+x-r);
    }
    public static void TeleOpDrive() {
        double x = Robot.opMode.gamepad1.left_stick_x;
        double y = -Robot.opMode.gamepad1.left_stick_y;
        double r = Robot.opMode.gamepad1.right_stick_x;
        if (!Robot.opMode.gamepad1.left_stick_button) {
            x*=.9;
            y*=.9;
        }
        if (!Robot.opMode.gamepad1.right_stick_button) {
            r*=.9;
        }
        move(x,y,r);
    }
}
