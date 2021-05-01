package uz.pdp.appspringboot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringboot1.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    boolean existsByNumber(String number);
    boolean existsByNumberAndIdNot(String number, Integer id);


}