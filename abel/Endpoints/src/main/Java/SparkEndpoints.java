package main.Java;
//Abel
//8/10/2023
import static spark.Spark.*;
    public class SparkEndpoints {

        public static void main(String[] args) {
            // Set the port for the Spark server


            // GET Endpoint
            get("/get", (req, res) -> {
                System.out.println("You are in the GET endpoint");
                return "YOU are in the GET endpoint";
            });

            // POST Endpoint
            post("/post", (req, res) -> {
                System.out.println("You are in the POST endpoint");
                return "YOU are in the POST endpoint";
            });

            // PUT Endpoint
            put("/put", (req, res) -> {
                System.out.println("You are in the PUT endpoint");
                return "YOU are in the PUT endpoint";
            });

            // DELETE Endpoint
            delete("/delete", (req, res) -> {
                System.out.println("You are in the DELETE endpoint");
                return "YOU are in the DELETE endpoint";
            });
        }
    }
