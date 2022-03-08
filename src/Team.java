public class Team {

    //класс Team имеет название команды, ее сила и кол-во очков
    public String name;
    public int power;
    public int points;

    //Конструктор Team
    public Team(String name, int power) {
        this.name = name;
        this.power = power;
        this.points = 0;
    }
}
