package com.tva.bigbellyblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.bigbellyblog.model.Header;
import com.tva.bigbellyblog.repositorie.HeaderRepository;

@Service("headerService")
@Transactional
public class HeaderServiceImpl implements HeaderService {

  @Autowired
  private HeaderRepository headerRepo;

  @Override
  public List<Header> getAllHeaders() {
    return headerRepo.findAll();
  }

}
