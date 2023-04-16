package com.FIle_Manager1.Entity;

public class FileData {
    private Integer id;
    private String fileType;
    private String fileName;
    private String fileCreationDate;
    private String fileEditionDate;
    private Integer fileSize;

    public FileData() {
    }

    public FileData(Integer id, String fileType, String fileName, String fileCreationDate, String fileEditionDate, Integer fileSize) {
        this.id = id;
        this.fileType = fileType;
        this.fileName = fileName;
        this.fileCreationDate = fileCreationDate;
        this.fileEditionDate = fileEditionDate;
        this.fileSize = fileSize;
    }

    public FileData(String fileType, String fileName, String fileCreationDate, String fileEditionDate, Integer fileSize) {
        this.fileType = fileType;
        this.fileName = fileName;
        this.fileCreationDate = fileCreationDate;
        this.fileEditionDate = fileEditionDate;
        this.fileSize = fileSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileCreationDate() {
        return fileCreationDate;
    }

    public void setFileCreationDate(String fileCreationDate) {
        this.fileCreationDate = fileCreationDate;
    }

    public String getFileEditionDate() {
        return fileEditionDate;
    }

    public void setFileEditionDate(String fileEditionDate) {
        this.fileEditionDate = fileEditionDate;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "FileData{" +
                "id=" + id +
                ", fileType='" + fileType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileCreationDate='" + fileCreationDate + '\'' +
                ", fileEditionDate='" + fileEditionDate + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}

