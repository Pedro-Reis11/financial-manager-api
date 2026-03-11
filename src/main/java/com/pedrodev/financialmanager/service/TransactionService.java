package com.pedrodev.financialmanager.service;

import com.pedrodev.financialmanager.dto.TransactionDTO;
import com.pedrodev.financialmanager.entity.Transaction;
import com.pedrodev.financialmanager.entity.User;
import com.pedrodev.financialmanager.mapper.TransactionMapper;
import com.pedrodev.financialmanager.repository.TrasactionRepository;
import com.pedrodev.financialmanager.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TrasactionRepository trasactionRepository;
    private final UserRepository userRepository;
    private final TransactionMapper transactionMapper;

    public TransactionService(TrasactionRepository trasactionRepository,
                              UserRepository userRepository,
                              TransactionMapper transactionMapper) {
        this.trasactionRepository = trasactionRepository;
        this.userRepository = userRepository;
        this.transactionMapper = transactionMapper;
    }

    public TransactionDTO createTransaction(TransactionDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Transaction transaction = transactionMapper.toEntity(dto);

        transaction.setUser(user);

        Transaction savedTransaction = trasactionRepository.save(transaction);

        return transactionMapper.toDTO(savedTransaction);
    }

    public Page<TransactionDTO> getAllTransactions(Pageable pageable) {

        return trasactionRepository
                .findAll(pageable)
                .map(transactionMapper::toDTO);
    }

    public TransactionDTO getTransactionById(Long id) {

        Transaction transaction = trasactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        return transactionMapper.toDTO(transaction);
    }

    public void deleteTransaction(Long id) {

        if (!trasactionRepository.existsById(id)) {
            throw new RuntimeException("Transaction not found");
        }

        trasactionRepository.deleteById(id);
    }
}
