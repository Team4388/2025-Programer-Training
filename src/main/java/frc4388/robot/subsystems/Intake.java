package frc4388.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc4388.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase{
    private TalonFX pivotMotor;
    private TalonFX intakeMotor;

    public Intake(TalonFX pivotTalonFX, TalonFX intakeTalonFX){
        pivotMotor = pivotTalonFX;
        intakeMotor = intakeTalonFX;

        pivotMotor.setNeutralMode(NeutralModeValue.Brake);
        intakeMotor.setNeutralMode(NeutralModeValue.Brake);

        var PIDConfigs = new Slot0Configs();
        PIDConfigs.kP = 1;
        PIDConfigs.kI = 0;
        PIDConfigs.kD = 0.25;
        pivotMotor.getConfigurator().apply(PIDConfigs);

    }

    public void PIDPosition(double position) {
        var request = new PositionVoltage(position);
        pivotMotor.setControl(request);
    }

    public void PIDIn() {
        PIDPosition(IntakeConstants.IN_POSITION);
    }

    public void PIDOut() {
        PIDPosition(IntakeConstants.OUT_POSITION);
    }

    public void handoff(){
        intakeMotor.set(IntakeConstants.OUTTAKE_SPEED);
    }

    public void spinIntakeMotor(){
        intakeMotor.set(IntakeConstants.INTAKE_SPEED);
    }
    public void stopIntakeMotor(){
        intakeMotor.set(0);
    }
    public void stopArmMotor(){
        pivotMotor.set(0);
    }

}
