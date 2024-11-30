package emsi.ma.model_mapper.entities;

import org.antlr.v4.runtime.tree.pattern.ParseTreePatternMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
}
