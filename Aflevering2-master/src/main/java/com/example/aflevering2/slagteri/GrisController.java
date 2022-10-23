package com.example.aflevering2.slagteri;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController


class GrisController {

    private final GrisRepository repository;


    GrisController(GrisRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/alleGrise")
    ResponseEntity<CollectionModel<EntityModel<Gris>>> findAll() {

        List<EntityModel<Gris>> grisResources = StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(gris -> EntityModel.of(gris,
                        linkTo(methodOn(GrisController.class).findAll()).withRel("Grise")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of( //
                grisResources, //
                linkTo(methodOn(GrisController.class).findAll()).withSelfRel()
                        .andAffordance(afford(methodOn(GrisController.class).newGris(null)))));
    }


    @PostMapping("/nyGris")
    ResponseEntity<?> newGris(@RequestBody Gris gris) {

        Gris savedGris = repository.save(gris);

        return EntityModel.of(savedGris,
                        linkTo(methodOn(GrisController.class).findAll()).withRel("gris")).getLink(IanaLinkRelations.SELF)
                .map(Link::getHref) //
                .map(href -> {
                    try {
                        return new URI(href);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }) //
                .map(uri -> ResponseEntity.noContent().location(uri).build())
                .orElse(ResponseEntity.badRequest().body("Unable to create " + gris));
    }

    @GetMapping("/findGris/{id}")
    ResponseEntity<EntityModel<Gris>> findOne(@PathVariable long id) {

        return repository.findById(id)
                .map(gris -> EntityModel.of(gris,
                        linkTo(methodOn(GrisController.class).findOne(gris.getID())).withSelfRel()))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/opdaterGris/{id}")
    ResponseEntity<?> updateGris(@RequestBody Gris gris, @PathVariable long id) {

        Gris grisToUpdate = gris;
        grisToUpdate.setID(id);

        Gris updatedGris = repository.save(grisToUpdate);

        return EntityModel.of(updatedGris,
                        linkTo(methodOn(GrisController.class).findOne(updatedGris.getID())).withSelfRel()
                                .andAffordance(afford(methodOn(GrisController.class).updateGris(null, updatedGris.getID()))),
                        linkTo(methodOn(GrisController.class).findAll()).withRel("gris")).getLink(IanaLinkRelations.SELF)
                .map(Link::getHref).map(href -> {
                    try {
                        return new URI(href);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                }) //
                .map(uri -> ResponseEntity.noContent().location(uri).build()) //
                .orElse(ResponseEntity.badRequest().body("Unable to update " + grisToUpdate));
    }

   @DeleteMapping("/fjernGris/{id}")

    ResponseEntity<?> deleteGris(@PathVariable long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }





  
}

