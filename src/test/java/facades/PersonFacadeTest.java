package facades;

import dtos.PersonDTO;
import entities.Person;
import entities.RenameMe;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.*;
/*
class PersonFacadeTest {


    private static EntityManagerFactory emf;
    private static PersonFacade facade;

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = PersonFacade.getPersonFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    @BeforeEach
    void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.persist(new RenameMe("1 txt", "More text"));
            em.persist(new RenameMe("aaa", "bbb"));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllPerson() {
        int expected = 1;
       // int actual = PersonFacade.getPersonFacade().getsize;
        //assertEquals(expected,actual);
    }
    
    @Test
    public void addPersonTest(){
        Person person = new Person("wd","wda","12314","232",2021-10-20);
        PersonDTO createdPerson = new PersonDTO(person);

        int actual = 2;
        PersonDTO expected = facade.addPerson(createdPerson);
        assertEquals(expected,actual);
    }
}
*/
