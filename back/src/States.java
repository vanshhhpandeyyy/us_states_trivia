package back.src;
import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

public class States {
    private static final Logger LOGGER = Logger.getLogger(States.class.getName());
    public static Set <String> validStates = new HashSet <> (Arrays.asList(
        "maine", "rhode island", "connecticut", "maryland", "vermont", "virginia", "west virginia", "north carolina", "south carolina"
        , "new york", "new jersey", "new hampshire", "pennsylvania", "massachusetts", "delaware", "georgia", "florida", "texas", "louisiana"
        , "kansas", "arkansas", "kentucky", "oklahoma", "ohio", "alabama", "tennessee", "california", "arizona", "utah", "colorado"
        , "washington", "oregon", "iowa", "idaho", "north dakota", "south dakota", "wisconsin", "wyoming", "indiana", "michigan"
        , "illinois", "missouri", "mississippi", "minnesota", "nebraska", "new mexico", "nevada", "alaska", "hawaii", "montana"
    ));
      public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        
        server.createContext("/", exchange -> {
            byte[] content = Files.readAllBytes(Paths.get("V:/Documents/Projects/Trivia/front/src/index.html"));
            exchange.sendResponseHeaders(200, content.length);
            exchange.getResponseBody().write(content);
            exchange.close();
        });

        server.createContext("/check", exchange -> {
            if ("POST".equals(exchange.getRequestMethod())) {
                InputStream body = exchange.getRequestBody();
                String name = new String(body.readAllBytes()).toLowerCase().trim();

                String response = validStates.contains(name) ? "valid" : "invalid";
                exchange.sendResponseHeaders(200, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
            }
        });

        server.setExecutor(null);
        server.start();
        LOGGER.info("Server running at http://localhost:8000");
    }
}