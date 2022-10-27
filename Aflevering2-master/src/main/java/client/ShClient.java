package client;

import com.example.aflevering2.slagteri.Gris;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.server.core.TypeReferences;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


public class ShClient {

    private final URI endpoint;
    private final RestTemplate restTemplate;

    public ShClient(URI endpoint) {
        this.endpoint = endpoint;
        this.restTemplate = new RestTemplate();
    }

    private String grisURI(long ID) {
        return endpoint + "gris/" + ID;
    }

    private String griseURI(Gris grisID) {
        return endpoint + "grise/" + grisID;
    }

    public Gris createGris(int weight, String origen, String date ) {
        Gris gris = new Gris(weight, origen, date) {
        };
        return restTemplate.postForEntity(endpoint + "Gris", gris, Gris.class).getBody();
    }

    public Gris getGris(Long ID) {
        return restTemplate.getForObject(grisURI(ID), Gris.class);
    }

    public List<Gris> getAllGrise () {
        UriBuilder builder = UriComponentsBuilder.fromUri(endpoint);
        builder.path("grise");
        builder.queryParam("ID", Gris.getID());
        Traverson traverson = new Traverson(builder.build(), MediaTypes.HAL_JSON);
        CollectionModel<Gris> exchangeRates = traverson.follow()
                .toObject(new TypeReferences.CollectionModelType<Gris>() {});
        Collection<Gris> accounts = Objects.requireNonNull(exchangeRates).getContent();
        return new ArrayList<>(accounts);
    }

    public void updateGris(Gris gris) {
        restTemplate.put(griseURI(gris), gris);
    }
    /*
    public Collection<TransactionSpecification> getTransactionsFor(Account account) {
        URI baseUri = endpoint
                .resolve("accounts/")
                .resolve(account.getAccountNumber().toString());
        Traverson traverson = new Traverson(baseUri, MediaTypes.HAL_JSON);
        CollectionModel<TransactionSpecification> ts = traverson
                .follow("$._links.transactions.href")
                .toObject(new TypeReferences.CollectionModelType<TransactionSpecification>() {});
        assert ts != null;
        return ts.getContent();
    }

     */
}
