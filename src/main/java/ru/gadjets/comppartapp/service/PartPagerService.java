package ru.gadjets.comppartapp.service;

import ru.gadjets.comppartapp.dao.utils.Pager;
import ru.gadjets.comppartapp.entity.Part;

import java.util.List;
import java.util.Properties;

public interface PartPagerService {
    void delete(int p);

    public List<Part> findAll(Properties prop);
    Part getById(int id);

    void update(Part part);

    public Pager getPager();

    void add(Part part);
}
