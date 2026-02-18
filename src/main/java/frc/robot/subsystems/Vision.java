// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;
import frc.robot.LimelightHelpers.RawFiducial;

public class Vision extends SubsystemBase {
public double[] measuments = {0,0,0,0,0,0};
public RawFiducial[] fiducials;
  public Vision() {
  }

  public Command print(){
    return run(()->{
      //System.out.println("x: " + LimelightHelpers.getTX(""));
      //System.out.println("y: " + LimelightHelpers.getTY(""));
      // for (double data: LimelightHelpers.getBotPose_TargetSpace("")){
      //   System.out.println(data);
      // }
      if (LimelightHelpers.getTV("")){
        updateMeasurments();
        System.out.println("x: " + measuments[2]);
        System.out.println("y: " + measuments[0]);
        System.out.println("rot: " + measuments[4]);
      }

    });
  }

  public double GetOutputX(){
    updateMeasurments();
    double xValue = measuments[2];
    double output = 0;
        if(LimelightHelpers.getTV("")){
      if(xValue > -0.85){
        output = -1;
      }
      if(output < -0.85){
        output = 1;
      }
    }
    return output;
  }

  public double GetOutputY(){
    updateMeasurments();
    double yValue = measuments[0];
    double output = 0;
    if(LimelightHelpers.getTV("")){
      if(yValue > 0){
        output = -1;
      }
      if(output < 0){
        output = 1;
      }
    }
    return output;
  }

  public double GetOutputRot(){
    updateMeasurments();
    double rotValue = measuments[4];
    double output = 0;
    if(LimelightHelpers.getTV("")){
      if(rotValue > 0){
        output = -1;
      }
      if(output < 0){
        output = 1;
      }
    }
    return output;
  }

  public void updateMeasurments(){
    measuments = LimelightHelpers.getBotPose_TargetSpace("");

    }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
