package br.projetoMave.dao;


import br.projetoMave.jpaUtil.JpaUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

public abstract class GenericDao< T extends Serializable> {

    private Class< T> clazz;
    private EntityManager entityManager = JpaUtil.getEntityManager();

    public void setClazz(final Class< T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final Long id) {
        try {
            return (T) entityManager.find(clazz, id);
        } catch (Exception e) {
        }
        return null;
    }

    public List<T> findForCodigo(final String id) {
        try {
            return entityManager.createQuery("FROM " + clazz.getSimpleName() + " where id =" + id).getResultList();
        } catch (Exception e) {
        }
        return null;
    }



    public List<T> findAll() {
        try {
            return entityManager.createQuery("FROM " + clazz.getSimpleName()).getResultList();
        } catch (Exception e) {
        }
        return null;
    }

    public List<T> findAll(final String habilitado) {
        try {
            return entityManager.createQuery("FROM " + clazz.getSimpleName() + " where habilitado = " + habilitado).getResultList();
        } catch (Exception e) {
        }
        return null;
    }

    public List<T> findForDescription(String campo, String description) {
        try {
            return entityManager.createQuery("FROM " + clazz.getSimpleName() + " where " + campo + " like'%" + description + "%'").getResultList();
        } catch (Exception e) {
        }
        return null;
    }

    public List<T> findForDescription(final String campo, final String description, final String habilitado) {
        try {
            return entityManager.createQuery("FROM " + clazz.getSimpleName() + " where " + campo + " like'%" + description + "%' and habilitado = " + habilitado).getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<T> findForDescription(String campo1, String description1, String campo2, String description2, final String habilitado) {
        try {
            return entityManager.createQuery("FROM " + clazz.getSimpleName() + " where " + campo1 + " = '" + description1 + "' and " + campo2 + " = '" + description2 + "' and habilitado = " + habilitado).getResultList();
        } catch (Exception e) {
        }
        return null;
    }

    public List<T> jpql(String JPQL) {
        try {
            System.out.println(JPQL);
            return entityManager.createQuery(JPQL).getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public Object jpqlUnico(String JPQL) {
        try {
            System.out.println(JPQL);
            return entityManager.createQuery(JPQL).getSingleResult();
        } catch (Exception e) {
            System.out.println(JPQL);
            System.out.println(e);
        }
        return null;
    }

    public void save(final T entity) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();

        } catch (Exception e) {

  
            System.out.println(e);
            Throwable t = e;
            boolean cont = true;
            while (t != null) {
                if (t.getMessage().startsWith("Duplicate entry")) {
                    entityManager.getTransaction().rollback();
                    cont = false;
                    throw new Exception("Duplicate entry");
                }
                t = t.getCause();
            }
            if (cont) {
                System.out.println(e.getMessage());
                throw new Exception(e.getMessage());
            }

            entityManager.getTransaction().rollback();
            System.out.println(e);
        }
    }

    public void update(final T entity) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {

            Throwable t = e;
            boolean cont = true;
            while (t != null) {
                if (t.getMessage().startsWith("Duplicate entry")) {
                    entityManager.refresh(entity);
                    entityManager.getTransaction().rollback();
                    cont = false;
                    throw new Exception("Duplicate entry");
                }
                t = t.getCause();
            }
            if (cont) {
                throw new Exception(e.getMessage());
            }

            entityManager.getTransaction().rollback();
        }
    }

    public void delete(final T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
