package com.example.aflevering2.slagteri;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
class DatabaseLoader {


    @Bean
    CommandLineRunner init(GrisRepository grisRepository){
        return args ->
        {
            grisRepository.save(new Gris(110,"Denmark","18-10-2022"));
            grisRepository.save(new Gris(115,"Denmark","18-10-2022"));
            grisRepository.save(new Gris(120,"Denmark","18-10-2022"));
            grisRepository.save(new Gris(100,"Denmark","18-10-2022"));
            grisRepository.save(new Gris(110,"Denmark","18-10-2022"));
            grisRepository.save(new Gris(115,"Denmark","18-10-2022"));
            grisRepository.save(new Gris(120,"Denmark","18-10-2022"));
        };
    }



}