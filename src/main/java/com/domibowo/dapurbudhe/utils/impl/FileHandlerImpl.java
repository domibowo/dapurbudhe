package com.domibowo.dapurbudhe.utils.impl;

import com.domibowo.dapurbudhe.exceptions.FileStorageErrorException;
import com.domibowo.dapurbudhe.exceptions.ResourceCannotBeReadException;
import com.domibowo.dapurbudhe.utils.FileHandler;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileHandlerImpl implements FileHandler {

    private final Path location = Paths.get("C:\\Users\\domib\\Documents\\materi_pascal\\NewProject2021\\web-jualan\\dapurbudhe\\src\\main\\resources\\assets");

    @Override
    public String store(MultipartFile file, String dest) {
        try {
            Path target = location.resolve(dest);
            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
            return dest;
        } catch (IOException ioe){
            throw new FileStorageErrorException(ioe);
        }
    }

    @Override
    public Resource read(String file) {
        try {
            String exceptionMsg = String.format("File %s not found", file);
            Path filename = location.resolve(file).normalize();
            Resource resource = new UrlResource(filename.toUri());
            if(!resource.exists()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, exceptionMsg);
            return resource;
        } catch (MalformedURLException mue){
            throw new ResourceCannotBeReadException(mue);
        }
    }
}
