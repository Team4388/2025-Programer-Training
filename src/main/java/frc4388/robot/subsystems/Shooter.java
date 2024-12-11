// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc4388.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc4388.robot.Constants.ShooterConstants;
import frc4388.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  TalonFX leftShooter;
  TalonFX rightShooter;

  public Shooter(TalonFX leftShooter, TalonFX rightShooter) {
    this.leftShooter = leftShooter;
    this.rightShooter = rightShooter;
    leftShooter.setNeutralMode(NeutralModeValue.Coast);
    rightShooter.setNeutralMode(NeutralModeValue.Coast);
  }

  public void spin(double speed) {
    leftShooter.set(-speed);
    rightShooter.set(-speed);
  }

  public void spin() {
    spin(ShooterConstants.SHOOTER_SPEED);
  }

  public void stop() {
    spin(0);
  }

  @Override 
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
