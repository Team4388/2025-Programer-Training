package frc4388.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc4388.robot.Constants.climberConstants;

public class Climber {
    private TalonFX climber;

    public Climber(TalonFX climberTalonFX){
        climber = climberTalonFX;

        climber.setNeutralMode(NeutralModeValue.Brake);
    }

    public void climberDown() {
        climber.set(climberConstants.CLIMBOUTSPEED);
    }

    public void climberUp() {
        climber.set(climberConstants.CLIMBINSPEED);
    }

    public void climberStop() {
        climber.set(0);
    }
}
