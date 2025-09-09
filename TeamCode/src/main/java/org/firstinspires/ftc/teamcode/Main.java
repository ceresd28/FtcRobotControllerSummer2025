package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="test",group="")
public class Main extends LinearOpMode {
    @Override
    public void runOpMode() {
        // INIT PRESSED: declare & set up everything
        Servo claw = hardwareMap.get(Servo.class,"claw");
        Servo wrist = hardwareMap.get(Servo.class,"wrist");
        Servo elbow1 = hardwareMap.get(Servo.class,"elbow1");
        Servo elbow2 = hardwareMap.get(Servo.class,"elbow2");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        Servo test = claw;

        waitForStart();
        // START PRESSED & OP MODE BEGINS:
        while (opModeIsActive()) {
            // configure controls
            double add=0;
            if (gamepad1.dpad_up) {
                add=.1;
            } else if (gamepad1.dpad_down) {
                add=-.1;
            }
            claw.scaleRange(0.0,1.0);
            test.setPosition(test.getPosition()+add);

            // send telemetry data
            telemetry.addData("TEST", test.getPosition());
            telemetry.addData("claw", claw.getPosition());
            telemetry.addData("wrist", wrist.getPosition());
            telemetry.addData("elbow1", elbow1.getPosition());
            telemetry.addData("elbow2", elbow2.getPosition());
            telemetry.update();
        }
    }
}
