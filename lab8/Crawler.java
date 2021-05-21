public class Crawler {

    private String URL;
    private static int maxDepth;
    public static int threadsWaiting = 0;
    public static int URLCount = 0;
    private static final String protocol = "https:";

    public static void main(String args[]){
        Crawler crawler = new Crawler("https://www.kfc.ru/", 3);
        crawler.run();
        Runtime.getRuntime().addShutdownHook(new Thread(()->printURLCount()));
    }

    public Crawler(String address, int maxDepth){
        this.URL = address;
        this.maxDepth = maxDepth;
    }

    public void run(){
        CrawlerTask task = new CrawlerTask(new URLDepthPair(URL, 0));
        task.start();
    }

    public static int getMaxDepth(){
        return maxDepth;
    }

    private static void printURLCount(){
        System.out.println("Final URL count: " + URLCount);
    }
}