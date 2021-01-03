package dao;

import dao.exception.DAOException;
import entity.IEntity;

import java.util.List;
import java.util.Optional;

public interface DAO<E extends IEntity> {
    E create(E entity) throws DAOException;
    Optional<E> getEntity(int id) throws DAOException;
    List<E> getAll() throws DAOException;
    E updateEntity(E entity) throws DAOException;
    void deleteEntity(int id) throws DAOException;
}
