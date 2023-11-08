package tn.esprit.spring.kaddem.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.ISubscriptionServices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static tn.esprit.spring.entities.TypeSubscription.SEMESTRIEL;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class SusbscriptionServiceImpMock {
    @Mock
    ISubscriptionRepository SRepository = Mockito.mock(ISubscriptionRepository.class);
    @InjectMocks
    ISubscriptionServices SService;
    Subscription S = new Subscription((long)1, LocalDate.now().minusDays(1), LocalDate.now(),(float)10.0,SEMESTRIEL);
    List<Subscription> listSubs = new ArrayList<Subscription>() {
        {
            add(new Subscription((long)2, LocalDate.now().minusDays(1), LocalDate.now(),(float)11.0,SEMESTRIEL));
            add(new Subscription((long)3, LocalDate.now().minusDays(1), LocalDate.now(),(float)12.0,SEMESTRIEL));
        }
    };
    @Test
    public void testRetrieveSubscriptions() {
        Mockito.when(SRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(S));
        Subscription sub = SService.retrieveSubscriptionById((long)1);
        Assertions.assertNotNull(sub);
    }
}



