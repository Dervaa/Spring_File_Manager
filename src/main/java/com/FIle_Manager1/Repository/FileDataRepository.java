package com.FIle_Manager1.Repository;

import com.FIle_Manager1.Entity.FileData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileDataRepository implements IFileDataRepository {

    private List<FileData> fileDataList = new ArrayList<>();
    private static String DB_Path = "C:\\Users\\petia\\Рабочий стол\\FIle_Manager1\\FIle_Manager1\\src\\main\\resources\\YAML\\DB.yml";

    ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
    private int idCount=1;
    public FileDataRepository () throws IOException {
        try
        {
            fileDataList = objectMapper.readValue(new File(DB_Path), new TypeReference<>() {});
            for (FileData fileData: fileDataList)
            {
                if (fileData.getId() >= idCount)
                {
                    idCount = fileData.getId()+1;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Async
    public List<FileData> getFileData()
    {
        return fileDataList;
    }

    @Async
    public FileData findFileById(Integer id)
    {
        for (FileData fileData : fileDataList)
        {
            if (fileData.getId().equals(id))
            {
                return fileData;
            }
        }
        return null;
    }

    @Async
    public void add(FileData fileData)
    {
        fileData.setId(idCount++);
        fileDataList.add(fileData);
        save();
    }

    @Async
    public void update(FileData fileData)
    {
        for (int i = 0; i < fileDataList.size(); i++)
        {
            if (fileDataList.get(i).getId().equals(fileData.getId()))
            {
                fileDataList.set(i, fileData);
                save();
                return;
            }
        }
    }

    @Async
    public void delete(Integer id)
    {
        fileDataList.removeIf(fileData -> fileData.getId().equals(id));
        save();
    }

    private void save()
    {
        try
        {
            objectMapper.writeValue(new File(DB_Path), fileDataList);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
