package com.demo.mcp.springboot;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbacks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class McpConfiguration
{
    @Bean
    public List<ToolCallback> videoTools(VideoService videoService)
    {
        return List.of(ToolCallbacks.from(videoService));
    }
}