package com.demo.mcp.springboot;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService implements InitializingBean
{
    private List<Video> videos = new ArrayList<>();

    @Tool(name = "ai-get-videos", description = "Get list of videos from AI Engineer")
    public List<Video> getVideos()
    {
        return videos;
    }

    @Tool(name = "ai-get-video", description = "Get video from AI Engineer by title")
    public Video getVideo(String title)
    {
        return videos.stream().filter(ele -> ele.title().equals(title)).findFirst().orElse(null);
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        videos.add(new Video("Building Agents with Model Context Protocol - Full Workshop with Mahesh Murag of Anthropic",
                "https://www.youtube.com/watch?v=kQmXtrmQ5Zg&t=2s"));
        videos.add(new Video("Tool Calling Is Not Just Plumbing for AI Agents — Roy Derks",
                "https://www.youtube.com/watch?v=zuMw0pkPXpU"));
        videos.add(new Video("Lets Build An Agent from Scratch",
                "https://www.youtube.com/watch?v=xzXdLRUyjUg"));
    }
}
