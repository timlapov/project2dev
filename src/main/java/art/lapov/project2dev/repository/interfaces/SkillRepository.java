package art.lapov.project2dev.repository.interfaces;

import art.lapov.project2dev.entity.Skill;

public interface SkillRepository extends GenericRepository<Skill, String> {
    Skill findByName(String name);
}