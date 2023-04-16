package com.FIle_Manager1.Services;

import com.FIle_Manager1.Entity.FileData;
import com.FIle_Manager1.Repository.IFileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileDataService implements IFileDataService {

    @Autowired
    private IFileDataRepository fileDataRepository;

    @Async
    public List<FileData> getFileData() {
        return fileDataRepository.getFileData();
    }

    @Async
    public FileData findFileById(Integer id) {
        return fileDataRepository.findFileById(id);
    }

    @Async
    public void add(FileData fileData) {
        fileDataRepository.add(fileData);
    }

    @Async
    public void update(FileData fileData) {
        fileDataRepository.update(fileData);
    }

    @Async
    public void delete(Integer id) {
        fileDataRepository.delete(id);
    }
}
