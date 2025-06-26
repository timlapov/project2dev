package art.lapov.project2dev.repository;

import art.lapov.project2dev.entity.Skill;
import art.lapov.project2dev.repository.interfaces.SkillRepository;
import jakarta.persistence.EntityManager;

public class SkillRepositoryImpl extends AbstractRepository<Skill, String> implements SkillRepository {


    public SkillRepositoryImpl(EntityManager em) {
        super(em, Skill.class);
    }

    @Override
    public Skill findByName(String name) {
        return null;
    }

}
