package tp.banque.defitech.gl3.s5.projet;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tp.banque.defitech.gl3.s5.projet.entities.Client;
import tp.banque.defitech.gl3.s5.projet.entities.Compte;
import tp.banque.defitech.gl3.s5.projet.entities.CompteCourant;
import tp.banque.defitech.gl3.s5.projet.entities.Personne;
import tp.banque.defitech.gl3.s5.projet.repositories.CompteRepository;
import tp.banque.defitech.gl3.s5.projet.repositories.PersonneRepository;

@SpringBootApplication
public class ProjetApplication implements CommandLineRunner {

    @Autowired
    PersonneRepository personneRepository;
    @Autowired
    CompteRepository compteRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personneRepository.save(new Client(1, "TETTEH", "Amen", "ZEBE", "99722667", "tkamen@outlook.com", "Code",null)) ;
        personneRepository.save(new Client(2, "TETTEH", "Serena", "ZEBE", "99722661", "seridatetteh@gmail.com", "Code",null)) ;
        personneRepository.save(new Client(3, "TETTEH", "Clara", "ZEBE", "99722661", "seridatetteh@gmail.com", "Code",null)) ;
        personneRepository.save(new Client(4, "TETTEH", "Cyriack", "ZEBE", "99722661", "seridatetteh@gmail.com", "Code",null)) ;
        personneRepository.save(new Client(5, "TSOWU", "Adzo Mabelle", "ZEBE", "99722661", "mabelletsowu@gmail.com", "Code",null)) ;
       
        compteRepository.save(new CompteCourant(1, "124f444f444551", new Date(), 12000.0 , (Personne)personneRepository.findById(1).get(), (Personne)personneRepository.findById(5).get()));
        compteRepository.save(new CompteCourant(2, "124f444f444552", new Date(), 12000.0 , (Personne)personneRepository.findById(1).get(), (Personne)personneRepository.findById(5).get()));
        compteRepository.save(new CompteCourant(3, "124f444f444553", new Date(), 12000.0 , (Personne)personneRepository.findById(2).get(), (Personne)personneRepository.findById(5).get()));
        compteRepository.save(new CompteCourant(4, "124f444f444554", new Date(), 12000.0 , (Personne)personneRepository.findById(3).get(), (Personne)personneRepository.findById(5).get()));
        compteRepository.save(new CompteCourant(5, "124f444f444555", new Date(), 12000.0 , (Personne)personneRepository.findById(4).get(), (Personne)personneRepository.findById(5).get()));
        compteRepository.save(new CompteCourant(6, "124f444f444556", new Date(), 12000.0 , (Personne)personneRepository.findById(4).get(), (Personne)personneRepository.findById(5).get()));
    }

}
