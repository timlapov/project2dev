package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Skill;
import art.lapov.project2dev.repository.interfaces.SkillRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

public class SkillRepositoryImpl extends AbstractRepository<Skill, String> implements SkillRepository {

    public SkillRepositoryImpl(EntityManager em) {
        super(em, Skill.class);
    }

}
