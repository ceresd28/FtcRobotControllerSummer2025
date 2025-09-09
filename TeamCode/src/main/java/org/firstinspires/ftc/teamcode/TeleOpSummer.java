package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name="test",group="")
public class TeleOpSummer extends LinearOpMode {
    @Override
    public void runOpMode() {
        // INIT PRESSED: declare & set up everything
        Robot.set(hardwareMap, this);

        Wheels.create("topLeft", "topRight", "bottomLeft", "bottomRight", false);

        // robot.servos.forEach(servo -> { });

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        // START PRESSED & OP MODE BEGINS:
        while (opModeIsActive()) {
            // configure controls

            Wheels.calculate(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);

            // send telemetry data
            telemetry.addData("Status", "Active");
            telemetry.update();
        }
    }
}
