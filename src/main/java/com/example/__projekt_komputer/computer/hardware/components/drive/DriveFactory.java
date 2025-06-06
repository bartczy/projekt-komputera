package com.example.__projekt_komputer.computer.hardware.components.drive;

import com.example.__projekt_komputer.computer.hardware.components.CPU;
import com.example.__projekt_komputer.computer.software.file.shared.Capacity;
import com.example.__projekt_komputer.computer.software.file.shared.FileService;

import java.util.Scanner;

public class DriveFactory {
    public static Drive createDrive(Scanner scanner, FileService fileService, CPU cpu) {

        System.out.println("Enter drive type (HDD, SSD, M2, M4): ");
        String driveType = scanner.nextLine();

        System.out.println("Enter drive name: ");
        String driveName = scanner.nextLine().toUpperCase();

        //System.out.println("Enter drive capacity (e.g. GB64, GB128): ");
       // String capacityStr = scanner.nextLine().toUpperCase();
        Capacity capacity = Capacity.GB64;

        return switch (driveType.toUpperCase()) {
            case "HDD" -> new HDDDrive(driveName, capacity, fileService);
            case "M4" -> new M4Drive(driveName, capacity, fileService);
            case "SSD" -> new SSDDrive(driveName, capacity, fileService, cpu);
            case "M2"  -> new M2Drive(driveName, capacity, fileService, cpu);
            default -> throw new IllegalArgumentException("Unknown drive type: " + driveType);
        };
    }
}
