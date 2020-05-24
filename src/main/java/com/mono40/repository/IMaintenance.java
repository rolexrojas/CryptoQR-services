package com.mono40.repository;

import com.mono40.domain.Maintenance;
import org.springframework.data.repository.CrudRepository;

public interface IMaintenance extends CrudRepository<Maintenance, Long> {
}
