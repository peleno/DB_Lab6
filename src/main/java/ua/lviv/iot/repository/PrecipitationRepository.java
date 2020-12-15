package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.Precipitation;

@Repository
public interface PrecipitationRepository extends JpaRepository<Precipitation, Integer> {
}
