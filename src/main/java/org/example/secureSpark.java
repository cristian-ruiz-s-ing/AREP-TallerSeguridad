package org.example;

import static spark.Spark.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class secureSpark {
    public static void main(String[] args) {
        System.out.println("Starting Server...");
        port(getPort());

        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("keyStores/ecikeystore.p12", "clave1234", null, null);

        get("/helloService", (req, res) -> "Hello Service!");

    }

    private static int getPort() {
        if(System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }
}