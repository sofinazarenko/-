import java.util.*;

public class URLPool {
    private HashMap<String, URLDepthPair> visited;
    private LinkedList<URLDepthPair> toVisit;

    public URLPool() {
        visited = new HashMap<>();
        toVisit = new LinkedList<>();
    }

    public synchronized URLDepthPair getLink(){
        boolean isWaiting = false;
        if (toVisit.size() == 0) {
            try {
                Crawler.threadsWaiting++;
                isWaiting = true;
                this.wait();
            } catch (Exception e) {
                return null;
            }
        }
        if (isWaiting)
            Crawler.threadsWaiting--;
        URLDepthPair urlPair = toVisit.pop();
        visited.put(urlPair.getUrl(), urlPair);
        return urlPair;
    }

    public synchronized void addLink(URLDepthPair urlPair){
        if (!visited.containsKey(urlPair.getUrl())){
            toVisit.add(urlPair);
            this.notify();
        }
    }
}