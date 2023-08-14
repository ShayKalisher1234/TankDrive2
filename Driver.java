// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Driver extends SubsystemBase {
  private CANSparkMax LeftFrontMotor;
  private CANSparkMax LeftBackMotor;
  private MotorControllerGroup lefMotorControllerGroup;
  private CANSparkMax RightFrontMotor;
  private CANSparkMax RightBackMotor;
  private MotorControllerGroup rightControllerGroup;
  private DifferentialDrive arcadeDrive;

  /** Creates a new turnMotor. */
  public Driver() {
    LeftBackMotor = new CANSparkMax(18, MotorType.kBrushless);
    LeftBackMotor.setInverted(false);

    LeftFrontMotor = new CANSparkMax(18, MotorType.kBrushless);
    LeftFrontMotor.setInverted(false);

    lefMotorControllerGroup = new MotorControllerGroup(LeftBackMotor, LeftFrontMotor);

    RightBackMotor = new CANSparkMax(18, MotorType.kBrushless);
    RightBackMotor.setInverted(false);

    RightFrontMotor = new CANSparkMax(18, MotorType.kBrushless);
    RightFrontMotor.setInverted(false);

    rightControllerGroup = new MotorControllerGroup(RightBackMotor, RightFrontMotor);
    
    arcadeDrive = new DifferentialDrive(RightFrontMotor, LeftFrontMotor);
    
    RelativeEncoder leftEncoder = LeftFrontMotor.getEncoder();
    RelativeEncoder rightEncoder = RightFrontMotor.getEncoder();
    
  }

  public Driver(Driver leftEncoder , Driver rightEncoder) {
    LeftFrontMotor.restoreFactoryDefaults();
    RightFrontMotor.restoreFactoryDefaults();
    LeftBackMotor.restoreFactoryDefaults();
    RightBackMotor.restoreFactoryDefaults();

    
    ((RelativeEncoder) leftEncoder).setPosition(0);
    ((RelativeEncoder) rightEncoder).setPosition(0);


    LeftBackMotor.follow(LeftFrontMotor);
    RightBackMotor.follow(RightFrontMotor);



  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void motorspeed(DoubleSupplier speed, DoubleSupplier rotation) {
    arcadeDrive.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble()); 
    
  }

  public static void setDefaultCommand(Driver driver) {
  }

    //public void motorspeed(DoubleSupplier leftSpeed) {
    //lefControllerGroup.set(leftSpeed.getAsDouble());
  //}
}
