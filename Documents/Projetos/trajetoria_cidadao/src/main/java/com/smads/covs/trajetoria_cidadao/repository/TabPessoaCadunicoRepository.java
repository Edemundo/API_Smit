package com.smads.covs.trajetoria_cidadao.repository;

import com.smads.covs.trajetoria_cidadao.model.TabPessoaCadunico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TabPessoaCadunicoRepository extends JpaRepository<TabPessoaCadunico, String> {

    TabPessoaCadunico findByNumNisPessoaAtual(String cdNis);
}
