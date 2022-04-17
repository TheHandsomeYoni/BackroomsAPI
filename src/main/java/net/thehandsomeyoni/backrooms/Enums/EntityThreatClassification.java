package net.thehandsomeyoni.backrooms.Enums;

/**
 * Defines the class of the entity according to its behaviour and aggressiveness.
 * You can find the explanation about the classes here:
 */
public enum EntityThreatClassification {
    CLASS_0(false, false),

    CLASS_1(false, true),

    CLASS_2(false, true),

    CLASS_3(true, false),

    CLASS_4(true, true),

    CLASS_5(true, true),

    CLASS_6(true, true),

    CLASS_7(true, true);


    private boolean aggressive;
    private boolean threatening;

    EntityThreatClassification(boolean aggressive, boolean threatening){
        this.aggressive = aggressive;
        this.threatening = threatening;
    }

    /**
     * Checks if the class's entities are aggressive towards survivors
     * @return 'true' if the class is aggressive, and 'false' if it's not
     */
    public boolean isAggressive() {
        return aggressive;
    }

    /**
     * Checks if the class's entities are threatening towards survivors.
     * For example: if the class's entity can be harmful, kill survivors, and leave survivors severely injured, the class will be considered as threatening
     * @return 'true' if the class is threatening, and 'false' it's not threatening
     */
    public boolean isThreatening(){
        return this.threatening;
    }
}
