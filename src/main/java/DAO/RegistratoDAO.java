package DAO;

import java.util.*;
import entity.Registrato;
public interface RegistratoDAO {
    public List<Registrato> read();
    public int create(Registrato e);
    public void update(Registrato reg);
    public void delete(int id);
    public Registrato findByID(int id);
    public void deleteAll();

    public List<Registrato> trovaMaschi();

}
