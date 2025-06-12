package spring.ai.example.test_spring_ai.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.ai.example.test_spring_ai.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/generate")
    public String generate(@RequestParam String prompt) {
        return imageService.generateImage(prompt);
    }
}
