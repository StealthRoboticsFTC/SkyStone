// simple autonomous program that drives bot forward 2 seconds then ends.

package org.firstinspires.ftc.teamcode.tyler;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

// below is the Annotation that registers this OpMode with the FtcRobotController app.
// @Autonomous classifies the OpMode as autonomous, name is the OpMode title and the
// optional group places the OpMode into the Exercises group.
// uncomment the @Disable annotation to remove the OpMode from the OpMode list.

@Autonomous(name="Stone", group="Exercises")
//@Disabled
public class Stone extends LinearOpMode {
    DcMotor rightBack;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor leftFront;
    DcMotor arm;
    Servo pincher;

    // called when init button is  pressed.

    @Override
    public void runOpMode() throws InterruptedException {
        rightBack = hardwareMap.dcMotor.get("rightBack");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        leftBack = hardwareMap.dcMotor.get("leftBack");
        leftFront = hardwareMap.dcMotor.get("leftFront");
        arm = hardwareMap.dcMotor.get("arm");
        pincher = hardwareMap.servo.get("clamp");

        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        pincher.setPosition(0.35);
        telemetry.addData("Mode", "running");
        telemetry.update();

        // set both motors to 25% power.

//        rightBack.setPower(0.25);
//        rightFront.setPower(0.25);
//        leftBack.setPower(0.25);
//        leftFront.setPower(0.25);
//
//        sleep(2000);        // wait for 2 seconds.

        arm.setTargetPosition(1263);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setPower(0.5);
        while (arm.isBusy()){
            idle();
        }
        pincher.setPosition(0.545);

        sleep(500);

        arm.setTargetPosition(0);
        while (arm.isBusy()){
            idle();
        }
        arm.setPower(0);

        // set both motors to 25% power.

        rightBack.setPower(0.25);
        rightFront.setPower(0.25);
        leftBack.setPower(0.25);
        leftFront.setPower(0.25);

        sleep(2000);

        // set both motors to 25% power.

        rightBack.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        leftFront.setPower(0);

        arm.setTargetPosition(1044);
        arm.setPower(.5);
        while (arm.isBusy()) {
            idle();
        }
        pincher.setPosition(0.35);

        sleep(500);

        arm.setTargetPosition(0);
        while (arm.isBusy()){
            idle();
        }
        arm.setPower(0);

    }
}