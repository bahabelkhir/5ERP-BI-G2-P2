package tn.esprit.spring.kaddem.service;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest

public class TestAvecMockito {
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private ContratRepository contratRepository;
    @Mock
    EtudiantRepository etudiantRepository;
    @InjectMocks
    EtudiantServiceImpl etudiantService;


    Etudiant e = Etudiant.builder().nomE("Test").prenomE("Test").op(Option.valueOf("SIM")).build();
    List<Etudiant> list= new ArrayList<Etudiant>() {
        {
            add(Etudiant.builder().nomE("e").prenomE("ee").op(Option.valueOf("SIM")).build());
            add(Etudiant.builder().nomE("b").prenomE("bb").op(Option.valueOf("GAMIX")).build());
        }
    };

    @Test
    public void testRetrieveAllEtudiants() {
        Mockito.when(etudiantRepository.findAll()).thenReturn(list);
        List<Etudiant> result = etudiantService.retrieveAllEtudiants();
        Mockito.verify(etudiantRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testAddEtudiant() {
        Mockito.when(etudiantRepository.save(ArgumentMatchers.any(Etudiant.class))).thenReturn(e);
        Etudiant result = etudiantService.addEtudiant(e);
        Mockito.verify(etudiantRepository, Mockito.times(1)).save(e);
    }

    @Test
    public void testUpdateEtudiant() {
        Mockito.when(etudiantRepository.save(ArgumentMatchers.any(Etudiant.class))).thenReturn(e);
        Etudiant result = etudiantService.updateEtudiant(e);
        Mockito.verify(etudiantRepository, Mockito.times(1)).save(e);
    }

    @Test
    public void testRetrieveEtudiant() {
        Mockito.when(etudiantRepository.findById(ArgumentMatchers.any(Integer.class))).thenReturn(java.util.Optional.ofNullable(e));
        Etudiant result = etudiantService.retrieveEtudiant(1);
        Mockito.verify(etudiantRepository, Mockito.times(1)).findById(1);
    }

    @Test
    public void testRemoveEtudiant() {
        // Mock the behavior of the repository

        // Invoke the service method
        etudiantService.removeEtudiant(1);

        // Verify the expected behavior
        Mockito.verify(etudiantRepository, Mockito.times(1)).delete(ArgumentMatchers.any(Etudiant.class));
    }

    @Test
    public void testAssignEtudiantToDepartement() {
        // Mock the behavior of the repository
        Etudiant etudiant = Etudiant.builder().idEtudiant(1).build();
        Mockito.when(etudiantRepository.findById(ArgumentMatchers.any(Integer.class))).thenReturn(java.util.Optional.ofNullable(etudiant));

        // Invoke the service method
        etudiantService.assignEtudiantToDepartement(1, 1);

        // Verify the expected behavior
        Mockito.verify(etudiantRepository, Mockito.times(1)).findById(1);
        Mockito.verify(etudiantRepository, Mockito.times(1)).save(etudiant);
    }

    @Test
    public void testAddAndAssignEtudiantToEquipeAndContract() {
        // Mock the behavior of the repository
        Contrat contrat = Contrat.builder().idContrat(1).build();
        Equipe equipe = Equipe.builder().idEquipe(1).build();
        Mockito.when(contratRepository.findById(ArgumentMatchers.any(Integer.class))).thenReturn(java.util.Optional.ofNullable(contrat));
        Mockito.when(equipeRepository.findById(ArgumentMatchers.any(Integer.class))).thenReturn(java.util.Optional.ofNullable(equipe));

        // Invoke the service method
        Etudiant result = etudiantService.addAndAssignEtudiantToEquipeAndContract(e, 1, 1);
        Mockito.verify(contratRepository, Mockito.times(1)).findById(1);
        Mockito.verify(equipeRepository, Mockito.times(1)).findById(1);
        Mockito.verify(etudiantRepository, Mockito.times(1)).save(result);
    }
}
