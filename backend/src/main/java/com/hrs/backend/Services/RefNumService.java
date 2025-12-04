package com.hrs.backend.Services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrs.backend.Models.RefSequence;
import com.hrs.backend.Repos.RefSeqRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefNumService {
    private final RefSeqRepo repo;

    // Static prefix
    private static final String PREFIX = "1123";

    @Transactional
    public String generateRefNum() {
        int year = LocalDate.now().getYear();

        // Read/Create sequence row for this year
        RefSequence seq = repo.findById(year).orElseGet(() -> new RefSequence(year, 0));

        // Increment sequence
        int nextSeq = seq.getLastSeq() + 1;
        seq.setLastSeq(nextSeq);
        repo.save(seq);

        return PREFIX + year + "-" + String.format("%02d", nextSeq);
    }
}
