package com.example.__projekt_komputer.computer.hardware.components.drive;

import com.example.__projekt_komputer.computer.software.file.shared.Capacity;
import com.example.__projekt_komputer.computer.software.file.shared.File;
import com.example.__projekt_komputer.computer.software.file.shared.FileService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public abstract class AbstractDrive implements Drive {

    protected final String name;
    protected final Capacity capacity;
    protected final FileService fileService;

    public AbstractDrive(String name, Capacity storageCapacity, FileService fileService) {
        this.name = name;
        this.capacity = storageCapacity;
        this.fileService = fileService;
    }

    @Override
    public Capacity getCapacity(){
        return capacity;
    }

    @Override
    public void addFile(Scanner scanner) {
        System.out.println("[File creator]");
        System.out.println("Enter file name: ");
        String fileName = scanner.nextLine();
        System.out.println("Enter file content: ");
        String fileContent = scanner.nextLine();

        File file = new File(fileName, fileContent, "text", 0);
        fileService.addFile(file);
    }

    @Override
    public void removeFile(String fileName) {
        fileService.removeFile(fileName);
    }

    @Override
    public void listFiles() {
        List<File> files = fileService.listFiles();
        for (File file : files) {
            System.out.println(file.getName() + ", type: " + file.getType() +  ", size: " + file.getSize() + "B");
        }
    }

    @Override
    public File findFileByName(String fileName) {
        Optional<File> file = fileService.findFile(fileName);
        return file.orElseThrow(() -> new RuntimeException("File not found: " + fileName));
    }

    @Override
    public String getName() {
        return name;
    }
    public List<File> getAllFiles(){
        return fileService.listFiles();
    }
}
