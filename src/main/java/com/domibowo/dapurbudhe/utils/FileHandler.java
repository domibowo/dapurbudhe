package com.domibowo.dapurbudhe.utils;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;

public interface FileHandler {

    String store(MultipartFile file, String dest);
    Resource read(String file);
}
