package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Wheels {
    public static DcMotorEx topLeft;
    public static DcMotorEx topRight;
    public static DcMotorEx bottomLeft;
    public static DcMotorEx bottomRight;
    private static double angle, dist;
    public static void create(String tL, String tR, String bL, String bR, boolean rollable) {
        topLeft = Motors.create(tL,rollable);
        topRight = Motors.create(tR,rollable);
        bottomLeft = Motors.create(bL,rollable);
        bottomRight = Motors.create(bR,rollable);
    }
    public static void calculateAngles(double x, double y) {
        dist = Math.sqrt(x*x+y*y);
        angle = (dist > 0) ? Math.atan2(x, y) : 0;
        // perhaps switch to field-centric controls?
    }
    public static void calculate(double x, double y, double r) {


        /*
        backSlashAngle = AngleUnit.normalizeRadians(angle - Math.PI / 4);
        frontSlashAngle = AngleUnit.normalizeRadians(angle - 3 * Math.PI / 4);
        backSlashAngle = (Math.abs(backSlashAngle)/-Math.PI+0.5)*2;
        frontSlashAngle = (Math.abs(frontSlashAngle)/-Math.PI+0.5)*2;
        */


        // be able to get auton from teleop??? roadrunner??????
        // maybeee channge runtopos to runwithencoder till reach target pos?
    }
    public static void move(double tL, double tR, double bL, double bR) {
        Motors.runControlled(topLeft,tL);
        Motors.runControlled(topRight,tR);
        Motors.runControlled(bottomLeft,bL);
        Motors.runControlled(bottomRight,bR);
    }
}
