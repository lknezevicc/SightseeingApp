package hr.tis.academy.hackaton.sightseeingapp.service.impl;

import hr.tis.academy.hackaton.sightseeingapp.model.Attraction;
import hr.tis.academy.hackaton.sightseeingapp.model.Image;
import hr.tis.academy.hackaton.sightseeingapp.repository.AttractionRepository;
import hr.tis.academy.hackaton.sightseeingapp.repository.ImageRepository;
import hr.tis.academy.hackaton.sightseeingapp.service.ImageService;
import hr.tis.academy.hackaton.sightseeingapp.util.DiacriticsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    private final AttractionRepository attractionRepository;
    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(AttractionRepository attractionRepository, ImageRepository imageRepository) {
        this.attractionRepository = attractionRepository;
        this.imageRepository = imageRepository;
    }


    @Override
    public Image saveImage(String locationName, String attractionURL, MultipartFile image) {
        List<Attraction> attractions = attractionRepository.findAttractionByLocation(locationName);
        if (attractions.isEmpty()) return null;

        Image newImage = new Image();

        Attraction attraction = attractions.stream()
                .filter(a -> DiacriticsConverter.convertToAscii(a.getName()).equals(attractionURL))
                .findFirst()
                .orElse(null);

        if (attraction == null) return null;

        try {
            newImage.setImageData(image.getBytes());
        } catch (Exception e) {
            return null;
        }

        newImage.setAttraction(attraction);
        return imageRepository.save(newImage);
    }

    @Override
    public Image getImage(String locationName, String attractionURL, Long imageId) {
        List<Attraction> attractions = attractionRepository.findAttractionByLocation(locationName);
        if (attractions.isEmpty()) return null;

        Attraction attraction = attractions.stream()
                .filter(a -> DiacriticsConverter.convertToAscii(a.getName()).equals(attractionURL))
                .findFirst()
                .orElse(null);

        if (attraction == null) return null;

        return imageRepository.findById(imageId)
                .filter(i -> i.getAttraction().equals(attraction))
                .orElse(null);
    }
}
