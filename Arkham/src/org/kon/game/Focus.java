package org.kon.game;

/**
 * Created with IntelliJ IDEA.
 * User: Kongus
 * Date: 18/01/13
 * Time: 19:06
 * To change this template use File | Settings | File Templates.
 */
public class Focus {
    private final int maxFocusValue;
    private final SkillSlider[] sliders;
    private int currentFocus;

    public Focus(int focusValue, SkillSlider... sliders) {
        maxFocusValue = focusValue;
        currentFocus = focusValue;
        this.sliders = sliders;
    }

    public void adjustSkill(SkillType type, int adjustment) {
        SkillSlider slider = findSlider(type);
        slider.adjustRight(adjustment);
        currentFocus -= adjustment;
    }

    private SkillSlider findSlider(SkillType type) {
        for (SkillSlider slider : sliders)
            if (slider.contains(type))
                return slider;
        return null;
    }

    public int remaining() {
        return currentFocus;
    }
}
