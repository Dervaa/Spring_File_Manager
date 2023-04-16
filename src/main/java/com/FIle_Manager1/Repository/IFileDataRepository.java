package com.FIle_Manager1.Repository;
import com.FIle_Manager1.Entity.FileData;
import java.io.File;
import java.util.List;


public interface IFileDataRepository {
    public List<FileData> getFileData();
    public FileData findFileById(Integer id);
    public void add(FileData fileData);
    public void update(FileData fileData);
    public void delete(Integer id);
}