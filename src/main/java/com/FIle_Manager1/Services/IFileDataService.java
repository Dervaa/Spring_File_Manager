package com.FIle_Manager1.Services;

import com.FIle_Manager1.Entity.FileData;

import java.util.List;

public interface IFileDataService {
    public List<FileData> getFileData();
    public FileData findFileById(Integer id);
    public void add(FileData fileData);
    public void update(FileData fileData);
    public void delete(Integer id);
}
