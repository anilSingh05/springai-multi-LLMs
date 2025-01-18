package springai_multi_LLMs;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnthropicAiController {

    // Implement OpenAI chat functionality here
    private final ChatClient chatClient;

    public AnthropicAiController(@Qualifier("anthropicChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/anthropicChat")
    public String chat(@RequestParam String message) {
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();
    }
}
