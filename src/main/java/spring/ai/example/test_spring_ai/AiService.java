package spring.ai.example.test_spring_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiService {
    @Autowired
    private ChatClient.Builder chatClientBuilder;

    public String sendPrompt(String prompt) {
        ChatClient chatClient = chatClientBuilder.build();
        return chatClient.prompt(prompt)
                .call()
                .content();
    }

}
