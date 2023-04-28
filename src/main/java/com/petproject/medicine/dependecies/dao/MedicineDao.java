package com.petproject.medicine.dependecies.dao;

import com.petproject.medicine.dependecies.dao.output.Medicine;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface MedicineDao extends CrudRepository<Medicine, Long> {
    LocalDate FOURTEEN_DAYS_BEFORE_NOW = LocalDate.now().minusDays(14);

    default List<Medicine> findAllByCreatedAt() {
        return findAllByCreatedAtAfter(FOURTEEN_DAYS_BEFORE_NOW);
    }

    default List<Medicine> findAllByCreatedAtBefore() {
        return findAllByCreatedAtBefore(FOURTEEN_DAYS_BEFORE_NOW);
    }

    List<Medicine> findAllByCreatedAtAfter(LocalDate after);

    List<Medicine> findAllByCreatedAtBefore(LocalDate before);
}
