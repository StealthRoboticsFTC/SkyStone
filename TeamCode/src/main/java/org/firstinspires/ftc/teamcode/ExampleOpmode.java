package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ExampleOpmode extends LinearOpMode {
    @Override
    public void runOpMode() {
        waitForStart();

        double clampPos = 0.5;

        Servo clamp = hardwareMap.get(Servo.class, "clamp");

        DcMotor arm = hardwareMap.get(DcMotor.class, "arm");
        arm.setDirection(DcMotorSimple.Direction.REVERSE);

        DcMotor leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        DcMotor leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        DcMotor rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        DcMotor rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        while (opModeIsActive()) {
            double forwardPower = -gamepad1.left_stick_y;
            double straife = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            leftFront.setPower(forwardPower + straife - turn);
            leftBack.setPower(forwardPower-straife - turn);
            rightFront.setPower(forwardPower-straife + turn);
            rightBack.setPower(straife+forwardPower + turn);

            double armPower = (gamepad1.y ? 1 : 0) - (gamepad1.a ? 1 : 0);
            arm.setPower(armPower * 0.6);

            if (gamepad1.dpad_down) clampPos = 0.545;
            if (gamepad1.dpad_up) clampPos = 0.35;

            telemetry.update();
            clamp.setPosition(clampPos);
        }
    }
}