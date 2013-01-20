package org.kon.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Kongus
 * Date: 18/01/13
 * Time: 18:59
 * To change this template use File | Settings | File Templates.
 */
public class FocusTest {
    private Skill s1;
    private Skill s2;
    private SkillSlider slider1;
    private Skill s3;
    private Skill s4;
    private SkillSlider slider2;
    private Skill s5;
    private Skill s6;
    private SkillSlider slider3;

    @Test
    public void focusContainsSeveralSliders() throws Exception {
        s1 = new Skill(SkillType.SPEED, 3);
        s2 = new Skill(SkillType.SNEAK, 1);
        slider1 = new SkillSlider(s1, s2);
        s3 = new Skill(SkillType.FIGHT, 5);
        s4 = new Skill(SkillType.WILL, 1);
        slider2 = new SkillSlider(s3, s4);
        s5 = new Skill(SkillType.LUCK, 4);
        s6 = new Skill(SkillType.LORE, 2);
        slider3 = new SkillSlider(s5, s6);

        Focus focus = new Focus(10, slider1, slider2, slider3);
        focus.adjustSkill(SkillType.SPEED, 2);

        assertEquals(1, slider1.skillValue(SkillType.SPEED));
        assertEquals(3, slider1.skillValue(SkillType.SNEAK));
        assertEquals(s3.baseValue, slider2.skillValue(SkillType.FIGHT));
        assertEquals(s4.baseValue, slider2.skillValue(SkillType.WILL));
        assertEquals(s5.baseValue, slider3.skillValue(SkillType.LUCK));
        assertEquals(s6.baseValue, slider3.skillValue(SkillType.LORE));
        assertEquals(8, focus.remaining());

    }
}
