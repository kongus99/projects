package org.kon.game;

/**
 * Created with IntelliJ IDEA.
 * User: ldudek
 * Date: 1/18/13
 * Time: 8:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class SkillSlider {
    private final Skill firstSkill;
    private final Skill secondSkill;

    private int firstSkillCurrentValue;

    private int secondSkillCurrentValue;


    public SkillSlider(Skill firstSkill, Skill secondSkill) {
        this.firstSkill = firstSkill;
        this.secondSkill = secondSkill;
        firstSkillCurrentValue = firstSkill.baseValue;
        secondSkillCurrentValue = secondSkill.baseValue;
    }

    public void moveRight(int movesNumber) {
        firstSkillCurrentValue -= movesNumber;
        secondSkillCurrentValue += movesNumber;
    }

    public int skillValue(SkillType type) {
        if (firstSkill.type == type)
            return firstSkillCurrentValue;
        if (secondSkill.type == type)
            return secondSkillCurrentValue;
        throw new SkillNotOnThisSlider();
    }

    public static class SkillNotOnThisSlider extends RuntimeException {
    }

    public static class SkillAdjustmentOutOfRange extends RuntimeException{
    }
}
