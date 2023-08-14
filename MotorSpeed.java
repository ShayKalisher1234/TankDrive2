// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Driver;

public class MotorSpeed extends CommandBase {
  private DoubleSupplier speed, rotation;
  private Driver  arcadeDrive; 

  

  /** Creates a new MotorSpeed. */
  public MotorSpeed(Driver arcadeDrive , DoubleSupplier speed , DoubleSupplier rotation) {
    this.arcadeDrive = arcadeDrive;
    this.speed = speed;
    this.rotation = rotation;
    addRequirements(arcadeDrive);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arcadeDrive.motorspeed(speed , rotation );
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arcadeDrive.motorspeed(()-> 0,()->0 );
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
