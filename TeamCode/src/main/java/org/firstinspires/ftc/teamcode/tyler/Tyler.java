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

@Autonomous(name="Drive Forward", group="Exercises")
//@Disabled
public class Tyler extends LinearOpMode
{
    DcMotor rightBack;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor leftFront;
    DcMotor arm;
    Servo pincher;

    // called when init button is  pressed.

    @Override
    public void runOpMode() throws InterruptedException
    {
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

        telemetry.addData("Mode", "running");
        telemetry.update();

        // set both motors to 25% power.

        rightBack.setPower(0.25);
        rightFront.setPower(0.25);
        leftBack.setPower(0.25);
        leftFront.setPower(0.25);

        sleep(2000);        // wait for 2 seconds.

        // set motor power to zero to stop motors.

        rightBack.setPower(0.0);
        rightFront.setPower(0.0);
        leftBack.setPower(0.0);
        leftFront.setPower(0.0);

        rightBack.setPower(-0.25);
        rightFront.setPower(-0.25);
        leftBack.setPower(-0.25);
        leftFront.setPower(-0.25);

        sleep(2000);        // wait for 2 seconds.

        // set motor power to zero to stop motors.

        rightBack.setPower(0.0);
        rightFront.setPower(0.0);
        leftBack.setPower(0.0);
        leftFront.setPower(0.0);

    }
}