package com.example.similaritysearch.vertexai.client;

import com.google.auth.oauth2.GoogleCredentials;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;

@Component
public class AccessTokenProvider implements InitializingBean
{
    @Value("${GOOGLE_APPLICATION_CREDENTIALS}")
    private String googleApplicationCredentials;

    private static final String SCOPE = "https://www.googleapis.com/auth/cloud-platform";

    private GoogleCredentials googleCredentials;

    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println("googleApplicationCredentials: \n" + googleApplicationCredentials);

        try (InputStream is = new FileInputStream(googleApplicationCredentials))
        {
            googleCredentials = GoogleCredentials.fromStream(is).createScoped(SCOPE);
        }
        catch (Exception e)
        {
            System.out.println("Exception while loading GoogleCredentials" + e);
        }
    }

    public String getToken()
    {
        try
        {
            googleCredentials.refreshIfExpired();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return googleCredentials.getAccessToken().getTokenValue();
    }
}