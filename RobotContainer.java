// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.MotorSpeed;
import frc.robot.subsystems.Driver;




/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  // The robot's subsystems and commands are defined here...
private final CommandXboxController driverController= new CommandXboxController(OperatorConstants.kDriverControllerPort);
private Driver arcadeDrive;



  
  public RobotContainer(Driver arcadeDrive ) {
    this.arcadeDrive = arcadeDrive; 
    configureBindings();
  }

  private void configureBindings() {
    arcadeDrive.setDefaultCommand(
        new MotorSpeed(arcadeDrive, () -> driverController.getLeftY(), () -> driverController.getRightX()));
  }
  
  }

