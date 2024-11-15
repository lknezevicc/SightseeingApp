package hr.tis.academy.hackaton.sightseeingapp.service;

import hr.tis.academy.hackaton.sightseeingapp.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Image saveImage(String locationName, String attractionURL, MultipartFile image);
    Image getImage(String locationName, String attractionURL, Long imageId);
}
