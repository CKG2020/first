package mapper;

import pojo.Person;

public interface PersonMapper {
    void insertPerson(Person person);

    Person queryById(int id);

    void updatePerson(int id);
}
