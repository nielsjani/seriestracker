package be.njani.seriestracker.domain.infrastructure.ddd;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static javax.persistence.LockModeType.WRITE;

public class RepositoryImpl<T extends AggregateRoot<ID>, ID extends Id> extends SimpleJpaRepository<T, ID> implements Repository<T, ID> {

    private EntityManager entityManager;

    public RepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public T getOne(ID id) {
        return super.getOne(id);
    }

    @Override
    public T findOne(ID id) {
        return super.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return super.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return super.findAll(sort);
    }

    @Override
    public List<T> findAll(Iterable<ID> ids) {
        return super.findAll(ids);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return super.findAll(pageable);
    }

    @Override
    public boolean exists(ID id) {
        return super.exists(id);
    }

    @Override
    public long count() {
        return super.count();
    }

    @Override
    @Transactional
    public <S extends T> S save(S entity) {
        S savedEntity = super.save(entity);
        entityManager.lock(savedEntity, WRITE);
        return savedEntity;
    }

    @Override
    @Transactional
    public <S extends T> List<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException("Implement this method in RepositoryImpl, make sure to detach and merge the entities.");
    }

    @Override
    @Transactional
    public <S extends T> S saveAndFlush(S entity) {
        throw new UnsupportedOperationException("Implement this method in RepositoryImpl, make sure to detach and merge the entities.");
    }

    @Override
    @Transactional
    public void flush() {
        throw new UnsupportedOperationException("Implement this method in RepositoryImpl, make sure to detach and merge the entities.");
    }

    @Override
    @Transactional
    public void delete(T entity) {
        throw new UnsupportedOperationException("Implement this method in RepositoryImpl, make sure to detach and merge the entities.");
    }

    @Override
    @Transactional
    public void delete(ID id) {
        throw new UnsupportedOperationException("Implement this method in RepositoryImpl, make sure to detach and merge the entities.");
    }

    @Override
    @Transactional
    public void delete(Iterable<? extends T> entities) {
        throw new UnsupportedOperationException("Implement this method in RepositoryImpl, make sure to detach and merge the entities.");
    }

    @Override
    @Transactional
    public void deleteAll() {
        throw new UnsupportedOperationException("Implement this method in RepositoryImpl, make sure to detach and merge the entities.");
    }

    @Override
    @Transactional
    public void deleteInBatch(Iterable<T> entities) {
        throw new UnsupportedOperationException("Implement this method in RepositoryImpl, make sure to detach and merge the entities.");
    }

    @Override
    @Transactional
    public void deleteAllInBatch() {
        throw new UnsupportedOperationException("Implement this method in RepositoryImpl, make sure to detach and merge the entities.");
    }
}
