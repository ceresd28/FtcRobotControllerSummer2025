package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="test",group="")
public class Main extends LinearOpMode {
    @Override
    public void runOpMode() {
        // INIT PRESSED: declare & set up everything
        Robot.set(hardwareMap,this);
        Servo claw = Servos.create("claw");
        Servo wrist = Servos.create("wrist");
        Servo elbow1 = Servos.create("elbow1");
        Servo elbow2 = Servos.create("elbow2");

        Wheels.create("topLeft","topRight","bottomLeft","bottomRight",true);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        Servo test = claw;
        Servos.runTo(test,.5,1);
        waitForStart();
        // START PRESSED & OP MODE BEGINS:
        while (opModeIsActive()) {
            // configure controls
            Wheels.TeleOpDrive();
            if (gamepad1.dpad_up) {
                Servos.runToIncrement(test,.1,2);
            } else if (gamepad1.dpad_down) {
                Servos.runToIncrement(test,-.1,2);
            }
            Servos.changeRangeOfMotion(test,0.0,1.0,true);



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
