package facades;

import dtos.PersonDTO;
import entities.Person;
import utils.EMF_Creator;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private PersonFacade() {}


    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<PersonDTO> getAllPerson(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("select p FROM Person p", Person.class);
        List<Person> personList = query.getResultList();
        return PersonDTO.getDtos(personList);
    }

   public PersonDTO addPerson(PersonDTO personDTO){
       EntityManager em = emf.createEntityManager();
       Person person = new Person(personDTO.getFirstName(), personDTO.getLastName(), personDTO.getPhone(), personDTO.getCreated(), personDTO.getLastEdited());
        return null;
   }


    //deletePerson
    //getPersonById
    //editPerson



    //Code below is used to sout information from DB
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        PersonFacade pf = getPersonFacade(emf);
        pf.getAllPerson().forEach(dto-> System.out.println(dto));
    }
}
