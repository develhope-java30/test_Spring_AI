package spring.ai.example.test_spring_ai;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class AiController {
    @Autowired
    private AiService aiService;

    @PostMapping(consumes  = MediaType.APPLICATION_JSON_VALUE,
                 produces  = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> chat(@RequestBody JsonNode body) {
        // estraiamo il campo "prompt" dal JSON
        String prompt = body.path("prompt").asText(null);

        if (prompt == null || prompt.isBlank()) {
            return ResponseEntity.badRequest().body("Missing or empty 'prompt' field");
        }

        String response = aiService.sendPrompt(prompt);

        return ResponseEntity.ok(response);
    }

}
