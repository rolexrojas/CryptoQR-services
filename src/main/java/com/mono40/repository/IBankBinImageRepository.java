package com.mono40.repository;

import com.mono40.domain.BankBinImage;
import org.springframework.data.repository.CrudRepository;


public interface IBankBinImageRepository extends CrudRepository<BankBinImage, String> {
}
