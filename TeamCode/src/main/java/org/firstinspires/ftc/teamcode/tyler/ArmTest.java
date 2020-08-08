package org.firstinspires.ftc.teamcode.tyler;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="ArmTest", group="Exercises")

public class ArmTest extends OpMode {
    DcMotor arm;

    @Override
    public void init(){
        arm = hardwareMap.dcMotor.get("arm");
    }

    @Override
    public void loop() {
    telemetry.addData("armposotion", arm.getCurrentPosition());
    telemetry.update();
    }
}
