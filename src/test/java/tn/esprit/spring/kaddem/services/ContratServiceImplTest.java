package tn.esprit.spring.kaddem.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ContratServiceImplTest {

    @InjectMocks
    private ContratServiceImpl contratService;

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EtudiantRepository etudiantRepository;

    @Test
    public void testRetrieveAllContrats() {
        // Créez une liste fictive de contrats pour simuler les données de la base de données
        List<Contrat> contrats = new ArrayList<>();

        // Ajoutez un contrat fictif
        Contrat contrat = new Contrat();
        contrat.setIdContrat(1); // Remplacez par l'ID réel de votre contrat
        contrat.setDateDebutContrat(new Date()); // Remplacez par la date de début réelle
        contrat.setDateFinContrat(new Date()); // Remplacez par la date de fin réelle
        contrat.setArchive(false); // Remplacez par la valeur réelle
        // Ajoutez d'autres attributs de contrat selon votre implémentation

        contrats.add(contrat);

        // Définissez le comportement du mock du repository
        Mockito.when(contratRepository.findAll()).thenReturn(contrats);

        // Appelez la méthode du service que vous voulez tester
        List<Contrat> result = contratService.retrieveAllContrats();

        // Assurez-vous que le résultat correspond à ce que vous attendez
        assertEquals(contrats, result);
    }



    // Ajoutez d'autres tests pour les autres méthodes de votre service
    // Assurez-vous de tester différents scénarios, y compris les cas limites et les erreurs attendues
}
