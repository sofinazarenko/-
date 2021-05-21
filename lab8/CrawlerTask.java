import java.util.*;
import java.net.*;

public class CrawlerTask extends Thread {
    private URLPool urlPool;
    private final String protocol = "https:";

    public CrawlerTask(URLDepthPair urlPair){
        urlPool = new URLPool();
        urlPool.addLink(urlPair);
    }

    @Override
    public void run(){
        URLDepthPair urlPair = urlPool.getLink();
        System.out.println(urlPair);
        Crawler.URLCount++;
        if (urlPair.getDepth() >= Crawler.getMaxDepth())
            return;
        search(urlPair);
    }

    private void search(URLDepthPair current_address){
        try {
            URL url = new URL(current_address.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.findWithinHorizon("<a\\s+(?:[^>]*?\\s+)?href=([\"'])(.*?)\\1", 0) != null){
                String new_url = scanner.match().group(2);
                URLDepthPair new_address = newURLPair(new_url, current_address);
                if (new_address == null)
                    continue;
                newThread(new_address);
            }
        } catch (Exception e) {
            System.err.println("Exception: " + e.getLocalizedMessage());
        }
    }

    private URLDepthPair newURLPair(String new_url, URLDepthPair current_address){
        if (new_url.startsWith("//"))
            new_url = protocol + new_url;
        else if (!new_url.startsWith(protocol)) return null;
        URLDepthPair new_pair = new URLDepthPair(new_url, current_address.getDepth() + 1);
        return new_pair;
    }

    private void newThread(URLDepthPair urlPair){
        CrawlerTask task = new CrawlerTask(urlPair);
        task.start();
    }
}