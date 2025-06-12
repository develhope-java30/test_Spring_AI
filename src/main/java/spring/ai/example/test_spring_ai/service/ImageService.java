package spring.ai.example.test_spring_ai.service;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private  ImageModel imageModel;

    public String generateImage(String prompt) {
        ImagePrompt imagePrompt = new ImagePrompt(
                prompt,
                StabilityAiImageOptions.builder()
                        .stylePreset("cinematic")
                        .height(512)
                        .width(512)
                        .N(1)
                        .build()
        );

        ImageResponse response = imageModel.call(imagePrompt);
        return response.getResults().get(0).getOutput().getUrl();
    }
}
