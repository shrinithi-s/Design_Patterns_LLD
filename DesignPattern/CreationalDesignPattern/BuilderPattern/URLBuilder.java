package DesignPattern.CreationalDesignPattern.BuilderPattern;

import java.util.*;

public class URLBuilder {
    private final String protocol;
    private final String host;
    private final Integer port;
    private final List<String> paths;
    private final Map<String, String> queryParams;

    private URLBuilder(Builder builder) {
        this.protocol = builder.protocol;
        this.host = builder.host;
        this.port = builder.port;
        this.paths = List.copyOf(builder.paths);
        this.queryParams = Map.copyOf(builder.queryParams);
    }

    public String build() {
        StringBuilder url = new StringBuilder();

        url.append(protocol).append("://").append(host);
        if (port != null) url.append(":").append(port);
        for (String path : paths) url.append("/").append(path);

        if (!queryParams.isEmpty()) {
            url.append("?");
            boolean first = true;

            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                if (!first) url.append("&");
                url.append(entry.getKey()).append("=").append(entry.getValue());
                first = false;
            }
        }

        return url.toString();
    }


    public static class Builder {

        private final String protocol;
        private final String host;

        private Integer port;
        private List<String> paths = new ArrayList<>();
        private Map<String, String> queryParams = new LinkedHashMap<>();

        // Essential parameters
        public Builder(String protocol, String host) {
            this.protocol =protocol;
            this.host = host;  //Objects.requireNonNull(host);
        }

        //Optional parameters
        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder addPath(String path) {
            paths.add(path);
            return this;
        }

        public Builder addQueryParam(String key, String value) {
            queryParams.put(key, value);
            return this;
        }

        public URLBuilder build() {
            return new URLBuilder(this);
        }
    }

}

class Client{
    public static void main(String[] args) {
        URLBuilder url = new URLBuilder.Builder("https", "example.com")
                .port(8080)
                .addPath("users")
                .addPath("101")
                .addQueryParam("name", "John")
                .addQueryParam("age", "25")
                .build();

        System.out.println(url.build());

        URLBuilder url2 = new URLBuilder.Builder("https", "google.com")
                .addPath("search")
                .addQueryParam("q", "java")
                .build();

        System.out.println(url2.build());
    }
}

// https://example.com:8080/users/101?name=John&age=25

//Protocol | Essential | https |
// Hostname | Essential | example.com |
//Port | Optional | 8080 |
//Path parameters | Optional | /users/101 |
//Query parameters | Optional | name=John&age=25 |