package server;

import client.ShClient;
import com.example.aflevering2.slagteri.Gris;
import com.example.aflevering2.slagteri.IAnimal;
import com.example.aflevering2.slagteri.RemoteAnimal;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.net.URI;
import java.net.URISyntaxException;

public class HelloServer {

    @Bean
    @Scope("singleton")
    public static IAnimal createAnimal() throws URISyntaxException {
        final URI uri = new URI("http://localhost:9000");
        ShClient shClient = new ShClient(uri);
        return new RemoteAnimal(shClient);
    }

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(9090).addService(new HelloServiceImpl()).build();
        server.start();
        server.awaitTermination();
    }
}