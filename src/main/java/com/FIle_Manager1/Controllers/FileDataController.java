package com.FIle_Manager1.Controllers;

import com.FIle_Manager1.Entity.FileData;
import com.FIle_Manager1.Services.FileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FileDataController {
    @Autowired
    private FileDataService FileDataService;
    /*@GetMapping("files/upload")
    public String editFileById(*//*@PathVariable Integer id,*//* Model model) {
        List<FileData> fileData = new ArrayList<>();
        *//*fileData.add(FileDataService.findFileById(id));*//*
        model.addAttribute("fileData", fileData);
        return "upload_file";
    }*/
    @PostMapping("files/add")
    public String uploading (@RequestParam("fileName") String fileName,
                             @RequestParam("fileType") String fileType,
                             @RequestParam("fileSize") Integer fileSize,
                             @RequestParam("fileCreationDate") String fileCreationDate,
                             @RequestParam("fileEditionDate") String fileEditionDate) {
        FileData fileData = new FileData(fileName, fileType, fileSize, fileCreationDate, fileEditionDate);
        FileDataService.add(fileData);
        // Add a flash attribute with a success message
/*
        redirectAttributes.addFlashAttribute("success", "File has been uploaded successfully");
*/
        return "redirect:/files"; // return to the upload form with a success message
    }

    @GetMapping("/files")
    public String listFiles(Model model) {
        List<FileData> fileDataList = FileDataService.getFileData();
        model.addAttribute("fileDataList", fileDataList);
        return "files";
    }
    @GetMapping("/delete/{id}")
    public String deleteFile(@PathVariable Integer id)
    {
        FileDataService.delete(id);
        return "redirect:/files";
    }

}
