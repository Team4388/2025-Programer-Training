// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc4388.utility.controller;

import static frc4388.robot.Constants.OIConstants.LEFT_AXIS_DEADBAND;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.XboxController;

/** Add your docs here. */
public class DeadbandedWhateverController extends DeadbandedXboxController {
  public DeadbandedWhateverController(int port) {
        super(port);
    }

    @Override public Translation2d getRight() { return skewToDeadzonedCircle(-getRawAxis(2), getRawAxis(3)); }
}
