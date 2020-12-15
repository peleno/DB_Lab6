package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.WorldPart;

@Repository
public interface WorldPartRepository extends JpaRepository<WorldPart, Integer> {
}
