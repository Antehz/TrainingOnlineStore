package by.hrychanok.training.shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Anton_Hrychanok on 2017-03-04.
 */
public abstract class BasicServiceDecorator<T, REPOSITORY extends JpaRepository<T, ID>, ID extends Serializable> implements JpaRepository<T, ID> {

    protected REPOSITORY repository;
    private static Logger logger = LoggerFactory.getLogger(BasicServiceDecorator.class);

    public BasicServiceDecorator(REPOSITORY repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public <S extends T> S save(S entity) {
        logger.debug("Save entity " + entity);
        return repository.save(entity);
    }

    @Override
    @Transactional
    public T findOne(ID id) {
        logger.debug("Find entity by id " + id);
        return (T) repository.findOne(id);
    }

    @Override
    @Transactional
    public boolean exists(ID id) {
        return repository.exists(id);
    }

    @Override
    @Transactional
    public List<T> findAll() {
        logger.debug("Find all");
        return (List<T>) repository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<T> findAll(Iterable<ID> iterable) {
        return null;
    }

    @Override
    public <S extends T> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    @Transactional
    public long count() {
        return repository.count();
    }

    @Override
    @Transactional
    public void delete(ID id) {
        logger.debug("Delete entity by ID " + id);
        repository.delete(id);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        logger.debug("Delete entity " + entity.getClass());
        repository.delete(entity);
    }

    @Override
    public void delete(Iterable<? extends T> iterable) {

    }

    @Override
    @Transactional
    public void deleteAll() {
        logger.debug("Delete all");
        repository.deleteAll();
    }

    @Override
    @Transactional
    public <S extends T> S saveAndFlush(S entity) {
        logger.debug("Save entity " + entity.getClass());
        return repository.saveAndFlush(entity);
    }

    @Override
    public void deleteInBatch(Iterable<T> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public T getOne(ID id) {
        return null;
    }

    @Override
    public <S extends T> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return false;
    }
}
