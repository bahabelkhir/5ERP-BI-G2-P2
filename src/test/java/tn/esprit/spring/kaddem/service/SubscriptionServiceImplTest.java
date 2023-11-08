package tn.esprit.spring.kaddem.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class DepartementServiceImplTest {
    @Autowired
    IDepartementService ds;
    @Test
    @Order(1)
    public void testRetrieveallDepartement() {
        List<Departement> listes = ds.retrieveallSubscriptions();

        Assertions.assertEquals(0, listes.size());
    }
}
