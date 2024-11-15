package hr.tis.academy.hackaton.sightseeingapp.controller;

import hr.tis.academy.hackaton.sightseeingapp.model.Image;
import hr.tis.academy.hackaton.sightseeingapp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/{location}/{attractionURLName}")
    public ResponseEntity<?> saveImage(@PathVariable String location, @PathVariable String attractionURLName, MultipartFile image) {
        Image savedImage = imageService.saveImage(location, attractionURLName, image);
        return  savedImage != null
                ? ResponseEntity.created(URI.create("/image/" + location + "/" + attractionURLName.replace(" ", "%20") + "/picture/" + savedImage.getId())).build()
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/{location}/{attractionURLName}/picture/{imageId}")
    public ResponseEntity<byte[]> getImage(@PathVariable String location, @PathVariable String attractionURLName, @PathVariable Long imageId) {
        Image image = imageService.getImage(location, attractionURLName, imageId);
        return image != null
                ? ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image.getImageData())
                : ResponseEntity.notFound().build();
    }
}
