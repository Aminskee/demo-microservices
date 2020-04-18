package com.example.demo.service;

import com.example.demo.persistence.Image;
import com.example.demo.persistence.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public List<Image> list(){
        return imageRepository.findAll();
    }

    public void deleteById(Long id){
        imageRepository.deleteById(id);
    }
}
