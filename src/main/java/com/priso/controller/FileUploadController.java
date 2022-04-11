package com.priso.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping("/fileform")
	public String showUploadForm() {
		return "fileform";
	}

	@RequestMapping(path = "/uploadimage", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("profile") CommonsMultipartFile file, HttpSession session, Model model) {
		System.out.println("File Upload Handler");

		System.out.println(String.format(
				"Name: %s, Original Name: %s, Content-Type: %s" + ", Size: %d , Description: %s", file.getName(),
				file.getOriginalFilename(), file.getContentType(), file.getSize(), file.getStorageDescription()));
		byte[] data = file.getBytes();
		String path = session.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
				+ File.separator + "images" + File.separator + file.getOriginalFilename();
		// save this file to server or as a flat file in resources
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			System.out.println("File uploaded");
			model.addAttribute("msg", String.format("File '%s' uploaded successfully", file.getOriginalFilename()));
			model.addAttribute("filename", file.getOriginalFilename());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Uploading Error");
			model.addAttribute("msg", String.format("Could not upload File '%s'", file.getOriginalFilename()));
		}
		return "filesuccess";
	}
}
