package com.FIle_Manager1.Controllers;

import com.FIle_Manager1.Entity.FileData;
import com.FIle_Manager1.Services.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FileDataController {
    @Autowired
    private FileDataService fileDataService;

    @GetMapping("/files")
    public String listWagons(Model model) {
        List<FileData> fileDataList = fileDataService.getFileData();
        model.addAttribute("fileDataList", fileDataList);
        return "files";
    }
    @GetMapping("/delete/{id}")
    public String deleteFile(@PathVariable Integer id)
    {
        fileDataService.delete(id);
        return "redirect:/files";
    }

}
