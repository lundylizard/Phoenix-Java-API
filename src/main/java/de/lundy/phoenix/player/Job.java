package de.lundy.phoenix.player;

public class Job {

    private String name;
    private int id;

    public Job(int id) {

        this.id = id;

        switch (this.id) {

            case 0:
                this.name = "Beginner";
                break;
            case 100:
                this.name = "Warrior";
                break;
            case 200:
                this.name = "Magician";
                break;
            case 300:
                this.name = "Archer";
                break;
            case 400:
                this.name = "Thief";
                break;
            case 110:
                this.name = "Fighter";
                break;
            case 120:
                this.name = "Page";
                break;
            case 130:
                this.name = "Spearman";
                break;
            case 210:
                this.name = "F/P Wizard";
                break;
            case 220:
                this.name = "I/L Wizard";
                break;
            case 230:
                this.name = "Cleric";
                break;
            case 310:
                this.name = "Hunter";
                break;
            case 320:
                this.name = "Crossbow Man";
                break;
            case 410:
                this.name = "Assassin";
                break;
            case 420:
                this.name = "Bandit";
                break;
            case 111:
                this.name = "Crusader";
                break;
            case 121:
                this.name = "White Knight";
                break;
            case 131:
                this.name = "Dragon Knight";
                break;
            case 211:
                this.name = "F/P Mage";
                break;
            case 221:
                this.name = "I/L Mage";
                break;
            case 231:
                this.name = "Priest";
                break;
            case 311:
                this.name = "Ranger";
                break;
            case 321:
                this.name = "Sniper";
                break;
            case 411:
                this.name = "Hermit";
                break;
            case 421:
                this.name = "Chief Bandit";
                break;

        }

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
