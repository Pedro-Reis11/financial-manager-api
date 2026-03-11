package com.pedrodev.financialmanager.mapper;
import com.pedrodev.financialmanager.dto.TransactionDTO;
import com.pedrodev.financialmanager.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Transaction toEntity(TransactionDTO dto);

    TransactionDTO toDTO(Transaction entity);

}
