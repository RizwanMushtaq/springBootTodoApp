package com.rizwanmushtaq.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class FileController extends ApiBaseController {
  Logger logger = LoggerFactory.getLogger(FileController.class);

  @PostMapping("/file/upload")
  public String uploadFile(@RequestParam("image") MultipartFile file) throws IOException {
    logger.info("Name: {}", file.getName());
    logger.info("Content Type: {}", file.getContentType());
    logger.info("Original File Name: {}", file.getOriginalFilename());
    InputStream inputStream = file.getInputStream();
    FileOutputStream fileOutputStream =
        new FileOutputStream("uploaded_" + Math.random() * 999 + file.getOriginalFilename());
    byte[] data = new byte[inputStream.available()];
    fileOutputStream.write(data);
    return "File uploaded successfully";
  }

  @PostMapping("/file/upload-multiple")
  public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) throws IOException {
    for (MultipartFile file : files) {
      logger.info("File Name: {}", file.getOriginalFilename());
      logger.info("File Type: {}", file.getContentType());
      logger.info("File Size: {} bytes", file.getSize());
      logger.info("************");
      InputStream inputStream = file.getInputStream();
      FileOutputStream fileOutputStream =
          new FileOutputStream("uploaded_" + Math.random() * 999 + file.getOriginalFilename());
      byte[] data = new byte[inputStream.available()];
      fileOutputStream.write(data);
    }
    return "Multiple files uploaded successfully";
  }

  //serving image files in response
  @GetMapping("/file/serve-image")
  public void serveImageHandler(HttpServletResponse response) {
    try {
      InputStream fileInputStream = new FileInputStream("images/riz1.png");
      response.setContentType(MediaType.IMAGE_JPEG_VALUE);
      StreamUtils.copy(fileInputStream, response.getOutputStream());
    } catch (IOException e) {
      logger.error("Error serving image: {}", e.getMessage());
    }
  }
}
