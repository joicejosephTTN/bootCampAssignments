package com.example.SpringHibernate.entities;
import javax.persistence.*;

// INHERITANCE MAPPING

/*
Single Table – The entities from different classes with a common ancestor are placed in a single table.
Joined Table – Each class has its table, and querying a subclass entity requires joining the tables.
Table per Class – All the properties of a class are in its table, so no join is required.
 */

// All JPQL queries are polymorphic, which means the from clause of a query includes not only instances
// of the specific entity class to which it refers, but all subclasses of that class as well. The
// instances returned by a query include instances of the subclasses that satisfy the query conditions.


@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// The Single Table strategy creates one table for all entities.
// JPA also chooses this strategy by default if we don't specify one explicitly.

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// The Table per Class strategy maps each entity to its table, which contains all
// the properties of the entity, including the ones inherited.

@Inheritance(strategy = InheritanceType.JOINED)
// Using this strategy, each class in the hierarchy is mapped to its table. The only column that repeatedly
// appears in all the tables is the identifier, which will be used for joining them when needed.

// not needed in case of TABLE_PER_CLASS, JOINED
//@DiscriminatorColumn(name="Emp_Type", discriminatorType = DiscriminatorType.STRING)
// Since the records for all entities will be in the same table, Hibernate needs a way to
// differentiate between them. By default, this is done through a discriminator column
// called DTYPE that has the name of the entity as a value.

public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'';
    }
}

/*

ADVANTAGES AND DISADVANTAGES OF STRATEGIES

- SINGLE_TABLE
This strategy has the advantage of polymorphic query performance since only one table needs
to be accessed when querying parent entities.

-TABLE_PER_CLASS
when querying the base class, it will return all the subclass records as well by using a
UNION statement in the background.

The use of UNION can also lead to inferior performance when choosing this strategy.
Another issue is that we can no longer use identity key generation.

-JOINED
The disadvantage of this inheritance mapping method is that retrieving entities requires joins
between tables, which can result in lower performance for large numbers of records.

The number of joins is higher when querying the parent class because it will join with every single
related child — so performance is more likely to be affected the higher up the hierarchy we want to
retrieve records.
*/