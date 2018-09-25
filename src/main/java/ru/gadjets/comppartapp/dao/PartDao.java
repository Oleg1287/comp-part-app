package ru.gadjets.comppartapp.dao;

import ru.gadjets.comppartapp.entity.Part;

import java.util.List;
import java.util.Properties;

public interface PartDao {
    public List<Part> findAll(String sql);
    public List<Part> findAll(String sql, Properties prop);
    public Integer getFoundRows();
    public Part getById(int id);

    void update(Part part);

    void delete(Part p);

    void add(Part part);
}
